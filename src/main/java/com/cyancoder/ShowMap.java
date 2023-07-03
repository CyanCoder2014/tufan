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

/**
 * Prompts the user for a shapefile and displays the contents on the screen in a map frame.
 *
 * <p>This is the GeoTools Quickstart application used in documentationa and tutorials. *
 */
public class ShowMap {

    public static ShowMap showMap;

    public ShowMap()
    {
        showMap = this;
        if (showMap ==null)
            showMap = new ShowMap();///////////////////////////////////////////////////////////
    }

    private static final Logger LOGGER = org.geotools.util.logging.Logging.getLogger(ShowMap.class);
    /**
     * GeoTools Quickstart demo application. Prompts the user for a shapefile and displays its
     * contents on the screen in a map frame
     */
    public static void main(String[] args) throws Exception {
        ShowMap.showMap();

    }


    public static void showMap() throws SchemaException, IOException {

        /*
         * We use the DataUtilities class to create a FeatureType that will describe the data in our
         * shapefile.
         *
         * See also the createFeatureType method below for another, more flexible approach.
         */
        final SimpleFeatureType TYPE =
                DataUtilities.createType(
                        "Location",
                        "the_geom:Point:srid=4326,"
                                + // <- the geometry attribute: Point type
                                "name:String,"
                                + // <- a String attribute
                                "number:Integer" // a number attribute
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
        String name = "sfsdfsdfsdfsd";
        int number = 31212;

        /* Longitude (= x coord) first ! */
        Point point = geometryFactory.createPoint(new Coordinate(longitude, latitude));

        featureBuilder.add(point);
        featureBuilder.add(name);
        featureBuilder.add(number);
        SimpleFeature feature = featureBuilder.buildFeature(null);

        features.add(feature);


        DefaultFeatureCollection featureCollection = new DefaultFeatureCollection("internal", TYPE);

        featureCollection.add(features.get(0));






        org.opengis.style.StyleFactory sf = CommonFactoryFinder.getStyleFactory();
        FilterFactory2 ff = CommonFactoryFinder.getFilterFactory2();
        //
        // create the graphical mark used to represent a city
        org.opengis.style.Stroke stroke = sf.stroke(ff.literal("#000000"), null, null, null, null, null, null);
        Fill fill = sf.fill(null, ff.literal(Color.BLUE), ff.literal(1.0));



        StyleFactory styleFactory = CommonFactoryFinder.getStyleFactory();
        StyledLayerDescriptor sld = styleFactory.createStyledLayerDescriptor();








//        // display a data store file chooser dialog for shapefiles
//        LOGGER.info( "Quickstart");
//        LOGGER.config( "Welcome Developers");
//        LOGGER.info("java.util.logging.config.file="+System.getProperty("java.util.logging.config.file"));
//        File file = JFileDataStoreChooser.showOpenFile("shp", null);
//        if (file == null) {
//            return;
//        }
//        LOGGER.config("File selected "+file);

        File file = new File("E:\\Users\\Farid\\Downloads\\IRN_adm\\IRN_adm1.shp");
        File file2 = new File("E:\\Users\\Farid\\Downloads\\IRN_adm\\IRN_adm2.shp");


        FileDataStore store = FileDataStoreFinder.getDataStore(file);
        FileDataStore store2 = FileDataStoreFinder.getDataStore(file2);
        SimpleFeatureSource featureSource = store.getFeatureSource();
        SimpleFeatureSource featureSource2 = store2.getFeatureSource();

        // Create a map content and add our shapefile to it
        MapContent map = new MapContent();
        map.setTitle("Quickstart");

        Style style = SLD.createSimpleStyle(featureSource.getSchema());
        Style style2 = SLD.createPolygonStyle(Color.ORANGE.darker(), Color.getColor("#aa0000"), 0.7f);

//        Style style2 = SLD.createPointStyle("Circle",Color.BLUE.brighter(), Color.RED, 0.5f, 10f);
//        Style style2 = SLD.createPointStyle("Square",Color.BLUE.brighter(), Color.RED, 0.5f, 10f);
//        Style style2 = SLD.createPointStyle("Triangle",Color.BLUE.brighter(), Color.RED, 0.5f, 10f);
        Style style3 = SLD.createPointStyle("Cross",Color.BLUE.brighter(), Color.RED, 0.5f, 10f);

        Layer layer = new FeatureLayer(featureSource, style);
        Layer layer2 = new FeatureLayer(featureSource2, style2);
        Layer layer3 = new FeatureLayer(featureCollection, style3);
        map.addLayer(layer2);
        map.addLayer(layer);
        map.addLayer(layer3);


//        MapViewport mapViewport = new MapViewport(map.getMaxBounds());

        // Now display the map
        JMapFrame.showMap(map);
    }


}