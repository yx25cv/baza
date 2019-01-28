package com.ds.baza.dsbaza.repository;

import com.ds.baza.dsbaza.model.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
