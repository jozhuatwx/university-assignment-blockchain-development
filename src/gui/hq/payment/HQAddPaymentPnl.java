package gui.hq.payment;

import gui.HQPanelContainer;
import tutormanagementsystem.Attendance;
import tutormanagementsystem.Main;
import tutormanagementsystem.Payment;
import tutormanagementsystem.Tutor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class HQAddPaymentPnl extends javax.swing.JPanel {
    private HQPanelContainer frame;

    public HQAddPaymentPnl(HQPanelContainer frame) {
        initComponents();
        this.frame = frame;

        populateCmbBranchName();

        // Populate text fields
        txtPaymentDate.setText(LocalDateTime.now().format(Main.DATE_FORMATTER));
    }

    // Populate combobox data
    private void populateCmbBranchName() {
        // Remove existing combobox items
        cmbBranchName.removeAllItems();

        for (int i = 0; i < Main.branchDatabase.getSize(); i++) {
            cmbBranchName.addItem(Main.branchDatabase.getData(i).getName());
        }
    }

    // Populate combobox data
    private void populateCmbTutorId(double branchId) {
        // Remove existing combobox items
        cmbTutorId.removeAllItems();

        // Get tutor id from branch
        for (int i = 0; i < Main.tutorDatabase.getSize(); i++) {
            Tutor tutor = Main.tutorDatabase.getData(i);
            if (tutor.getBranchId() == branchId) {
                cmbTutorId.addItem(String.format("%.0f", tutor.getId()));
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlRightBg = new javax.swing.JPanel();
        lblClose = new javax.swing.JLabel();
        pnlAddPaymentContainer = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        tabpnlPayment = new javax.swing.JTabbedPane();
        pnlPersonalDetails = new javax.swing.JPanel();
        lblBranchName = new javax.swing.JLabel();
        lblTutorId = new javax.swing.JLabel();
        lblTutorName = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        cmbBranchName = new javax.swing.JComboBox<>();
        cmbTutorId = new javax.swing.JComboBox<>();
        txtTutorName = new javax.swing.JTextField();
        txtTitle = new javax.swing.JTextField();
        pnlPaymentDetails = new javax.swing.JPanel();
        lblPaymentDate = new javax.swing.JLabel();
        lblAttendedHours = new javax.swing.JLabel();
        lblPayRate = new javax.swing.JLabel();
        lblTotalAmount = new javax.swing.JLabel();
        txtPaymentDate = new javax.swing.JTextField();
        txtAttendedHours = new javax.swing.JTextField();
        txtPayRate = new javax.swing.JTextField();
        txtTotalAmount = new javax.swing.JTextField();
        pnlBankAccountDetails = new javax.swing.JPanel();
        lblBankName = new javax.swing.JLabel();
        lblAccountName = new javax.swing.JLabel();
        lblBankNumber = new javax.swing.JLabel();
        txtBankName = new javax.swing.JTextField();
        txtAccountName = new javax.swing.JTextField();
        txtBankNumber = new javax.swing.JTextField();

        setMaximumSize(new java.awt.Dimension(950, 550));
        setMinimumSize(new java.awt.Dimension(950, 550));
        setPreferredSize(new java.awt.Dimension(950, 550));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlRightBg.setBackground(new java.awt.Color(255, 255, 255));
        pnlRightBg.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 51), 1, true));

        lblClose.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClose.setText("X");
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
        });

        pnlAddPaymentContainer.setBackground(new java.awt.Color(242, 242, 242));
        pnlAddPaymentContainer.setMinimumSize(new java.awt.Dimension(500, 450));

        btnAdd.setBackground(new java.awt.Color(0, 0, 43));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        tabpnlPayment.setBackground(new java.awt.Color(51, 51, 51));

        pnlPersonalDetails.setBackground(new java.awt.Color(230, 230, 230));

        lblBranchName.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblBranchName.setText("Branch");

        lblTutorId.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblTutorId.setText("Tutor ID");

        lblTutorName.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblTutorName.setText("Tutor Name");

        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblTitle.setText("Title");

        cmbBranchName.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cmbBranchName.setBorder(null);
        cmbBranchName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBranchNameActionPerformed(evt);
            }
        });

        cmbTutorId.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cmbTutorId.setBorder(null);
        cmbTutorId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTutorIdActionPerformed(evt);
            }
        });

        txtTutorName.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtTutorName.setEnabled(false);

        txtTitle.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtTitle.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtTitle.setMaximumSize(new java.awt.Dimension(190, 26));
        txtTitle.setMinimumSize(new java.awt.Dimension(190, 26));

        javax.swing.GroupLayout pnlPersonalDetailsLayout = new javax.swing.GroupLayout(pnlPersonalDetails);
        pnlPersonalDetails.setLayout(pnlPersonalDetailsLayout);
        pnlPersonalDetailsLayout.setHorizontalGroup(
            pnlPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPersonalDetailsLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(pnlPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBranchName)
                    .addComponent(lblTutorId)
                    .addComponent(lblTutorName)
                    .addComponent(lblTitle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addGroup(pnlPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTutorName, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbBranchName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbTutorId, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33))
        );
        pnlPersonalDetailsLayout.setVerticalGroup(
            pnlPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPersonalDetailsLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(pnlPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBranchName)
                    .addComponent(cmbBranchName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(pnlPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTutorId)
                    .addComponent(cmbTutorId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(pnlPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTutorName)
                    .addComponent(txtTutorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(pnlPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        tabpnlPayment.addTab("Personal Details", pnlPersonalDetails);

        pnlPaymentDetails.setBackground(new java.awt.Color(230, 230, 230));

        lblPaymentDate.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblPaymentDate.setText("Payment Date");

        lblAttendedHours.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblAttendedHours.setText("Attended Hours");

        lblPayRate.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblPayRate.setText("Hourly Pay Rate");

        lblTotalAmount.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblTotalAmount.setText("Total Amount:");

        txtPaymentDate.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtPaymentDate.setEnabled(false);

        txtAttendedHours.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtAttendedHours.setEnabled(false);

        txtPayRate.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtPayRate.setEnabled(false);

        txtTotalAmount.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtTotalAmount.setEnabled(false);
        txtTotalAmount.setMaximumSize(new java.awt.Dimension(190, 26));
        txtTotalAmount.setMinimumSize(new java.awt.Dimension(190, 26));

        javax.swing.GroupLayout pnlPaymentDetailsLayout = new javax.swing.GroupLayout(pnlPaymentDetails);
        pnlPaymentDetails.setLayout(pnlPaymentDetailsLayout);
        pnlPaymentDetailsLayout.setHorizontalGroup(
            pnlPaymentDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPaymentDetailsLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(pnlPaymentDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPaymentDate)
                    .addComponent(lblAttendedHours)
                    .addComponent(lblPayRate)
                    .addComponent(lblTotalAmount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(pnlPaymentDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPaymentDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtPayRate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                        .addComponent(txtAttendedHours, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtPaymentDate, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(txtTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );
        pnlPaymentDetailsLayout.setVerticalGroup(
            pnlPaymentDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPaymentDetailsLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(pnlPaymentDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPaymentDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPaymentDate))
                .addGap(40, 40, 40)
                .addGroup(pnlPaymentDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAttendedHours)
                    .addComponent(txtAttendedHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(pnlPaymentDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPayRate)
                    .addComponent(txtPayRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(pnlPaymentDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalAmount)
                    .addComponent(txtTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        tabpnlPayment.addTab("Payment Details", pnlPaymentDetails);

        pnlBankAccountDetails.setBackground(new java.awt.Color(230, 230, 230));

        lblBankName.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblBankName.setText("Bank Name");

        lblAccountName.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblAccountName.setText("Account Name");

        lblBankNumber.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblBankNumber.setText("Bank Number");

        txtBankName.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtBankName.setEnabled(false);

        txtAccountName.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtAccountName.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtAccountName.setEnabled(false);
        txtAccountName.setMaximumSize(new java.awt.Dimension(190, 26));
        txtAccountName.setMinimumSize(new java.awt.Dimension(190, 26));

        txtBankNumber.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtBankNumber.setEnabled(false);

        javax.swing.GroupLayout pnlBankAccountDetailsLayout = new javax.swing.GroupLayout(pnlBankAccountDetails);
        pnlBankAccountDetails.setLayout(pnlBankAccountDetailsLayout);
        pnlBankAccountDetailsLayout.setHorizontalGroup(
            pnlBankAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBankAccountDetailsLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(pnlBankAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBankName)
                    .addComponent(lblAccountName)
                    .addComponent(lblBankNumber))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(pnlBankAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAccountName, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlBankAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtBankNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBankName, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );
        pnlBankAccountDetailsLayout.setVerticalGroup(
            pnlBankAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBankAccountDetailsLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(pnlBankAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBankName)
                    .addComponent(txtBankName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(pnlBankAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAccountName)
                    .addComponent(txtAccountName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(pnlBankAccountDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBankNumber)
                    .addComponent(txtBankNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        tabpnlPayment.addTab("Bank Account Details", pnlBankAccountDetails);

        javax.swing.GroupLayout pnlAddPaymentContainerLayout = new javax.swing.GroupLayout(pnlAddPaymentContainer);
        pnlAddPaymentContainer.setLayout(pnlAddPaymentContainerLayout);
        pnlAddPaymentContainerLayout.setHorizontalGroup(
            pnlAddPaymentContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddPaymentContainerLayout.createSequentialGroup()
                .addGroup(pnlAddPaymentContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAddPaymentContainerLayout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAddPaymentContainerLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(tabpnlPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        pnlAddPaymentContainerLayout.setVerticalGroup(
            pnlAddPaymentContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddPaymentContainerLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(tabpnlPayment)
                .addGap(18, 18, 18)
                .addComponent(btnAdd)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout pnlRightBgLayout = new javax.swing.GroupLayout(pnlRightBg);
        pnlRightBg.setLayout(pnlRightBgLayout);
        pnlRightBgLayout.setHorizontalGroup(
            pnlRightBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRightBgLayout.createSequentialGroup()
                .addGap(548, 548, 548)
                .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlRightBgLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(pnlAddPaymentContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlRightBgLayout.setVerticalGroup(
            pnlRightBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRightBgLayout.createSequentialGroup()
                .addComponent(lblClose)
                .addGap(36, 36, 36)
                .addComponent(pnlAddPaymentContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(pnlRightBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 550));
    }// </editor-fold>//GEN-END:initComponents

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        //Exit button
        System.exit(0);
    }//GEN-LAST:event_lblCloseMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (!txtAttendedHours.getText().isEmpty() && !txtTotalAmount.getText().isEmpty() && !txtTitle.getText().isEmpty() && !cmbTutorId.getSelectedItem().toString().isEmpty()) {
            // Save payment data
            Payment payment = new Payment(Main.paymentBlockchain.generateId(), Double.parseDouble(txtAttendedHours.getText()), Double.parseDouble(txtTotalAmount.getText().substring(3)), txtTitle.getText(), LocalDateTime.now(), Double.parseDouble(cmbTutorId.getSelectedItem().toString()));
            Main.paymentBlockchain.add(payment);

            // Display success message
            JOptionPane.showMessageDialog(new JFrame(), "Attendance Added Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

            // Refresh the page
            frame.navigateContentPanel(new HQAddPaymentPnl(frame));
        } else {
            // Display error message
            JOptionPane.showMessageDialog(new JFrame(), "Fields Cannot Be Empty", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void cmbBranchNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBranchNameActionPerformed
        // Update tutor fields
        populateCmbTutorId(Main.branchDatabase.findData(cmbBranchName.getSelectedItem().toString()).getId());
    }//GEN-LAST:event_cmbBranchNameActionPerformed

    private void cmbTutorIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTutorIdActionPerformed
        // Update tutor fields
        if (cmbTutorId.getSelectedItem() != null) {
            // Get tutor data
            Tutor tutor = Main.tutorDatabase.findData(Double.parseDouble(cmbTutorId.getSelectedItem().toString()));

            // Calculate total unpaid attended hours
            double attendedHours = 0;

            // Find latest payment
            Payment latestPayment = new Payment(-1, -1, -1, "", LocalDateTime.MIN, -1);
            for (int i = 0; i < Main.paymentBlockchain.getSize(); i++) {
                if (Main.paymentBlockchain.getBlock(i).getData().getTutorId() == tutor.getId()) {
                    latestPayment = Main.paymentBlockchain.getBlock(i).getData();
                }
            }

            // Sum total attended hours after latest payment
            for (int i = 0; i < Main.attendanceBlockchain.getSize(); i++) {
                Attendance attendance = Main.attendanceBlockchain.getBlock(i).getData();
                if (attendance.getTutorId() == tutor.getId() && attendance.getDateTime().isAfter(latestPayment.getPaymentDateTime())) {
                    attendedHours += attendance.getTotalHours();
                }
            }

            // Populate tutor text fields
            txtTutorName.setText(tutor.getName());
            txtAttendedHours.setText(Double.toString(attendedHours));
            txtPayRate.setText("RM " + String.format("%.2f", tutor.getPayRate()));
            txtTotalAmount.setText("RM " + String.format("%.2f", attendedHours * tutor.getPayRate()));
            txtBankName.setText(tutor.getBankName());
            txtAccountName.setText(tutor.getAccountName());
            txtBankNumber.setText(tutor.getBankNumber());
        }
    }//GEN-LAST:event_cmbTutorIdActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JComboBox<String> cmbBranchName;
    private javax.swing.JComboBox<String> cmbTutorId;
    private javax.swing.JLabel lblAccountName;
    private javax.swing.JLabel lblAttendedHours;
    private javax.swing.JLabel lblBankName;
    private javax.swing.JLabel lblBankNumber;
    private javax.swing.JLabel lblBranchName;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblPayRate;
    private javax.swing.JLabel lblPaymentDate;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTotalAmount;
    private javax.swing.JLabel lblTutorId;
    private javax.swing.JLabel lblTutorName;
    private javax.swing.JPanel pnlAddPaymentContainer;
    private javax.swing.JPanel pnlBankAccountDetails;
    private javax.swing.JPanel pnlPaymentDetails;
    private javax.swing.JPanel pnlPersonalDetails;
    private javax.swing.JPanel pnlRightBg;
    private javax.swing.JTabbedPane tabpnlPayment;
    private javax.swing.JTextField txtAccountName;
    private javax.swing.JTextField txtAttendedHours;
    private javax.swing.JTextField txtBankName;
    private javax.swing.JTextField txtBankNumber;
    private javax.swing.JTextField txtPayRate;
    private javax.swing.JTextField txtPaymentDate;
    private javax.swing.JTextField txtTitle;
    private javax.swing.JTextField txtTotalAmount;
    private javax.swing.JTextField txtTutorName;
    // End of variables declaration//GEN-END:variables
}
