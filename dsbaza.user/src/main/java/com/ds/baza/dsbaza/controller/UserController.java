package com.ds.baza.dsbaza.controller;

import com.ds.baza.dsbaza.model.User;
import com.ds.baza.dsbaza.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserController {


        @Autowired
        private UserService userService;

        @RequestMapping("/{username}")
        public User getUserByUsername(@PathVariable String username) {
            return userService.findByUsername(username);
        }

        @RequestMapping(method = RequestMethod.POST)
        public User createUser(@RequestBody User user) {
            return userService.createUser(user);

        }
}
