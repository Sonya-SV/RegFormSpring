package com.training.regform.spring.config.service;


import com.training.regform.spring.config.entity.User;
import com.training.regform.spring.config.repository.UserRepository;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public void saveNewUser(User user) throws DataIntegrityViolationException {
        try {
            userRepository.save(user);
        } catch (Exception ex) {
            log.info("{User is already exists}");
        }
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }


}
