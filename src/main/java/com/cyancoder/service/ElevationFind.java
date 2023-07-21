package com.cyancoder.service;

import org.geotools.data.*;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;
import org.geotools.filter.text.ecql.ECQL;
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

    public Long findPointElevation(Double x, Double y) {

        // display a data store file chooser dialog for shapefiles
//        File file = JFileDataStoreChooser.showOpenFile("shp", null);
//        if (file == null) {
//            return;
//        }

//        File file = new File("./maps/_demshp/Dem_100.shp");
        File file = new File("./maps/provinces_dem/DEM_AZar_Sharghi.shp");


        FeatureSource<SimpleFeatureType, SimpleFeature> source = null;
        try {
            FileDataStore store = FileDataStoreFinder.getDataStore(file);
            SimpleFeatureSource featureSource = store.getFeatureSource();

            Map<String, Object> map = new HashMap<>();
            map.put("url", file.toURI().toURL());

            System.out.println(store.getSchema());


            DataStore dataStore = DataStoreFinder.getDataStore(map);
            String typeName = dataStore.getTypeNames()[0];


            source = dataStore.getFeatureSource(typeName);
        } catch (Exception ignored) {

        }


        Scanner scanner = new Scanner(System.in);

        double xMin = x - 0.001;
        double xMax = x + 0.001;

        double yMin = y - 0.001;
        double yMax = y + 0.001;

        String sqlFilter = "(X BETWEEN " +
                String.valueOf(Math.round(xMin * 1000.0) / 1000.0) +
                " AND " +
                String.valueOf(Math.round(xMax * 1000.0) / 1000.0) +
                ") AND (Y BETWEEN " +
                String.valueOf(Math.round(yMin * 1000.0) / 1000.0) +
                " AND " +
                String.valueOf(Math.round(yMax * 1000.0) / 1000.0) +
                ")";
        System.out.println(sqlFilter);


        Filter filter = null;

        Long res = 0L;
        try {

//        Filter filter = Filter.INCLUDE; // ECQL.toFilter("BBOX(THE_GEOM, 10,20,30,40)")
//        Filter filter = CQL.toFilter( "X = 46.170833333333 AND Y = 39.695833333333 " );
//        Filter filter = CQL.toFilter( "X LIKE '45.929%' AND Y LIKE '37.525%' " );//********************
//        Filter filter = ECQL.toFilter("(X BETWEEN 45.608 AND 45.612) AND (Y BETWEEN 38.951 AND 38.955)");
            filter = ECQL.toFilter(sqlFilter);

            assert source != null;///////////////////////////////////////////////////////////////********
            FeatureCollection<SimpleFeatureType, SimpleFeature> collection = source.getFeatures(filter);

            FeatureIterator<SimpleFeature> test = collection.features();

            res = Math.round((double) test.next().getAttributes().get(3));
            System.out.println("this one: ");
            System.out.println(res);
            test.close();


        } catch (Exception ignored) {

        }



        return res;


//        try (FeatureIterator<SimpleFeature> features = collection.features()) {
//            while (features.hasNext()) {
//                SimpleFeature feature = features.next();
//                System.out.println(feature.getAttribute("X"));
//                System.out.println(feature.getAttribute("Y"));
//                System.out.println(feature.getAttribute("Z"));
//            }
//        }


    }


}
