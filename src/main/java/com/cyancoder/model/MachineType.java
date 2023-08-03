package com.cyancoder.model;

import java.util.Date;

public class MachineType {

    private  Long id;
    private  Long machine_id;
    private  String name;
    private  Integer state;
    private Date created_on;


    public MachineType(Long id, Long machine_id, String name, Integer state){
        this.id = id;
        this.machine_id = machine_id;
        this.name = name;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMachine_id() {
        return machine_id;
    }

    public void setMachine_id(Long machine_id) {
        this.machine_id = machine_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Date created_on) {
        this.created_on = created_on;
    }



}
