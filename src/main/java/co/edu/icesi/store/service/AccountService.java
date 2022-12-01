package co.edu.icesi.store.service;

import co.edu.icesi.store.dto.LoginDTO;
import co.edu.icesi.store.dto.TokenDTO;
import co.edu.icesi.store.model.User;

import java.util.List;

public interface AccountService {

    TokenDTO login(LoginDTO loginDTO);

    User register(User user);

    List<User> getUsers();
}