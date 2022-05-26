package gui.tcentre.attendance;

import gui.TCentrePanelContainer;
import java.awt.Color;
import tutormanagementsystem.Branch;

public class TCentreAttendanceRightMenu extends javax.swing.JPanel {
    private TCentrePanelContainer frame;
    private Branch branch;

    public TCentreAttendanceRightMenu(TCentrePanelContainer frame, Branch branch) {
        initComponents();
        this.frame = frame;
        this.branch = branch;
        
        frame.navigateContentPanel(new TCentreAddAttendancePnl(frame, branch));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlRightMenu = new javax.swing.JPanel();
        pnlAddAttendance = new javax.swing.JPanel();
        lblAddAttendance = new javax.swing.JLabel();
        pnlSearchAttendance = new javax.swing.JPanel();
        lblSearchAttendance = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(950, 550));
        setMinimumSize(new java.awt.Dimension(950, 550));
        setPreferredSize(new java.awt.Dimension(950, 550));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlRightMenu.setBackground(new java.awt.Color(39, 56, 83));

        pnlAddAttendance.setBackground(new java.awt.Color(63, 91, 135));
        pnlAddAttendance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlAddAttendanceMouseClicked(evt);
            }
        });

        lblAddAttendance.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblAddAttendance.setForeground(new java.awt.Color(255, 255, 255));
        lblAddAttendance.setText("Add Attendance");

        javax.swing.GroupLayout pnlAddAttendanceLayout = new javax.swing.GroupLayout(pnlAddAttendance);
        pnlAddAttendance.setLayout(pnlAddAttendanceLayout);
        pnlAddAttendanceLayout.setHorizontalGroup(
            pnlAddAttendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAddAttendanceLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(lblAddAttendance)
                .addGap(55, 55, 55))
        );
        pnlAddAttendanceLayout.setVerticalGroup(
            pnlAddAttendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddAttendanceLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblAddAttendance)
                .addGap(17, 17, 17))
        );

        pnlSearchAttendance.setBackground(new java.awt.Color(39, 56, 83));
        pnlSearchAttendance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlSearchAttendanceMouseClicked(evt);
            }
        });

        lblSearchAttendance.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSearchAttendance.setForeground(new java.awt.Color(255, 255, 255));
        lblSearchAttendance.setText("Attendance Record");

        javax.swing.GroupLayout pnlSearchAttendanceLayout = new javax.swing.GroupLayout(pnlSearchAttendance);
        pnlSearchAttendance.setLayout(pnlSearchAttendanceLayout);
        pnlSearchAttendanceLayout.setHorizontalGroup(
            pnlSearchAttendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSearchAttendanceLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(lblSearchAttendance)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSearchAttendanceLayout.setVerticalGroup(
            pnlSearchAttendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchAttendanceLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblSearchAttendance)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlRightMenuLayout = new javax.swing.GroupLayout(pnlRightMenu);
        pnlRightMenu.setLayout(pnlRightMenuLayout);
        pnlRightMenuLayout.setHorizontalGroup(
            pnlRightMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRightMenuLayout.createSequentialGroup()
                .addGroup(pnlRightMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnlSearchAttendance, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlAddAttendance, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlRightMenuLayout.setVerticalGroup(
            pnlRightMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRightMenuLayout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(pnlAddAttendance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlSearchAttendance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(301, Short.MAX_VALUE))
        );

        add(pnlRightMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 550));
    }// </editor-fold>//GEN-END:initComponents

    private void pnlAddAttendanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlAddAttendanceMouseClicked
        pnlAddAttendance.setBackground(new Color(63,91,135));
        pnlSearchAttendance.setBackground(new Color(39,56,83));
        
        frame.navigateContentPanel(new TCentreAddAttendancePnl(frame, branch));
    }//GEN-LAST:event_pnlAddAttendanceMouseClicked

    private void pnlSearchAttendanceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSearchAttendanceMouseClicked
        pnlSearchAttendance.setBackground(new Color(63,91,135));
        pnlAddAttendance.setBackground(new Color(39,56,83));
        
        frame.navigateContentPanel(new TCentreSearchAttendancePnl(branch));
    }//GEN-LAST:event_pnlSearchAttendanceMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblAddAttendance;
    private javax.swing.JLabel lblSearchAttendance;
    private javax.swing.JPanel pnlAddAttendance;
    private javax.swing.JPanel pnlRightMenu;
    private javax.swing.JPanel pnlSearchAttendance;
    // End of variables declaration//GEN-END:variables
}