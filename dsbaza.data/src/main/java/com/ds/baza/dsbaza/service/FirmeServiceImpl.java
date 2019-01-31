package com.ds.baza.dsbaza.service;

import com.ds.baza.dsbaza.model.Firme;
import com.ds.baza.dsbaza.repository.FirmeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class FirmeServiceImpl implements FirmeService {

    private FirmeRepository firmeRepository;

    public FirmeServiceImpl(FirmeRepository firmeRepository) {
        this.firmeRepository = firmeRepository;
    }


    @Override
    public Set<Firme> findAll() {
        Set<Firme> firmes = new HashSet<>();

        firmeRepository.findAll().forEach(firmes::add);
        return firmes;
    }

    @Override
    public Firme save(Firme object) {
        return firmeRepository.save(object);
    }

    @Override
    public Firme findByNaziv(String naziv) {
        return firmeRepository.findByNaziv(naziv).orElse(null);
    }

    @Override
    public Firme findById(Long id) {
        return firmeRepository.findById(id).orElse(null);
    }
}
