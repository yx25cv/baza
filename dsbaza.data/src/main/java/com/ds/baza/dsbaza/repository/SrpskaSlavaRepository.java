package com.ds.baza.dsbaza.repository;

import com.ds.baza.dsbaza.model.SrpskaSlava;
import org.springframework.data.repository.CrudRepository;

public interface SrpskaSlavaRepository extends CrudRepository<SrpskaSlava, Long> {

    SrpskaSlava findByNaziv(String naziv);

}
