package com.Artyom.ShopingCartDemo.ShopingCartDemo.Services;

import com.Artyom.ShopingCartDemo.ShopingCartDemo.Models.Basket;
import com.Artyom.ShopingCartDemo.ShopingCartDemo.Models.Item;

import com.Artyom.ShopingCartDemo.ShopingCartDemo.Repositories.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService {
    @Autowired
    private BasketRepository basketRepository;

    public void addBasket(Basket basket){
        basketRepository.save(basket);
    }
    public List<Basket> showBasket(){
        return basketRepository.findAll();
    }

    public Basket searchBasket(long id){return basketRepository.getById(id);}
}
