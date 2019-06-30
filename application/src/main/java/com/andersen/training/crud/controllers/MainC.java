package com.andersen.training.crud.controllers;

import com.andersen.training.crud.interfaces.UserService;
import com.andersen.training.crud.repository.OtherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainC {
    @Autowired
    private OtherRepo userRepository;
    @Autowired
    private UserService userService;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String start() {
        userRepository.print();
        return "index";
    }

}
