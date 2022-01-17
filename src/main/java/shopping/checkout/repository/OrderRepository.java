package shopping.checkout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shopping.checkout.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
