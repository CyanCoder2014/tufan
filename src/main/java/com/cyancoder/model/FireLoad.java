package com.cyancoder.model;

import java.util.Date;

public class FireLoad {

    private Long id;
    private String name;
    private String originX;
    private String originY;
    private String targetX;
    private String targetY;
    private String machineId;
    private String machineName;
    private String machineType;
    private Date createdOn;



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

    public String getOriginX() {
        return originX;
    }

    public void setOriginX(String originX) {
        this.originX = originX;
    }

    public String getOriginY() {
        return originY;
    }

    public void setOriginY(String originY) {
        this.originY = originY;
    }

    public String getTargetX() {
        return targetX;
    }

    public void setTargetX(String targetX) {
        this.targetX = targetX;
    }

    public String getTargetY() {
        return targetY;
    }

    public void setTargetY(String targetY) {
        this.targetY = targetY;
    }

    public String getMachineId() {
        return machineId;
    }

    public void setMachineId(String machineId) {
        this.machineId = machineId;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
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

    private Date updatedOn;
}
