package shopping.checkout.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopping.checkout.exceptions.fraud.FraudWithMoreThan1500MoneyValue;
import shopping.checkout.exceptions.validations.ItemNotAvailableException;
import shopping.checkout.exceptions.validations.OrderPriceLessThan100Exception;
import shopping.checkout.model.Order;
import shopping.checkout.model.OrderDTO;
import shopping.checkout.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepo;

    @Autowired
    ItemService itemService;

    public Order addNewOrder(OrderDTO orderDTO) {
        Order order = new Order(orderDTO.getItems());
        return orderRepo.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    public boolean validateOrderItemsAvailability(Order order) throws Exception {
        for (String itemCode: order.getItems()) {
           if (!itemService.isItemAvailable(itemCode)) {
               throw new ItemNotAvailableException ("Unfortunately, item: " + itemCode + "is not available");
           }
        }
        return true;
    }

    public boolean validateOrderPriceAbove100(Order order) throws Exception {
        Long orderPrice = getTotalOrderPrice(order);
        if (orderPrice <= 100) {
            throw new OrderPriceLessThan100Exception("Order price equals: " + orderPrice);
        } else {
            return true;
        }
    }

    public boolean isUserNotFraud(Order order) throws Exception {
        Long orderPrice = getTotalOrderPrice(order);
        if (orderPrice > 1500) {
            throw new FraudWithMoreThan1500MoneyValue("User is Fraud, Order price equals: " + orderPrice);
        } else {
            return true;
        }
    }

    private Long getTotalOrderPrice (Order order) {
        Long orderPrice = 0l;
        for (String item : order.getItems()) {
            orderPrice += itemService.getItemPrice(item);
        }
        return orderPrice;
    }

}
