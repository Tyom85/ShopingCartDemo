package com.Artyom.ShopingCartDemo.ShopingCartDemo.Repositories;

import com.Artyom.ShopingCartDemo.ShopingCartDemo.Models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
