package co.edu.icesi.store.controller;

import co.edu.icesi.store.api.AccountAPI;
import co.edu.icesi.store.dto.LoginDTO;
import co.edu.icesi.store.dto.TokenDTO;
import co.edu.icesi.store.dto.UserDTO;
import co.edu.icesi.store.mapper.UserMapper;
import co.edu.icesi.store.model.User;
import co.edu.icesi.store.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@AllArgsConstructor
public class AccountController implements AccountAPI {

    private final AccountService accountService;
    private final UserMapper userMapper;

    @Override
    public TokenDTO login(LoginDTO loginDTO) {
        return accountService.login(loginDTO);
    }

    @Override
    public UserDTO register(User user) {
        return userMapper.fromUser(accountService.register(user));
    }

    @Override
    public List<UserDTO> getUsers() {
        return accountService.getUsers().stream().map(userMapper::fromUser).collect(Collectors.toList());
    }
}