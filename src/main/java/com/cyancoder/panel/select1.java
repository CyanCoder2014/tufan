package com.cyancoder.panel;

import com.cyancoder.ShowMap;
import org.geotools.feature.SchemaException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class select1 extends JFrame{

    private JPanel adas;
    private JButton button1;
    private JButton button2;

    public JTextField getTextField1() {
        return textField1;
    }

    public void setTextField1(JTextField textField1) {
        this.textField1 = textField1;
    }

    private  JTextField textField1;



    public static select1 StaticSelect1;

    public select1() {
        StaticSelect1 = this;

        setContentPane(adas);
        setTitle("Tufan - G11");
        setSize(1100,800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

//        JPanel card1 = new JPanel();
//        JPanel card2 = new JPanel();
//        JPanel cards = new JPanel(new CardLayout());
//        cards.add(card1, "asadasd");
//        cards.add(card2, "Asafsfaf");


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(button1, textField1.getText());

                new newp().setVisible(true);
//                new newp().AccessibleJFrame;
//                CardLayout cl = (CardLayout)(cards.getLayout());
//                cl.show(cards, (String)textField1.getText());

            }
        });
        button2.addActionListener(new ActionListener() {
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
    }


    public static void main(String[] args) {
        select1 s = new select1();


    }
}
