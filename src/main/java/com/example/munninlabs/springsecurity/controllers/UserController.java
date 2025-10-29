package com.example.munninlabs.springsecurity.controllers;

import com.example.munninlabs.springsecurity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    public UserService userService;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public Object getAllUsers() {
        return userService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Object getUserById(Long id) {
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteUser(Long id) {
        userService.deleteUser(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Object createUser(String userName, String email, String password) {
        return userService.createUserIfNotExists(userName, email, password);
    }


}
