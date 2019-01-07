package com.ds.baza.dsbaza.service;

import com.ds.baza.dsbaza.model.SrpskaSlava;
import com.ds.baza.dsbaza.repository.SrpskaSlavaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SrpskaSlavaServiceImpl implements SrpskaSlavaService {

    @Autowired
    private SrpskaSlavaRepository srpskaSlavaRepository;

//    public SrpskaSlavaServiceImpl(SrpskaSlavaRepository srpskaSlavaRepository) {
//        this.srpskaSlavaRepository = srpskaSlavaRepository;
//    }

    @Override
    public SrpskaSlava save(SrpskaSlava object) {
        return srpskaSlavaRepository.save(object);
    }

    @Override
    public SrpskaSlava findByNaziv(String naziv) {
        return srpskaSlavaRepository.findByNaziv(naziv);
    }
}
