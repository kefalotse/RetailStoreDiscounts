package com.retailstore.retailStoreDiscounts.model;

import javax.persistence.*;

@Entity
@Table(	name = "item",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "item_id"),

        })
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long itemId;

    @Column(name="itemType")
    public String itemType;

    @Column(name="price")
    public double price;

    public Item() {
    }

    public Item(long itemId, String itemType, double price) {
        this.itemId = itemId;
        this.itemType = itemType;
        this.price = price;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemID) {
        this.itemId = itemId;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemType='" + itemType + '\'' +
                ", price=" + price +
                '}';
    }
}
