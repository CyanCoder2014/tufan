package com.cyancoder.panel.machine;

import org.geotools.swing.control.JIntegerField;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Corrections extends JFrame {
    private JIntegerField fieldCorRight;
    private JIntegerField fieldCorLeft;
    private JIntegerField fieldCorLess;
    private JIntegerField fieldCorMore;
    private JButton btnSubmitCorrections;
    private JPanel correctionPanel;


    public Corrections(MachinePanel machinePanel){

        setContentPane(correctionPanel);
        setTitle("تصحیحات");
        setSize(350,400);
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        Font fontTahoma = new Font("Tahoma", 0, 12);
        UIManager.put("Label.font", fontTahoma);
        UIManager.put("Button.font", fontTahoma);
        UIManager.put("Field.font", fontTahoma);


        btnSubmitCorrections.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int mx = fieldCorRight.getValue()-fieldCorLeft.getValue();
                int my = fieldCorMore.getValue()-fieldCorLess.getValue();
                machinePanel.setCorrections(mx,my);
                setVisible(false);

            }
        });
    }
}
