package pl.weglarz.believo.service.impl;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.weglarz.believo.model.dto.UserDto;
import pl.weglarz.believo.model.entities.User;
import pl.weglarz.believo.repository.RoleRepository;
import pl.weglarz.believo.repository.UserRepository;
import pl.weglarz.believo.service.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        assert userRepository != null;
        assert roleRepository != null;
        assert passwordEncoder != null;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(userRepository.findByName(username));
    }

    @Override
    public User registerNewUserAccount(UserDto accountDto) {
        val user = new User(null, accountDto.getName(), accountDto.getEmail(),
                passwordEncoder.encode(accountDto.getPassword()), accountDto.isLocked(),
                roleRepository.findByNameIn(accountDto.getRoles()));
        return userRepository.save(user);
    }
}
