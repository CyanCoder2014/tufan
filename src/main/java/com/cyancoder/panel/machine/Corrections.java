package com.cyancoder.panel.machine;

import com.cyancoder.panel.machine.MachinePanel;
import org.geotools.swing.control.JIntegerField;

import javax.swing.*;
import java.awt.*;

public class Corrections extends JFrame {
    private JIntegerField textField1;
    private JIntegerField textField2;
    private JIntegerField textField3;
    private JIntegerField textField4;
    private JIntegerField textField5;
    private JIntegerField textField6;
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


    }
}
