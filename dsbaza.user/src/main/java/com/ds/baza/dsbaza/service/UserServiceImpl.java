package com.ds.baza.dsbaza.service;

import com.ds.baza.dsbaza.model.Role;
import com.ds.baza.dsbaza.model.User;
import com.ds.baza.dsbaza.model.UserRole;
import com.ds.baza.dsbaza.repository.UserRepository;
import com.ds.baza.dsbaza.uitility.SecurityUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private static Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User createUser(User user) {

            User localUser = userRepository.findByUsername(user.getUsername());
        LOG.info("User with username {} already exist. Nothing will be done", user.getUsername());
        if (localUser != null) {
            LOG.info("User with username {} already exist. Nothing will be done", user.getUsername());
        } else {
            Set<UserRole> userRoles = new HashSet<>();
            Role localRole = new Role();
            localRole.setRoleId(1);
            userRoles.add(new UserRole(user,localRole));
            user.getUserRoles().addAll(userRoles);
            Date today = new Date();
            user.setJoinDate(today);

            String encryptedPassword = SecurityUtility.passwordEncoder().encode(user.getPassword());
            user.setPassword(encryptedPassword);
            localUser = userRepository.save(user);
        }

                return localUser;
                }
}
