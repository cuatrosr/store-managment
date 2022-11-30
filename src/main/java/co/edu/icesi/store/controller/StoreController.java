package co.edu.icesi.store.controller;

import co.edu.icesi.store.api.StoreAPI;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreController implements StoreAPI {
    @Override
    public String getTest() {
        return "test";
    }
}
