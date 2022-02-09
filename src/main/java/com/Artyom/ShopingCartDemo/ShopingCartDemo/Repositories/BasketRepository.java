package com.Artyom.ShopingCartDemo.ShopingCartDemo.Repositories;

import com.Artyom.ShopingCartDemo.ShopingCartDemo.Models.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket,Long> {
}
