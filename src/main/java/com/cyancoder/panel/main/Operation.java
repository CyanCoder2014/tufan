package com.cyancoder.panel.main;

import com.cyancoder.model.OperationSingleton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Operation extends JFrame {
    private JButton button1;

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    private JPanel panel1;
    private JTextField textField1;
    private JComboBox selectOperation;
    private JTextField fieldTemA;
    private JTextField fieldTemM;
    private JTextField fieldPr;
    private JTextField fieldDirCor;

    public static Operation staticOperation;

    public Operation(OperationSingleton operationSingleton){

        textField1.setText(operationSingleton.getName());

        staticOperation = this;

        setContentPane(panel1);
        setTitle("ثبت عملیات");
        setSize(500,400);
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        setVisible(true);


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operationSingleton.setName(textField1.getText());
                operationSingleton.setTem_a(Integer.parseInt(fieldTemA.getText()));
                operationSingleton.setTem_m(Integer.parseInt(fieldTemM.getText()));
                operationSingleton.setPr(Integer.parseInt(fieldPr.getText()));
                operationSingleton.setDir_cor(Double.parseDouble(fieldDirCor.getText()));
                Home.staticHome.getTextField1().setText(operationSingleton.getName());
                staticOperation.setVisible(false);
            }
        });
    }
}
