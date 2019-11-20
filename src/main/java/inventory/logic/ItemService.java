package inventory.logic;

import inventory.entities.Item;
import java.util.List;

public interface ItemService {

    List<Item> getListOfItems();

    Item readItem(Long itemNumber);

    Item withdrawQuantity(int amount, Long itemNumber);

    Item depositQuantity(int amount, Long itemNumber);

    Item addItem(Item newItem);

    void deleteItem(Long itemNumber);
}
