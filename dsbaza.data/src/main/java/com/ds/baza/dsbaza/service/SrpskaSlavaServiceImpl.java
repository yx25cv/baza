package com.ds.baza.dsbaza.service;

import com.ds.baza.dsbaza.model.SrpskaSlava;
import com.ds.baza.dsbaza.repository.SrpskaSlavaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SrpskaSlavaServiceImpl implements SrpskaSlavaService {



    @Autowired
    private SrpskaSlavaRepository srpskaSlavaRepository;

//    public SrpskaSlavaServiceImpl(SrpskaSlavaRepository srpskaSlavaRepository) {
//        this.srpskaSlavaRepository = srpskaSlavaRepository;
//    }


    @Override
    public List<SrpskaSlava> findAll() {
        List<SrpskaSlava> srpskaSlavas = new ArrayList<>();

        srpskaSlavaRepository.findAll().forEach(srpskaSlavas::add);
        return srpskaSlavas;
    }

    @Override
    public SrpskaSlava save(SrpskaSlava object) {
        return srpskaSlavaRepository.save(object);
    }

    @Override
    public SrpskaSlava findByNaziv(String naziv) {
        return srpskaSlavaRepository.findByNaziv(naziv);
    }
}
