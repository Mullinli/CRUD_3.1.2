package com.example.CRUD_312.service;

import com.example.CRUD_312.model.User;
import com.example.CRUD_312.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.delete(userRepository.findById(id).orElse(null));
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }
}
