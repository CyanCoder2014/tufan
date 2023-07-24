package com.cyancoder.service;

public class CalculateElevationItems {


    public Long calculateElvDifference(Long x, Long y){

        return y-x;

    }

    public Long calculateLevelDifference(Long elvDif, Long distance){

        long res = 0L;

        if (distance != 0 && elvDif != 0)
            res =elvDif/(distance/1000);

        return res;
    }


}
