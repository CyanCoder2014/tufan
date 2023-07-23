package com.cyancoder.panel.main;

import com.cyancoder.model.OperationSingleton;

import javax.swing.*;
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
    private JCheckBox checkBox1;
    private JTextField textField1;
    private JComboBox comboBox1;

    public static Operation staticOperation;

    public Operation(OperationSingleton operationSingleton){

        textField1.setText(operationSingleton.getName());

        staticOperation = this;

        setContentPane(panel1);
        setTitle("Tufan - G11 - انتخاب توپ");
        setSize(700,500);
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operationSingleton.setName(textField1.getText());
                Home.staticHome.getTextField1().setText(operationSingleton.getName());
                staticOperation.setVisible(false);
            }
        });
    }
}
