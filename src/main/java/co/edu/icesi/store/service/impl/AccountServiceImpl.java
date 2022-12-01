package co.edu.icesi.store.service.impl;

import co.edu.icesi.store.constant.ErrorConstants;
import co.edu.icesi.store.dto.LoginDTO;
import co.edu.icesi.store.dto.TokenDTO;
import co.edu.icesi.store.error.exception.StoreError;
import co.edu.icesi.store.error.exception.StoreException;
import co.edu.icesi.store.model.User;
import co.edu.icesi.store.repository.UserRepository;
import co.edu.icesi.store.service.AccountService;
import co.edu.icesi.store.utils.JWTParser;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    public final UserRepository userRepository;
    public PasswordEncoder passwordEncoder;

    @Override
    public TokenDTO login(LoginDTO loginDTO) {

        User user = StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .filter(user1 -> user1.getEmail().equals(loginDTO.getEmail()))
                .findFirst()
                .orElseThrow();
        if (passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            Map<String, String> claims = new HashMap<>();
            claims.put("userId", user.getUserId().toString());
            claims.put("roleId", user.getRole().getRoleId().toString());
            return new TokenDTO(JWTParser.createJWT(user.getUserId().toString(), user.getUserName(), user.getUserName(), claims, 900000L));
        }
        throw new InvalidParameterException();
    }

    @Override
    public User register(User user) {
        validateUniqueUser(user);
        return userRepository.save(user);
    }

    private void validateUniqueUser(User user) {
        if (getUsers().stream().anyMatch(actual -> actual.getEmail().equals(user.getEmail())))
            throw new StoreException(HttpStatus.BAD_REQUEST, new StoreError(ErrorConstants.CODE_UD_09, ErrorConstants.CODE_UD_09.getMessage()));
    }

    @Override
    public List<User> getUsers() {
        return StreamSupport.stream(userRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }
}