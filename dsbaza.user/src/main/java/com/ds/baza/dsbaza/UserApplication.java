package com.ds.baza.dsbaza;

import com.ds.baza.dsbaza.model.Role;
import com.ds.baza.dsbaza.model.User;
import com.ds.baza.dsbaza.model.UserRole;
import com.ds.baza.dsbaza.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class UserApplication implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(UserApplication.class);

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User();
        user1.setFirstName("John");
        user1.setLastName("Adams");
        user1.setUsername("jadams");
        user1.setPassword("password");
        user1.setEmail("jadams@gmail.com");

        Set<UserRole> userRoles = new HashSet<>();
        Role role1 = new Role();
        role1.setRoleId(1);
        role1.setName("ROLE_USER");
        userRoles.add(new UserRole(user1, role1));

        userService.createUser(user1);

        //LOG.info("authority je: {}", user1.getAuthorities());


    }
}
