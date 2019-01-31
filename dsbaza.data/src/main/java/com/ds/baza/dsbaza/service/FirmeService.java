package com.ds.baza.dsbaza.service;

import com.ds.baza.dsbaza.model.Firme;

public interface FirmeService extends CrudService<Firme,Long>{


    Firme findByNaziv(String naziv);



}
