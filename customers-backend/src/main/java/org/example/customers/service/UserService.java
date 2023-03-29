package org.example.customers.service;


import org.example.customers.model.entity.SystemUser;
import org.example.customers.model.repository.UserRepository;
import org.example.customers.rest.exception.RegisteredUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public SystemUser save(SystemUser user) {
        boolean exists = userRepository.existsByUsername(user.getUsername());
        if (exists) {
            throw new RegisteredUserException((user.getUsername()));
        }
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SystemUser user = userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return User
                .builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles("USER").build();
    }
}
