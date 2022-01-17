package shopping.checkout.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopping.checkout.model.Item;
import shopping.checkout.repository.ItemRepository;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public List<Item> getShopItems() {
        return itemRepository.findAll();
    }

    public Long getItemPrice(String itemCode) {
        return itemRepository.getItemPrice(itemCode);
    }

    public boolean isItemAvailable(String itemCode) {
        if (itemRepository.getAvailableItem(itemCode) != null) {
            return true;
        }
        return false;
    }
}
