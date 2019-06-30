package com.andersen.training.crud.controllers;

import com.andersen.training.crud.dto.UserDto;
import com.andersen.training.crud.interfaces.UserService;
import com.andersen.training.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
//    private UserService userService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

//    public UserController() {
//    }
//
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    @PostMapping
    @Secured(value = {"IS_AUTHENTICATED_ANONYMOUSLY", "ADMIN"})
    public void createUser(@RequestBody UserDto user, @AuthenticationPrincipal UserDto userOwner) {
        userService.create(user);
    }

    @GetMapping
    @Secured(value = "ADMIN")
    public List<UserDto> getUsers() {
        return userService.readAll();
    }

    @GetMapping("{id}")
    @Secured(value = {"User", "ADMIN"})
    public UserDto getUserById(@PathVariable("id") int id) {
        return userService.readById(id);
    }

    @PutMapping("{id}")
//    @Secured(value = {"User", "ADMIN"})
    @PreAuthorize("#userOwner.username == 'admin' || #userOwner.id == id")
    public void updateUserById(@PathVariable("id") int id, @RequestBody UserDto user, Principal userOwner) {
        userService.update(id, user);
    }

    @DeleteMapping("{id}")
    @Secured(value = {"User", "ADMIN"})
    public void deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
    }
}
