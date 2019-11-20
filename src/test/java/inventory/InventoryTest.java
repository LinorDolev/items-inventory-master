package inventory;

import com.fasterxml.jackson.databind.ObjectMapper;
import exceptions.ItemNotFoundException;
import inventory.logic.ItemService;
import inventory.entities.Item;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InventoryTest {
        private ObjectMapper jacksonMapper;
        private RestTemplate restTemplate;
        private String url;
        private ItemService itemService;

        @LocalServerPort
        private int port;

        @PostConstruct
        public void init() {
            restTemplate = new RestTemplate();
            url = "http://localhost:" + port + "/items";
            jacksonMapper = new ObjectMapper();
        }

        @Before
        public void setup() {
        }

        @After
        public void teardown() {

        }

        @Autowired
        public void setItemService(ItemService itemService) {
            this.itemService = itemService;
        }


        @Test
        public List<Item> testGetListOfInventoryItems() throws ItemNotFoundException {
            return null;
        }

        @Test
        public Item readItemDetails() throws ItemNotFoundException {
            return null;
        }





}