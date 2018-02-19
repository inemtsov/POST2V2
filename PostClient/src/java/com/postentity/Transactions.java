/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.postentity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author daniellenunez
 */
@Entity
@Table(name = "TRANSACTIONS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transactions.findAll", query = "SELECT t FROM Transactions t")
    , @NamedQuery(name = "Transactions.findByTransactionId", query = "SELECT t FROM Transactions t WHERE t.transactionId = :transactionId")
    , @NamedQuery(name = "Transactions.findByCustomerName", query = "SELECT t FROM Transactions t WHERE t.customerName = :customerName")
    , @NamedQuery(name = "Transactions.findByPaymentType", query = "SELECT t FROM Transactions t WHERE t.paymentType = :paymentType")
    , @NamedQuery(name = "Transactions.findByMoneyPaid", query = "SELECT t FROM Transactions t WHERE t.moneyPaid = :moneyPaid")
    , @NamedQuery(name = "Transactions.findByCreditCard", query = "SELECT t FROM Transactions t WHERE t.creditCard = :creditCard")})
public class Transactions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRANSACTION_ID")
    private Integer transactionId;
    @Size(max = 20)
    @Column(name = "CUSTOMER_NAME")
    private String customerName;
    @Size(max = 10)
    @Column(name = "PAYMENT_TYPE")
    private String paymentType;
    @Column(name = "MONEY_PAID")
    private Integer moneyPaid;
    @Size(max = 20)
    @Column(name = "CREDIT_CARD")
    private String creditCard;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transactions")
    private Collection<ItemsTransaction> itemsTransactionCollection;

    public Transactions() {
    }

    public Transactions(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getMoneyPaid() {
        return moneyPaid;
    }

    public void setMoneyPaid(Integer moneyPaid) {
        this.moneyPaid = moneyPaid;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    @XmlTransient
    public Collection<ItemsTransaction> getItemsTransactionCollection() {
        return itemsTransactionCollection;
    }

    public void setItemsTransactionCollection(Collection<ItemsTransaction> itemsTransactionCollection) {
        this.itemsTransactionCollection = itemsTransactionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionId != null ? transactionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transactions)) {
            return false;
        }
        Transactions other = (Transactions) object;
        if ((this.transactionId == null && other.transactionId != null) || (this.transactionId != null && !this.transactionId.equals(other.transactionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.postentity.Transactions[ transactionId=" + transactionId + " ]";
    }
    
}
