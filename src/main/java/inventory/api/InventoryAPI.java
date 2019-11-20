package inventory.api;

import inventory.entities.Item;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface InventoryAPI {

    @GetMapping("/items")
    List<Item> getListOfItems();

    @GetMapping("/items/{itemNumber}")
    Item readItem(@PathVariable Long itemNumber);

    @PutMapping("/items/withdraw/{itemNumber}/{amount}")
    Item withdrawQuantity(@PathVariable int amount, @PathVariable Long itemNumber);

    @PutMapping("/items/deposit/{itemNumber}{amount}")
    Item depositQuantity(@PathVariable int amount, @PathVariable Long itemNumber);

    @PostMapping("/items/add")
    Item addItem(@RequestBody Item newItem);

    @DeleteMapping("/items/{itemNumber}")
    void deleteItem(@PathVariable Long itemNumber);
}
