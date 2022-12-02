package co.edu.icesi.store.controller;

import co.edu.icesi.store.api.StoreAPI;
import co.edu.icesi.store.dto.ItemDTO;
import co.edu.icesi.store.mapper.ItemMapper;
import co.edu.icesi.store.model.Item;
import co.edu.icesi.store.service.StoreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class StoreController implements StoreAPI {

    private StoreService storeService;
    private ItemMapper itemMapper;

    @Override
    public ItemDTO item(Item item) {
        return itemMapper.fromItem(storeService.item(item));
    }
}
