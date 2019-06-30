package com.andersen.training.crud.repository;

import com.andersen.training.crud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByUsername(String username);
    default void print() {
        System.out.println("this ok");
    }
}
