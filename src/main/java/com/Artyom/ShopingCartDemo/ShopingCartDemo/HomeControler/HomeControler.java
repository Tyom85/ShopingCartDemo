package com.Artyom.ShopingCartDemo.ShopingCartDemo.HomeControler;

import com.Artyom.ShopingCartDemo.ShopingCartDemo.Models.Basket;
import com.Artyom.ShopingCartDemo.ShopingCartDemo.Models.Customer;
import com.Artyom.ShopingCartDemo.ShopingCartDemo.Models.Item;
import com.Artyom.ShopingCartDemo.ShopingCartDemo.Services.BasketService;
import com.Artyom.ShopingCartDemo.ShopingCartDemo.Services.CustomerService;
import com.Artyom.ShopingCartDemo.ShopingCartDemo.Services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RequestMapping("/shopping")
public class HomeControler {

    private final BasketService basketRepository;
    private final CustomerService customerService;
    private final ItemService itemService;

    @Autowired
    public HomeControler(BasketService basketRepository,
                         CustomerService customerService,
                         ItemService itemService) {
        this.basketRepository = basketRepository;
        this.customerService = customerService;
        this.itemService = itemService;
    }

    //
//    ShoppingCart shoppingCart = new ShoppingCart("Yerevan City");
//
//    @PostConstruct
//    public void add_items() {
//
//        shoppingCart.add_item(new Item("Juice", 250.5, 120,5));
//        shoppingCart.add_item(new Item("Shampoo", 450.2, 520,6));
//        shoppingCart.add_item(new Item("Biscuits", 120.4, 420,10));
//        shoppingCart.add_user(new User("Artyom", "93629324", new Basket()));
//        shoppingCart.add_user(new User("Artash", "659878", new Basket()));
//        shoppingCart.add_user(new User("Karen", "789565", new Basket()));
//
//    }
//
//
    @GetMapping("/init")
    public String homepage(Model model) {
        model.addAttribute("users", customerService.showUser());

        return "/home";
    }


    @GetMapping("/shop")
    public String user_item(@RequestParam("cust_id") Long id, Model model) {

        if (id !=null) {
            model.addAttribute("customer", customerService.searchUser(id).getCust_name());
            model.addAttribute("item", itemService.showItem());
            model.addAttribute("cust_id", id);



            return "cust_item";
        }
        return "redirect:init";
    }

    @GetMapping("/addusers")
    public String add_user(Model model) {
        model.addAttribute("user", new Customer());

        return "user_form";
    }

    @PostMapping("/saveuser")
    public String save_user(@ModelAttribute("user") Customer customer) {

        if (customer.getCust_name() != null && customer.getCotact() != null) {

            customer.setBasket(new Basket());
            customerService.addUser(customer);


            return "redirect:init";
        }

        return "redirect:init";

    }


    @PostMapping("/updateitem")
    public String item_up(@RequestParam("item_id")Long id, @ModelAttribute("Items") Item item) {

        if (id!=null){
//            Item updated_item = new Item();
//            updated_item.setItem_id(item.getItem_id());
//            updated_item.setItem_id(item.getItem_id());
//            updated_item.setItem_id(item.getItem_id());
//            updated_item.setItem_id(item.getItem_id());
//            updated_item.setItem_id(item.getItem_id());
            itemService.addItem(item);
            return "redirect:items";
        }
        return "redirect:items";
    }

    @GetMapping("/additems")
    public String add_item(Model model) {

        model.addAttribute("item", new Item());

        return "item_form";
    }

    @GetMapping("/items")
    public String listItems(Model model) {
        model.addAttribute("Items", itemService.showItem());

        return "itemslist";
    }

    @PostMapping("/saveitem")
    public String save_item(@ModelAttribute("Item") Item item) {

        if ((item.getName() != null && item.getPrice() != null) && item.getStock() != 0) {

            itemService.addItem(item);

            return "redirect:items";

        }

        return "redirect:items";
    }

    @GetMapping("/itemupd")
    public String item_update(@RequestParam("item_id")Long id, Model model){

          if(id!= null){

              Item item = itemService.searchItem(id);
              model.addAttribute(item);

                  return "items_form_update";
              }

          return "redirect:items";
    }

        @GetMapping("itemdel")
    public String item_del(@RequestParam("item_id") Long id ){



          if(id!=null){
             itemService.removeItem(id);
          }
          return "redirect:items";
    }


    @GetMapping("/upduser")
    public String update_user(@RequestParam("cust_id") Long id, Model model) {

        if (id != null) {

            Customer customer = customerService.searchUser(id);
            model.addAttribute(customer);
            return "user_update";

        }
        return "redirect:init";
    }

    //
    @PostMapping("/updateuser")
    public String form_update(@RequestParam("cust_id") Long id, @ModelAttribute("user") Customer customer) {

        if (id != null) {

            customerService.addUser(customer);
            return "redirect:init";
        }

        return "redirect:init";

    }

    @GetMapping("/deluser")
    public String del_user(@RequestParam("cust_id")Long id){

        if (id != null){

        customerService.removeUser(id);
                return "redirect:init";
            }

        return "redirect:init";
}

        @GetMapping("/additemto_basket")
    public String itemTobasket(@RequestParam("item_id")Long id,@RequestParam("cid")Long id1,
                              Model model)
                              {

                                  Item item = itemService.searchItem(id);
               model.addAttribute(item);
               model.addAttribute("cust",customerService.searchUser(id1).getCust_name());
               model.addAttribute("cust_contact",customerService.searchUser(id1).getCotact());
               model.addAttribute("cust_id",id1);




        return "basketform";
        }

    @PostMapping("/saveinbasket")
    public String saveInbasket(@RequestParam("cust_id") Long id,@RequestParam("item_id")Long id1, @ModelAttribute Item item, Model model) {

//
//         System.out.println(item.getQuantity());
//        System.out.println(itemService.searchItem(id1).getQuantity());
        int new_quantity = itemService.searchItem(id1).getQuantity()+item.getQuantity();

        if ((item.getName() != null && item.getPrice() != null) && item.getStock() != 0) {
            Long basId = customerService.searchUser(id).getBasket().getBasket_id();


            Basket basket = basketRepository.searchBasket(basId);
            item.setQuantity(new_quantity);
            basket.getBasketWithItems().add(item);
            item.setBasket(basket);

            itemService.updateItem(item);

                Set<Item> basketList = basketRepository.searchBasket(basId).getBasketWithItems();



                model.addAttribute("basket",basketList);
                model.addAttribute("customer",customerService.searchUser(id).getCust_name());
                model.addAttribute("cust_id_from_basket", id);
            model.addAttribute("contact", customerService.searchUser(id).getCotact());

                return "cust_list";

            }

            return "redirect:shopping/shop?cust_id="+id;

              }


    @GetMapping("/backToshop")
    public String user_items(@RequestParam("cust_id") Long id, Model model) {

        if (id !=null) {
            model.addAttribute("customer", customerService.searchUser(id).getCust_name());
            model.addAttribute("item", itemService.showItem());
            model.addAttribute("cust_id", id);



            return "cust_item";
        }
        return "redirect:init";
    }


    @GetMapping("/printbill")
    private String printbill(@RequestParam("cust_id") Long id, Model model){
        System.out.println(id);

        if(id!=null){

            double price = 0.0;

                Long basketId = customerService.searchUser(id).getBasket().getBasket_id();
            Customer customer = customerService.searchUser(id);
            model.addAttribute("customer", customer);
            model.addAttribute("basket",basketRepository.searchBasket(basketId).getBasketWithItems());

            for(Item items:basketRepository.searchBasket(basketId).getBasketWithItems()){

                price += items.getPrice()*items.getQuantity();

            }

            model.addAttribute("total",price);



             return "print_bills";
        }

      //  return "redirect:shopping/shop?cust_id="+id;

        return "redirect:init";
    }


   }


