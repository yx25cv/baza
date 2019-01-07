package com.ds.baza.dsbaza.repository;

import com.ds.baza.dsbaza.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {



    User findByUsername(String username);

}
