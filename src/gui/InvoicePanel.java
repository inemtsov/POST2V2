package gui;

import java.awt.ComponentOrientation;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PeterJayCruz
 */
public class InvoicePanel extends javax.swing.JPanel {

    private int currentRow = 0;

    /**
     * Creates new form InvoicePanel
     */
    public InvoicePanel() {
        initComponents();
        invoiceTable.setEnabled(false);

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        invoiceTable.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
        invoiceTable.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        invoiceTable.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);

    }

    public void reset() {
        for (int i = 0; i < currentRow; i++) {
            invoiceTable.setValueAt(null, i, 0);
            invoiceTable.setValueAt(null, i, 1);
            invoiceTable.setValueAt(null, i, 2);
            invoiceTable.setValueAt(null, i, 3);
        }
        totalTextfield.setText("$0.00");
        currentRow = 0;
    }

    public void setLineItem(String UPC, int quantity, float unitPrice) {
        invoiceTable.setValueAt(UPC, currentRow, 0);
        invoiceTable.setValueAt(quantity, currentRow, 1);
        invoiceTable.setValueAt(String.format("%.2f", unitPrice), currentRow, 2);
        invoiceTable.setValueAt(String.format("%.2f", quantity * unitPrice), currentRow, 3);
        currentRow++;
    }

    public void setTotalTextfield(String subtotal) {
        totalTextfield.setText(subtotal);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        invoiceScrollPane = new javax.swing.JScrollPane();
        invoiceTable = new javax.swing.JTable();
        totalPriceLabel = new javax.swing.JLabel();
        totalTextfield = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Invoice"));

        invoiceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Item", "Quantity", "Unit Price", "Extended Price"
            }
        ));
        invoiceScrollPane.setViewportView(invoiceTable);

        totalPriceLabel.setText("TOTAL  ");

        totalTextfield.setText(" $0.00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(invoiceScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(totalPriceLabel)
                .addGap(18, 18, 18)
                .addComponent(totalTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(invoiceScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalPriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalTextfield))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane invoiceScrollPane;
    private javax.swing.JTable invoiceTable;
    private javax.swing.JLabel totalPriceLabel;
    private javax.swing.JLabel totalTextfield;
    // End of variables declaration//GEN-END:variables
}
