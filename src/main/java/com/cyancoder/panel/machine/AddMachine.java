package com.cyancoder.panel.machine;

import com.cyancoder.model.FireLoad;
import com.cyancoder.model.OperationSingleton;
import com.cyancoder.panel.main.Home;
import com.cyancoder.panel.main.MapSelect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.cyancoder.panel.main.Home.staticHome;

public class AddMachine extends JFrame{
    private JTextField textField1;
    private JButton Button6;
    private JComboBox comboBox1;
    private JPanel addMachinePanel;


    private static AddMachine staticAddMachine;
    public AddMachine(OperationSingleton operationSingleton) {

        staticAddMachine = this;

        setContentPane(addMachinePanel);
        setTitle("افزودن آتشبار");
        setSize(500,250);
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        setVisible(true);




        Button6.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            FireLoad fireLoad = new FireLoad();
//            fireLoad.setId(); // if selected old fire_load from DB
            fireLoad.setName(textField1.getText());
            operationSingleton.getFireLoad().add(fireLoad);

            JPanel machinePanel = new MachinePanel();
            staticHome.getTabbedPane1().add(fireLoad.getName(), machinePanel);
            staticAddMachine.setVisible(false);
        }
    });
}
}
