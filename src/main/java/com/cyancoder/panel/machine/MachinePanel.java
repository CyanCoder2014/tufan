package com.cyancoder.panel.machine;

import com.cyancoder.model.*;
import com.cyancoder.service.CalculateElevationItems;
import com.cyancoder.service.CalculateGisItems;
import com.cyancoder.service.ElevationFind;
import com.cyancoder.service.MachineService;
import org.geotools.swing.control.JIntegerField;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.*;
import java.util.List;


public class MachinePanel extends JPanel {


    JLabel labelLocTitle = new JLabel("مختصات آتشبار و هدف:");

    JLabel labelMacX = new JLabel("طول جغرافیایی آتشبار:");
    JFormattedTextField fieldMacX = new JFormattedTextField(getMaskFormatter("##.######"));
    JLabel labelMacY = new JLabel("عرض جغرافیایی آتشبار:");
    JFormattedTextField fieldMacY = new JFormattedTextField(getMaskFormatter("##.######"));
    JLabel labelAimX = new JLabel("طول جغرافیایی هدف:");
    JFormattedTextField fieldAimX = new JFormattedTextField(getMaskFormatter("##.######"));
    JLabel labelAimY = new JLabel("عرض جغرافیایی هدف:");
    JFormattedTextField fieldAimY = new JFormattedTextField(getMaskFormatter("##.######"));



    String[] pointTypeSelectArray = new String[]{"مختصات UTM" , "مختصات جغرافیایی (درجه)"};
    JComboBox<String> selectPointType = new JComboBox<>(pointTypeSelectArray);
    JLabel labelZoneUTM = new JLabel(":zone");
    JFormattedTextField fieldZoneUTM = new JFormattedTextField(getMaskFormatter("##"));

    JLabel labelMacXUTM = new JLabel("طول UTM آتشبار:");
    JIntegerField fieldMacXUTM = new JIntegerField();
    JLabel labelMacYUTM = new JLabel("عرض UTM آتشبار:");
    JIntegerField fieldMacYUTM = new JIntegerField();
    JLabel labelAimXUTM = new JLabel("طول UTM هدف:");
    JIntegerField fieldAimXUTM = new JIntegerField();
    JLabel labelAimYUTM = new JLabel("عرض UTM هدف:");
    JIntegerField fieldAimYUTM = new JIntegerField();



    JButton btnCalDir = new JButton("محاسبه برد و گرا (سمت نقشه‌ای)");

    JLabel labelCheckBoxLoc = new JLabel("قفل ویرایش مختصات");
    JCheckBox checkBoxLoc = new JCheckBox();

    JLabel labelElvMac = new JLabel("ارتفاع آتشبار (متر):");
    JLabel fieldElvMac = new JLabel();
    JLabel labelElvAim = new JLabel("ارتفاع هدف (متر):");
    JLabel fieldElvAim = new JLabel();
    JLabel labelDiffElv = new JLabel("اختلاف ارتفاع (متر):");
    JLabel fieldDiffElv = new JLabel();
    JLabel labelTElv = new JLabel("تراز:");
    JLabel fieldTElv = new JLabel();

    JLabel labelDistM = new JLabel("برد (مسافت به متر):");
    JLabel fieldDistM = new JLabel();
    JLabel labelDistKm = new JLabel("برد (مسافت به کیلومتر):");
    JLabel fieldDistKm = new JLabel();
    JLabel labelDirMil = new JLabel("گرا به میلیم ( سمت نقشه ای):");
    JLabel fieldDirMil = new JLabel();
    JLabel labelDirDeg = new JLabel("گرا به درجه (سمت نقشه ای):");
    JLabel fieldDirDeg = new JLabel();


    JLabel labelMacSelectTitle = new JLabel("اطلاعات توپ و خرج گلوله:");

    JLabel labelSelectMac = new JLabel("انتخاب توپ:");
    String[] macSelectArray = new String[]{"توپ 10 ام 46"};
    JComboBox<String> selectMac = new JComboBox<>(macSelectArray);

    JLabel labelSelectType = new JLabel("انتخاب خرج گلوله:");
    String[] typeSelectArray = new String[]{};
    JComboBox<String> selectType = new JComboBox<>(typeSelectArray);

    JButton btnCalDirAndDeg = new JButton("محاسبه سمت و زاویه توپ");
    JCheckBox checkBoxMac = new JCheckBox();
    JLabel labelCheckBoxMac = new JLabel("قفل ویرایش توپ و خرج");

    JLabel labelCorrectionDir = new JLabel("تصحیح سمت (میلیم):");
    JLabel fieldCorrectionDir = new JLabel();
    JLabel labelMacDir = new JLabel("سمت توپ (میلیم):");
    JLabel fieldMacDir = new JLabel();


    JLabel labelDeg = new JLabel("تصحیح درجه (میلیم):");
    JLabel fieldDeg = new JLabel();
    JLabel labelArrDir = new JLabel("درجه توپ (میلیم):");
    JLabel fieldArrDir = new JLabel();


    JLabel labelLandingTop = new JLabel("قله مسیر گلوله:");
    JLabel fieldLandingTop = new JLabel();
    JLabel labelLandingDeg = new JLabel("زاویه فرود:");
    JLabel fieldLandingDeg = new JLabel();

    JLabel labelMaxSpeed = new JLabel("سرعت نهایی:");
    JLabel fieldMaxSpeed = new JLabel();

    JLabel labelFlightTime = new JLabel("زمان پرواز:");
    JLabel fieldFlightTime = new JLabel();


    JLabel labelCorrectionTitle = new JLabel("تصحیحات:");

    JButton btnCorrection = new JButton("ثبت تصحیحات");


    JButton btnRemoveFireLoad = new JButton("حذف آتشبار");




    JButton btnAirCor = new JButton("تصحیحات هواشناسی");
    JButton btnObstacle = new JButton("حداقل ارتقاع (تراز مانع)");


    private final CalculateGisItems calculateGisItems;
    private final ElevationFind elevationFind;
    private final CalculateElevationItems calculateElevationItems;

    private final OperationSingleton operationSingleton;
    private final FireLoad fireLoad;
    private final MachineService machineService;

    private Long macElv;
    private Long aimElv;

    private Double distance;
    private Long directionMil = 0L;
    private Long levelDiff;
    private JPanel machinePanel;


    private Double macX;
    private Double macY;
    private Double aimX;
    private Double aimY;


    public MachinePanel(FireLoad fireLoad) {

        machinePanel = this;

        calculateGisItems = new CalculateGisItems();
        elevationFind = new ElevationFind();
        calculateElevationItems = new CalculateElevationItems();
        operationSingleton = OperationSingleton.getOperationSingleton();
        this.fireLoad = fireLoad;
        machineService = new MachineService();


        setName("آتشبار 1");

        formFeature();
        uiMake();

        setInvisibleElvFields(false);
        setInvisibleMacFields(false);
        setInvisibleCorrectionFields(false);

        selectType.setEnabled(false);

        changePointTypeFields(false);
        fieldZoneUTM.setValue(38);

        ArrayList<Machine> machines = machineService.fetchMachines();
        List<String> field1List = machines.stream().map(Machine::getName).toList();
        macSelectArray = field1List.toArray(new String[0]);
        DefaultComboBoxModel<String> macSelectModel = new DefaultComboBoxModel<>(macSelectArray);
        selectMac.setModel(macSelectModel);


        btnAirCor.setEnabled(false);
        btnObstacle.setEnabled(false);

        btnCalDir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                callBtnCalDir();
            }
        });

        btnCalDirAndDeg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                callBtnCalDirAndDeg();
            }
        });

        btnCorrection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                callCorrectionsForm();
            }
        });
        checkBoxLoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBoxLoc.isSelected()) {
                    setDisablePointFields(false);
                    btnCalDir.setEnabled(false);
                    btnRemoveFireLoad.setEnabled(false);
                } else {
                    setDisablePointFields(true);
                    btnCalDir.setEnabled(true);
                    btnRemoveFireLoad.setEnabled(true);
                }
            }
        });
        checkBoxMac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBoxMac.isSelected()) {
                    setDisableMacFields(false);
                    btnCalDirAndDeg.setEnabled(false);

                } else {
                    setDisableMacFields(true);
                    btnCalDirAndDeg.setEnabled(true);
                }
            }
        });
        selectMac.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<MachineType> machineTypes = machineService.fetchMachineTypes((String) selectMac.getSelectedItem(), null);
                List<String> field1List = machineTypes.stream().map(MachineType::getName).toList();
                typeSelectArray = field1List.toArray(new String[0]);
                DefaultComboBoxModel<String> selectTypeModel = new DefaultComboBoxModel<>(typeSelectArray);
                selectType.setModel(selectTypeModel);

                selectType.setEnabled(true);
            }
        });

        btnRemoveFireLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                RemoveMachine dialog = new RemoveMachine(machinePanel, fireLoad);
                dialog.pack();
                dialog.setVisible(true);
            }
        });


        selectPointType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pointType = (String) selectPointType.getSelectedItem();

                if (pointType.equals("مختصات UTM"))
                    changePointTypeFields(false);
                else
                    changePointTypeFields(true);


            }
        });
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

    private void formFeature() {
        labelLocTitle.setFont(new FontUIResource(new Font("Tahoma", 0, 16)));

        btnCalDir.setSize(320, 40);
        btnCalDir.setHorizontalAlignment(SwingConstants.CENTER);

        fieldElvMac.setFont(new Font("Tahoma", 1, 13));
        fieldElvAim.setFont(new Font("Tahoma", 1, 13));
        fieldDiffElv.setFont(new Font("Tahoma", 1, 13));
        fieldTElv.setFont(new Font("Tahoma", 1, 13));

        fieldDistM.setFont(new Font("Tahoma", 1, 13));
        fieldDistKm.setFont(new Font("Tahoma", 1, 13));
        fieldDirMil.setFont(new Font("Tahoma", 1, 13));
        fieldDirDeg.setFont(new Font("Tahoma", 1, 13));


        labelMacSelectTitle.setFont(new FontUIResource(new Font("Tahoma", 0, 16)));

//        MacSelectModel[] macSelectArray = new MacSelectModel[1];
//        macSelectArray[0] = new MacSelectModel(1L,"توپ 10 ام 46");
//        JComboBox<String> selectMac = new JComboBox<>(macSelectArray);
//        JComboBox<String> selectType = new JComboBox<>(typeSelectArray);

        fieldCorrectionDir.setFont(new Font("Tahoma", 1, 13));
        fieldMacDir.setFont(new Font("Tahoma", 1, 13));

        fieldDeg.setFont(new Font("Tahoma", 1, 13));
        fieldArrDir.setFont(new Font("Tahoma", 1, 13));

        fieldLandingTop.setFont(new Font("Tahoma", 1, 13));
        fieldLandingDeg.setFont(new Font("Tahoma", 1, 13));

        fieldMaxSpeed.setFont(new Font("Tahoma", 1, 13));

        fieldFlightTime.setFont(new Font("Tahoma", 1, 13));

        labelMacSelectTitle.setFont(new FontUIResource(new Font("Tahoma", 0, 16)));
        labelCorrectionTitle.setFont(new FontUIResource(new Font("Tahoma", 0, 16)));


    }

    private void uiMake() {


        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);
        setLayout(groupLayout);

        groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup()
                .addGroup(groupLayout.createParallelGroup()
                        .addComponent(btnRemoveFireLoad)
                        .addComponent(labelLocTitle)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addComponent(labelLocTitle)
                                .addGap(50, 60, 80)
                                .addComponent(selectPointType)
                                .addGap(30, 40, 50)
                                .addComponent(labelZoneUTM)
                                .addComponent(fieldZoneUTM)

                        )
                        .addGroup(groupLayout.createSequentialGroup()
                                .addComponent(labelMacX)
                                .addComponent(fieldMacX)
                                .addComponent(labelMacY)
                                .addComponent(fieldMacY)

                                .addComponent(labelMacXUTM)
                                .addComponent(fieldMacXUTM)
                                .addComponent(labelMacYUTM)
                                .addComponent(fieldMacYUTM)
                        )
                        .addGroup(groupLayout.createSequentialGroup()
                                .addComponent(labelAimX)
                                .addComponent(fieldAimX)
                                .addComponent(labelAimY)
                                .addComponent(fieldAimY)

                                .addComponent(labelAimXUTM)
                                .addComponent(fieldAimXUTM)
                                .addComponent(labelAimYUTM)
                                .addComponent(fieldAimYUTM)

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
                                .addGap(30, 40, 50)
                                .addComponent(labelElvAim)
                                .addComponent(fieldElvAim)

                        )
                        .addGroup(groupLayout.createSequentialGroup()
                                .addComponent(labelDiffElv)
                                .addComponent(fieldDiffElv)
                                .addGap(30, 40, 50)
                                .addComponent(labelTElv)
                                .addComponent(fieldTElv)

                        )
                        .addGroup(groupLayout.createSequentialGroup()
                                .addComponent(labelDistM)
                                .addComponent(fieldDistM)
                                .addGap(30, 40, 50)
                                .addComponent(labelDistKm)
                                .addComponent(fieldDistKm)

                        )
                        .addGroup(groupLayout.createSequentialGroup()
                                .addComponent(labelDirMil)
                                .addComponent(fieldDirMil)
                                .addGap(30, 40, 50)
                                .addComponent(labelDirDeg)
                                .addComponent(fieldDirDeg)
                        )
                )
                .addGap(10, 20, 70)
                .addGroup(groupLayout.createParallelGroup()
                        .addGroup(groupLayout.createSequentialGroup()
                        .addComponent(btnAirCor)
                        .addComponent(btnObstacle))

                        .addComponent(labelMacSelectTitle)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addComponent(labelSelectMac)
                                .addComponent(selectMac)
                                .addComponent(labelSelectType)
                                .addComponent(selectType))
                        .addGroup(groupLayout.createSequentialGroup()
                                .addComponent(btnCalDirAndDeg)
                                .addGap(30, 40, 50)
                                .addComponent(checkBoxMac)
                                .addComponent(labelCheckBoxMac))
                        .addGroup(groupLayout.createSequentialGroup()
                                .addComponent(labelCorrectionDir)
                                .addComponent(fieldCorrectionDir)
                                .addGap(30, 40, 50)
                                .addComponent(labelMacDir)
                                .addComponent(fieldMacDir))
                        .addGroup(groupLayout.createSequentialGroup()
                                .addComponent(labelDeg)
                                .addComponent(fieldDeg)
                                .addGap(30, 40, 50)
                                .addComponent(labelArrDir)
                                .addComponent(fieldArrDir))
                        .addGroup(groupLayout.createSequentialGroup()
                                .addComponent(labelFlightTime)
                                .addComponent(fieldFlightTime)
                                .addGap(10, 25, 40)
                                .addComponent(labelLandingTop)
                                .addComponent(fieldLandingTop)
                                .addGap(10, 25, 40)
                                .addComponent(labelLandingDeg)
                                .addComponent(fieldLandingDeg)
                                .addGap(10, 25, 40)
                                .addComponent(labelMaxSpeed)
                                .addComponent(fieldMaxSpeed)
                        )
                        .addGroup(groupLayout.createSequentialGroup()
                                .addComponent(labelCorrectionTitle))
                        .addGroup(groupLayout.createSequentialGroup()
                                .addComponent(btnCorrection))
                )
        );

        groupLayout.setVerticalGroup(groupLayout.createParallelGroup()
                .addGroup(groupLayout.createSequentialGroup()
                        .addGap(5, 10, 20)
                        .addComponent(btnRemoveFireLoad)
                        .addGap(3, 5, 8)

                        .addGroup(groupLayout.createParallelGroup()

                                .addComponent(labelLocTitle)

                        .addComponent(selectPointType, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelZoneUTM)
                                        .addComponent(fieldZoneUTM, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        )

                        .addGap(15, 20, 25)
                        .addGroup(groupLayout.createParallelGroup()
                                .addComponent(labelMacX)
                                .addComponent(fieldMacX, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelMacY)
                                .addComponent(fieldMacY, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)


                                .addComponent(labelMacXUTM)
                                .addComponent(fieldMacXUTM, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelMacYUTM)
                                .addComponent(fieldMacYUTM, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)

                        )
                        .addGroup(groupLayout.createParallelGroup()
                                .addComponent(labelAimX)
                                .addComponent(fieldAimX, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelAimY)
                                .addComponent(fieldAimY, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)

                                .addComponent(labelAimXUTM)
                                .addComponent(fieldAimXUTM, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelAimYUTM)
                                .addComponent(fieldAimYUTM, GroupLayout.DEFAULT_SIZE,
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
                                .addComponent(labelDistM)
                                .addComponent(fieldDistM, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelDistKm)
                                .addComponent(fieldDistKm, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        )
                        .addGroup(groupLayout.createParallelGroup()
                                .addComponent(labelDirMil)
                                .addComponent(fieldDirMil, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelDirDeg)
                                .addComponent(fieldDirDeg, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        ))


                .addGroup(groupLayout.createSequentialGroup()
                        .addGap(10, 20, 30)

                        .addGroup(groupLayout.createParallelGroup()
                                .addComponent(btnAirCor)
                                .addComponent(btnObstacle))

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
                                .addGroup(groupLayout.createParallelGroup()
                                        .addComponent(btnCorrection))


                        ))
        );

        setAlignmentX(SwingConstants.RIGHT);
        applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    }

    private void setDisablePointFields(boolean isDisable) {

        fieldMacX.setEnabled(isDisable);
        fieldMacY.setEnabled(isDisable);
        fieldAimX.setEnabled(isDisable);
        fieldAimY.setEnabled(isDisable);

        fieldMacXUTM.setEnabled(isDisable);
        fieldMacYUTM.setEnabled(isDisable);
        fieldAimXUTM.setEnabled(isDisable);
        fieldAimYUTM.setEnabled(isDisable);
        fieldZoneUTM.setEnabled(isDisable);
        selectPointType.setEnabled(isDisable);

    }

    private void setDisableMacFields(boolean isEnabled) {
        selectMac.setEnabled(isEnabled);
        selectType.setEnabled(isEnabled);
    }

    private void setInvisibleElvFields(boolean isVisible) {

        labelElvMac.setVisible(isVisible);
        fieldElvMac.setVisible(isVisible);
        labelElvAim.setVisible(isVisible);
        fieldElvAim.setVisible(isVisible);
        labelDiffElv.setVisible(isVisible);
        fieldDiffElv.setVisible(isVisible);
        labelTElv.setVisible(isVisible);
        fieldTElv.setVisible(isVisible);
        labelDistM.setVisible(isVisible);
        fieldDistM.setVisible(isVisible);
        labelDistKm.setVisible(isVisible);
        fieldDistKm.setVisible(isVisible);
        labelDirMil.setVisible(isVisible);
        fieldDirMil.setVisible(isVisible);
        labelDirDeg.setVisible(isVisible);
        fieldDirDeg.setVisible(isVisible);

        labelMacSelectTitle.setVisible(isVisible);
        labelSelectMac.setVisible(isVisible);
        selectMac.setVisible(isVisible);
        labelSelectType.setVisible(isVisible);
        selectType.setVisible(isVisible);
        btnCalDirAndDeg.setVisible(isVisible);
        checkBoxMac.setVisible(isVisible);
        labelCheckBoxMac.setVisible(isVisible);
    }

    private void setInvisibleMacFields(boolean isVisible) {

        labelCorrectionDir.setVisible(isVisible);
        fieldCorrectionDir.setVisible(isVisible);
        labelMacDir.setVisible(isVisible);
        fieldMacDir.setVisible(isVisible);
        labelDeg.setVisible(isVisible);
        fieldDeg.setVisible(isVisible);
        labelArrDir.setVisible(isVisible);
        fieldArrDir.setVisible(isVisible);
        labelLandingTop.setVisible(isVisible);
        fieldLandingTop.setVisible(isVisible);
        labelLandingDeg.setVisible(isVisible);
        fieldLandingDeg.setVisible(isVisible);
        labelMaxSpeed.setVisible(isVisible);
        fieldMaxSpeed.setVisible(isVisible);
        labelFlightTime.setVisible(isVisible);
        fieldFlightTime.setVisible(isVisible);


        labelCorrectionTitle.setVisible(isVisible);
        btnCorrection.setVisible(isVisible);
    }

    private void setInvisibleCorrectionFields(boolean isVisible) {

        labelCorrectionTitle.setVisible(isVisible);
        btnCorrection.setVisible(isVisible);
    }

    private void callBtnCalDir() {

        Double macX = 0.0;
        Double macY = 0.0;
        Double aimX = 0.0;
        Double aimY = 0.0;

        Double macXUTM = 0.0;
        Double macYUTM = 0.0;
        Double aimXUTM = 0.0;
        Double aimYUTM = 0.0;

        if(selectPointType.getSelectedItem().toString().equals("مختصات UTM")){

            macXUTM = Double.valueOf(fieldMacXUTM.getText());
            macYUTM = Double.valueOf(fieldMacYUTM.getText());
            aimXUTM = Double.valueOf(fieldAimXUTM.getText());
            aimYUTM = Double.valueOf(fieldAimYUTM.getText());

            int zone = (int) fieldZoneUTM.getValue();
            PointModel pointModelMac = calculateGisItems.UTM2Deg(zone, 'S' ,macXUTM, macYUTM);
            macX = pointModelMac.getLongitude();
            macY = pointModelMac.getLatitude();
            PointModel pointModelAim = calculateGisItems.UTM2Deg(zone, 'S' ,aimXUTM, aimYUTM);
            aimX = pointModelAim.getLongitude();
            aimY = pointModelAim.getLatitude();
            fieldMacX.setValue(macX);
            fieldMacY.setValue(macY);
            fieldAimX.setValue(aimX);
            fieldAimY.setValue(aimY);
        }else {
             macX = Double.valueOf(fieldMacX.getText());
             macY = Double.valueOf(fieldMacY.getText());
             aimX = Double.valueOf(fieldAimX.getText());
             aimY = Double.valueOf(fieldAimY.getText());

            int zone = (int) fieldZoneUTM.getValue();
            PointModel pointModelMacUTM = calculateGisItems.Deg2UTM(zone,macY, macX);
            macXUTM = pointModelMacUTM.getLongitude();
            macYUTM = pointModelMacUTM.getLatitude();
            PointModel pointModelAimUTM = calculateGisItems.Deg2UTM(zone,aimY, aimX);
            aimXUTM = pointModelAimUTM.getLongitude();
            aimYUTM = pointModelAimUTM.getLatitude();
            fieldMacXUTM.setValue((int) Math.round(macXUTM));
            fieldMacYUTM.setValue((int) Math.round(macYUTM));
            fieldAimXUTM.setValue((int) Math.round(aimXUTM));
            fieldAimYUTM.setValue((int) Math.round(aimYUTM));
        }


        if ((43.000 < macX && macX < 63.300) &&
                (25.000 < macY && macY < 40.000) &&
                (43.000 < aimX && aimX < 63.300) &&
                (25.000 < aimY && aimY < 40.000)) {

            setInvisibleElvFields(true);
            btnCalDir.setEnabled(false);
            btnRemoveFireLoad.setEnabled(false);

            Double distance = calculateGisItems.calculateDistance(macX, macY, aimX, aimY);
            Long directionDeg = Math.round(calculateGisItems.calculateDegDirection(macX, macY, aimX, aimY,0));
            Long directionMil = calculateGisItems.calculateMilDirection(macX, macY, aimX, aimY,0);
            double corDeg = operationSingleton.getDir_cor();
            Long directionDegCorrected = Math.round(calculateGisItems.calculateDegDirection(macX, macY, aimX, aimY,corDeg));
            Long directionMilCorrected  = calculateGisItems.calculateMilDirection(macX, macY, aimX, aimY,corDeg);
            this.distance = distance;
            this.directionMil = directionMilCorrected;

            Double finalMacX = macX;
            Double finalMacY = macY;
            Runnable runnable1 = () -> {
                macElv = elevationFind.findPointElevation(finalMacX, finalMacY);
                System.out.println("macElv: " + macElv);
            };
            Double finalAimX = aimX;
            Double finalAimY = aimY;
            Runnable runnable2 = () -> {
                aimElv = elevationFind.findPointElevation(finalAimX, finalAimY);
                System.out.println("aimElv: " + aimElv);

            };
            Thread t1 = new Thread(runnable1, "t1 - elv");
            Thread t2 = new Thread(runnable2, "t2 - elv");

            t1.start();
            t2.start();

            try {
                t1.join();
                t2.join();
            } catch (Exception ignored) {
            }

            fieldElvMac.setText(String.valueOf(macElv));
            fieldElvAim.setText(String.valueOf(aimElv));

            fieldDistM.setText(String.valueOf(Math.round(distance)));
            fieldDistKm.setText(String.valueOf(Math.round(distance/100) / 10));
            fieldDirMil.setText(directionMilCorrected +" ("+directionMil+")");
            fieldDirDeg.setText(directionDegCorrected +" ("+directionDeg+")");
            System.out.println("before: " + 0);

            if (macElv != null && aimElv != null) {
                System.out.println("after: " + 0);

                Long elvDiff = calculateElevationItems.calculateElvDifference(macElv, aimElv);
                Long levelDiff = calculateElevationItems.calculateLevelDifference(elvDiff, distance);
                this.levelDiff = levelDiff;

                fieldDiffElv.setText(String.valueOf(elvDiff));
                fieldTElv.setText(String.valueOf(levelDiff));

                fireLoad.setOriginX(macX);
                fireLoad.setOriginY(macY);
                fireLoad.setTargetX(aimX);
                fireLoad.setTargetY(aimY);
                operationSingleton.getFireLoad().indexOf(fireLoad);
                operationSingleton.getFireLoad().set(operationSingleton.getFireLoad().indexOf(fireLoad), fireLoad);
                checkBoxLoc.setSelected(true);
                setDisablePointFields(false);
            } else {
                btnCalDir.setEnabled(true);
                JOptionPane.showMessageDialog(null, "مختصات خارج از محدوده نقشه ارتفاعی است!");
            }


        } else
            JOptionPane.showMessageDialog(null, "مختصات به درستی وارد نشده است!");

    }

    private void callBtnCalDirAndDeg() {


        if (selectMac.getSelectedItem() != null && selectType.getSelectedItem() != null) {
            MachineDetail machineDetail = machineService.getMachineDetails(
                    selectMac.getSelectedItem().toString(),
                    selectType.getSelectedItem().toString(),
                    Math.round(this.distance));


            if (machineDetail != null) {

                fieldCorrectionDir.setText(String.valueOf(machineDetail.getCor_dir()));
                fieldMacDir.setText(String.valueOf(this.directionMil - machineDetail.getCor_dir()));

                fieldDeg.setText(String.valueOf(machineDetail.getDeg_mil()));
                fieldArrDir.setText(String.valueOf(this.levelDiff + machineDetail.getDeg_mil()));

                fieldFlightTime.setText(String.valueOf(machineDetail.getFlight_time()));
                fieldLandingTop.setText(String.valueOf(machineDetail.getTop()));
                fieldLandingDeg.setText(String.valueOf(machineDetail.getLand_deg()));
                fieldMaxSpeed.setText(String.valueOf(machineDetail.getSpeed()));

            } else
                JOptionPane.showMessageDialog(null, "مسافت خارج از محدوده جدول توپ می باشد!");

            btnCalDirAndDeg.setEnabled(false);
            checkBoxMac.setSelected(true);
            setDisableMacFields(false);

            setInvisibleMacFields(true);
            setInvisibleCorrectionFields(true);
        } else
            JOptionPane.showMessageDialog(null, "مشخصات توپ و خرج به درستی وارد نشده است!");

    }

    public void callCorrectionsForm() {

        Corrections correctionsForm = new Corrections(this);

    }

    private void changePointTypeFields(boolean isVisible) {

        labelMacX.setVisible(isVisible);
        fieldMacX.setVisible(isVisible);
        labelMacY.setVisible(isVisible);
        fieldMacY.setVisible(isVisible);
        labelAimX.setVisible(isVisible);
        fieldAimX.setVisible(isVisible);
        labelAimY.setVisible(isVisible);
        fieldAimY.setVisible(isVisible);

        labelMacXUTM.setVisible(!isVisible);
        fieldMacXUTM.setVisible(!isVisible);
        labelMacYUTM.setVisible(!isVisible);
        fieldMacYUTM.setVisible(!isVisible);
        labelAimXUTM.setVisible(!isVisible);
        fieldAimXUTM.setVisible(!isVisible);
        labelAimYUTM.setVisible(!isVisible);
        fieldAimYUTM.setVisible(!isVisible);

        labelZoneUTM.setVisible(!isVisible);
        fieldZoneUTM.setVisible(!isVisible);

    }

    public void setCorrections(int mx, int my) {

        if(this.macX==null)
            this.macX = Double.valueOf(fieldMacX.getText());
        if(this.macY==null)
            this.macY = Double.valueOf(fieldMacY.getText());
        if(this.aimX==null)
            this.aimX = Double.valueOf(fieldAimX.getText());
        if(this.aimY==null)
            this.aimY = Double.valueOf(fieldAimY.getText());

        Double macX = this.macX;
        Double macY = this.macY;
        Double aimX = this.aimX;
        Double aimY = this.aimY;

        Double macXUTM;
        Double macYUTM;
        Double aimXUTM;
        Double aimYUTM;


            int zone = (int) fieldZoneUTM.getValue();
            PointModel pointModelMacUTM = calculateGisItems.Deg2UTM(zone,macY, macX);
            macXUTM = pointModelMacUTM.getLongitude();
            macYUTM = pointModelMacUTM.getLatitude();
            PointModel pointModelAimUTM = calculateGisItems.Deg2UTM(zone,aimY, aimX);
            aimXUTM = pointModelAimUTM.getLongitude();
            aimYUTM = pointModelAimUTM.getLatitude();
            fieldMacXUTM.setValue((int) Math.round(macXUTM));
            fieldMacYUTM.setValue((int) Math.round(macYUTM));
            fieldAimXUTM.setValue((int) Math.round(aimXUTM));
            fieldAimYUTM.setValue((int) Math.round(aimYUTM));

//        PointModel newPointMac = calculateGisItems.changeLoc(macX, macY, (double) mx, (double) my);
        PointModel newPointAim = calculateGisItems.changeLoc(aimX, aimY, (double) mx, (double) my);

//        macX = newPointMac.getX();
//        macY = newPointMac.getY();
        aimX = newPointAim.getX();
        aimY = newPointAim.getY();


        if ((43.000 < macX && macX < 63.300) &&
                (25.000 < macY && macY < 40.000) &&
                (43.000 < aimX && aimX < 63.300) &&
                (25.000 < aimY && aimY < 40.000)) {

            setInvisibleElvFields(true);
            btnCalDir.setEnabled(false);
            btnRemoveFireLoad.setEnabled(false);

            Double distance = calculateGisItems.calculateDistance(macX, macY, aimX, aimY);
            Long directionDeg = Math.round(calculateGisItems.calculateDegDirection(macX, macY, aimX, aimY,0));
            Long directionMil = calculateGisItems.calculateMilDirection(macX, macY, aimX, aimY,0);
            double corDeg = operationSingleton.getDir_cor();
            Long directionDegCorrected = Math.round(calculateGisItems.calculateDegDirection(macX, macY, aimX, aimY,corDeg));
            Long directionMilCorrected  = calculateGisItems.calculateMilDirection(macX, macY, aimX, aimY,corDeg);
            this.distance = distance;
            this.directionMil = directionMilCorrected;

            Double finalMacX = macX;
            Double finalMacY = macY;
            Runnable runnable1 = () -> {
                macElv = elevationFind.findPointElevation(finalMacX, finalMacY);
                System.out.println("macElv: " + macElv);
            };
            Double finalAimX = aimX;
            Double finalAimY = aimY;
            Runnable runnable2 = () -> {
                aimElv = elevationFind.findPointElevation(finalAimX, finalAimY);
                System.out.println("aimElv: " + aimElv);

            };
            Thread t1 = new Thread(runnable1, "t1 - elv");
            Thread t2 = new Thread(runnable2, "t2 - elv");

            t1.start();
            t2.start();

            try {
                t1.join();
                t2.join();
            } catch (Exception ignored) {
            }

            fieldElvMac.setText(String.valueOf(macElv));
            fieldElvAim.setText(String.valueOf(aimElv));

            fieldDistM.setText(String.valueOf(Math.round(distance)));
            fieldDistKm.setText(String.valueOf(Math.round(distance/100) / 10));
            fieldDirMil.setText(directionMilCorrected +" ("+directionMil+")");
            fieldDirDeg.setText(directionDegCorrected +" ("+directionDeg+")");



            fieldDistM.setForeground(Color.RED);
            fieldDistKm.setForeground(Color.RED);
            fieldDirMil.setForeground(Color.RED);
            fieldDirDeg.setForeground(Color.RED);



            if (macElv != null && aimElv != null) {
                System.out.println("after: " + 0);

                Long elvDiff = calculateElevationItems.calculateElvDifference(macElv, aimElv);
                Long levelDiff = calculateElevationItems.calculateLevelDifference(elvDiff, distance);
                this.levelDiff = levelDiff;

                fieldDiffElv.setText(String.valueOf(elvDiff));
                fieldTElv.setText(String.valueOf(levelDiff));

                fireLoad.setOriginX(macX);
                fireLoad.setOriginY(macY);
                fireLoad.setTargetX(aimX);
                fireLoad.setTargetY(aimY);
                operationSingleton.getFireLoad().indexOf(fireLoad);
                operationSingleton.getFireLoad().set(operationSingleton.getFireLoad().indexOf(fireLoad), fireLoad);
                checkBoxLoc.setSelected(true);
                setDisablePointFields(false);
            } else {
                btnCalDir.setEnabled(true);
                JOptionPane.showMessageDialog(null, "مختصات خارج از محدوده نقشه ارتفاعی است!");
            }


        } else
            JOptionPane.showMessageDialog(null, "مختصات به درستی وارد نشده است!");


        if (selectMac.getSelectedItem() != null && selectType.getSelectedItem() != null) {
            MachineDetail machineDetail = machineService.getMachineDetails(
                    selectMac.getSelectedItem().toString(),
                    selectType.getSelectedItem().toString(),
                    Math.round(this.distance));


            if (machineDetail != null) {

                fieldCorrectionDir.setText(String.valueOf(machineDetail.getCor_dir()));
                fieldMacDir.setText(String.valueOf(this.directionMil - machineDetail.getCor_dir()));

                fieldDeg.setText(String.valueOf(machineDetail.getDeg_mil()));
                fieldArrDir.setText(String.valueOf(this.levelDiff + machineDetail.getDeg_mil()));

                fieldFlightTime.setText(String.valueOf(machineDetail.getFlight_time()));
                fieldLandingTop.setText(String.valueOf(machineDetail.getTop()));
                fieldLandingDeg.setText(String.valueOf(machineDetail.getLand_deg()));
                fieldMaxSpeed.setText(String.valueOf(machineDetail.getSpeed()));


//                fieldCorrectionDir.setForeground(Color.RED);
                fieldMacDir.setForeground(Color.RED);
//                fieldDeg.setForeground(Color.RED);
                fieldArrDir.setForeground(Color.RED);


            } else
                JOptionPane.showMessageDialog(null, "مسافت خارج از محدوده جدول توپ می باشد!");

            btnCalDirAndDeg.setEnabled(false);
            checkBoxMac.setSelected(true);
            setDisableMacFields(false);

            setInvisibleMacFields(true);
            setInvisibleCorrectionFields(true);
        } else
            JOptionPane.showMessageDialog(null, "مشخصات توپ و خرج به درستی وارد نشده است!");

    }



}
