import org.junit.Before;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import shopping.checkout.ShoppingCheckout;
import shopping.checkout.model.Item;

import shopping.checkout.repository.OrderRepository;
import shopping.checkout.service.ItemService;
import shopping.checkout.service.OrderService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShoppingCheckout.class)
public class ShoppingCheckoutIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ItemService itemService;

    @Before
    public void setUp() {
        Item item = new Item("tshirt", 80, true);

        Mockito.when(itemService.isItemAvailable("tshirt"))
                .thenReturn(true);
    }

    /*
    TODO Integration test
     */
}
