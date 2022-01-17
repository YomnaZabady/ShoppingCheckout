package shopping.checkout.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import shopping.checkout.exceptions.validations.ItemNotAvailableException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="orders_table")
public class Order {

    @JsonIgnore
    private @Id @GeneratedValue(strategy = GenerationType.SEQUENCE) Long id;

    @ElementCollection
    private List<String> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // @JsonIgnore
    @Column(name="price")
    private long orderPrice;

    public Order() {
        items = new ArrayList<String>();
        orderPrice = 0;
    }

    public Order(List<String> items) {
        this.items = items;
        orderPrice = 0;
    }

//    public void addItemToOrder(Item item) throws ItemNotAvailableException {
//        items.add(item);
//        if(item.isAvailable()) {
//            orderPrice += item.getPrice();
//        } else {
//            throw new ItemNotAvailableException("Sorry Item is out of stock");
//        }
//    }

    public long getOrderPrice() {
        return orderPrice;
    }

    public List<String> getItems() {
        return items;
    }
}
