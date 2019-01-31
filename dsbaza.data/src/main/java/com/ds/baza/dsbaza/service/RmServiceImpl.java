package com.ds.baza.dsbaza.service;

import com.ds.baza.dsbaza.model.Firme;
import com.ds.baza.dsbaza.model.Rm;
import com.ds.baza.dsbaza.repository.RmRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RmServiceImpl implements RmService {

    private RmRepository rmRepository;

    public RmServiceImpl(RmRepository rmRepository) {
        this.rmRepository = rmRepository;
    }

    @Override
    public Set<Rm> findAll() {
        Set<Rm> rms = new HashSet<>();

        rmRepository.findAll().forEach(rms::add);
        return rms;
    }

    @Override
    public Rm save(Rm object) {
        return rmRepository.save(object);
    }

    @Override
    public Rm findByNaziv(String naziv) {
        return rmRepository.findByNaziv(naziv).orElse(null);
    }

    @Override
    public Rm findById(Long id) {
        return rmRepository.findById(id).orElse(null);
    }
}
