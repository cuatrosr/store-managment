package co.edu.icesi.store.service.impl;

import co.edu.icesi.store.dto.LoginDTO;
import co.edu.icesi.store.dto.TokenDTO;
import co.edu.icesi.store.model.User;
import co.edu.icesi.store.repository.UserRepository;
import co.edu.icesi.store.service.LoginService;
import co.edu.icesi.store.utils.JWTParser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {

    public final UserRepository userRepository;

    @Override
    public TokenDTO login(LoginDTO loginDTO) {

        User user = StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .filter(user1 -> user1.getEmail().equals(loginDTO.getEmail()))
                .findFirst()
                .orElseThrow();
        if (user.getPassword().equals(loginDTO.getPassword())) {
            Map<String, String> claims = new HashMap<>();
            claims.put("userId", user.getId().toString());
            return new TokenDTO(JWTParser.createJWT(user.getId().toString(), user.getName(), user.getName(), claims, 900000L));
        }
        throw new InvalidParameterException();
    }
}