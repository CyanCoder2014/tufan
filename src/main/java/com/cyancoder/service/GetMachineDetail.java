package com.cyancoder.service;

import com.cyancoder.model.MachineDetail;
import com.cyancoder.model.User;
import com.cyancoder.panel.setting.ManageMacType;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GetMachineDetail {



    Connection con;
    Statement st;
    ArrayList<MachineDetail> machineDetails = new ArrayList<>();


    public GetMachineDetail(){
//        machineDetails
    }


    public void fetchData(){




        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tufan-g11", "adminMG", "maghsoud71");
            String sql = "select * from machine_details where id = 1";
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                MachineDetail machineDetail = new MachineDetail(
                        Long.valueOf(rs.getString("id")),
                        Long.valueOf(rs.getString("machine_types_id")),
                        Integer.valueOf(rs.getString("distance")),
                        Double.valueOf(rs.getString("deg_mil"))
                );
                machineDetails.add(machineDetail);
            }



            System.out.println("machineDetails:");
            System.out.println(machineDetails.get(0).getId());
            System.out.println(machineDetails.get(0).getDistance());


        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ManageMacType.class.getName()).log(Level.SEVERE, null, ex);
        }




    }
}
