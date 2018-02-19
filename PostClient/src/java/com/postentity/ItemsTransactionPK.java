/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.postentity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author daniellenunez
 */
@Embeddable
public class ItemsTransactionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "TRANSACTION_ID")
    private int transactionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "UPC")
    private String upc;

    public ItemsTransactionPK() {
    }

    public ItemsTransactionPK(int transactionId, String upc) {
        this.transactionId = transactionId;
        this.upc = upc;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) transactionId;
        hash += (upc != null ? upc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemsTransactionPK)) {
            return false;
        }
        ItemsTransactionPK other = (ItemsTransactionPK) object;
        if (this.transactionId != other.transactionId) {
            return false;
        }
        if ((this.upc == null && other.upc != null) || (this.upc != null && !this.upc.equals(other.upc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.postentity.ItemsTransactionPK[ transactionId=" + transactionId + ", upc=" + upc + " ]";
    }
    
}
