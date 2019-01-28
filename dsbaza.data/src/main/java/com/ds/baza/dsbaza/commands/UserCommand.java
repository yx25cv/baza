package com.ds.baza.dsbaza.commands;

import com.ds.baza.dsbaza.model.user.Role;
import com.ds.baza.dsbaza.model.user.User;
import com.ds.baza.dsbaza.model.user.UserRole;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class UserCommand {

    private String firstName;
    private String lastName;
    //@Size(min=4, max = 250, message="{emailSizeError}")
    private String email;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date joinDate;

    @NotEmpty
    @Size(min = 1, max = 100)
    private String username;

    @NotEmpty
    @Size(min = 6, max = 32)
    private String password;

    private Set<UserRole> userRoles = new HashSet<>();

    @Transient
    private Role role = new Role();

    public User toUser() {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setJoinDate(joinDate);
        user.setUsername(username);
        user.setPassword(password);
        user.setUserRoles(userRoles);
        return user;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }
}
