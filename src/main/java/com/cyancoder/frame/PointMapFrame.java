package com.cyancoder.frame;

import org.geotools.map.MapContent;
import org.geotools.swing.JMapFrame;

import javax.swing.*;

public class PointMapFrame extends JMapFrame {


    public PointMapFrame(MapContent content){
        if (SwingUtilities.isEventDispatchThread()) {
            doShowMap(content);
        } else {
            SwingUtilities.invokeLater(() -> {
                doShowMap(content);
            });
        }
    }



    private static void doShowMap(MapContent content) {
        JMapFrame frame = new JMapFrame(content);
        frame.enableStatusBar(true);
        frame.enableToolBar(true);
        frame.initComponents();
        frame.setSize(700, 600);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}
