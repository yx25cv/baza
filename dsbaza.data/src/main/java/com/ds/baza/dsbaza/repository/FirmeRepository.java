package com.ds.baza.dsbaza.repository;

import com.ds.baza.dsbaza.model.Firme;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FirmeRepository extends CrudRepository<Firme, Long> {

    Optional<Firme> findByNaziv(String naziv);


}
