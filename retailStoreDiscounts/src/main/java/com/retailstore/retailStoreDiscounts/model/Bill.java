package com.retailstore.retailStoreDiscounts.model;

import javax.persistence.*;

@Table(	name = "bill",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "bill_id"),
        })
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long billId;

    @Column(name="totalAmount")
    public double totalAmount;

    @Column(name="discountPercentage")
    public double discountPercentage;

    @Column(name="billCost")
    public double billCost;

    public Bill() {
    }

    public Bill(long billId, double totalAmount, double discountPercentage, double billCost ) {
        this. billId = billId;
        this.totalAmount = totalAmount;
        this.discountPercentage = discountPercentage;
        this.billCost = billCost;
    }

    public long getBillId() {
        return billId;
    }

    public void setBillId(long billId) {
        this.billId= billId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double getBillCost() {
        return billCost;
    }

    public void setBillCost(double billCost) {
        this.billCost = billCost;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billId=" + billId +
                ", totalAmount=" + totalAmount +
                ", discountPercentage=" + discountPercentage +
                ", billCost=" + billCost +
                '}';
    }
}
