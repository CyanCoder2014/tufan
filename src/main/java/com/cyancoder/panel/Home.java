package com.cyancoder.panel;

import com.cyancoder.ShowMap;
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
    private JTabbedPane tabbedPane1;
    private  JLabel wIcon;
    private JButton button3;
    private JPanel topPanel;
    private JButton Button11;
    private JButton Button22;
    private JPanel tab1;
    private JLabel labelHomeTitle;
    private JButton btnAbout;


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


//        JFrame f = new JFrame("Add an image to JFrame");
//        ImageIcon icon = new ImageIcon("E:\\\\Users\\\\Farid\\\\Downloads\\\\Map-of-Iran-with-the-Digital-Elevation-Model-DEM.png");
//        f.add(new JLabel(icon));
//        f.pack();
//        f.setVisible(true);

//        JLabel label = new JLabel(); //JLabel Creation
//        wIcon.setIcon(new ImageIcon("./images/icons/add_new_plus-01.png")); //Sets the image to be displayed as an icon
//        wIcon.setIcon(new ImageIcon("./images/icons/lightning_thunder_power_energy_flash-01.png")); //Sets the image to be displayed as an icon
        wIcon.setIcon(new ImageIcon("./images/icons/map_location_pin_marker-01.png")); //Sets the image to be displayed as an icon
        Dimension size = wIcon.getPreferredSize(); //Gets the size of the image
        wIcon.setBounds(50, 30, size.width, size.height); //Sets the location of the image



//        JPanel card1 = new JPanel();
//        JPanel card2 = new JPanel();
//        JPanel cards = new JPanel(new CardLayout());
//        cards.add(card1, "asadasd");
//        cards.add(card2, "Asafsfaf");

//        BufferedImage wPic = null;
//        try {
//            wPic = ImageIO.read(Objects.requireNonNull(this.getClass().getResource("E:\\\\Users\\\\Farid\\\\Downloads\\\\Map-of-Iran-with-the-Digital-Elevation-Model-DEM.png")));
//        } catch (IOException ex) {
//            // handle exception...
//        }
//        wIcon = new JLabel(new ImageIcon(wPic));



        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(button1, textField1.getText());

//                new Form1().setVisible(true);
//                new newp().AccessibleJFrame;
//                CardLayout cl = (CardLayout)(cards.getLayout());
//                cl.show(cards, (String)textField1.getText());

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
                System.out.println("new machinePanel added");

                JPanel panel1 = new MachinePanel();

                tabbedPane1.add("آتشبار 1",panel1);

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
