package shopping.checkout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import shopping.checkout.model.Item;
import shopping.checkout.service.ItemService;

import java.util.List;

@RestController
public class ShoppingItemsController {

    @Autowired
    ItemService itemService;

    @GetMapping("/getItems")
    public List<Item> getShoppingItems() {
        return itemService.getShopItems();
    }
}
