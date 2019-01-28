package com.ds.baza.dsbaza.repository;

import com.ds.baza.dsbaza.model.user.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByName (String name);

}
