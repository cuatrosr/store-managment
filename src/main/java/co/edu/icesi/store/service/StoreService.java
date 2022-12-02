package co.edu.icesi.store.service;

import co.edu.icesi.store.dto.ItemDTO;
import co.edu.icesi.store.model.Item;
import org.springframework.web.bind.annotation.RequestBody;

public interface StoreService {

    Item item(@RequestBody Item item);
}
