package com.santosh.springsecurityuserdetailsservice.service;

import com.santosh.springsecurityuserdetailsservice.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service("userDetails")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Username : {}", username);

        User user = findUser(username);

        if (user != null) {

            org.springframework.security.core.userdetails.User.UserBuilder userBuilder =
                    org.springframework.security.core.userdetails.User.withUsername(username)
                            .password(user.getPassword())
                            .authorities(user.getRoles());

            return userBuilder.build();
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
    }

    private User findUser(String username) {
        if (username.equalsIgnoreCase("admin")) {
            return new User(username, "$2a$12$2JEtsGvBzEPV67mwOS3i8OTDSw0nFbxN9RZ.ohSYjkvG3sR.vYAYW", "ADMIN");
        } else if (username.equalsIgnoreCase("user")) {
            return new User(username, "$2a$12$2JEtsGvBzEPV67mwOS3i8OTDSw0nFbxN9RZ.ohSYjkvG3sR.vYAYW", "USER");
        }
        return null;
    }
}
