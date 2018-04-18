package pl.weglarz.believo.service;

import pl.weglarz.believo.model.dto.UserDto;
import pl.weglarz.believo.model.entities.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);
    User registerNewUserAccount(UserDto accountDto);
}
