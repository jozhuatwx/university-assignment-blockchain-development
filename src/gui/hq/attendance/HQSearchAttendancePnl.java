package gui.hq.attendance;

import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import tutormanagementsystem.Attendance;
import tutormanagementsystem.Main;
import tutormanagementsystem.Tutor;

public class HQSearchAttendancePnl extends javax.swing.JPanel {

    public HQSearchAttendancePnl() {
        initComponents();

        populateTblAttendance();
        populateCmbBranchName();
    }

    // Populate table data
    private void populateTblAttendance() {
        // Get table model
        DefaultTableModel model = (DefaultTableModel) tblAttendance.getModel();
        // Remove existing table data
        model.setRowCount(0);

        for (int i = 0; i < Main.attendanceBlockchain.getSize(); i++) {
            Attendance attendance = Main.attendanceBlockchain.getBlock(i).getData();
            model.addRow(new Object[] {String.format("%.0f", attendance.getId()), Main.tutorDatabase.findData(attendance.getTutorId()).getName(), attendance.getDateTime().format(Main.DATE_FORMATTER), attendance.getTotalHours()});
        }
    }

    // Populate combobox data
    private void populateCmbBranchName() {
        // Remove existing combobox items
        cmbBranchName.removeAllItems();
        // Add default combobox item
        cmbBranchName.addItem("All");

        for (int i = 0; i < Main.branchDatabase.getSize(); i++) {
            cmbBranchName.addItem(Main.branchDatabase.getData(i).getName());
        }
    }

    // Filter data
    private void filter(String query) {
        // Get table model and create sorter
        DefaultTableModel model = (DefaultTableModel) tblAttendance.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tblAttendance.setRowSorter(sorter);

        // Filter the data
        if (query.trim().length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + query));
        }
    }

    // Filter branch
    private void filterBranch(String branchName) {
        // Get table model
        DefaultTableModel model = (DefaultTableModel) tblAttendance.getModel();
        // Remove existing table data
        model.setRowCount(0);

        double branchId = Main.branchDatabase.findData(branchName).getId();

        // Filter to only branch tutors
        LinkedList<Tutor> tutors = new LinkedList<>();
        for (int i = 0; i < Main.tutorDatabase.getSize(); i++) {
            Tutor tutor = Main.tutorDatabase.getData(i);
            if (tutor.getBranchId() == branchId) {
                tutors.add(tutor);
            }
        }

        for (int i = 0; i < Main.attendanceBlockchain.getSize(); i++) {
            Attendance attendance = Main.attendanceBlockchain.getBlock(i).getData();

            for (int j = 0; j < tutors.size(); j++) {
                Tutor tutor = tutors.get(j);
                if (tutor.getId() == attendance.getTutorId()) {
                    model.addRow(new Object[] {String.format("%.0f", attendance.getId()), tutor.getName(), attendance.getDateTime().format(Main.DATE_FORMATTER), attendance.getTotalHours()});
                }
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
        pnlSearchAttendanceContainer = new javax.swing.JPanel();
        scrpnlAttendanceTable = new javax.swing.JScrollPane();
        tblAttendance = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        cmbBranchName = new javax.swing.JComboBox<>();

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

        pnlSearchAttendanceContainer.setBackground(new java.awt.Color(242, 242, 242));
        pnlSearchAttendanceContainer.setMinimumSize(new java.awt.Dimension(500, 450));

        scrpnlAttendanceTable.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrpnlAttendanceTable.setPreferredSize(new java.awt.Dimension(452, 200));

        tblAttendance.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblAttendance.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Date", "Attended Hours"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrpnlAttendanceTable.setViewportView(tblAttendance);

        txtSearch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        cmbBranchName.setBorder(null);
        cmbBranchName.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbBranchNameItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pnlSearchAttendanceContainerLayout = new javax.swing.GroupLayout(pnlSearchAttendanceContainer);
        pnlSearchAttendanceContainer.setLayout(pnlSearchAttendanceContainerLayout);
        pnlSearchAttendanceContainerLayout.setHorizontalGroup(
            pnlSearchAttendanceContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchAttendanceContainerLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(pnlSearchAttendanceContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrpnlAttendanceTable, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlSearchAttendanceContainerLayout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbBranchName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        pnlSearchAttendanceContainerLayout.setVerticalGroup(
            pnlSearchAttendanceContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchAttendanceContainerLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(pnlSearchAttendanceContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSearch)
                    .addComponent(cmbBranchName))
                .addGap(29, 29, 29)
                .addComponent(scrpnlAttendanceTable, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout pnlRightBgLayout = new javax.swing.GroupLayout(pnlRightBg);
        pnlRightBg.setLayout(pnlRightBgLayout);
        pnlRightBgLayout.setHorizontalGroup(
            pnlRightBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRightBgLayout.createSequentialGroup()
                .addGap(548, 548, 548)
                .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlRightBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlRightBgLayout.createSequentialGroup()
                    .addGap(44, 44, 44)
                    .addComponent(pnlSearchAttendanceContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(44, Short.MAX_VALUE)))
        );
        pnlRightBgLayout.setVerticalGroup(
            pnlRightBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRightBgLayout.createSequentialGroup()
                .addComponent(lblClose)
                .addGap(523, 523, 523))
            .addGroup(pnlRightBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlRightBgLayout.createSequentialGroup()
                    .addGap(59, 59, 59)
                    .addComponent(pnlSearchAttendanceContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(60, Short.MAX_VALUE)))
        );

        add(pnlRightBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 550));
    }// </editor-fold>//GEN-END:initComponents

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        // Exit button
        System.exit(0);
    }//GEN-LAST:event_lblCloseMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // Get the input and call filter()
        String query = txtSearch.getText().toLowerCase();
        filter(query);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void cmbBranchNameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbBranchNameItemStateChanged
        // Repopulate at default
        if (cmbBranchName.getSelectedIndex() > 0) {
            filterBranch(cmbBranchName.getSelectedItem().toString());
        } else {
            populateTblAttendance();
        }
    }//GEN-LAST:event_cmbBranchNameItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbBranchName;
    private javax.swing.JLabel lblClose;
    private javax.swing.JPanel pnlRightBg;
    private javax.swing.JPanel pnlSearchAttendanceContainer;
    private javax.swing.JScrollPane scrpnlAttendanceTable;
    private javax.swing.JTable tblAttendance;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
