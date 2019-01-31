package com.ds.baza.dsbaza.service;

import com.ds.baza.dsbaza.model.Firme;
import com.ds.baza.dsbaza.model.Rm;

public interface RmService extends CrudService<Rm,Long>{


    Rm findByNaziv(String naziv);



}
