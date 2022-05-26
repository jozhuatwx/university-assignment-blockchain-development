package gui.hq.payment;

import gui.HQPanelContainer;
import tutormanagementsystem.Main;
import tutormanagementsystem.Payment;

import java.awt.Font;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import tutormanagementsystem.Tutor;

public class HQSearchPaymentPnl extends javax.swing.JPanel {
    private HQPanelContainer frame;

    public HQSearchPaymentPnl(HQPanelContainer frame) {
        initComponents();
        this.frame = frame;

        populateTblPayment();
        populateCmbBranchName();
    }

    // Populate table data
    private void populateTblPayment() {
        // Get table model
        DefaultTableModel model = (DefaultTableModel) tblPayment.getModel();
        // Remove existing table data
        model.setRowCount(0);

        for (int i = 0; i < Main.paymentBlockchain.getSize(); i++) {
            Payment payment = Main.paymentBlockchain.getBlock(i).getData();
            model.addRow(new Object[] {String.format("%.0f", payment.getTutorId()), Main.tutorDatabase.findData(payment.getTutorId()).getName(), payment.getPaymentDateTime().format(Main.DATE_FORMATTER), "RM " + String.format("%.2f", payment.getAmount())});
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
        DefaultTableModel model = (DefaultTableModel) tblPayment.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tblPayment.setRowSorter(sorter);

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
        DefaultTableModel model = (DefaultTableModel) tblPayment.getModel();
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

        for (int i = 0; i < Main.paymentBlockchain.getSize(); i++) {
            Payment payment = Main.paymentBlockchain.getBlock(i).getData();

            for (int j = 0; j < tutors.size(); j++) {
                Tutor tutor = tutors.get(j);
                if (tutor.getId() == payment.getTutorId()) {
                    model.addRow(new Object[] {String.format("%.0f", tutor.getId()), tutor.getName(), payment.getPaymentDateTime().format(Main.DATE_FORMATTER), "RM " + String.format("%.2f", payment.getAmount())});
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
        pnlSearchPaymentContainer = new javax.swing.JPanel();
        scrpnlPaymentTable = new javax.swing.JScrollPane();
        tblPayment = new javax.swing.JTable();
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

        pnlSearchPaymentContainer.setBackground(new java.awt.Color(242, 242, 242));
        pnlSearchPaymentContainer.setMinimumSize(new java.awt.Dimension(500, 450));

        scrpnlPaymentTable.setBackground(new java.awt.Color(255, 255, 255));
        scrpnlPaymentTable.setBorder(null);
        scrpnlPaymentTable.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tblPayment.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        tblPayment.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblPayment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tutor ID", "Name", "Date", "Total Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPayment.setSelectionBackground(new java.awt.Color(24, 34, 56));
        tblPayment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPaymentMouseClicked(evt);
            }
        });
        scrpnlPaymentTable.setViewportView(tblPayment);

        txtSearch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        cmbBranchName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbBranchNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSearchPaymentContainerLayout = new javax.swing.GroupLayout(pnlSearchPaymentContainer);
        pnlSearchPaymentContainer.setLayout(pnlSearchPaymentContainerLayout);
        pnlSearchPaymentContainerLayout.setHorizontalGroup(
            pnlSearchPaymentContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchPaymentContainerLayout.createSequentialGroup()
                .addGroup(pnlSearchPaymentContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlSearchPaymentContainerLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(scrpnlPaymentTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSearchPaymentContainerLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(txtSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbBranchName, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
        );
        pnlSearchPaymentContainerLayout.setVerticalGroup(
            pnlSearchPaymentContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchPaymentContainerLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(pnlSearchPaymentContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSearch)
                    .addComponent(cmbBranchName))
                .addGap(39, 39, 39)
                .addComponent(scrpnlPaymentTable, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
        );

        javax.swing.GroupLayout pnlRightBgLayout = new javax.swing.GroupLayout(pnlRightBg);
        pnlRightBg.setLayout(pnlRightBgLayout);
        pnlRightBgLayout.setHorizontalGroup(
            pnlRightBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRightBgLayout.createSequentialGroup()
                .addGap(548, 548, 548)
                .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRightBgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSearchPaymentContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        pnlRightBgLayout.setVerticalGroup(
            pnlRightBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRightBgLayout.createSequentialGroup()
                .addComponent(lblClose)
                .addGap(18, 18, 18)
                .addComponent(pnlSearchPaymentContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        add(pnlRightBg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 550));
    }// </editor-fold>//GEN-END:initComponents

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        // Exit button
        System.exit(0);
    }//GEN-LAST:event_lblCloseMouseClicked

    private void tblPaymentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPaymentMouseClicked
        // Get model of the table, then get selected row
        DefaultTableModel model = (DefaultTableModel) tblPayment.getModel();
        int selectedRowIndex = tblPayment.convertRowIndexToModel(tblPayment.getSelectedRow());

        // Get the paymentId
        double id = Double.parseDouble(model.getValueAt(selectedRowIndex, 0).toString());

        frame.navigateMenuPanel(new HQPaymentRightMenuSecondVer(frame));
        frame.navigateContentPanel(new HQPaymentDetailsPnl(Main.paymentBlockchain.findData(id).getData()));
    }//GEN-LAST:event_tblPaymentMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // Get the input and call filter()
        String query = txtSearch.getText().toLowerCase();
        filter(query);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void cmbBranchNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbBranchNameActionPerformed
        // Repopulate at default
        if (cmbBranchName.getSelectedIndex() > 0) {
            filterBranch(cmbBranchName.getSelectedItem().toString());
        } else {
            populateTblPayment();
        }
    }//GEN-LAST:event_cmbBranchNameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbBranchName;
    private javax.swing.JLabel lblClose;
    private javax.swing.JPanel pnlRightBg;
    private javax.swing.JPanel pnlSearchPaymentContainer;
    private javax.swing.JScrollPane scrpnlPaymentTable;
    private javax.swing.JTable tblPayment;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
