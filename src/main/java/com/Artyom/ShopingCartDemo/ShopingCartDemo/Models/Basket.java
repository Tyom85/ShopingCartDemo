package com.Artyom.ShopingCartDemo.ShopingCartDemo.Models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "fk_basket")
    private long basket_id;

    @OneToMany(mappedBy = "baskets", cascade =CascadeType.ALL)
    private Set<Item> basketWithItems;


    public Basket() {

        basketWithItems = new HashSet<>();
    }

    public Basket(Set<Item> basketWithItems) {
        this.basketWithItems = basketWithItems;
    }

    public long getBasket_id() {
        return basket_id;
    }

    public void setBasket_id(long basket_id) {
        this.basket_id = basket_id;
    }

    public Set<Item> getBasketWithItems() {
        return basketWithItems;
    }

    public void setBasketWithItems(Set<Item> basketWithItems) {
        this.basketWithItems = basketWithItems;
    }


}
