package com.ds.baza.dsbaza.repository;

import com.ds.baza.dsbaza.model.Rm;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RmRepository extends CrudRepository<Rm, Long> {

    Optional<Rm> findByNaziv(String naziv);


}
