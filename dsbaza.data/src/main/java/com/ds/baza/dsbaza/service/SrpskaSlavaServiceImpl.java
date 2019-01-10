package com.ds.baza.dsbaza.service;

import com.ds.baza.dsbaza.model.SrpskaSlava;
import com.ds.baza.dsbaza.repository.SrpskaSlavaRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SrpskaSlavaServiceImpl implements SrpskaSlavaService {



    private SrpskaSlavaRepository srpskaSlavaRepository;

    public SrpskaSlavaServiceImpl(SrpskaSlavaRepository srpskaSlavaRepository) {
        this.srpskaSlavaRepository = srpskaSlavaRepository;
    }


    @Override
    public Set<SrpskaSlava> findAll() {
        Set<SrpskaSlava> srpskaSlavas = new HashSet<>();

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
