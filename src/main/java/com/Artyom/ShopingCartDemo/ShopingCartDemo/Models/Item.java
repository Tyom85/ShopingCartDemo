package com.Artyom.ShopingCartDemo.ShopingCartDemo.Models;


import javax.persistence.*;
@Entity
@Table
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long item_id;
    @Column
    private String name;
    @Column
    private Double price;
    @Column
    private int stock;
    @Column
    private int quantity;

    @ManyToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "basket_id",nullable=true, referencedColumnName = "fk_basket",foreignKey = @ForeignKey(name = "basket_item"))
    private Basket baskets;

    public Item() {

    }
    public Item(String name, Double price, int stock, int quantity) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.quantity = quantity;
    }

    public Item(long item_id, String name, Double price, int stock, int quantity) {
        this.item_id = item_id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.quantity = quantity;
    }

    public Item(Basket basket) {
        this.baskets = basket;
    }

    public Basket getBasket() {
        return baskets;
    }

    public void setBasket(Basket basket) {
        this.baskets = basket;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public long getItem_id() {
        return item_id;
    }

    public void setItem_id(long item_id) {
        this.item_id = item_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "item_id=" + item_id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", quantity=" + quantity +
                '}';
    }
}
