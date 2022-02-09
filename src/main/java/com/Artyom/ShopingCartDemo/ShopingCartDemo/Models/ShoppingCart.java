//package com.Artyom.ShopingCartDemo.ShopingCartDemo.Models;
//
//
//import javax.persistence.*;
//import java.util.*;
//
//public class ShoppingCart {
//
//    private long shop_id;
//
//    private String shop_name;
//
//    private List<Item> items;
//
//    private List<User> users;
//
//    private HashMap<Date,User> invoice;
//
//    public ShoppingCart(String shop_name) {
//        this.shop_name = shop_name;
//        this.items = new ArrayList<>();
//        this.users = new ArrayList<>();
//        this.invoice = new HashMap<>();
//    }
//
//    public  boolean add_item(Item item){
//        int pos =check_item(item.getName());
//
//        if(pos<0){
//            this.items.add(item);
//            return true;
//        }else{
//
//            System.out.println("Item=> "+item.getName()+" already exist");
//        }
//        return false;
//    }
//
//    public int check_item(String item){
//        int i=0;
//
//        for(Item item1:this.items){
//
//            if(item1.getName().toLowerCase().equals(item.toLowerCase())){
//
//                return i;
//            }
//            i++;
//        }
//        return -1;
//    }
//
//    public  boolean add_user(User user){
//
//        int pos = check_user(user.getUser_name());
//
//        if(pos < 0){
//            this.users.add(user);
//          return true;
//        }
//        else {
//            System.out.println("User " +user.getUser_name()+ "already exist");
//        }
//        return false;
//    }
//
//
//    public int check_user(String user){
//
//        int i = 0;
//
//        for(User user1:this.users){
//
//            if (user1.getUser_name().toLowerCase().equals(user.toLowerCase())){
//
//                return i;
//            }
//            i++;
//        }
//        return -1;
//    }
//
//
//
//    public String getShop_name() {
//        return shop_name;
//    }
//
//    public List<Item> getItems() {
//        return items;
//    }
//
//    public List<User> getUsers() {
//        return users;
//    }
//
//    public HashMap<Date, User> getInvoice() {
//        return invoice;
//    }
//
//
//}
