package gui.tcentre.tutor;

import gui.TCentrePanelContainer;
import tutormanagementsystem.Branch;

public class TCentreTutorRightMenuSecondVer extends javax.swing.JPanel {
    private TCentrePanelContainer frame;
    private Branch branch;

    public TCentreTutorRightMenuSecondVer(TCentrePanelContainer frame, Branch branch) {
        initComponents();
        this.frame = frame;
        this.branch = branch;
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
        pnlAddTutor = new javax.swing.JPanel();
        lblAddTutor = new javax.swing.JLabel();
        pnlBackToSearch = new javax.swing.JPanel();
        lblBackToSearch = new javax.swing.JLabel();
        lblIconBack = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(950, 550));
        setMinimumSize(new java.awt.Dimension(950, 550));
        setPreferredSize(new java.awt.Dimension(950, 550));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlRightMenu.setBackground(new java.awt.Color(39, 56, 83));

        pnlAddTutor.setBackground(new java.awt.Color(39, 56, 83));
        pnlAddTutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlAddTutorMouseClicked(evt);
            }
        });

        lblAddTutor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblAddTutor.setForeground(new java.awt.Color(255, 255, 255));
        lblAddTutor.setText("Add Tutor");

        javax.swing.GroupLayout pnlAddTutorLayout = new javax.swing.GroupLayout(pnlAddTutor);
        pnlAddTutor.setLayout(pnlAddTutorLayout);
        pnlAddTutorLayout.setHorizontalGroup(
            pnlAddTutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAddTutorLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(lblAddTutor)
                .addContainerGap(96, Short.MAX_VALUE))
        );
        pnlAddTutorLayout.setVerticalGroup(
            pnlAddTutorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAddTutorLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblAddTutor)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pnlBackToSearch.setBackground(new java.awt.Color(63, 91, 135));
        pnlBackToSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlBackToSearchMouseClicked(evt);
            }
        });

        lblBackToSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblBackToSearch.setForeground(new java.awt.Color(255, 255, 255));
        lblBackToSearch.setText("Back to Search");

        lblIconBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/resources/icon_back.png"))); // NOI18N

        javax.swing.GroupLayout pnlBackToSearchLayout = new javax.swing.GroupLayout(pnlBackToSearch);
        pnlBackToSearch.setLayout(pnlBackToSearchLayout);
        pnlBackToSearchLayout.setHorizontalGroup(
            pnlBackToSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackToSearchLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblIconBack)
                .addGap(14, 14, 14)
                .addComponent(lblBackToSearch)
                .addGap(58, 58, 58))
        );
        pnlBackToSearchLayout.setVerticalGroup(
            pnlBackToSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackToSearchLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlBackToSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBackToSearch)
                    .addComponent(lblIconBack))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlRightMenuLayout = new javax.swing.GroupLayout(pnlRightMenu);
        pnlRightMenu.setLayout(pnlRightMenuLayout);
        pnlRightMenuLayout.setHorizontalGroup(
            pnlRightMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackToSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlRightMenuLayout.createSequentialGroup()
                .addComponent(pnlAddTutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlRightMenuLayout.setVerticalGroup(
            pnlRightMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRightMenuLayout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(pnlAddTutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlBackToSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(351, Short.MAX_VALUE))
        );

        add(pnlRightMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 550));
    }// </editor-fold>//GEN-END:initComponents

    private void pnlAddTutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlAddTutorMouseClicked
        frame.navigateContentPanel(new TCentreAddTutorPnl(frame, branch));
        frame.navigateMenuPanel(new TCentreTutorRightMenu(frame, branch));
    }//GEN-LAST:event_pnlAddTutorMouseClicked

    private void pnlBackToSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBackToSearchMouseClicked
        frame.navigateContentPanel(new TCentreSearchTutorPnl(frame, branch));
        frame.navigateMenuPanel(new TCentreTutorRightMenu(frame, branch, 1));
    }//GEN-LAST:event_pnlBackToSearchMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblAddTutor;
    private javax.swing.JLabel lblBackToSearch;
    private javax.swing.JLabel lblIconBack;
    private javax.swing.JPanel pnlAddTutor;
    private javax.swing.JPanel pnlBackToSearch;
    private javax.swing.JPanel pnlRightMenu;
    // End of variables declaration//GEN-END:variables
}
