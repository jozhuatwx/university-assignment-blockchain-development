package gui;

import gui.hq.tutor.HQTutorRightMenu;
import gui.hq.tcentre.HQTCentreRightMenu;
import gui.hq.attendance.HQAttendanceRightMenu;
import gui.hq.payment.HQPaymentRightMenu;

import java.awt.Color;
import javax.swing.JPanel;

import tutormanagementsystem.Branch;

public class HQPanelContainer extends javax.swing.JFrame {
    //Variable for GUI draggable
    private int mousepX, mousepY;
    private Branch branch;

    public HQPanelContainer(Branch branch) {
        initComponents();
        this.branch = branch;
        
        navigateMenuPanel(new HQTutorRightMenu(this));
    }

    //Change panels
    public void navigateMenuPanel(JPanel panel){
        //remove all previous content
        pnlRightMenu.removeAll();
        //add the new panel
        pnlRightMenu.add(panel);
        pnlRightMenu.revalidate();
    }

    public void navigateContentPanel(JPanel panel){
        //remove all previous content
        pnlRightContent.removeAll();
        //add the new panel
        pnlRightContent.add(panel);
        pnlRightContent.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLeftMenu = new javax.swing.JPanel();
        pnlTutor = new javax.swing.JPanel();
        lblTutor = new javax.swing.JLabel();
        lblVerticalBar1 = new javax.swing.JLabel();
        pnlTCentre = new javax.swing.JPanel();
        lblTCentre = new javax.swing.JLabel();
        lblVerticalBar2 = new javax.swing.JLabel();
        pnlAttendance = new javax.swing.JPanel();
        lblAttendance = new javax.swing.JLabel();
        lblVerticalBar3 = new javax.swing.JLabel();
        pnlPayment = new javax.swing.JPanel();
        lblPayment = new javax.swing.JLabel();
        lblVerticalBar4 = new javax.swing.JLabel();
        pnlLogout = new javax.swing.JPanel();
        lbl_logout = new javax.swing.JLabel();
        pnlRightContainer = new javax.swing.JPanel();
        pnlRightMenu = new javax.swing.JPanel();
        pnlRightContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(950, 550));
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

        pnlLeftMenu.setBackground(new java.awt.Color(24, 34, 56));
        pnlLeftMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlTutor.setBackground(new java.awt.Color(39, 56, 83));
        pnlTutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlTutorMouseClicked(evt);
            }
        });

        lblTutor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTutor.setForeground(new java.awt.Color(255, 255, 255));
        lblTutor.setText("Tutor");

        lblVerticalBar1.setBackground(new java.awt.Color(255, 255, 255));
        lblVerticalBar1.setForeground(new java.awt.Color(255, 255, 255));
        lblVerticalBar1.setOpaque(true);

        javax.swing.GroupLayout pnlTutorLayout = new javax.swing.GroupLayout(pnlTutor);
        pnlTutor.setLayout(pnlTutorLayout);
        pnlTutorLayout.setHorizontalGroup(
            pnlTutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTutorLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblTutor)
                .addGap(78, 78, 78))
            .addGroup(pnlTutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlTutorLayout.createSequentialGroup()
                    .addComponent(lblVerticalBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 147, Short.MAX_VALUE)))
        );
        pnlTutorLayout.setVerticalGroup(
            pnlTutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTutorLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblTutor)
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(pnlTutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblVerticalBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
        );

        pnlLeftMenu.add(pnlTutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 150, 50));

        pnlTCentre.setBackground(new java.awt.Color(24, 34, 56));
        pnlTCentre.setForeground(new java.awt.Color(255, 255, 255));
        pnlTCentre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlTCentreMouseClicked(evt);
            }
        });

        lblTCentre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTCentre.setForeground(new java.awt.Color(255, 255, 255));
        lblTCentre.setText("Tuition Centre");

        lblVerticalBar2.setBackground(new java.awt.Color(24, 34, 56));
        lblVerticalBar2.setForeground(new java.awt.Color(255, 255, 255));
        lblVerticalBar2.setOpaque(true);

        javax.swing.GroupLayout pnlTCentreLayout = new javax.swing.GroupLayout(pnlTCentre);
        pnlTCentre.setLayout(pnlTCentreLayout);
        pnlTCentreLayout.setHorizontalGroup(
            pnlTCentreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTCentreLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblTCentre)
                .addGap(47, 47, 47))
            .addGroup(pnlTCentreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlTCentreLayout.createSequentialGroup()
                    .addComponent(lblVerticalBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 180, Short.MAX_VALUE)))
        );
        pnlTCentreLayout.setVerticalGroup(
            pnlTCentreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTCentreLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblTCentre)
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(pnlTCentreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblVerticalBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
        );

        pnlLeftMenu.add(pnlTCentre, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 150, 50));

        pnlAttendance.setBackground(new java.awt.Color(24, 34, 56));
        pnlAttendance.setForeground(new java.awt.Color(255, 255, 255));
        pnlAttendance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlAttendanceMouseClicked(evt);
            }
        });

        lblAttendance.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblAttendance.setForeground(new java.awt.Color(255, 255, 255));
        lblAttendance.setText("Attendance");

        lblVerticalBar3.setBackground(new java.awt.Color(24, 34, 56));
        lblVerticalBar3.setForeground(new java.awt.Color(255, 255, 255));
        lblVerticalBar3.setOpaque(true);

        javax.swing.GroupLayout pnlAttendanceLayout = new javax.swing.GroupLayout(pnlAttendance);
        pnlAttendance.setLayout(pnlAttendanceLayout);
        pnlAttendanceLayout.setHorizontalGroup(
            pnlAttendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAttendanceLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblAttendance)
                .addGap(47, 47, 47))
            .addGroup(pnlAttendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlAttendanceLayout.createSequentialGroup()
                    .addComponent(lblVerticalBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 160, Short.MAX_VALUE)))
        );
        pnlAttendanceLayout.setVerticalGroup(
            pnlAttendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAttendanceLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblAttendance)
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(pnlAttendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblVerticalBar3, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
        );

        pnlLeftMenu.add(pnlAttendance, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 150, 50));

        pnlPayment.setBackground(new java.awt.Color(24, 34, 56));
        pnlPayment.setForeground(new java.awt.Color(255, 255, 255));
        pnlPayment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlPaymentMouseClicked(evt);
            }
        });

        lblPayment.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPayment.setForeground(new java.awt.Color(255, 255, 255));
        lblPayment.setText("Payment");

        lblVerticalBar4.setBackground(new java.awt.Color(24, 34, 56));
        lblVerticalBar4.setForeground(new java.awt.Color(255, 255, 255));
        lblVerticalBar4.setOpaque(true);

        javax.swing.GroupLayout pnlPaymentLayout = new javax.swing.GroupLayout(pnlPayment);
        pnlPayment.setLayout(pnlPaymentLayout);
        pnlPaymentLayout.setHorizontalGroup(
            pnlPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPaymentLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblPayment)
                .addGap(47, 47, 47))
            .addGroup(pnlPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlPaymentLayout.createSequentialGroup()
                    .addComponent(lblVerticalBar4, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 145, Short.MAX_VALUE)))
        );
        pnlPaymentLayout.setVerticalGroup(
            pnlPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPaymentLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblPayment)
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(pnlPaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblVerticalBar4, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
        );

        pnlLeftMenu.add(pnlPayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 150, 50));

        pnlLogout.setBackground(new java.awt.Color(24, 34, 56));
        pnlLogout.setForeground(new java.awt.Color(255, 255, 255));
        pnlLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlLogoutMouseClicked(evt);
            }
        });

        lbl_logout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_logout.setForeground(new java.awt.Color(255, 255, 255));
        lbl_logout.setText("Log out");

        javax.swing.GroupLayout pnlLogoutLayout = new javax.swing.GroupLayout(pnlLogout);
        pnlLogout.setLayout(pnlLogoutLayout);
        pnlLogoutLayout.setHorizontalGroup(
            pnlLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLogoutLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(lbl_logout)
                .addGap(47, 47, 47))
        );
        pnlLogoutLayout.setVerticalGroup(
            pnlLogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLogoutLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lbl_logout)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pnlLeftMenu.add(pnlLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 150, 50));

        pnlRightMenu.setLayout(new java.awt.BorderLayout());

        pnlRightContent.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout pnlRightContainerLayout = new javax.swing.GroupLayout(pnlRightContainer);
        pnlRightContainer.setLayout(pnlRightContainerLayout);
        pnlRightContainerLayout.setHorizontalGroup(
            pnlRightContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRightContainerLayout.createSequentialGroup()
                .addComponent(pnlRightMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlRightContent, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        pnlRightContainerLayout.setVerticalGroup(
            pnlRightContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlRightMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlRightContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnlLeftMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlRightContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlRightContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnlLeftMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // Draggable - get X and Y 
        mousepX = evt.getX();
        mousepY = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        //Draggable
        int coordinateX = evt.getXOnScreen();
        int coordinateY = evt.getYOnScreen();
        this.setLocation(coordinateX-mousepX,coordinateY-mousepY);
    }//GEN-LAST:event_formMouseDragged

    private void pnlPaymentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPaymentMouseClicked
        pnlPayment.setBackground(new Color(39,56,83));
        lblVerticalBar4.setBackground(new Color(255,255,255));

        pnlTutor.setBackground(new Color(24,34,56));
        lblVerticalBar1.setBackground(new Color(24,34,56));

        pnlTCentre.setBackground(new Color(24,34,56));
        lblVerticalBar2.setBackground(new Color(24,34,56));

        pnlAttendance.setBackground(new Color(24,34,56));
        lblVerticalBar3.setBackground(new Color(24,34,56));

        navigateMenuPanel(new HQPaymentRightMenu(this));
    }//GEN-LAST:event_pnlPaymentMouseClicked

    private void pnlAttendanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlAttendanceMouseClicked
        pnlAttendance.setBackground(new Color(39,56,83));
        lblVerticalBar3.setBackground(new Color(255,255,255));

        pnlTutor.setBackground(new Color(24,34,56));
        lblVerticalBar1.setBackground(new Color(24,34,56));

        pnlTCentre.setBackground(new Color(24,34,56));
        lblVerticalBar2.setBackground(new Color(24,34,56));

        pnlPayment.setBackground(new Color(24,34,56));
        lblVerticalBar4.setBackground(new Color(24,34,56));

        navigateMenuPanel(new HQAttendanceRightMenu(this, branch));
    }//GEN-LAST:event_pnlAttendanceMouseClicked

    private void pnlTCentreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTCentreMouseClicked
        pnlTCentre.setBackground(new Color(39,56,83));
        lblVerticalBar2.setBackground(new Color(255,255,255));

        pnlTutor.setBackground(new Color(24,34,56));
        lblVerticalBar1.setBackground(new Color(24,34,56));

        pnlAttendance.setBackground(new Color(24,34,56));
        lblVerticalBar3.setBackground(new Color(24,34,56));

        pnlPayment.setBackground(new Color(24,34,56));
        lblVerticalBar4.setBackground(new Color(24,34,56));

        navigateMenuPanel(new HQTCentreRightMenu(this));
    }//GEN-LAST:event_pnlTCentreMouseClicked

    private void pnlTutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTutorMouseClicked
        pnlTutor.setBackground(new Color(39,56,83));
        lblVerticalBar1.setBackground(new Color(255,255,255));

        pnlTCentre.setBackground(new Color(24,34,56));
        lblVerticalBar2.setBackground(new Color(24,34,56));

        pnlAttendance.setBackground(new Color(24,34,56));
        lblVerticalBar3.setBackground(new Color(24,34,56));

        pnlPayment.setBackground(new Color(24,34,56));
        lblVerticalBar4.setBackground(new Color(24,34,56));

        navigateMenuPanel(new HQTutorRightMenu(this));
    }//GEN-LAST:event_pnlTutorMouseClicked

    private void pnlLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlLogoutMouseClicked
        //Logout and show the login form
        LoginForm loginForm = new LoginForm();
        loginForm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_pnlLogoutMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblAttendance;
    private javax.swing.JLabel lblPayment;
    private javax.swing.JLabel lblTCentre;
    private javax.swing.JLabel lblTutor;
    private javax.swing.JLabel lblVerticalBar1;
    private javax.swing.JLabel lblVerticalBar2;
    private javax.swing.JLabel lblVerticalBar3;
    private javax.swing.JLabel lblVerticalBar4;
    private javax.swing.JLabel lbl_logout;
    private javax.swing.JPanel pnlAttendance;
    private javax.swing.JPanel pnlLeftMenu;
    private javax.swing.JPanel pnlLogout;
    private javax.swing.JPanel pnlPayment;
    private javax.swing.JPanel pnlRightContainer;
    private javax.swing.JPanel pnlRightContent;
    private javax.swing.JPanel pnlRightMenu;
    private javax.swing.JPanel pnlTCentre;
    private javax.swing.JPanel pnlTutor;
    // End of variables declaration//GEN-END:variables
}
