package co.edu.icesi.store.service.impl;

import co.edu.icesi.store.dto.ItemDTO;
import co.edu.icesi.store.model.Item;
import co.edu.icesi.store.repository.ItemRepository;
import co.edu.icesi.store.service.StoreService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StoreServiceImpl implements StoreService {

    private ItemRepository itemRepository;


    @Override
    public Item item(Item item) {
        return itemRepository.save(item);
    }
}
