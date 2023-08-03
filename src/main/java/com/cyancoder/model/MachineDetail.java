package com.cyancoder.model;

import java.util.Date;

public class MachineDetail {

    private  Long id;
    private  Long machine_types_id;
    private  Integer distance;  // برد
    private  Double deg_mil;  // درجه میلیم
    private  Double deg_bar;  // درجه بارابان
    private  Double deg_bar_b;  // درجه بازوئی
    private  Integer top;  // قله مسیر گلوله

    private  Integer cor_dir;  // تصحیحات: سمت: انحراف
    private  Integer cor_dir_w;  // تصحیحات: سمت: باد 10 متر در ثانیه
    private  Integer cor_dis_w;  //  تصحیحات: برد: باد بردی 10 متر در ثانیه
    private  Integer cor_dis_p;  //  تصحیحات: عنوان
    private  Integer cor_dis_air_tem;  //  تصحیحات: عنوان
    private  Integer cor_dis_s;  //  تصحیحات: عنوان
    private  Integer cor_dis_tem;  //  تصحیحات: عنوان
    private  Integer cor_dis_wg;  //  تصحیحات: عنوان
    private  Integer cor_dis_mil;  //  تصحیحات: عنوان

    private  Integer dis_deg;  // تغییر برد به ازای یک میلیم تغییر در زاویه درجه
    private  Integer b;  // دوشاخه
    private  Integer deg;  // زاویه درجه
    private  Double land_deg;  // زاویه فرود
    private  Integer speed;  // سرعت نهایی
    private  Integer flight_time;  // زمان پرواز
    private  Integer err_dis;  // title
    private  Integer err_h;  // title
    private  Integer err_dir;  // title
    private  Integer state;
    private Date created_on;


    public MachineDetail(Long id, Long machine_types_id, Integer distance, Double deg_mil, Double deg_bar, Double deg_bar_b, Integer top, Integer cor_dir, Integer cor_dir_w, Integer cor_dis_w, Integer cor_dis_p, Integer cor_dis_air_tem, Integer cor_dis_s, Integer cor_dis_tem, Integer cor_dis_wg, Integer cor_dis_mil, Integer dis_deg, Integer b, Integer deg, Double land_deg, Integer speed, Integer flight_time, Integer err_dis, Integer err_h, Integer err_dir, Integer state, Date created_on) {
        this.id = id;
        this.machine_types_id = machine_types_id;
        this.distance = distance;
        this.deg_mil = deg_mil;
        this.deg_bar = deg_bar;
        this.deg_bar_b = deg_bar_b;
        this.top = top;
        this.cor_dir = cor_dir;
        this.cor_dir_w = cor_dir_w;
        this.cor_dis_w = cor_dis_w;
        this.cor_dis_p = cor_dis_p;
        this.cor_dis_air_tem = cor_dis_air_tem;
        this.cor_dis_s = cor_dis_s;
        this.cor_dis_tem = cor_dis_tem;
        this.cor_dis_wg = cor_dis_wg;
        this.cor_dis_mil = cor_dis_mil;
        this.dis_deg = dis_deg;
        this.b = b;
        this.deg = deg;
        this.land_deg = land_deg;
        this.speed = speed;
        this.flight_time = flight_time;
        this.err_dis = err_dis;
        this.err_h = err_h;
        this.err_dir = err_dir;
        this.state = state;
        this.created_on = created_on;
    }

    public MachineDetail(Long id, Long machine_types_id, Integer distance, Double deg_mil){
        this.id = id;
        this.machine_types_id = machine_types_id;
        this.distance = distance;
        this.deg_mil = deg_mil;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMachine_types_id() {
        return machine_types_id;
    }

    public void setMachine_types_id(Long machine_types_id) {
        this.machine_types_id = machine_types_id;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Double getDeg_mil() {
        return deg_mil;
    }

    public void setDeg_mil(Double deg_mil) {
        this.deg_mil = deg_mil;
    }

    public Double getDeg_bar() {
        return deg_bar;
    }

    public void setDeg_bar(Double deg_bar) {
        this.deg_bar = deg_bar;
    }

    public Double getDeg_bar_b() {
        return deg_bar_b;
    }

    public void setDeg_bar_b(Double deg_bar_b) {
        this.deg_bar_b = deg_bar_b;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public Integer getCor_dir() {
        return cor_dir;
    }

    public void setCor_dir(Integer cor_dir) {
        this.cor_dir = cor_dir;
    }

    public Integer getCor_dir_w() {
        return cor_dir_w;
    }

    public void setCor_dir_w(Integer cor_dir_w) {
        this.cor_dir_w = cor_dir_w;
    }

    public Integer getCor_dis_w() {
        return cor_dis_w;
    }

    public void setCor_dis_w(Integer cor_dis_w) {
        this.cor_dis_w = cor_dis_w;
    }

    public Integer getCor_dis_p() {
        return cor_dis_p;
    }

    public void setCor_dis_p(Integer cor_dis_p) {
        this.cor_dis_p = cor_dis_p;
    }

    public Integer getCor_dis_air_tem() {
        return cor_dis_air_tem;
    }

    public void setCor_dis_air_tem(Integer cor_dis_air_tem) {
        this.cor_dis_air_tem = cor_dis_air_tem;
    }

    public Integer getCor_dis_s() {
        return cor_dis_s;
    }

    public void setCor_dis_s(Integer cor_dis_s) {
        this.cor_dis_s = cor_dis_s;
    }

    public Integer getCor_dis_tem() {
        return cor_dis_tem;
    }

    public void setCor_dis_tem(Integer cor_dis_tem) {
        this.cor_dis_tem = cor_dis_tem;
    }

    public Integer getCor_dis_wg() {
        return cor_dis_wg;
    }

    public void setCor_dis_wg(Integer cor_dis_wg) {
        this.cor_dis_wg = cor_dis_wg;
    }

    public Integer getCor_dis_mil() {
        return cor_dis_mil;
    }

    public void setCor_dis_mil(Integer cor_dis_mil) {
        this.cor_dis_mil = cor_dis_mil;
    }

    public Integer getDis_deg() {
        return dis_deg;
    }

    public void setDis_deg(Integer dis_deg) {
        this.dis_deg = dis_deg;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    public Integer getDeg() {
        return deg;
    }

    public void setDeg(Integer deg) {
        this.deg = deg;
    }

    public Double getLand_deg() {
        return land_deg;
    }

    public void setLand_deg(Double land_deg) {
        this.land_deg = land_deg;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getFlight_time() {
        return flight_time;
    }

    public void setFlight_time(Integer flight_time) {
        this.flight_time = flight_time;
    }

    public Integer getErr_dis() {
        return err_dis;
    }

    public void setErr_dis(Integer err_dis) {
        this.err_dis = err_dis;
    }

    public Integer getErr_h() {
        return err_h;
    }

    public void setErr_h(Integer err_h) {
        this.err_h = err_h;
    }

    public Integer getErr_dir() {
        return err_dir;
    }

    public void setErr_dir(Integer err_dir) {
        this.err_dir = err_dir;
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
