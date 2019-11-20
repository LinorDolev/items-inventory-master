package inventory.dal;

import inventory.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryDao extends JpaRepository<Item, Long> {
}
