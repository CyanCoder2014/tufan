package com.cyancoder.panel;

import org.geotools.swing.control.JIntegerField;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class MachinePanel extends JPanel {


    public MachinePanel() {


        GroupLayout layout = new GroupLayout(this);
//        layout.setAutoCreateGaps(true);
//        layout.setAutoCreateContainerGaps(true);
//
//        JButton btn1 = new JButton("Button 1");
//        JButton btn2 = new JButton("Button 2");
//        JButton btn3 = new JButton("Button 3");


        GroupLayout groupLayout = new GroupLayout(this);


//        setLayout(null);
//        setName("آتشبار 1");
//        FlowLayout  g1 = new FlowLayout ();
//        GridLayout  g1 = new GridLayout ();
//        g1.setVgap(30);

        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);
        setLayout(groupLayout);

        JLabel labelLocTitle = new JLabel("مختصات آتشبار و هدف:");

        JLabel labelMacX = new JLabel("طول جغرافیایی آتشبار:");
        JFormattedTextField fieldMacX = new JFormattedTextField(getMaskFormatter("##.###"));
        JLabel labelMacY = new JLabel("عرض جغرافیایی آتشبار:");
        JFormattedTextField fieldMacY = new JFormattedTextField(getMaskFormatter("##.###"));
        JLabel labelAimX = new JLabel("طول جغرافیایی هدف:");
        JFormattedTextField fieldAimX = new JFormattedTextField(getMaskFormatter("##.###"));
        JLabel labelAimY = new JLabel("عرض جغرافیایی هدف:");
        JFormattedTextField fieldAimY = new JFormattedTextField(getMaskFormatter("##.###"));

        JButton btnCalDir = new JButton("محاسبه برد و گرا (سمت نقشه‌ای)");
        btnCalDir.setSize(320,40);
        btnCalDir.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel labelElvMac = new JLabel("ارتفاع آتشبار:");
        JTextField fieldElvMac = new JIntegerField(false);
        fieldElvMac.setEnabled(false);
        JLabel labelElvAim = new JLabel("ارتفاع هدف:");
        JTextField fieldElvAim = new JIntegerField(false);
        fieldElvAim.setEnabled(false);
        JLabel labelDiffElv = new JLabel("اختلاف ارتفاع:");
        JTextField fieldDiffElv = new JIntegerField(false);
        fieldDiffElv.setEnabled(false);
        JLabel labelTElv = new JLabel("تراز:");
        JTextField fieldTElv = new JIntegerField(false);
        fieldTElv.setEnabled(false);

        JLabel labelDist = new JLabel("برد (مسافت):");
        JTextField fieldDist = new JIntegerField(false);
        fieldDist.setEnabled(false);
        JLabel labelDir = new JLabel("سمت نقشه ای (گرا):");
        JTextField fieldDir = new JIntegerField(false);
        fieldDir.setEnabled(false);


        JLabel clickMe = new JLabel("Click Here");
        JButton button = new JButton("This Button");


        JLabel label1 = new JLabel("مسافت:");
        JTextField field = new JIntegerField(false);
        field.setEnabled(false);
        JLabel label2 = new JLabel("سمت:");
        JPasswordField fieldPass = new JPasswordField();

        JLabel label11 = new JLabel("مسافت:");
        JTextField field1 = new JIntegerField(false);
        JLabel label21 = new JLabel("سمت:");
        JPasswordField fieldPass1 = new JPasswordField();

        JButton login = new JButton("ثبت مختصات (هدف/آتشبار)");
        JButton login1 = new JButton("انتخاب توپ");
//                                        .addGap(10, 20, 100)


        groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup()
//                .addComponent(clickMe)
                        .addGroup(groupLayout.createParallelGroup()
                                .addComponent(labelLocTitle)
                                .addGroup(groupLayout.createSequentialGroup()
                                        .addComponent(labelMacX)
                                        .addComponent(fieldMacX)
                                        .addComponent(labelMacY)
                                        .addComponent(fieldMacY)
                                )
                                .addGroup(groupLayout.createSequentialGroup()
                                        .addComponent(labelAimX)
                                        .addComponent(fieldAimX)
                                        .addComponent(labelAimY)
                                        .addComponent(fieldAimY)

                                )


                                .addGroup(groupLayout.createSequentialGroup()
                                        .addComponent(btnCalDir)
                                )
                                .addGroup(groupLayout.createSequentialGroup()
                                        .addComponent(labelElvMac)
                                        .addComponent(fieldElvMac)
                                        .addComponent(labelElvAim)
                                        .addComponent(fieldElvAim)

                                )
                                .addGroup(groupLayout.createSequentialGroup()
                                        .addComponent(labelDiffElv)
                                        .addComponent(fieldDiffElv)
                                        .addComponent(labelTElv)
                                        .addComponent(fieldTElv)

                                )
                                .addGroup(groupLayout.createSequentialGroup()
                                        .addComponent(labelDist)
                                        .addComponent(fieldDist)
                                )
                                .addGroup(groupLayout.createSequentialGroup()
                                        .addComponent(labelDir)
                                        .addComponent(fieldDir)
                                )

                        )
                        .addGap(10, 20, 100)
                        .addGroup(groupLayout.createParallelGroup()

                                .addGroup(groupLayout.createSequentialGroup()
                                        .addComponent(label11)
                                        .addComponent(field1)
                                        .addComponent(label21)
                                        .addComponent(fieldPass1))
                                .addGroup(groupLayout.createParallelGroup()
                                        .addComponent(login1)
                                        .addComponent(login)))
        );

        groupLayout.setVerticalGroup(groupLayout.createParallelGroup()
                .addGroup(groupLayout.createSequentialGroup()
                        .addGap(10, 20, 30)
                        .addComponent(labelLocTitle)
                        .addGap(10, 20, 30)
                        .addGroup(groupLayout.createParallelGroup()
                                .addComponent(labelMacX)
                                .addComponent(fieldMacX, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelMacY)
                                .addComponent(fieldMacY, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        )
                        .addGroup(groupLayout.createParallelGroup()
                                .addComponent(labelAimX)
                                .addComponent(fieldAimX, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelAimY)
                                .addComponent(fieldAimY, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        )
                        .addGap(10, 20, 30)
                        .addGroup(groupLayout.createParallelGroup()
                                .addComponent(btnCalDir)
                        )
                        .addGap(10, 20, 30)
                        .addGroup(groupLayout.createParallelGroup()
                                .addComponent(labelElvMac)
                                .addComponent(fieldElvMac, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelElvAim)
                                .addComponent(fieldElvAim, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)

                        )
                        .addGroup(groupLayout.createParallelGroup()
                                .addComponent(labelDiffElv)
                                .addComponent(fieldDiffElv, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelTElv)
                                .addComponent(fieldTElv, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)

                        )
                        .addGap(20, 30, 40)
                        .addGroup(groupLayout.createParallelGroup()
                                .addComponent(labelDist)
                                .addComponent(fieldDist, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        )
                        .addGroup(groupLayout.createParallelGroup()
                                .addComponent(labelDir)
                                .addComponent(fieldDir, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        ))


                .addGroup(groupLayout.createSequentialGroup()
                        .addGroup(groupLayout.createSequentialGroup()

                                .addGroup(groupLayout.createParallelGroup()
                                        .addComponent(label11)
                                        .addComponent(field1, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label21)
                                        .addComponent(fieldPass1, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(groupLayout.createSequentialGroup()
                                        .addComponent(login1, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(login, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
        );


        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(button1, textField1.getText());

                new Form1().setVisible(true);
//                new newp().AccessibleJFrame;
//                CardLayout cl = (CardLayout)(cards.getLayout());
//                cl.show(cards, (String)textField1.getText());

            }
        });

        setAlignmentX(SwingConstants.RIGHT);
        applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

    }


    private MaskFormatter getMaskFormatter(String format) {
        MaskFormatter mask = null;
        try {
            mask = new MaskFormatter(format);
            mask.setPlaceholderCharacter('0');
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return mask;
    }

}
