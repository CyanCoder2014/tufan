package com.cyancoder.panel.setting;

import com.cyancoder.model.Machine;
import com.cyancoder.model.MachineType;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ManageMacType extends javax.swing.JFrame {

    /**
     * Creates new form Crud
     */
    Connection con;
    Statement st;
    Integer macId;
    ArrayList<MachineType> machines = new ArrayList<>();

    public ManageMacType(Integer macId) {
        this.macId = macId;
        initComponents();
        fetch();
    }


    private void initComponents() {

        txtId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtState = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMachines = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete1 = new javax.swing.JButton();
        btnShowDetail = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("تنظیمات خرج توپ ها");
        setResizable(false);
        applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);


        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("نام توپ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("توضیحات");

//        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
//        jLabel3.setText("Reg Number");


        tblMachines.setFont(new java.awt.Font("Tahoma", 0, 12));
        txtId.setFont(new java.awt.Font("Tahoma", 0, 12));
        txtName.setFont(new java.awt.Font("Tahoma", 0, 12));
        txtState.setFont(new java.awt.Font("Tahoma", 0, 12));

        tblMachines.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "شناسه", " خرج توپ"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tblMachines.setCellSelectionEnabled(true);
        tblMachines.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMachinesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMachines);
        if (tblMachines.getColumnModel().getColumnCount() > 0) {
            tblMachines.getColumnModel().getColumn(1).setResizable(false);
        }

        btnSave.setText("افزودن/کپی");
        btnSave.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSave.setIconTextGap(0);
        btnSave.setInheritsPopupMenu(true);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setText("ویرایش");
        btnUpdate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete1.setText("حذف");
        btnDelete1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });

        btnShowDetail.setText("نمایش تنظیمات جدول توپ");
        btnShowDetail.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnShowDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {


                int macTypeId = Integer.parseInt(!txtId.getText().isEmpty()?txtId.getText().trim():"0");
                if (macTypeId != 0) {
                    new ManageMacDetail(macTypeId).setVisible(true);
                } else {
                    alert("موردی انتخاب نشده است!", "No row selected");
                }



            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("افزودن و ویرایش خرج های توپ ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        )
//                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                    .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                                                        .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        )
                                                        )
                                                        .addComponent(btnShowDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))

                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(27, 27, 27)
//                        .addComponent(btnShowDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        ))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(218, 218, 218)
                                .addComponent(jLabel4)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(30, 30, 30)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                                                        .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                )
                                                .addGap(30, 30, 30)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                            .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
//                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                )
                                                .addComponent(btnShowDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(39, 39, 39)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                                .addComponent(btnShowDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(btnDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);

//        setAlignmentX(SwingConstants.RIGHT);
        applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        tblMachines.setAlignmentX(SwingConstants.RIGHT);
        tblMachines.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        tblMachines.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

    }

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        Integer id = null; //txtId.getText().trim();
        String name = txtName.getText().trim();
        String state = txtState.getText().trim();

        if (!name.isEmpty()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tufan-g11", "adminMG", "maghsoud71");
                String sql = "select * from machine_types where machine_id ="+macId+" and id='" + id + "'";
                st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
//                if (!rs.next()) {
                saveMachine(id, name);
                DefaultTableModel model = (DefaultTableModel) tblMachines.getModel();
//                Object[] row = new Object[4];
//                row[0] = id;
//                row[1] = name;
//                row[2] = state;
//                model.addRow(row);
                model.setRowCount(0);
                fetch();

//                } else {
//                    alert("Please provide a different id number", "Similar id found");
//                }

                clear();
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ManageMac.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    con.close();
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ManageMac.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } //        else if (!id.matches("^[0-9]{8}$")) {
        //            alert("please provide a valid id number", "Wrong id");
        //        }
        else {
            alert("نام خرج به درستی وارد نشده است!");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(!txtId.getText().isEmpty()?txtId.getText().trim():"0");
        String name = txtName.getText().trim();
        String state = txtState.getText().trim();
        if (id != 0 && !name.isEmpty()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tufan-g11", "adminMG", "maghsoud71");
                String sql = "select * from machine_types where machine_id ="+macId+" and id='" + id + "'";
                st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);

                System.out.println(sql);
//                System.out.println(rs.relative(1));
                if (rs.next()) {
                    update(id, name);
                    DefaultTableModel model = (DefaultTableModel) tblMachines.getModel();
                    model.setRowCount(0);
                    fetch();
                    alert("ویرایش با موفقیت انجام شد");

                } else {
                    alert("توپ مورد نظر یافت نشد!", "Update error");
                    clear();
                }

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ManageMac.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            alert("موردی برای ویرایش انتخاب نشده است!", "No row selected");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    //set the values of a row to the textfields
    private void tblMachinesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMachinesMouseClicked
        // TODO add your handling code here:
        int i = tblMachines.getSelectedRow();
        TableModel model = tblMachines.getModel();
        txtId.setText(model.getValueAt(i, 0).toString());
        txtName.setText(model.getValueAt(i, 1).toString());
//        txtState.setText(model.getValueAt(i, 2).toString());
    }//GEN-LAST:event_tblMachinesMouseClicked

    //handles delete button action
    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
        // TODO add your handling code here:
        int i = tblMachines.getSelectedRow();
        if (i >= 0) {
            int option = JOptionPane.showConfirmDialog(rootPane,
                    "آیا از حذف این مورد مطمئن هستید؟", "Delete confirmation", JOptionPane.YES_NO_OPTION);
            if (option == 0) {
                TableModel model = tblMachines.getModel();

                Integer id = Integer.valueOf(model.getValueAt(i, 0).toString());
                if (tblMachines.getSelectedRows().length == 1) {
                    delete(id);
                    DefaultTableModel model1 = (DefaultTableModel) tblMachines.getModel();
                    model1.setRowCount(0);
                    fetch();
                    clear();
                }
            }
        } else {
            alert("ابتدا مورد مورد نظر برای حذف را انتخاب کنید");
        }
    }//GEN-LAST:event_btnDelete1ActionPerformed

    //method to show an info alert
    public void alert(String msg) {
        JOptionPane.showMessageDialog(rootPane, msg);
    }

    //method to show an error alert
    public void alert(String msg, String title) {
        JOptionPane.showMessageDialog(rootPane, msg, title, JOptionPane.ERROR_MESSAGE);
    }

    //method to save machine to the db
    public void saveMachine(Integer id, String name) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tufan-g11", "adminMG", "maghsoud71");
            String sql = "INSERT INTO `machine_types`(`id`, `machine_id`, `name`) "
                    + "VALUES (" + id + ","+ macId + ",'" + name + "')";
            st = con.createStatement();
            st.execute(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ManageMac.class.getName()).log(Level.SEVERE, null, ex);
        }
//        fetch();
    }

    //update the db
    public void update(Integer id, String name) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tufan-g11", "adminMG", "maghsoud71");
            String sql = "UPDATE `machine_types`SET name='" + name + "' WHERE id='" + id + "'";
            st = con.createStatement();
            st.execute(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ManageMac.class.getName()).log(Level.SEVERE, null, ex);
        }
//        fetch();
    }

    //delete details in the db
    public void delete(Integer id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tufan-g11", "adminMG", "maghsoud71");
            String sql = "DELETE FROM `machine_types` WHERE id='" + id + "'";
            st = con.createStatement();
            st.execute(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ManageMac.class.getName()).log(Level.SEVERE, null, ex);
        }
        fetch();
    }

    //method to clear the txt fields
    private void clear() {
        txtId.setText("");
        txtName.setText("");
        txtState.setText("");
    }

    //fetch
    private void fetch() {
        machines.clear();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tufan-g11", "adminMG", "maghsoud71");
            String sql = "select * from machine_types where machine_id ="+macId;
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                MachineType machine = new MachineType(rs.getLong("id"), rs.getLong("machine_id"), rs.getString("name"), rs.getInt("state"));
                machines.add(machine);
            }
            DefaultTableModel model = (DefaultTableModel) tblMachines.getModel();
            for (MachineType machine : machines) {

                Object[] row = new Object[4];
                row[0] = machine.getId();
                row[1] = machine.getName();
//                row[2] = machine.getState();

                model.addRow(row);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ManageMac.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ManageMac().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnShowDetail;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMachines;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtState;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
