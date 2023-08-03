package com.cyancoder.model;

import java.util.Date;

public class MachineDetail {

    private  Long id;
    private  Long machine_types_id;
    private  int distance;  // برد
    private  double deg_mil;  // درجه میلیم
    private  double deg_bar;  // درجه بارابان
    private  double deg_bar_b;  // درجه بازوئی
    private  int top;  // قله مسیر گلوله

    private  int cor_dir;  // تصحیحات: سمت: انحراف
    private  int cor_dir_w;  // تصحیحات: سمت: باد 10 متر در ثانیه
    private  int cor_dis_w;  //  تصحیحات: برد: باد بردی 10 متر در ثانیه
    private  int cor_dis_p;  //  تصحیحات: عنوان
    private  int cor_dis_air_tem;  //  تصحیحات: عنوان
    private  int cor_dis_s;  //  تصحیحات: عنوان
    private  int cor_dis_tem;  //  تصحیحات: عنوان
    private  int cor_dis_wg;  //  تصحیحات: عنوان
    private  int cor_dis_mil;  //  تصحیحات: عنوان

    private  int dis_deg;  // تغییر برد به ازای یک میلیم تغییر در زاویه درجه
    private  int b;  // دوشاخه
    private  int deg;  // زاویه درجه
    private  double land_deg;  // زاویه فرود
    private  int speed;  // سرعت نهایی
    private  int flight_time;  // زمان پرواز
    private  int err_dis;  // title
    private  int err_h;  // title
    private  int err_dir;  // title
    private  int state;
    private Date created_on;


    public MachineDetail(Long id, Long machine_types_id, int distance, double deg_mil, double deg_bar, double deg_bar_b, int top, int cor_dir, int cor_dir_w, int cor_dis_w, int cor_dis_p, int cor_dis_air_tem, int cor_dis_s, int cor_dis_tem, int cor_dis_wg, int cor_dis_mil, int dis_deg, int b, int deg, double land_deg, int speed, int flight_time, int err_dis, int err_h, int err_dir, int state, Date created_on) {
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

    public MachineDetail(Long id, Long machine_types_id, int distance, double deg_mil){
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

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public double getDeg_mil() {
        return deg_mil;
    }

    public void setDeg_mil(double deg_mil) {
        this.deg_mil = deg_mil;
    }

    public double getDeg_bar() {
        return deg_bar;
    }

    public void setDeg_bar(double deg_bar) {
        this.deg_bar = deg_bar;
    }

    public double getDeg_bar_b() {
        return deg_bar_b;
    }

    public void setDeg_bar_b(double deg_bar_b) {
        this.deg_bar_b = deg_bar_b;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getCor_dir() {
        return cor_dir;
    }

    public void setCor_dir(int cor_dir) {
        this.cor_dir = cor_dir;
    }

    public int getCor_dir_w() {
        return cor_dir_w;
    }

    public void setCor_dir_w(int cor_dir_w) {
        this.cor_dir_w = cor_dir_w;
    }

    public int getCor_dis_w() {
        return cor_dis_w;
    }

    public void setCor_dis_w(int cor_dis_w) {
        this.cor_dis_w = cor_dis_w;
    }

    public int getCor_dis_p() {
        return cor_dis_p;
    }

    public void setCor_dis_p(int cor_dis_p) {
        this.cor_dis_p = cor_dis_p;
    }

    public int getCor_dis_air_tem() {
        return cor_dis_air_tem;
    }

    public void setCor_dis_air_tem(int cor_dis_air_tem) {
        this.cor_dis_air_tem = cor_dis_air_tem;
    }

    public int getCor_dis_s() {
        return cor_dis_s;
    }

    public void setCor_dis_s(int cor_dis_s) {
        this.cor_dis_s = cor_dis_s;
    }

    public int getCor_dis_tem() {
        return cor_dis_tem;
    }

    public void setCor_dis_tem(int cor_dis_tem) {
        this.cor_dis_tem = cor_dis_tem;
    }

    public int getCor_dis_wg() {
        return cor_dis_wg;
    }

    public void setCor_dis_wg(int cor_dis_wg) {
        this.cor_dis_wg = cor_dis_wg;
    }

    public int getCor_dis_mil() {
        return cor_dis_mil;
    }

    public void setCor_dis_mil(int cor_dis_mil) {
        this.cor_dis_mil = cor_dis_mil;
    }

    public int getDis_deg() {
        return dis_deg;
    }

    public void setDis_deg(int dis_deg) {
        this.dis_deg = dis_deg;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    public double getLand_deg() {
        return land_deg;
    }

    public void setLand_deg(double land_deg) {
        this.land_deg = land_deg;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getFlight_time() {
        return flight_time;
    }

    public void setFlight_time(int flight_time) {
        this.flight_time = flight_time;
    }

    public int getErr_dis() {
        return err_dis;
    }

    public void setErr_dis(int err_dis) {
        this.err_dis = err_dis;
    }

    public int getErr_h() {
        return err_h;
    }

    public void setErr_h(int err_h) {
        this.err_h = err_h;
    }

    public int getErr_dir() {
        return err_dir;
    }

    public void setErr_dir(int err_dir) {
        this.err_dir = err_dir;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Date created_on) {
        this.created_on = created_on;
    }



}
