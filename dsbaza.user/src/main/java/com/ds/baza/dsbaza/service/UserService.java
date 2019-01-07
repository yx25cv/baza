package com.ds.baza.dsbaza.service;

import com.ds.baza.dsbaza.model.User;

public interface UserService {

    User findByUsername(String username);

    User createUser (User user);
}
