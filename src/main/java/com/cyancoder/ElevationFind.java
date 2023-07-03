package com.cyancoder;

import org.geotools.data.*;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;
import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.filter.text.ecql.ECQL;
import org.geotools.geometry.jts.JTSFactoryFinder;
import org.geotools.map.FeatureLayer;
import org.geotools.map.Layer;
import org.geotools.map.MapContent;
import org.geotools.styling.SLD;
import org.geotools.styling.Style;
import org.geotools.swing.JMapFrame;
import org.geotools.swing.data.JFileDataStoreChooser;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.filter.Filter;

import java.io.File;
import java.util.*;

/**
 * Hello world!
 *
 */
public class ElevationFind
{


    public static void main(String[] args) throws Exception {







        // display a data store file chooser dialog for shapefiles
        File file = JFileDataStoreChooser.showOpenFile("shp", null);
        if (file == null) {
            return;
        }



        FileDataStore store = FileDataStoreFinder.getDataStore(file);
        SimpleFeatureSource featureSource = store.getFeatureSource();

        Map<String, Object> map = new HashMap<>();
        map.put("url", file.toURI().toURL());

        System.out.println(store.getSchema());


        DataStore dataStore = DataStoreFinder.getDataStore(map);
        String typeName = dataStore.getTypeNames()[0];


        FeatureSource<SimpleFeatureType, SimpleFeature> source =
                dataStore.getFeatureSource(typeName);

//        Filter filter = Filter.INCLUDE; // ECQL.toFilter("BBOX(THE_GEOM, 10,20,30,40)")
//        Filter filter = CQL.toFilter( "X = 46.170833333333 AND Y = 39.695833333333 " );
//        Filter filter = CQL.toFilter( "X LIKE '45.929%' AND Y LIKE '37.525%' " );//********************
        Filter filter = ECQL.toFilter("(X BETWEEN 45.928 AND 45.930) AND (Y BETWEEN 37.524 AND 37.526)");



        FeatureCollection<SimpleFeatureType, SimpleFeature> collection = source.getFeatures(filter);
//        System.out.println(collection.size());








        try (FeatureIterator<SimpleFeature> features = collection.features()) {
            while (features.hasNext()) {
                SimpleFeature feature = features.next();
//                System.out.println(feature.getDefaultGeometryProperty().getValue());
                System.out.println(feature.getAttribute("X"));
                System.out.println(feature.getAttribute("Y"));
                System.out.println(feature.getAttribute("Z"));


//                features.close();

//                elvMap.put(feature.getAttribute("ID"),feature.getAttributes());
            }
        }
//        dataStore.dispose();

//        System.out.println(elvMap.size());








        final SimpleFeatureType TYPE =
                DataUtilities.createType(
                        "Location",
                        "the_geom:Point:srid=4326,"
                                + // <- the geometry attribute: Point type
                                "X:double,"
                                +
                                "Y:double,"
                                + // <- a String attribute
                                "Z:double" // a number attribute
                );
        System.out.println("TYPE:" + TYPE);

        List<SimpleFeature> features = new ArrayList<>();

        /*
         * GeometryFactory will be used to create the geometry attribute of each feature,
         * using a Point object for the location.
         */
        GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory();
        SimpleFeatureBuilder featureBuilder = new SimpleFeatureBuilder(TYPE);

        double latitude = 45.85159;
        double longitude = 38.23718;
        double X = 45.85159;
        double Y = 38.23718;
        double Z = 31212;

        /* Longitude (= x coord) first ! */
        Point point = geometryFactory.createPoint(new Coordinate(longitude, latitude));

        featureBuilder.add(point);
        featureBuilder.add(X);
        featureBuilder.add(Y);
        featureBuilder.add(Z);
        SimpleFeature feature = featureBuilder.buildFeature(null);
        features.add(feature);


//        FeatureCollection<SimpleFeatureType, SimpleFeature> collection1 = (FeatureCollection<SimpleFeatureType, SimpleFeature>) features;












        System.out.println(collection);





        MapContent map1 = new MapContent();
        map1.setTitle("Quickstart");

        Style style = SLD.createSimpleStyle(featureSource.getSchema());
        Layer layer = new FeatureLayer(collection, style);
        map1.addLayer(layer);

        // Now display the map
        JMapFrame.showMap(map1);

    }








}
