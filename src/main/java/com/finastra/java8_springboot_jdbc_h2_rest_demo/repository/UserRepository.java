package com.finastra.java8_springboot_jdbc_h2_rest_demo.repository;

import com.finastra.java8_springboot_jdbc_h2_rest_demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByLastName(String lastName);
}
