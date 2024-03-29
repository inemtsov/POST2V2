package gui;

import store.ProductCatalog;
import java.io.IOException;

/**
*
* @author leirelitwin
*/

public class ProductPanel extends javax.swing.JPanel {

    /**
     * Creates new form ProductPanel
     */
    public ProductPanel() {
        initComponents();
        try {
            UPCSelector.setModel(new javax.swing.DefaultComboBoxModel<>(ProductCatalog.getAllUpc()));
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public String getSelectedUPC() {
        return UPCSelector.getItemAt(UPCSelector.getSelectedIndex());
    }

    public int getSelectedQuantity() {
        return quantitySelector.getSelectedIndex() + 1;
    }

    public void reset() {
        UPCSelector.setSelectedIndex(0);
        quantitySelector.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        UPClabel = new javax.swing.JLabel();
        AddProductButton = new javax.swing.JButton();
        UPCSelector = new javax.swing.JComboBox<>();
        quantityLabel = new javax.swing.JLabel();
        quantitySelector = new javax.swing.JComboBox<>();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setBorder(javax.swing.BorderFactory.createTitledBorder("Product"));

        UPClabel.setText("UPC:");

        AddProductButton.setText("ADD");
        AddProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddProductButtonActionPerformed(evt);
            }
        });

        quantityLabel.setText("Quantity:");

        quantitySelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(UPClabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UPCSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(quantityLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quantitySelector, 0, 66, Short.MAX_VALUE)
                .addGap(12, 12, 12))
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(AddProductButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UPClabel)
                    .addComponent(UPCSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantityLabel)
                    .addComponent(quantitySelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AddProductButton)
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AddProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddProductButtonActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_AddProductButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddProductButton;
    private javax.swing.JComboBox<String> UPCSelector;
    private javax.swing.JLabel UPClabel;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JComboBox<String> quantitySelector;
    // End of variables declaration//GEN-END:variables
}
