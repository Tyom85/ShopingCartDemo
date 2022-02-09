package com.Artyom.ShopingCartDemo.ShopingCartDemo.Repositories;

import com.Artyom.ShopingCartDemo.ShopingCartDemo.Models.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRep extends JpaRepository<Customer,Long> {
}
