package io.opeleh.authenticationservices.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import io.opeleh.authenticationservices.model.UsersDetails;
import io.opeleh.authenticationservices.repository.UserJparepository;
import io.opeleh.authenticationservices.model.User;

@Service
public class AuthUserDetailsService implements UserDetailsService {

    @Autowired
    UserJparepository userJparepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional <User> userToAccesss = userJparepository.findByUsername(username);
        return userToAccesss.map(UsersDetails::new).get();

    }
}