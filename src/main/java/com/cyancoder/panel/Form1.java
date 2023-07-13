package com.cyancoder.panel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form1 extends JFrame {
    private JButton button1;
    private JPanel panel1;
    private JCheckBox checkBox1;
    private JTextField textField1;

    public static Form1 staticForm1;

    public Form1(){


        staticForm1 = this;

        setContentPane(panel1);
        setTitle("Tufan - G11 - انتخاب توپ");
        setSize(700,500);
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Home.staticHome.getTextField1().setText(textField1.getText());
                staticForm1.setVisible(false);

            }
        });
    }
}
