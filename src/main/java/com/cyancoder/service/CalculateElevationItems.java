package com.cyancoder.service;

public class CalculateElevationItems {


    public Long calculateElvDifference(Long x, Long y){

        return y-x;

    }

    public Long calculateLevelDifference(Long elvDif, Long Distance){

        return elvDif/(Distance/1000);

    }


}
