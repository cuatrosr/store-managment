package co.edu.icesi.store.service;

import co.edu.icesi.store.model.Item;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface StoreService {

    Item item(@RequestBody Item item);

    List<Item> getItems();

}
