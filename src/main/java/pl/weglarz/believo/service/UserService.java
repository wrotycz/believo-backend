package pl.weglarz.believo.service;

import pl.weglarz.believo.model.dto.UserDto;
import pl.weglarz.believo.model.entities.User;

public interface UserService {
    User registerNewUserAccount(UserDto accountDto);
}
