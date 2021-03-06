package com.ds.baza.dsbaza.repository;

import com.ds.baza.dsbaza.model.SrpskaSlava;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SrpskaSlavaRepository extends CrudRepository<SrpskaSlava, Long> {

    Optional<SrpskaSlava> findByNaziv(String naziv);


}
