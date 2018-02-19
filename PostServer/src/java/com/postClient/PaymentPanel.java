package com.postClient;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ilyanemtsov
 */
public class PaymentPanel extends javax.swing.JPanel {

    /**
     * Creates new form PaymentPanel
     */
    public PaymentPanel() {
        initComponents();
    }
    
    public String getPaymentTextfield(){
        return areaPayment.getText();
    }

    public String getSelectedPaymentType(){
        return paymentTypeDropDownMenu.getItemAt(paymentTypeDropDownMenu.getSelectedIndex());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        payButton = new javax.swing.JButton();
        paymentTypeLabel = new javax.swing.JLabel();
        paymentTypeDropDownMenu = new javax.swing.JComboBox<>();
        textPayment = new javax.swing.JLabel();
        areaPayment = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Payment"));

        payButton.setText("Pay");
        payButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                payButtonMouseClicked(evt);
            }
        });
        payButton.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                payButtonComponentShown(evt);
            }
        });
        payButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payButtonActionPerformed(evt);
            }
        });
        payButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                payButtonKeyPressed(evt);
            }
        });

        paymentTypeLabel.setText("Payment Type:");

        paymentTypeDropDownMenu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Check", "Credit Card" }));
        paymentTypeDropDownMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentTypeDropDownMenuActionPerformed(evt);
            }
        });

        textPayment.setText("Tendered amount: $");

        areaPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areaPaymentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(paymentTypeLabel)
                                .addGap(63, 63, 63)
                                .addComponent(paymentTypeDropDownMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63))
                            .addComponent(payButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(areaPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(paymentTypeLabel)
                    .addComponent(paymentTypeDropDownMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(areaPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(payButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void payButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_payButtonActionPerformed

    private void paymentTypeDropDownMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentTypeDropDownMenuActionPerformed
    
        switch(paymentTypeDropDownMenu.getSelectedIndex()){
            case 1:
            textPayment.setText("Check routing #:");
            break;
            case 2:
            textPayment.setText("Credit card #:");
            break;
            case 0:
            textPayment.setText("Tendered amount: $");
            break;
        }

    }//GEN-LAST:event_paymentTypeDropDownMenuActionPerformed

    private void areaPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areaPaymentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_areaPaymentActionPerformed

    private void payButtonComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_payButtonComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_payButtonComponentShown

    private void payButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_payButtonKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_payButtonKeyPressed

    private void payButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_payButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_payButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField areaPayment;
    private javax.swing.JButton payButton;
    private javax.swing.JComboBox<String> paymentTypeDropDownMenu;
    private javax.swing.JLabel paymentTypeLabel;
    private javax.swing.JLabel textPayment;
    // End of variables declaration//GEN-END:variables
}
