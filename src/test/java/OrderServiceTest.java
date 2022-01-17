import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import shopping.checkout.ShoppingCheckout;
import shopping.checkout.exceptions.fraud.FraudWithMoreThan1500MoneyValue;
import shopping.checkout.exceptions.validations.ItemNotAvailableException;
import shopping.checkout.exceptions.validations.OrderPriceLessThan100Exception;
import shopping.checkout.model.Item;
import shopping.checkout.model.Order;
import shopping.checkout.service.ItemService;
import shopping.checkout.service.OrderService;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShoppingCheckout.class)
public class OrderServiceTest {

    @Autowired
    OrderService orderService;

    @MockBean
    ItemService itemService;

    @Before
    public void setUp() {
        Item item = new Item("tshirt", 80, true);

        Mockito.when(itemService.isItemAvailable("tshirt"))
                .thenReturn(true);

        Mockito.when(itemService.getItemPrice("tshirt"))
                .thenReturn(150l);

        Mockito.when(itemService.getItemPrice("socks"))
                .thenReturn(20l);

        Mockito.when(itemService.getItemPrice("travel_bag"))
                .thenReturn(160l);

        Mockito.when(itemService.getItemPrice("gold"))
                .thenReturn(1400l);

    }

    @Test
    public void orderItemsAvailableTest() throws Exception {
        String itemCode = "tshirt";
        Order order = new Order(new ArrayList<String>(Arrays.asList("tshirt")));
        boolean isValid = orderService.validateOrderItemsAvailability(order);
        assertEquals(isValid,true);
    }

    @Test(expected = ItemNotAvailableException.class)
    public void orderItemsNotAvailableThrowsExceptionTest() throws Exception {
        Order order = new Order(new ArrayList<String>(Arrays.asList("socks")));
        orderService.validateOrderItemsAvailability(order);
    }

    @Test
    public void orderItemsMoreThan100Test() throws Exception {
        Order order = new Order(new ArrayList<String>(Arrays.asList("tshirt", "socks")));
        boolean isValid = orderService.validateOrderPriceAbove100(order);
        assertEquals(isValid,true);
    }

    @Test(expected = OrderPriceLessThan100Exception.class)
    public void orderItemsLessThan100ThrowsExceptionTest() throws Exception {
        Order order = new Order(new ArrayList<String>(Arrays.asList("socks")));
        orderService.validateOrderPriceAbove100(order);
    }


    @Test
    public void orderUserNotFraud() throws Exception {
        Order order = new Order(new ArrayList<String>(Arrays.asList("tshirt", "travel_bag")));
        boolean isValid = orderService.isUserNotFraud(order);
        assertEquals(isValid,true);
    }

    @Test(expected = FraudWithMoreThan1500MoneyValue.class)
    public void orderUserFraudThrowsExceptionTest() throws Exception {
        Order order = new Order(new ArrayList<String>(Arrays.asList("socks", "tshirt", "travel_bag", "gold")));
        orderService.isUserNotFraud(order);
    }
}
