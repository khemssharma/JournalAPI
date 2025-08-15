package com.firstapi.demo.services;

import com.firstapi.demo.entity.User;
import com.firstapi.demo.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User entry) {
        return userRepository.save(entry);
    }
    public List<User> findAll() {
        return userRepository.findAll();
    }
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }   
    public void deleteById(ObjectId id) {
        userRepository.deleteById(id);
    }   
}
