package com.sinam.sinamproject.service.impl;

import com.sinam.sinamproject.entity.User;
import com.sinam.sinamproject.repository.UserRepository;
import com.sinam.sinamproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public User findUserByFin(String fin) {
        return userRepository.findByFin(fin).orElse(null);
    }

    @Override

    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

}

