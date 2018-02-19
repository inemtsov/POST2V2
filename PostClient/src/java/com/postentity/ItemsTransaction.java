/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.postentity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author daniellenunez
 */
@Entity
@Table(name = "ITEMS_TRANSACTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemsTransaction.findAll", query = "SELECT i FROM ItemsTransaction i")
    , @NamedQuery(name = "ItemsTransaction.findByTransactionId", query = "SELECT i FROM ItemsTransaction i WHERE i.itemsTransactionPK.transactionId = :transactionId")
    , @NamedQuery(name = "ItemsTransaction.findByUpc", query = "SELECT i FROM ItemsTransaction i WHERE i.itemsTransactionPK.upc = :upc")
    , @NamedQuery(name = "ItemsTransaction.findByQuantity", query = "SELECT i FROM ItemsTransaction i WHERE i.quantity = :quantity")})
public class ItemsTransaction implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItemsTransactionPK itemsTransactionPK;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @JoinColumn(name = "UPC", referencedColumnName = "UPC", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Products products;
    @JoinColumn(name = "TRANSACTION_ID", referencedColumnName = "TRANSACTION_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Transactions transactions;

    public ItemsTransaction() {
    }

    public ItemsTransaction(ItemsTransactionPK itemsTransactionPK) {
        this.itemsTransactionPK = itemsTransactionPK;
    }

    public ItemsTransaction(int transactionId, String upc) {
        this.itemsTransactionPK = new ItemsTransactionPK(transactionId, upc);
    }

    public ItemsTransactionPK getItemsTransactionPK() {
        return itemsTransactionPK;
    }

    public void setItemsTransactionPK(ItemsTransactionPK itemsTransactionPK) {
        this.itemsTransactionPK = itemsTransactionPK;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public Transactions getTransactions() {
        return transactions;
    }

    public void setTransactions(Transactions transactions) {
        this.transactions = transactions;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemsTransactionPK != null ? itemsTransactionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemsTransaction)) {
            return false;
        }
        ItemsTransaction other = (ItemsTransaction) object;
        if ((this.itemsTransactionPK == null && other.itemsTransactionPK != null) || (this.itemsTransactionPK != null && !this.itemsTransactionPK.equals(other.itemsTransactionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.postentity.ItemsTransaction[ itemsTransactionPK=" + itemsTransactionPK + " ]";
    }
    
}
