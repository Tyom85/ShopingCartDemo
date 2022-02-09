package com.Artyom.ShopingCartDemo.ShopingCartDemo.Services;

import com.Artyom.ShopingCartDemo.ShopingCartDemo.Models.Customer;


import com.Artyom.ShopingCartDemo.ShopingCartDemo.Repositories.CustomerRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRep customerRep;

    public void addUser(Customer user){
        customerRep.save(user);
    }
    public List<Customer> showUser(){
        return customerRep.findAll();
    }

    public Customer searchUser(long id){return customerRep.getById(id);}

    public void removeUser(Long id){
        customerRep.deleteById(id);
    }
}
