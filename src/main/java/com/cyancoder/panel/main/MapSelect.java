package com.cyancoder.panel.main;

import com.cyancoder.model.GeneralFields;
import com.cyancoder.model.OperationSingleton;
import org.apache.commons.lang3.ArrayUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MapSelect extends JFrame {
    private JButton button1;
    JComboBox comboBox1;
    String[] mapSelectArray = GeneralFields.mapSelectArray;

    private JPanel mapSelectPanel;


    private static MapSelect staticMapSelect;
    public MapSelect(OperationSingleton operationSingleton){
        staticMapSelect = this;

        setContentPane(mapSelectPanel);
        setTitle("انتخاب نقشه ارتفاعی منطقه");
        setSize(500,250);
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        setVisible(true);

        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(mapSelectArray);
        comboBox1.setModel(model);

        String selected = operationSingleton.getMapName()!=null?operationSingleton.getMapName():mapSelectArray[0];
        comboBox1.setSelectedIndex(ArrayUtils.indexOf(mapSelectArray, selected));

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operationSingleton.setMapName(comboBox1.getSelectedItem().toString());
                staticMapSelect.setVisible(false);
            }
        });
    }
}
