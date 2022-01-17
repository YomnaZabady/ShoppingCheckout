package shopping.checkout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import shopping.checkout.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("Select it from Item it where it.code = ?1 and it.available = true" )
    Item getAvailableItem(String code);

    @Query("Select it.price from Item it where it.code = ?1" )
    Long getItemPrice(String code);
}
