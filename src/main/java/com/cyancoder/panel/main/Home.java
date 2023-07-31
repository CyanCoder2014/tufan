package com.cyancoder.panel.main;

import com.cyancoder.model.OperationSingleton;
import com.cyancoder.panel.machine.AddMachine;
import com.cyancoder.panel.machine.MachinePanel;
import com.cyancoder.service.ShowMap;
import org.geotools.feature.SchemaException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Home extends JFrame{

    private JPanel homePanel;
    private JButton button1;
    private JButton btnShowMap;

    public JTextField getTextField1() {
        return textField1;
    }

    public void setTextField1(JTextField textField1) {
        this.textField1 = textField1;
    }

    private  JTextField textField1;

    public JTabbedPane getTabbedPane1() {
        return tabbedPane1;
    }

    private JTabbedPane tabbedPane1;
    private  JLabel wIcon;
    private JButton button3;
    private JPanel topPanel;
    private JButton Button11;
    private JButton Button22;
    private JPanel tab1;
    private JLabel labelHomeTitle;
    private JButton btnAbout;

    private static String baseLoc = "C:\\Tufan-Application";

    public static Home staticHome;

    public Home() {

        staticHome = this;

        setContentPane(homePanel);
        setTitle("Tufan - G11");
        setSize(1100,750);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        Font fontTahoma = new Font("Tahoma", 0, 12);
        UIManager.put("Label.font", fontTahoma);
        UIManager.put("Button.font", fontTahoma);
        UIManager.put("Field.font", fontTahoma);
        changeFont(homePanel,fontTahoma);
        labelHomeTitle.setFont(new Font("Tahoma", 1, 16));

        wIcon.setIcon(new ImageIcon(baseLoc+"/images/icons/map_location_pin_marker-01.png")); //Sets the image to be displayed as an icon
        Dimension size = wIcon.getPreferredSize(); //Gets the size of the image
        wIcon.setBounds(50, 30, size.width, size.height); //Sets the location of the image


        if (OperationSingleton.getOperationSingleton().getName()==null)
            new Operation(OperationSingleton.getOperationSingleton());



        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnShowMap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    ShowMap.showMap();
                } catch (SchemaException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                this.addPanel();
            }


            public void addPanel()
            {
              new AddMachine(OperationSingleton.getOperationSingleton());
            }






        });


        btnAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                About dialog = new About();
                dialog.pack();
                dialog.setVisible(true);
//                System.exit(0);
            }
        });
        Button11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new Operation(OperationSingleton.getOperationSingleton());
            }
        });
        Button22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MapSelect(OperationSingleton.getOperationSingleton());

            }
        });
    }




//    image = ImageIO.read(new File("E:\\Users\\Farid\\Downloads\\Map-of-Iran-with-the-Digital-Elevation-Model-DEM.png"));



    public static void main(String[] args) {




        Home s = new Home();



//        Component[] component = s.getComponents();
//        for(int i=0; i<component.length; i++){
//            component[i].applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
//            Component[] cp = ((Container) component[i]).getComponents();
//            for(int j=0; j<cp.length; j++){
//                try{
//                    ((Component) ((JComboBox) cp[j]).getRenderer()).applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
//                }catch(Exception e){
//                    continue;
//
//                }
//            }
//        }


    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }



    public static void changeFont ( Component component, Font font )
    {
        component.setFont ( font );
        if ( component instanceof Container )
        {
            for ( Component child : ( ( Container ) component ).getComponents () )
            {
                changeFont ( child, font );
            }
        }
    }
}
