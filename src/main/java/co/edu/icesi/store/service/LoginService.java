package co.edu.icesi.store.service;

import co.edu.icesi.store.dto.LoginDTO;
import co.edu.icesi.store.dto.TokenDTO;

public interface LoginService {

    TokenDTO login(LoginDTO loginDTO);
}