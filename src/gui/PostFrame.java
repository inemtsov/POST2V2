package gui;

import javax.swing.JOptionPane;

/**
*
* @author PeterJayCruz
*/

public class PostFrame extends javax.swing.JFrame {

    /**
     * Creates new form PostFrame
     */
    public PostFrame() {
        initComponents();
    }

    public void setInvoicePanel(InvoicePanel IP) {
        this.invoicePanel2 = IP;
    }

    public void setPaymentPanel(PaymentPanel PP) {
        this.paymentPanel1 = PP;
    }

    public void setCustomerNamePanel(CustomerNamePanel CNP) {
        this.customerNamePanel1 = CNP;
    }

    public void setProductPanel(ProductPanel PP) {
        this.productPanel1 = PP;
    }

    public void popUpCustomerName() {
        JOptionPane.showMessageDialog(null, "Please enter Customer Name");
    }

    public void popUpPaymentInfo() {
        JOptionPane.showMessageDialog(null, "Payment field is not completed");
    }

    public void popUpCashChange(String change) {
        JOptionPane.showMessageDialog(null, change);
    }

    public void popUpPaymentRejected() {
        JOptionPane.showMessageDialog(null, "The payment is not correct");
    }


    public void popUpCheckRejected() {
        JOptionPane.showMessageDialog(null, "Check amount doesn't match subtotal amount");
    }

    public void popUpCreditCardRejected() {
        JOptionPane.showMessageDialog(null, "Credit Card number is not accepted");
    }

    public void popUpSaleCompleted() {
        JOptionPane.showMessageDialog(null, "The sale was completed");
    }

    public void popUpEmptyCart() {
        JOptionPane.showMessageDialog(null, "Your cart is empty");
    }

    public void popUpTransactionInfo(String transaction){
        JOptionPane.showMessageDialog(null, transaction, "transaction Info", JOptionPane.PLAIN_MESSAGE);
    }

    public void setSaleDate(String date) {
        dateLabel.setText(date);
    }

    public ProductPanel getProductPanel() {
        return this.productPanel1;
    }

    public CustomerNamePanel getCustomerNamePanel() {
        return this.customerNamePanel1;
    }

    public InvoicePanel getInvoicePanel() {
        return this.invoicePanel2;
    }

    public PaymentPanel getPaymentPanel() {
        return this.paymentPanel1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateLabel = new javax.swing.JLabel();
        productPanel1 = new ProductPanel();
        invoicePanel2 = new InvoicePanel();
        customerNamePanel1 = new CustomerNamePanel();
        paymentPanel1 = new PaymentPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Post Terminal");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(dateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 203, Short.MAX_VALUE)
                        .addComponent(paymentPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(invoicePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(customerNamePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(productPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(productPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(customerNamePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(invoicePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dateLabel)
                        .addGap(77, 77, 77))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(paymentPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CustomerNamePanel customerNamePanel1;
    private javax.swing.JLabel dateLabel;
    private InvoicePanel invoicePanel2;
    private PaymentPanel paymentPanel1;
    private ProductPanel productPanel1;
    // End of variables declaration//GEN-END:variables
}
