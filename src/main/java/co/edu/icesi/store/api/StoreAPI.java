package co.edu.icesi.store.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/test")
public interface StoreAPI {

    @GetMapping
    String getTest();
}
