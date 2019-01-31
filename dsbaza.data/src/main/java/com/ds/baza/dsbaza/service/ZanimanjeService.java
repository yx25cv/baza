package com.ds.baza.dsbaza.service;

import com.ds.baza.dsbaza.model.SrpskaSlava;
import com.ds.baza.dsbaza.model.Zanimanje;

public interface ZanimanjeService extends CrudService<Zanimanje,Long>{


    Zanimanje findByNaziv(String naziv);



}
