package com.cyancoder.service;

import com.cyancoder.model.Machine;
import com.cyancoder.model.MachineDetail;
import com.cyancoder.model.MachineType;
import com.cyancoder.panel.setting.ManageMacType;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MachineService {


    Connection con;
    Statement st;
    ArrayList<Machine> machines = new ArrayList<>();
    ArrayList<MachineType> machineTypes = new ArrayList<>();
    ArrayList<MachineDetail> machineDetails = new ArrayList<>();


    public MachineService() {
//        machineDetails
    }


    public MachineDetail getMachineDetails(String mac, String type, Long distance) {

        machineTypes = fetchMachineTypes(mac, type);
        MachineType machineType = machineTypes.size() > 0 ? machineTypes.get(0) : null;
        Long machineTypeId = machineType != null ? machineType.getId() : null;

        return fetchData(String.valueOf(machineTypeId), String.valueOf(roundDistance(distance)));

    }

    public int roundDistance(Long distance) {

        return Math.round(distance / 200) * 200;

    }


    public ArrayList<Machine> fetchMachines() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tufan-g11", "adminMG", "maghsoud71");
            StringBuilder sqlStringBuilder = new StringBuilder();
            sqlStringBuilder.append("SELECT * FROM machines m ;");

            String sql = sqlStringBuilder.toString();
            System.out.println(sql);

            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Machine machine = new Machine(
                        Long.valueOf(rs.getString("id")),
                        rs.getString("name"),
                        null
                );
                machines.add(machine);
            }


        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ManageMacType.class.getName()).log(Level.SEVERE, null, ex);
        }

        return machines;
    }


    public ArrayList<MachineType> fetchMachineTypes(String mac, String type) {
        Integer macId = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tufan-g11", "adminMG", "maghsoud71");
            StringBuilder sqlStringBuilder = new StringBuilder();
            sqlStringBuilder.append("SELECT * FROM machines m " +
                            " LEFT JOIN machine_types mt ON m.id = mt.machine_id WHERE ")
                    .append("m.name LIKE ").append("'%").append(mac).append("%'");
            if (type != null) {
                sqlStringBuilder.append(" AND ")
                        .append("mt.name LIKE ").append("'%").append(type).append("%'");
            }
            sqlStringBuilder.append(";");

            String sql = sqlStringBuilder.toString();
            System.out.println(sql);

            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println("mt.id");
                System.out.println(rs.getString("mt.id"));

                MachineType machineType = new MachineType(
                        Long.valueOf(rs.getString("mt.id")),
                        Long.valueOf(rs.getString("mt.machine_id")),
                        rs.getString("mt.name"),
                        null
                );
                machineTypes.add(machineType);
            }


        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ManageMacType.class.getName()).log(Level.SEVERE, null, ex);
        }


        return machineTypes;
    }



    public ArrayList<MachineType> fetchMachineTypes(Integer macId, Integer typeId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tufan-g11", "adminMG", "maghsoud71");
            StringBuilder sqlStringBuilder = new StringBuilder();
            sqlStringBuilder.append("SELECT * FROM machines m " +
                            " LEFT JOIN machine_types mt ON m.id = mt.machine_id WHERE ")
                    .append("m.id = ").append(macId);
            if (typeId != null) {
                sqlStringBuilder.append(" AND ")
                        .append("mt.id = ").append(typeId);
            }
            sqlStringBuilder.append(";");

            String sql = sqlStringBuilder.toString();
            System.out.println(sql);

            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println("mt.id");
                System.out.println(rs.getString("mt.id"));

                MachineType machineType = new MachineType(
                        Long.valueOf(rs.getString("mt.id")),
                        Long.valueOf(rs.getString("mt.machine_id")),
                        rs.getString("mt.name"),
                        null
                );
                machineTypes.add(machineType);
            }


        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ManageMacType.class.getName()).log(Level.SEVERE, null, ex);
        }


        return machineTypes;
    }


    public MachineDetail fetchData(String typeId, String distance) {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tufan-g11", "adminMG", "maghsoud71");
            StringBuilder sqlStringBuilder = new StringBuilder();
            sqlStringBuilder.append("SELECT * FROM machine_details md " +
//                            " LEFT JOIN machine_types mt ON mt.id = md.machine_types_id " +
                            "WHERE ")
                    .append("md.machine_types_id = ")
                    .append(typeId)
                    .append(" AND ")
                    .append("distance = ")
                    .append(distance);


            String sql = sqlStringBuilder.toString();
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                MachineDetail machineDetail = new MachineDetail(
                        rs.getLong("id"),
                        rs.getLong("machine_types_id"),
                        rs.getInt("distance"),
                        rs.getInt("deg_mil"),
                        rs.getDouble("deg_bar"),
                        rs.getDouble("deg_bar_b"),
                        rs.getInt("top"),
                        rs.getInt("cor_dir"),
                        rs.getInt("cor_dir_w"),
                        rs.getInt("cor_dis_w"),
                        rs.getInt("cor_dis_p"),
                        rs.getInt("cor_dis_air_tem"),
                        rs.getInt("cor_dis_s"),
                        rs.getInt("cor_dis_tem"),
                        rs.getInt("cor_dis_wg"),
                        rs.getInt("cor_dis_mil"),
                        rs.getInt("dis_deg"),
                        rs.getInt("b"),
                        rs.getInt("deg"),
                        rs.getDouble("land_deg"),
                        rs.getInt("speed"),
                        rs.getInt("flight_time"),
                        rs.getInt("err_dis"),
                        rs.getInt("err_h"),
                        rs.getInt("err_dir")
                );
                machineDetails.add(machineDetail);
            }


            System.out.println("machineDetails:");
            System.out.println(machineDetails.size() > 0 ? machineDetails.get(0).getId() : null);
            System.out.println(machineDetails.size() > 0 ? machineDetails.get(0).getDistance() : null);


        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ManageMacType.class.getName()).log(Level.SEVERE, null, ex);
        }

        return machineDetails.size() > 0 ? machineDetails.get(0) : null;///////


    }
}
