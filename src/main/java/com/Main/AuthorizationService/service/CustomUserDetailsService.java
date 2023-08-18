package com.Main.AuthorizationService.service;

import com.Main.AuthorizationService.exception.UserNotFoundException;
import com.Main.AuthorizationService.model.User;
import com.Main.AuthorizationService.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User loadUserByUsername(String login) throws UserNotFoundException {
        User user = userRepository.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + login));
        return user;
    }
}
