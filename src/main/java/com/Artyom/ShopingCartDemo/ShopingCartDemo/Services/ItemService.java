package com.Artyom.ShopingCartDemo.ShopingCartDemo.Services;

import com.Artyom.ShopingCartDemo.ShopingCartDemo.Models.Item;

import com.Artyom.ShopingCartDemo.ShopingCartDemo.Repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public void addItem(Item item) {
        itemRepository.save(item);
    }

    public List<Item> showItem() {
        return itemRepository.findAll();
    }

    public Item searchItem(long id) {
        return itemRepository.getById(id);
    }

    public void removeItem(Long id) {
        itemRepository.deleteById(id);
    }

    public void  updateItem(Item item){
        itemRepository.save(item);
    }
}


