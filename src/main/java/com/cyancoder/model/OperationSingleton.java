package com.cyancoder.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OperationSingleton {


    private static OperationSingleton operationSingleton = null;

    private OperationSingleton(){
    }

    private Long id;
    private String name;
    private String mapName;
    private String mapUrl;

    private double dir_cor;
    private int tem_a;


    private int tem_m;
    private int pr;

    private List<FireLoad> fireLoad = new ArrayList<>();
    private Date createdOn;
    private Date updatedOn;


    public static synchronized OperationSingleton getOperationSingleton(){
        if(operationSingleton == null)
            operationSingleton = new OperationSingleton();

        return operationSingleton;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public String getMapUrl() {
        return mapUrl;
    }

    public void setMapUrl(String mapUrl) {
        this.mapUrl = mapUrl;
    }

    public List<FireLoad> getFireLoad() {
        return fireLoad;
    }

    public void setFireLoad(List<FireLoad> fireLoad) {
        this.fireLoad = fireLoad;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }




    public double getDir_cor() {
        return dir_cor;
    }

    public void setDir_cor(double dir_cor) {
        this.dir_cor = dir_cor;
    }

    public int getTem_a() {
        return tem_a;
    }

    public void setTem_a(int tem_a) {
        this.tem_a = tem_a;
    }

    public int getTem_m() {
        return tem_m;
    }

    public void setTem_m(int tem_m) {
        this.tem_m = tem_m;
    }

    public int getPr() {
        return pr;
    }

    public void setPr(int pr) {
        this.pr = pr;
    }









}
