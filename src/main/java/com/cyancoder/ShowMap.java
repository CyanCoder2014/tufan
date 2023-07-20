package com.cyancoder;
/*
 *    GeoTools Sample code and Tutorials by Open Source Geospatial Foundation, and others
 *    https://docs.geotools.org
 *
 *    To the extent possible under law, the author(s) have dedicated all copyright
 *    and related and neighboring rights to this software to the public domain worldwide.
 *    This software is distributed without any warranty.
 *
 *    You should have received a copy of the CC0 Public Domain Dedication along with this
 *    software. If not, see <http://creativecommons.org/publicdomain/zero/1.0/>.
 */

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.cyancoder.frame.PointMapFrame;
import com.cyancoder.model.PointModel;
import org.geotools.data.*;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.feature.DefaultFeatureCollection;
import org.geotools.feature.SchemaException;
import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.geometry.jts.JTSFactoryFinder;
import org.geotools.map.FeatureLayer;
import org.geotools.map.Layer;
import org.geotools.map.MapContent;
import org.geotools.styling.*;
import org.geotools.swing.JMapFrame;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.filter.FilterFactory2;
import org.opengis.style.Fill;
import org.opengis.style.Stroke;


public class ShowMap {

    public static ShowMap showMap;

    public ShowMap()
    {
        showMap = this;
        if (showMap ==null)
            showMap = new ShowMap();///////////////////////////////////////////////////////////
    }

    private static final Logger LOGGER = org.geotools.util.logging.Logging.getLogger(ShowMap.class);



    public static void main(String[] args) throws Exception {
        ShowMap.showMap();
    }


    public static void showMap() throws SchemaException, IOException {

        PointModel basePoint = new PointModel( 45.8,38.23);
        basePoint.setName("موقعیت مبدأ");
        basePoint.setElevation(232324);
        Layer basePoinLayer = setPointLayer(basePoint,"Circle",Color.YELLOW, Color.RED, 0.7f, 12f);

        PointModel targetPoint = new PointModel( 45.87159,38.13718);
        targetPoint.setName("موقعیت هدف");
        targetPoint.setElevation(232324);
        Layer targetPoinLayer = setPointLayer(targetPoint,"Cross",Color.YELLOW, Color.RED, 0.7f, 12f);


       Layer admLayer = setPolLayer("./maps/IRN_adm/IRN_adm2.shp",Color.ORANGE.darker(),Color.decode("#f9d19d"),0.3f);
       Layer watAreaLayer = setPolLayer("./maps/IRN_wat/IRN_water_areas_dcw.shp",Color.decode("#0077ff"),Color.decode("#0099ff"),0.8f);
       Layer watLineLayer = setPolLayer("./maps/IRN_wat/IRN_water_lines_dcw.shp",Color.decode("#ccffff"),null,0f);
       Layer roadLayer = setPolLayer("./maps/IRN_rds/IRN_roads.shp",Color.decode("#ccccaa"),null,0f);
       Layer borderLayer = setPolLayer("./maps/IRN_adm/IRN_adm1.shp",Color.decode("#000000"),null,0f);

        MapContent map = new MapContent();
        map.setTitle("نمایش موقعیت آتشتبارها و اهداف روی نقشه");

        map.addLayer(admLayer);
        map.addLayer(watAreaLayer);
        map.addLayer(watLineLayer);
        map.addLayer(roadLayer);
        map.addLayer(borderLayer);

        map.addLayer(basePoinLayer);
        map.addLayer(targetPoinLayer);

        new PointMapFrame(map);
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
                                "elevation:double,"
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