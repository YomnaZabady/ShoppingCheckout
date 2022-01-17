package shopping.checkout.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Item {

    private @Id @GeneratedValue long id;

    private String code;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private long price;
    private boolean available;

    public Item(String code, long price, boolean available) {
        this.code = code;
        this.price = price;
        this.available = available;
    }

    public Item(){}

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Item code: " + code + ", price: " + price + ", available: " + available;
    }
}
