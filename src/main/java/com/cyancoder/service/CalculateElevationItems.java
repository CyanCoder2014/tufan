package com.cyancoder.service;

public class CalculateElevationItems {


    public Long calculateElvDifference(Long x, Long y){

        return y-x;

    }

    public Long calculateLevelDifference(Long elvDif, Double distance){

        long res = 0L;

        if (distance != 0 && elvDif != 0)
            res =Math.round(elvDif/(distance/1000));

        return res;
    }


}
