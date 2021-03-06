package gui.tutor.payment;

import gui.TutorPanelContainer;
import java.awt.Font;
import java.time.format.DateTimeFormatter;

import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import tutormanagementsystem.Main;
import tutormanagementsystem.Payment;
import tutormanagementsystem.Tutor;

public class TutorPaymentPnlLatest extends javax.swing.JPanel {
    private TutorPanelContainer frame;
    private Tutor tutor;

    public TutorPaymentPnlLatest(TutorPanelContainer frame, Tutor tutor) {
        initComponents();
        this.frame = frame;
        this.tutor = tutor;

        populateTblPayment();
    }

    // Populate table data
    private void populateTblPayment() {
        // Get table model
        DefaultTableModel model = (DefaultTableModel) tblPayment.getModel();
        // Remove existing table data
        model.setRowCount(0);

        for (int i = 0; i < Main.paymentBlockchain.getSize(); i++) {
            Payment payment = Main.paymentBlockchain.getBlock(i).getData();
            if (payment.getTutorId() == tutor.getId()) {
                model.addRow(new Object[] {String.format("%.0f", payment.getId()), payment.getPaymentDateTime().format(Main.DATE_FORMATTER), "RM " + String.format("%.2f", payment.getAmount())});
            }
        }
    }

    // Filter data
    private void filter(String query) {
        // Get table model and create sorter
        DefaultTableModel model = (DefaultTableModel) tblPayment.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tblPayment.setRowSorter(sorter);
        
        // Filter the data
        if (query.trim().length() == 0){
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + query));
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
        pnlUpdateProfileContainer = new javax.swing.JPanel();
        scrpnlPaymentTable = new javax.swing.JScrollPane();
        tblPayment = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();

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

        pnlUpdateProfileContainer.setBackground(new java.awt.Color(242, 242, 242));
        pnlUpdateProfileContainer.setMinimumSize(new java.awt.Dimension(500, 450));

        scrpnlPaymentTable.setBackground(new java.awt.Color(255, 255, 255));
        scrpnlPaymentTable.setBorder(null);
        scrpnlPaymentTable.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tblPayment.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        tblPayment.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblPayment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Payment ID", "Payment Date", "Total Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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

        javax.swing.GroupLayout pnlUpdateProfileContainerLayout = new javax.swing.GroupLayout(pnlUpdateProfileContainer);
        pnlUpdateProfileContainer.setLayout(pnlUpdateProfileContainerLayout);
        pnlUpdateProfileContainerLayout.setHorizontalGroup(
            pnlUpdateProfileContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUpdateProfileContainerLayout.createSequentialGroup()
                .addGroup(pnlUpdateProfileContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlUpdateProfileContainerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlUpdateProfileContainerLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(scrpnlPaymentTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        pnlUpdateProfileContainerLayout.setVerticalGroup(
            pnlUpdateProfileContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUpdateProfileContainerLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(scrpnlPaymentTable, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
        );

        javax.swing.GroupLayout pnlRightBgLayout = new javax.swing.GroupLayout(pnlRightBg);
        pnlRightBg.setLayout(pnlRightBgLayout);
        pnlRightBgLayout.setHorizontalGroup(
            pnlRightBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRightBgLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(pnlRightBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblClose, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRightBgLayout.createSequentialGroup()
                        .addComponent(pnlUpdateProfileContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))))
        );
        pnlRightBgLayout.setVerticalGroup(
            pnlRightBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRightBgLayout.createSequentialGroup()
                .addComponent(lblClose)
                .addGap(30, 30, 30)
                .addComponent(pnlUpdateProfileContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

        frame.navigateContentPanel(new TutorPaymentDetailsPnl(tutor, Main.paymentBlockchain.findData(id).getData()));
        frame.navigateMenuPanel(new TutorPaymentRightMenuSecondVer(frame, tutor));
        
    }//GEN-LAST:event_tblPaymentMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // Get the input and call filter()
        String query = txtSearch.getText().toLowerCase();
        filter(query);
    }//GEN-LAST:event_txtSearchKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblClose;
    private javax.swing.JPanel pnlRightBg;
    private javax.swing.JPanel pnlUpdateProfileContainer;
    private javax.swing.JScrollPane scrpnlPaymentTable;
    private javax.swing.JTable tblPayment;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
