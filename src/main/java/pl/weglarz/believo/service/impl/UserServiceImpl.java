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
    public User registerNewUserAccount(UserDto accountDto) {
        val user = User.builder()
                .name(accountDto.getName())
                .password(passwordEncoder.encode(accountDto.getPassword()))
                .email(accountDto.getEmail())
                .locked(false)
                .roles(roleRepository.findByNameIn(accountDto.getRoles()))
                .build();
        return userRepository.save(user);
    }
}
