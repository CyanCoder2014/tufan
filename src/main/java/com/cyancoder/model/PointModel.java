package com.cyancoder.model;

import java.awt.geom.Point2D;

public class PointModel extends Point2D.Double {


    public PointModel(double latitude,double longitude){
        setLatitude(latitude);
        setLongitude(longitude);
    }

    private  double latitude;
    private  double longitude;
    private  double elevation;
    private  String name;
    private  String note;


    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getElevation() {
        return elevation;
    }

    public void setElevation(double elevation) {
        this.elevation = elevation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
