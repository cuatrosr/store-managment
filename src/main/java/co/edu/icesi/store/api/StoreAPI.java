package co.edu.icesi.store.api;

import co.edu.icesi.store.dto.ItemDTO;
import co.edu.icesi.store.model.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/store")
public interface StoreAPI {

    @PostMapping("/item")
    ItemDTO item(@RequestBody Item item);

    @GetMapping("/item")
    List<ItemDTO> item();
}
