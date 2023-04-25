package com.muntameh.springbootjunit.service;

import com.muntameh.springbootjunit.model.User;
import com.muntameh.springbootjunit.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public void createUser(User user) {
        User userToCreate = new User();
        userToCreate.setName(user.getName());
        userToCreate.setAge(user.getAge());
        userToCreate.setAddress(user.getAddress());
        userRepository.save(userToCreate);
    }

    public void updateUserAddress(User user) {
        User existingUser = getUserById(user.getId());
        existingUser.setName(user.getName());
        existingUser.setAge(user.getAge());
        existingUser.setAddress(user.getAddress());
        userRepository.save(existingUser);
    }

    public String deleteUserById(String id) {
        userRepository.deleteById(id);
        return "User deleted";
    }
}
