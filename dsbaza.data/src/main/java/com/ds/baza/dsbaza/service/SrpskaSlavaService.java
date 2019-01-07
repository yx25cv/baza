package com.ds.baza.dsbaza.service;

import com.ds.baza.dsbaza.model.SrpskaSlava;
import com.ds.baza.dsbaza.repository.SrpskaSlavaRepository;

public interface SrpskaSlavaService extends CrudService<SrpskaSlava,Long>{


    SrpskaSlava findByNaziv (String naziv);


}
