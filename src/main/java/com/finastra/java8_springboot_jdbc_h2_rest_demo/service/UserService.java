package com.finastra.java8_springboot_jdbc_h2_rest_demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finastra.java8_springboot_jdbc_h2_rest_demo.model.User;
import com.finastra.java8_springboot_jdbc_h2_rest_demo.repository.UserRepository;
import org.example.enums.Country;
import org.example.enums.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Integer addNumbers(int num1, int num2) {
        Operator operator = Operator.ADD;
        return operator.execute(num1, num2);;
    }
    public User createUser(String requestBody) {

        User userToCreate;
        try {
            userToCreate = new ObjectMapper().readValue(requestBody, User.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
        return userRepository.save(userToCreate);
    }

    public User createUserDemo() {

        User userToCreate = User.builder()
                .id(101)
                .firstName("Benny")
                .lastName("Regev")
                .age(52)
                .country(Country.ISRAEL)
                .build();
        return userRepository.save(userToCreate);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(String userId) {
        User user = userRepository.findById(Integer.valueOf(userId)).orElse(null);
        System.out.println(user.toJson());
        return user;
    }

    public List<User> getByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }

    public User updateUser(String id, String requestBody) {
        User userToUpdate = this.getById(id);
        try {
            User user = new ObjectMapper().readValue(requestBody, User.class);
            userToUpdate.setFirstName(user.getFirstName());
            userToUpdate.setLastName(user.getLastName());
            userToUpdate.setAge(user.getAge());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
        return userRepository.save(userToUpdate);
    }

    public User deleteUser(String userId) {
        User userToDelete = this.getById(userId);
        if (userToDelete != null) {
            userRepository.delete(userToDelete);
        }
        return userToDelete;
    }
}
