package com.ds.baza.dsbaza.service;

import com.ds.baza.dsbaza.model.Zanimanje;
import com.ds.baza.dsbaza.repository.ZanimanjeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ZanimanjeServiceImpl implements ZanimanjeService {



    private ZanimanjeRepository zanimanjeRepository;

    public ZanimanjeServiceImpl(ZanimanjeRepository zanimanjeRepository) {
        this.zanimanjeRepository = zanimanjeRepository;
    }


    @Override
    public Zanimanje findByNaziv(String naziv) {
        return zanimanjeRepository.findByNaziv(naziv).orElse(null);
    }

    @Override
    public Zanimanje save(Zanimanje object) {
        return null;
    }

    @Override
    public Set<Zanimanje> findAll() {
        Set<Zanimanje> zanimanjes = new HashSet<>();
        zanimanjeRepository.findAll().forEach(zanimanjes::add);
        return zanimanjes;
    }

    @Override
    public Zanimanje findById(Long id) {
        return null;
    }
}
