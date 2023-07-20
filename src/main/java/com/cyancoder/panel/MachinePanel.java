package com.cyancoder.panel;

import com.cyancoder.model.MacSelectModel;
import org.geotools.swing.control.JIntegerField;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class MachinePanel extends JPanel {


    public MachinePanel() {

        setName("آتشبار 1");
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);
        setLayout(groupLayout);

        JLabel labelLocTitle = new JLabel("مختصات آتشبار و هدف:");
        labelLocTitle.setFont(new FontUIResource(new Font("Tahoma", 0, 16)));

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

        JCheckBox checkBoxLoc = new JCheckBox();
        JLabel labelCheckBoxLoc = new JLabel("اجازه ویرایش مختصات");

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




        JLabel labelMacSelectTitle = new JLabel("اطلاعات توپ و خرج گلوله:");
        labelMacSelectTitle.setFont(new FontUIResource(new Font("Tahoma", 0, 16)));

        JLabel labelSelectMac = new JLabel("انتخاب توپ:");
//        MacSelectModel[] macSelectArray = new MacSelectModel[1];
//        macSelectArray[0] = new MacSelectModel(1L,"توپ 10 ام 46");
        String[] macSelectArray = new String[] {"توپ 10 ام 46"};
        JComboBox<String> selectMac = new JComboBox<>(macSelectArray);

        JLabel labelSelectType = new JLabel("انتخاب خرج گلوله:");
        String[] typeSelectArray = new String[] {"خرج کامل"};
        JComboBox<String> selectType = new JComboBox<>(typeSelectArray);

        JButton btnCalDirAndDeg = new JButton("محاسبه سمت و زاویه توپ");
        JCheckBox checkBoxMac = new JCheckBox();
        JLabel labelCheckBoxMac = new JLabel("اجازه ویرایش توپ و خرج");

        JLabel labelCorrectionDir = new JLabel("تصحیح سمت:");
        JPasswordField fieldCorrectionDir = new JPasswordField();
        fieldCorrectionDir.setEnabled(false);
        JLabel labelMacDir = new JLabel("سمت توپ:");
        JPasswordField fieldMacDir = new JPasswordField();
        fieldMacDir.setEnabled(false);


        JLabel labelDeg = new JLabel("درجه:");
        JPasswordField fieldDeg = new JPasswordField();
        fieldDeg.setEnabled(false);
        JLabel labelArrDir = new JLabel("سمت تیر:");
        JPasswordField fieldArrDir = new JPasswordField();
        fieldArrDir.setEnabled(false);


        JLabel labelLandingTop = new JLabel("قله مسیر گلوله:");
        JPasswordField fieldLandingTop = new JPasswordField();
        fieldLandingTop.setEnabled(false);
        JLabel labelLandingDeg = new JLabel("زاویه فرود:");
        JPasswordField fieldLandingDeg = new JPasswordField();
        fieldLandingDeg.setEnabled(false);

        JLabel labelMaxSpeed = new JLabel("سرعت نهایی:");
        JPasswordField fieldMaxSpeed = new JPasswordField();
        fieldMaxSpeed.setEnabled(false);

        JLabel labelFlightTime = new JLabel("زمان پرواز:");
        JPasswordField fieldFlightTime = new JPasswordField();
        fieldFlightTime.setEnabled(false);


        labelMacSelectTitle.setFont(new FontUIResource(new Font("Tahoma", 0, 16)));

        JLabel labelCorrectionTitle = new JLabel("تصحیحات:");
        labelCorrectionTitle.setFont(new FontUIResource(new Font("Tahoma", 0, 16)));


        groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup()
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
                                        .addGap(10, 20, 30)
                                        .addComponent(checkBoxLoc)
                                        .addComponent(labelCheckBoxLoc)
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
                        .addGap(10, 20, 70)
                        .addGroup(groupLayout.createParallelGroup()
                                .addComponent(labelMacSelectTitle)
                                .addGroup(groupLayout.createSequentialGroup()
                                        .addComponent(labelSelectMac)
                                        .addComponent(selectMac)
                                        .addComponent(labelSelectType)
                                        .addComponent(selectType))
                                .addGroup(groupLayout.createSequentialGroup()
                                        .addComponent(btnCalDirAndDeg)
                                        .addGap(20, 30, 40)
                                        .addComponent(checkBoxMac)
                                        .addComponent(labelCheckBoxMac))
                                .addGroup(groupLayout.createSequentialGroup()
                                        .addComponent(labelCorrectionDir)
                                        .addComponent(fieldCorrectionDir)
                                        .addComponent(labelMacDir)
                                        .addComponent(fieldMacDir))
                                .addGroup(groupLayout.createSequentialGroup()
                                        .addComponent(labelDeg)
                                        .addComponent(fieldDeg)
                                        .addComponent(labelArrDir)
                                        .addComponent(fieldArrDir))
                                .addGroup(groupLayout.createSequentialGroup()
                                                .addComponent(labelFlightTime)
                                                .addComponent(fieldFlightTime)
                                        .addComponent(labelLandingTop)
                                        .addComponent(fieldLandingTop)
                                        .addComponent(labelLandingDeg)
                                        .addComponent(fieldLandingDeg)
                                        .addComponent(labelMaxSpeed)
                                        .addComponent(fieldMaxSpeed)
                                        )
                                .addGroup(groupLayout.createSequentialGroup()
                                        .addComponent(labelCorrectionTitle))
                        )
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
                                .addComponent(checkBoxLoc)
                                .addComponent(labelCheckBoxLoc)
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
                        .addGap(10, 20, 30)
                        .addComponent(labelMacSelectTitle)
                        .addGap(10, 20, 30)
                        .addGroup(groupLayout.createSequentialGroup()

                                .addGroup(groupLayout.createParallelGroup()
                                        .addComponent(labelSelectMac)
                                        .addComponent(selectMac, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelSelectType)
                                        .addComponent(selectType, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 10, 20)
                                .addGroup(groupLayout.createParallelGroup()
                                        .addComponent(btnCalDirAndDeg)
                                        .addComponent(checkBoxMac)
                                        .addComponent(labelCheckBoxMac))
                                .addGap(5, 10, 20)
                                .addGroup(groupLayout.createParallelGroup()
                                        .addComponent(labelCorrectionDir)
                                        .addComponent(fieldCorrectionDir, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelMacDir)
                                        .addComponent(fieldMacDir, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(groupLayout.createParallelGroup()
                                        .addComponent(labelDeg)
                                        .addComponent(fieldDeg, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelArrDir)
                                        .addComponent(fieldArrDir, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 10, 20)
                                .addGroup(groupLayout.createParallelGroup()
                                        .addComponent(labelFlightTime)
                                        .addComponent(fieldFlightTime, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelLandingTop)
                                        .addComponent(fieldLandingTop, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelLandingDeg)
                                        .addComponent(fieldLandingDeg, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelMaxSpeed)
                                        .addComponent(fieldMaxSpeed, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                )
                                .addGap(10, 20, 30)
                                .addGroup(groupLayout.createParallelGroup()
                                        .addGap(10, 20, 30)
                                        .addComponent(labelCorrectionTitle)
                                        .addGap(10, 20, 30))



                        ))
        );





//        login.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                JOptionPane.showMessageDialog(button1, textField1.getText());
//
//                new Form1().setVisible(true);
////                new newp().AccessibleJFrame;
////                CardLayout cl = (CardLayout)(cards.getLayout());
////                cl.show(cards, (String)textField1.getText());
//
//            }
//        });

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
