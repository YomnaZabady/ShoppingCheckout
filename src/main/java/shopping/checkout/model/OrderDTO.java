package shopping.checkout.model;

import java.util.List;

public class OrderDTO {

    private List<String> items;

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        String itemsList = "";
        for (String item:items) {
            itemsList += ", " + item;
        }
        return itemsList;
    }
}
