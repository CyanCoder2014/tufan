package com.cyancoder.panel.main;

import com.cyancoder.model.OperationSingleton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MapSelect extends JFrame {
    private JButton button1;
    JComboBox comboBox1;
    String[] mapSelectArray = new String[]{"نقشه ارتفاعی آذربایجان شرقی"
    , "نقشه ارتفاعی آذربایجان غربی", "نقشه ارتفاعی کردستان", "نقشه ارتفاعی اردبیل", "نقشه ارتفاعی تجمیعی ۴ استان"};

    private JPanel mapSelectPanel;


    private static MapSelect staticMapSelect;
    public MapSelect(OperationSingleton operationSingleton){

        comboBox1.setSelectedItem(operationSingleton.getMapName());

        staticMapSelect = this;

        setContentPane(mapSelectPanel);
        setTitle("انتخاب نقشه ارتفاعی منطقه");
        setSize(500,250);
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(mapSelectArray);
        comboBox1.setModel(model);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operationSingleton.setMapName(comboBox1.getSelectedItem().toString());
                staticMapSelect.setVisible(false);
            }
        });
    }
}
