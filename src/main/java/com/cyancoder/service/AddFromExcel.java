package com.cyancoder.service;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import javax.swing.*;

public class AddFromExcel {


    private static int machine_type_id;
    private static String fileName;

    public static void insert(int machineTypeId) {


        JFileChooser chooser = new JFileChooser();
        int status = chooser.showOpenDialog(null);
        if (status == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            if (file == null) {
                return;
            }

            fileName = chooser.getSelectedFile().getAbsolutePath();
        }

        String jdbcURL = "jdbc:mysql://localhost:3306/tufan-g11";
        String username = "adminMG";
        String password = "maghsoud71";

//        Class.forName("com.mysql.cj.jdbc.Driver");



//        String excelFilePath = "file.xlsx";
        String excelFilePath = fileName;

        int batchSize = 20;

        Connection connection = null;

        try {
            long start = System.currentTimeMillis();



            FileInputStream inputStream = new FileInputStream(excelFilePath);

            Workbook workbook = new XSSFWorkbook(inputStream);

            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = firstSheet.iterator();

            connection = DriverManager.getConnection(jdbcURL, username, password);
            connection.setAutoCommit(false);

            String sql = "INSERT INTO machine_details " +
                    "(`machine_types_id`, `distance`, `deg_mil`, `deg_bar`, `deg_bar_b`, `top`,    `cor_dir`, `cor_dir_w`, `cor_dis_w`, `cor_dis_p`, `cor_dis_air_tem`, `cor_dis_s`, `cor_dis_tem`, `cor_dis_wg`, `cor_dis_mil`,              `dis_deg`, `b`, `deg`, `land_deg`, `speed`, `flight_time`, `err_dis`, `err_h`, `err_dir`) " +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            int count = 0;

            rowIterator.next(); // skip the header row

            while (rowIterator.hasNext()) {
                Row nextRow = rowIterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell nextCell = cellIterator.next();

                    int columnIndex = nextCell.getColumnIndex();

                    switch (columnIndex) {
                        case 0:
                            int machine_types_id = machine_type_id;
                            statement.setInt(1, machine_types_id);
                            break;
                        case 1:
                            int distance = Integer.parseInt(nextCell.getStringCellValue());
                            statement.setInt(2, distance);
                            break;
                        case 2:
                            int deg_mil = Integer.parseInt(nextCell.getStringCellValue());
                            statement.setInt(3, deg_mil);
                            break;
                        case 3:
                            double deg_bar = Double.parseDouble(nextCell.getStringCellValue());
                            statement.setDouble(4, deg_bar);
                            break;
                        case 4:
                            double deg_bar_b = Double.parseDouble(nextCell.getStringCellValue());
                            statement.setDouble(5, deg_bar_b);
                            break;
                        case 5:
                            int top = Integer.parseInt(nextCell.getStringCellValue());
                            statement.setInt(6, top);
                            break;
                        case 6:
                            int cor_dir = Integer.parseInt(nextCell.getStringCellValue());
                            statement.setInt(7, cor_dir);
                            break;
                        case 7:
                            int cor_dir_w = Integer.parseInt(nextCell.getStringCellValue());
                            statement.setInt(8, cor_dir_w);
                            break;
                        case 8:
                            int cor_dis_w = Integer.parseInt(nextCell.getStringCellValue());
                            statement.setInt(9, cor_dis_w);
                            break;
                        case 9:
                            int cor_dis_p = Integer.parseInt(nextCell.getStringCellValue());
                            statement.setInt(10, cor_dis_p);
                            break;
                        case 10:
                            int cor_dis_air_tem = Integer.parseInt(nextCell.getStringCellValue());
                            statement.setInt(11, cor_dis_air_tem);
                            break;
                        case 11:
                            int cor_dis_s = Integer.parseInt(nextCell.getStringCellValue());
                            statement.setInt(12, cor_dis_s);
                            break;
                        case 12:
                            int cor_dis_tem = Integer.parseInt(nextCell.getStringCellValue());
                            statement.setInt(13, cor_dis_tem);
                            break;
                        case 13:
                            int cor_dis_wg = Integer.parseInt(nextCell.getStringCellValue());
                            statement.setInt(14, cor_dis_wg);
                            break;
                        case 14:
                            int cor_dis_mil = Integer.parseInt(nextCell.getStringCellValue());
                            statement.setInt(15, cor_dis_mil);
                            break;
                        case 15:
                            int dis_deg = Integer.parseInt(nextCell.getStringCellValue());
                            statement.setInt(16, dis_deg);
                            break;
                        case 16:
                            int b = Integer.parseInt(nextCell.getStringCellValue());
                            statement.setInt(17, b);
                            break;
                        case 17:
                            int deg = Integer.parseInt(nextCell.getStringCellValue());
                            statement.setInt(18, deg);
                            break;
                        case 18:
                            double land_deg = Double.parseDouble(nextCell.getStringCellValue());
                            statement.setDouble(19, land_deg);
                            break;
                        case 19:
                            int speed = Integer.parseInt(nextCell.getStringCellValue());
                            statement.setInt(20, speed);
                            break;
                        case 20:
                            int flight_time = Integer.parseInt(nextCell.getStringCellValue());
                            statement.setInt(21, flight_time);
                            break;
                        case 21:
                            int err_dis = Integer.parseInt(nextCell.getStringCellValue());
                            statement.setInt(22, err_dis);
                            break;
                        case 22:
                            int err_h = Integer.parseInt(nextCell.getStringCellValue());
                            statement.setInt(23, err_h);
                            break;
                        case 23:
                            int err_dir = Integer.parseInt(nextCell.getStringCellValue());
                            statement.setInt(24, err_dir);
                            break;

//                        case 2:
//                            int state = (int) nextCell.getNumericCellValue();
//                            statement.setInt(3, state);
//                        case 1:
//                            Date created_on = nextCell.getDateCellValue();
//                            statement.setTimestamp(2, new Timestamp(created_on.getTime()));

                    }

                }

                statement.addBatch();

                if (count % batchSize == 0) {
                    statement.executeBatch();
                }

            }

            workbook.close();

            // execute the remaining queries
            statement.executeBatch();

            connection.commit();
            connection.close();

            long end = System.currentTimeMillis();
            System.out.printf("Import done in %d ms\n", (end - start));

        } catch (IOException ex1) {
            System.out.println("Error reading file");
            ex1.printStackTrace();
        } catch (SQLException ex2) {
            System.out.println("Database error");
            ex2.printStackTrace();
        }

    }



}
