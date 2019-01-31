package com.ds.baza.dsbaza.repository;

import com.ds.baza.dsbaza.model.SrpskaSlava;
import com.ds.baza.dsbaza.model.Zanimanje;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ZanimanjeRepository extends CrudRepository<Zanimanje, Long> {

    Optional<Zanimanje> findByNaziv(String naziv);


}
