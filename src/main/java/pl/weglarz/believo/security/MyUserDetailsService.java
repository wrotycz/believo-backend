package pl.weglarz.believo.security;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import pl.weglarz.believo.model.entities.Privilege;
import pl.weglarz.believo.model.entities.Role;
import pl.weglarz.believo.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Database user authentication service.
 */
@Component
public final class MyUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public MyUserDetailsService(UserService userService) {
        super();
        this.userService = userService;
    }

    /**
     * Loads the user from the datastore, by it's user name <br>
     */
    @Override
    public final UserDetails loadUserByUsername(final String username) {
        if (username == null) {
            throw new NullPointerException();
        }

        val userOptional = userService.findByUsername(username);
        if (!userOptional.isPresent()) {
            throw new UsernameNotFoundException("Username was not found: " + username);
        }

        val user = userOptional.get();
        final Set<Role> rolesOfUser = user.getRoles();
        final Set<Privilege> privileges = new HashSet<>();
        for (final Role roleOfUser : rolesOfUser) {
            privileges.addAll(roleOfUser.getPrivileges());
        }
        final String[] privilegeStringsAsArray = privileges.stream()
                .map(Privilege::toString)
                .toArray(String[]::new);
        final List<GrantedAuthority> auths = AuthorityUtils.createAuthorityList(privilegeStringsAsArray);

        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), auths);
    }

}
