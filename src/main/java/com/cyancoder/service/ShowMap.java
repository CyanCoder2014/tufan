package com.cyancoder.service;


import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.cyancoder.config.BaseUrls;
import com.cyancoder.frame.PointMapFrame;
import com.cyancoder.model.OperationSingleton;
import com.cyancoder.model.PointModel;
import org.geotools.data.*;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.feature.DefaultFeatureCollection;
import org.geotools.feature.SchemaException;
import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.geometry.jts.JTSFactoryFinder;
import org.geotools.map.FeatureLayer;
import org.geotools.map.Layer;
import org.geotools.map.MapContent;
import org.geotools.styling.*;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;


public class ShowMap {


    public ShowMap()
    {}

    private static final Logger LOGGER = org.geotools.util.logging.Logging.getLogger(ShowMap.class);


    private static String baseLoc = BaseUrls.baseLocWin;

    public static void showMap() throws SchemaException, IOException {

        if (!Files.exists(Path.of(baseLoc))) {
            baseLoc = BaseUrls.baseLocLnx;
        }

        Layer admLayer = setPolLayer(baseLoc+"/maps/IRN_adm/IRN_adm2.shp",Color.ORANGE.darker(),Color.decode("#f9d19d"),0.3f);
        Layer watAreaLayer = setPolLayer(baseLoc+"/maps/IRN_wat/IRN_water_areas_dcw.shp",Color.decode("#0077ff"),Color.decode("#0099ff"),0.8f);
        Layer watLineLayer = setPolLayer(baseLoc+"/maps/IRN_wat/IRN_water_lines_dcw.shp",Color.decode("#ccffff"),null,0f);
        Layer roadLayer = setPolLayer(baseLoc+"/maps/IRN_rds/IRN_roads.shp",Color.decode("#ccccaa"),null,0f);
        Layer borderLayer = setPolLayer(baseLoc+"/maps/IRN_adm/IRN_adm1.shp",Color.decode("#000000"),null,0f);

        MapContent map = new MapContent();
        map.setTitle("نمایش موقعیت آتشبارها و اهداف روی نقشه");

        map.addLayer(admLayer);
        map.addLayer(watAreaLayer);
        map.addLayer(watLineLayer);
        map.addLayer(roadLayer);
        map.addLayer(borderLayer);

        addPoints(map);

        new PointMapFrame(map);
    }

    private static void addPoints(MapContent map) throws SchemaException {

        OperationSingleton operationSingleton = OperationSingleton.getOperationSingleton();

        operationSingleton.getFireLoad().forEach(fireLoad -> {
            double originX = fireLoad.getOriginX() != null ? fireLoad.getOriginX() : 0;
            double originY = fireLoad.getOriginY() != null ? fireLoad.getOriginY() : 0;
            if ((43.000 < originX && originX < 63.300) && (25.000 < originY && originY < 40.000)) {
                PointModel originPoint = new PointModel(originX, originY);
                originPoint.setName("موقعیت استقرار توپ آتشبار: " + fireLoad.getName());
                originPoint.setElevation(0);
                try {
                    Layer originPoinLayer = setPointLayer(originPoint,"Circle",Color.YELLOW, Color.RED, 0.7f, 12f);
                    map.addLayer(originPoinLayer);
                } catch (SchemaException e) {
                    throw new RuntimeException(e);
                }
            }

            double targetX = fireLoad.getTargetX() != null ? fireLoad.getTargetX() : 0;
            double targetY = fireLoad.getTargetY() != null ? fireLoad.getTargetY() : 0;
            if ((43.000 < targetX && targetX < 63.300) && (25.000 < targetY && targetY < 40.000)) {
                PointModel targetPoint = new PointModel(targetX, targetY);
                targetPoint.setName("موقعیت هدف آتشبار: " + fireLoad.getName());
                targetPoint.setElevation(0);
                try {
                    Layer originPoinLayer = setPointLayer(targetPoint,"Cross",Color.YELLOW, Color.RED, 0.7f, 12f);
                    map.addLayer(originPoinLayer);
                } catch (SchemaException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }



    private static Layer setPolLayer(String fileLoc, Color outlineColor, Color fillColor, float opacity) throws IOException {

        File file = new File(fileLoc);

        FileDataStore store = FileDataStoreFinder.getDataStore(file);

        SimpleFeatureSource featureSource = store.getFeatureSource();

        Style style = SLD.createPolygonStyle(outlineColor, fillColor, opacity);

        return new FeatureLayer(featureSource, style);
    }




    private static Layer setPointLayer(PointModel pointObject, String shapeType, Color outlineColor, Color fillColor, float opacity, float size) throws SchemaException {

        final SimpleFeatureType TYPE =
                DataUtilities.createType(
                        "Location",
                        "the_geom:Point:srid=4326,"
                                +
                                "title:String," // need to consider
                                +
                                "name:String,"
                                +
                                "note:String"
                );

        List<SimpleFeature> features = new ArrayList<>();

        GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory();
        SimpleFeatureBuilder featureBuilder = new SimpleFeatureBuilder(TYPE);

        Point point = geometryFactory.createPoint(new Coordinate(pointObject.getLongitude(), pointObject.getLatitude()));

        featureBuilder.add(point);
        featureBuilder.add(pointObject.getName());
        featureBuilder.add(pointObject.getElevation());
        SimpleFeature feature = featureBuilder.buildFeature(null);

        features.add(feature);
        DefaultFeatureCollection featureCollection = new DefaultFeatureCollection("internal", TYPE);
        featureCollection.add(features.get(0));

        Style style = SLD.createPointStyle(shapeType,outlineColor,fillColor, opacity, size);
        return new FeatureLayer(featureCollection, style);
    }


}