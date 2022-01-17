package shopping.checkout;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shopping.checkout.model.Item;
import shopping.checkout.repository.ItemRepository;


@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ItemRepository repo) {
        return args -> {
            log.info("Pre-Loading " + repo.save(new Item("tshirt", 80, true)));
            log.info("Pre-Loading " + repo.save(new Item("jacket", 100, true)));
            log.info("Pre-Loading " + repo.save(new Item("sweatshirt", 120, true)));
            log.info("Pre-Loading " + repo.save(new Item("shoes", 180, false)));
            log.info("Pre-Loading " + repo.save(new Item("socks", 20, true)));
            log.info("Pre-Loading " + repo.save(new Item("dress", 200, false)));
            log.info("Pre-Loading " + repo.save(new Item("pants", 200, true)));
            log.info("Pre-Loading " + repo.save(new Item("hoodie", 190, true)));
        };
    }
}
