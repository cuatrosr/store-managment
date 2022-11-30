package co.edu.icesi.store.controller;

import co.edu.icesi.store.api.LoginAPI;
import co.edu.icesi.store.dto.LoginDTO;
import co.edu.icesi.store.dto.TokenDTO;
import co.edu.icesi.store.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LoginController implements LoginAPI {

    private final LoginService loginService;

    @Override
    public TokenDTO login(LoginDTO loginDTO) {
        return loginService.login(loginDTO);
    }
}