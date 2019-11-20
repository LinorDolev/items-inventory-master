package inventory.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
public class Item {
    private @Id @GeneratedValue Long itemNumber;
    private String name;
    private int amount;
    private String inventoryCode;

    public Item(){}

    public Item(String name, int amount, String inventoryCode) {
        setName(name);
        setAmount(amount);
        setInventoryCode(inventoryCode);
    }

    public void setItemNumber(Long itemNumber) {
        this.itemNumber = itemNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setInventoryCode(String inventoryCode) {
        this.inventoryCode = inventoryCode;
    }

    public Long getItemNumber() {
        return itemNumber;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public String getInventoryCode() {
        return inventoryCode;
    }
}
