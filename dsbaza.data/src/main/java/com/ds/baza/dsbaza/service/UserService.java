package com.ds.baza.dsbaza.service;

import com.ds.baza.dsbaza.commands.UserCommand;
import com.ds.baza.dsbaza.model.user.Role;
import com.ds.baza.dsbaza.model.user.User;
import org.springframework.boot.context.event.ApplicationReadyEvent;

public interface UserService {

    User findByUsername(String username);

    void signup (UserCommand userCommand, Role role);

    public void afterApplicationReady(ApplicationReadyEvent event1);

}
