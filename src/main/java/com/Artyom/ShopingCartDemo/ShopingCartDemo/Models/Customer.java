package com.Artyom.ShopingCartDemo.ShopingCartDemo.Models;


import javax.persistence.*;

@Entity
@Table
public class Customer

{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cust_id;
    private String cust_name;
    private String cotact;
    private Double bill=0.0;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_basket", referencedColumnName = "fk_basket")
    private Basket basket;

    public Customer() {
    }

    public Customer(String cust_name, String cotact, Double bill) {
        this.cust_name = cust_name;
        this.cotact = cotact;
        this.bill = bill;
    }

    public long getCust_id() {
        return cust_id;
    }

    public void setCust_id(long cust_id) {
        this.cust_id = cust_id;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public String getCotact() {
        return cotact;
    }

    public void setCotact(String cotact) {
        this.cotact = cotact;
    }

    public Double getBill() {
        return bill;
    }

    public void setBill(Double bill) {
        this.bill = bill;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }
}
