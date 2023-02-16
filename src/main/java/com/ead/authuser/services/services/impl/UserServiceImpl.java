package com.ead.authuser.services.services.impl;

import com.ead.authuser.models.UserModel;
import com.ead.authuser.repositories.UserRepository;
import com.ead.authuser.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserModel> findAll() {
        return userRepository.findAll();
    }
    @Override
    public Optional<UserModel> findById(UUID userUuid) {
        return userRepository.findById(userUuid);
    }

    @Override
    public void deleteById(UUID uuid) {
        userRepository.deleteById(uuid);
    }
}
