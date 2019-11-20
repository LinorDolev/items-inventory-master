package inventory.logic;

import exceptions.ItemNotFoundException;
import inventory.dal.InventoryDao;
import inventory.entities.Item;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JPAItemService implements ItemService {

    private final InventoryDao inventoryDao;

    JPAItemService(InventoryDao inventoryDao){
        this.inventoryDao = inventoryDao;
    }

    @Override
    public List<Item> getListOfItems() {
        return inventoryDao.findAll();
    }

    @Override
    public Item readItem(Long itemNumber) {
        return getItem(itemNumber);
    }

    @Override
    public Item withdrawQuantity(int amount, Long itemNumber) {
        return inventoryDao.findById(itemNumber).map(item->{
            int newAmount = item.getAmount() - amount;
            int oldAmount = item.getAmount();
            if(oldAmount == 0){
                throw new NullPointerException("This item are missing");
            }
            if(amount < 0){
                throw new IllegalArgumentException("Amount " + amount +" can not be negative");
            }
            if(newAmount < 0){
                throw new NullPointerException("This amount are too big, we have " + oldAmount + " items");
            }

            item.setAmount(newAmount);
            return inventoryDao.save(item);
        }).orElseGet(() -> {
            throw new ItemNotFoundException(itemNumber);
        });
    }

    @Override
    public Item depositQuantity(int amount, Long itemNumber) {
        return inventoryDao.findById(itemNumber).map(item -> {
            if(amount < 0){
                throw new IllegalArgumentException("Amount " + amount + " can not be negative");
            }
            item.setAmount(item.getAmount() + amount);
            return  inventoryDao.save(item);
        }).orElseGet(() -> {
            throw new ItemNotFoundException(itemNumber);
        });
    }

    @Override
    public Item addItem(Item newItem) {
        return inventoryDao.save(newItem);
    }

    @Override
    public void deleteItem(Long itemNumber) {
        getItem(itemNumber); // throws exception if item number is not exist
        inventoryDao.deleteById(itemNumber);
    }

    private Item getItem(Long itemNumber) throws ItemNotFoundException{
        Optional<Item> opItem = inventoryDao.findById(itemNumber);
        if(!opItem.isPresent()){
            throw new ItemNotFoundException(itemNumber);
        }
        return opItem.get();
    }
}
