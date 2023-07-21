package com.cyancoder.service;


import java.awt.*;

import static java.lang.Math.*;

public class CalculateGisItems {


    public Long calculateDistance(Double originX, Double originY,Double targetX,Double targetY){

        double rad = PI / 180;
        long radius = 6371; //earth radius in kilometers

        double d = radius * acos(sin(originX*rad) * sin(targetX*rad) + cos(originX*rad) * cos(targetX*rad) * cos(targetY*rad - originY*rad));

        return Math.round(d*1000);


    }

    public Long calculateMilDirection(Double originX, Double originY,Double targetX,Double targetY){

        double xDiff = targetX - originX;
        double yDiff = targetY - originY;

//        double angle = (double) Math.toDegrees(Math.atan2(targetY - originY, targetX - originX));
//        if(angle < 0)
//            angle += 360;

        double angle = (double) Math.toDegrees(Math.atan(abs(xDiff)/abs(yDiff)));

        if(xDiff > 0 && yDiff < 0 )
            angle = 180 - Math.abs(angle);
        if(xDiff < 0 && yDiff < 0 )
            angle = 180 + Math.abs(angle);
        if(xDiff < 0 && yDiff > 0 )
            angle = 360 - Math.abs(angle);

        return Math.round(angle);
    }



    public static double distance(double lat1,
                                  double lat2, double lon1,
                                  double lon2)
    {

        // The math module contains a function
        // named toRadians which converts from
        // degrees to radians.
        lon1 = Math.toRadians(lon1);
        lon2 = Math.toRadians(lon2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // Haversine formula
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2),2);

        double c = 2 * Math.asin(Math.sqrt(a));

        // Radius of earth in kilometers. Use 3956
        // for miles
        double r = 6371;

        // calculate the result
        return(c * r);
    }




}
