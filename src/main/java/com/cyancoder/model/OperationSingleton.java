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













}
