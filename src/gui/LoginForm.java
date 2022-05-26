package gui;

import java.awt.Image;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import tutormanagementsystem.*;

public class LoginForm extends javax.swing.JFrame {
    // GUI -- Variable for GUI draggable
    private int mousepX, mousepY;

    public LoginForm() {
        initComponents();
        // GUI -- Scale the image to label size
        scaleImage("./src/gui/resources/icon_tuition.png", lblTitleIcon);

        // Set default button
        getRootPane().setDefaultButton(btnLogin);

        verifyExistingData();

        populateDefaultBranchData();
        populateDefaultTutorData();
        populateDefaultSubjectData();

        removeTerminatedTutors();
    }

    // GUI -- Scale the image to label size
    private void scaleImage(String filePath, JLabel labelName) {
        // Find the icon location
        ImageIcon icon = new ImageIcon(filePath);

        // Rescale icon the jLabel size
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(labelName.getWidth() - 20, labelName.getHeight() - 20, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        labelName.setIcon(scaledIcon);
    }

    private void populateDefaultBranchData() {
        if (Main.branchDatabase.isEmpty()) {
            // Role: branch
            // Username: hq
            // Password: 12345
            Main.branchDatabase.add(new Branch(1, "hq", "Taman HQ", "012-987654321", "", BranchCategory.HEADQUARTER));
            Branch hq = Main.branchDatabase.getData(0);
            hq.setPassword(Main.DEFAULT_PASSWORD, Main.cryptography);

            // Username: branch
            // Password: 12345
            Main.branchDatabase.add(new Branch(2, "branch", "Taman Branch", "019-654321859", "", BranchCategory.BRANCH));
            Branch b = Main.branchDatabase.getData(1);
            b.setPassword(Main.DEFAULT_PASSWORD, Main.cryptography);

            Main.branchDatabase.save();
        }
    }

    private void populateDefaultSubjectData() {
        if (Main.subjectDatabase.isEmpty()) {
            Main.subjectDatabase.add(new Subject(1, "Biology", "Study of life", SubjectCategory.FORM4));
            Main.subjectDatabase.add(new Subject(2, "Physics", "Study of how the Universe interact", SubjectCategory.FORM4));
            Main.subjectDatabase.add(new Subject(3, "Chemistry", "Study of properties, composition, and structure of substances", SubjectCategory.FORM4));
            Main.subjectDatabase.add(new Subject(4, "Mathematics", "Study of logic of shape, quantity and arrangement", SubjectCategory.FORM4));
            Main.subjectDatabase.add(new Subject(5, "Bahasa Malaysia", "Malaysian language", SubjectCategory.FORM4));
        }
    }

    private void populateDefaultTutorData() {
        if (Main.tutorDatabase.isEmpty()) {
            // Role: tutor
            // Username: tutor
            // Password: 12345
            Tutor tutor = new Tutor(1, "tutor", "950101-10-1011", "012-34567890", "mail.com", "", new double[] {1}, LocalDate.now(), "Maybank", "Tutor Name", "10268714269", 1, 10, LocalDate.MIN);
            tutor.setPassword(Main.DEFAULT_PASSWORD, Main.cryptography);
            Main.tutorDatabase.add(tutor);
        }
    }

    // Remove terminated tutors more than one month old
    private void removeTerminatedTutors() {
        for (int i = 0; i < Main.tutorDatabase.getSize(); i++) {
            Tutor tutor = Main.tutorDatabase.getData(i);
            // Check if tutor is terminated and if is terminated more than one month ago
            if (!tutor.getTerminationDate().isEqual(LocalDate.MIN) && LocalDate.now().isAfter(tutor.getTerminationDate().plusMonths(1))) {
                // Remove tutor from SecureDatabase
                Main.tutorDatabase.removeData(i);
                // Repeat index to read next tutor
                i--;
            }
        }
    }

    private void verifyExistingData() {
        // Verify tutor database
        if (!Main.tutorDatabase.getReadSuccessful()) {
            // Displays the error message
            JOptionPane.showMessageDialog(new JFrame(), "Tutor Database Cannot Be Read", "Error", JOptionPane.ERROR_MESSAGE);

            // Disable login
            btnLogin.setEnabled(false);
            lblError.setText("Error loading data. Please relaunch application.");
        }

        // Verify attendance blockchain
        if (!Main.attendanceBlockchain.verify()) {
            // Displays the error message
            JOptionPane.showMessageDialog(new JFrame(), "Attendance Blockchain Cannot Be Verified", "Error", JOptionPane.ERROR_MESSAGE);

            // Disable login
            btnLogin.setEnabled(false);
            lblError.setText("Error loading data. Please relaunch application.");
        }
        
        // Verify payment blockchain
        if (!Main.paymentBlockchain.verify()) {
            // Displays the error message
            JOptionPane.showMessageDialog(new JFrame(), "Payment Blockchain Cannot Be Verified", "Error", JOptionPane.ERROR_MESSAGE);

            // Disable login
            btnLogin.setEnabled(false);
            lblError.setText("Error loading data. Please relaunch application.");
        }
    }

    // Login function for tutors
    private Tutor loginTutor() {
        for (int i = 0; i < Main.tutorDatabase.getSize(); i++) {
            Tutor current = Main.tutorDatabase.getData(i);
            // Find active and matching username
            if (current.getTerminationDate().equals(LocalDate.MIN) && current.getName().equalsIgnoreCase(txtUsername.getText())) {
                // Verify tutor password
                if (current.verify(Main.cryptography, String.valueOf(txtPassword.getPassword()))) {
                    return current;
                }
                break;
            }
        }
        return null;
    }

    // Login function for branches
    private Branch loginBranch() {
        for (int i = 0; i < Main.branchDatabase.getSize(); i++) {
            Branch current = Main.branchDatabase.getData(i);
            // Find matching username
            if (current.getName().equalsIgnoreCase(txtUsername.getText())) {
                // Verify branch password
                if (current.verify(Main.cryptography, String.valueOf(txtPassword.getPassword()))) {
                    return current;
                }
                break;
            }
        }
        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBg = new javax.swing.JPanel();
        pnlLeft = new javax.swing.JPanel();
        lblTitleIcon = new javax.swing.JLabel();
        lblTitle1 = new javax.swing.JLabel();
        lblTitle2 = new javax.swing.JLabel();
        lblTitle3 = new javax.swing.JLabel();
        pnlRight = new javax.swing.JPanel();
        lblClose = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();
        cmbRole = new javax.swing.JComboBox<>();
        lblRole = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(950, 550));
        setName("frame"); // NOI18N
        setUndecorated(true);
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        pnlBg.setBackground(new java.awt.Color(255, 255, 255));
        pnlBg.setMaximumSize(new java.awt.Dimension(950, 569));
        pnlBg.setMinimumSize(new java.awt.Dimension(950, 569));
        pnlBg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlLeft.setBackground(new java.awt.Color(0, 0, 51));

        lblTitleIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitleIcon.setText("jLabel2");

        lblTitle1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTitle1.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle1.setText("Tutor");

        lblTitle2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTitle2.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle2.setText("Management");

        lblTitle3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTitle3.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle3.setText("System");

        javax.swing.GroupLayout pnlLeftLayout = new javax.swing.GroupLayout(pnlLeft);
        pnlLeft.setLayout(pnlLeftLayout);
        pnlLeftLayout.setHorizontalGroup(
            pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblTitle2, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
            .addComponent(lblTitle3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlLeftLayout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(lblTitleIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlLeftLayout.setVerticalGroup(
            pnlLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLeftLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(lblTitleIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(lblTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitle3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
        );

        pnlBg.add(pnlLeft, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 550));

        pnlRight.setBackground(new java.awt.Color(255, 255, 255));
        pnlRight.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)));

        lblClose.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClose.setText("X");
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
        });

        lblUsername.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        lblUsername.setText("Username:");

        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsername.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lblPassword.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        lblPassword.setText("Password:");

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPassword.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        btnLogin.setBackground(new java.awt.Color(0, 0, 43));
        btnLogin.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblError.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 0, 51));
        lblError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        cmbRole.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cmbRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tutor", "Branch" }));

        lblRole.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        lblRole.setText("Role:");

        javax.swing.GroupLayout pnlRightLayout = new javax.swing.GroupLayout(pnlRight);
        pnlRight.setLayout(pnlRightLayout);
        pnlRightLayout.setHorizontalGroup(
            pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRightLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlRightLayout.createSequentialGroup()
                .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRightLayout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlRightLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUsername)
                            .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                            .addComponent(lblError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPassword)
                            .addGroup(pnlRightLayout.createSequentialGroup()
                                .addComponent(lblRole, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbRole, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        pnlRightLayout.setVerticalGroup(
            pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRightLayout.createSequentialGroup()
                .addComponent(lblClose)
                .addGap(94, 94, 94)
                .addComponent(lblUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRole, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(btnLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlBg.add(pnlRight, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 480, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlBg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // Check role selected
        switch (cmbRole.getSelectedIndex()) {
            // Tutor
            case 0: {
                // Verity tutor
                Tutor tutor = loginTutor();
                if (tutor != null) {
                    TutorPanelContainer pnlContainer = new TutorPanelContainer(tutor);
                    pnlContainer.setVisible(true);
                    // Close login frame
                    this.dispose();
                } else {
                    lblError.setText("Incorrect username or password. Please try again.");
                }
                break;
            }

            // Branch
            case 1: {
                // Verify branch
                Branch branch = loginBranch();
                if (branch != null) {
                    // Check branch category
                    switch (branch.getCategory()) {
                        case HEADQUARTER: {
                            HQPanelContainer pnlContainer = new HQPanelContainer(branch);
                            pnlContainer.setVisible(true);
                            // Close login frame
                            this.dispose();
                            break;
                        }

                        case BRANCH: {
                            TCentrePanelContainer pnlContainer = new TCentrePanelContainer(branch);
                            pnlContainer.setVisible(true);
                            // Close login frame
                            this.dispose();
                            break;
                        }
                    }
                } else {
                    lblError.setText("Incorrect username or password. Please try again.");
                }
                break;
            }
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        // Exit button
        System.exit(0);
    }//GEN-LAST:event_lblCloseMouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // Draggable - get X and Y 
        mousepX = evt.getX();
        mousepY = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // Draggable
        int coordinateX = evt.getXOnScreen();
        int coordinateY = evt.getYOnScreen();
        this.setLocation(coordinateX - mousepX, coordinateY - mousepY);
    }//GEN-LAST:event_formMouseDragged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JComboBox<String> cmbRole;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JLabel lblTitle2;
    private javax.swing.JLabel lblTitle3;
    private javax.swing.JLabel lblTitleIcon;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel pnlBg;
    private javax.swing.JPanel pnlLeft;
    private javax.swing.JPanel pnlRight;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
