package com.cyancoder.panel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class newp  extends JFrame {
    private JButton button1;
    private JPanel panel1;
    private JCheckBox checkBox1;
    private JTextField textField1;

    public static newp StaticNewp;

    public newp(){


        StaticNewp = this;

        setContentPane(panel1);
        setTitle("Tufan - G11 - انتخاب توپ");
        setSize(700,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                select1.StaticSelect1.getTextField1().setText(textField1.getText());
                StaticNewp.setVisible(false);

            }
        });
    }
}
