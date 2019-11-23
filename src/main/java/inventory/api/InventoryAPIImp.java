package inventory.api;

import inventory.logic.ItemService;
import inventory.entities.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
public class InventoryAPIImp implements InventoryAPI{

    private final ItemService itemService;

    @Autowired
    InventoryAPIImp(ItemService itemService){
        this.itemService = itemService;
    }

    @Override
    public List<Item> getListOfItems() {
        return itemService.getListOfItems();
    }

    @Override
    public Item readItem(Long itemNumber) {
        return itemService.readItem(itemNumber);
    }

    @Override
    public Item withdrawQuantity(int amount, Long itemNumber) {
        return itemService.withdrawQuantity(amount, itemNumber);
    }

    @Override
    public Item depositQuantity(int amount, Long itemNumber) {
        return itemService.depositQuantity(amount, itemNumber);
    }

    @Override
    public Item addItem(Item newItem) {
        return itemService.addItem(newItem);
    }

    @Override
    public void deleteItem(Long itemNumber) {
        itemService.deleteItem(itemNumber);
    }


}
