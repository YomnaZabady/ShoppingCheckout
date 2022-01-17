package shopping.checkout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shopping.checkout.model.Order;
import shopping.checkout.model.OrderDTO;
import shopping.checkout.repository.OrderRepository;
import shopping.checkout.service.OrderService;


import java.util.List;


@RestController
public class ShoppingCheckoutController {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository repo;


    @PostMapping(value = "/orderValidation")
    public void createAndValidateOrder(@RequestBody OrderDTO orderDTO) throws Exception{
        Order order = orderService.addNewOrder(orderDTO);
        orderService.validateOrderItemsAvailability(order);
        orderService.validateOrderPriceAbove100(order);
        orderService.isUserNotFraud(order);
    }

    @PostMapping(value = "/validateAvailability")
    public boolean validateItemsAvailability(@RequestBody OrderDTO orderDTO) throws Exception{
        Order order = orderService.addNewOrder(orderDTO);
        return orderService.validateOrderItemsAvailability(order);
    }

    @PostMapping(value = "/validatePrice")
    public boolean validatePriceAbove100(@RequestBody OrderDTO orderDTO) throws Exception{
        Order order = orderService.addNewOrder(orderDTO);
        return orderService.validateOrderPriceAbove100(order);
    }

    @PostMapping(value = "/checkUser")
    public boolean checkUserFraud(@RequestBody OrderDTO orderDTO) throws Exception{
        Order order = orderService.addNewOrder(orderDTO);
        return orderService.isUserNotFraud(order);
    }

    @GetMapping("/getOrders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

//    @GetMapping("users/{id}")
//    public ResponseEntity<Item> getById(@PathVariable long id) {
//        Optional<Item> user = userService.getById(id);
//        if (user.isPresent()) {
//            return new ResponseEntity<>(user.get(), HttpStatus.OK);
//        } else {
//            throw new RecordNotFoundException();
//        }
//    }
}
