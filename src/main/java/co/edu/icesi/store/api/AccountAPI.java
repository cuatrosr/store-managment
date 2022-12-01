package co.edu.icesi.store.api;

import co.edu.icesi.store.dto.LoginDTO;
import co.edu.icesi.store.dto.TokenDTO;
import co.edu.icesi.store.dto.UserDTO;
import co.edu.icesi.store.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/account")
public interface AccountAPI {

    @PostMapping("/login")
    TokenDTO login(@RequestBody LoginDTO loginDTO);

    @PostMapping("/register")
    UserDTO register(@RequestBody User user);

    @GetMapping
    List<UserDTO> getUsers();
}