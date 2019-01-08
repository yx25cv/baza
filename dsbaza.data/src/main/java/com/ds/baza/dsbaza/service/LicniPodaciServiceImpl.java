package com.ds.baza.dsbaza.service;

import com.ds.baza.dsbaza.errorhandling.BazaException;
import com.ds.baza.dsbaza.model.LicniPodaci;
import com.ds.baza.dsbaza.model.SrpskaSlava;
import com.ds.baza.dsbaza.repository.LicniPodaciRepository;
import org.springframework.stereotype.Service;

@Service
public class LicniPodaciServiceImpl implements LicniPodaciService {

    //boolean provera = false;

    private final LicniPodaciRepository licniPodaciRepository;
    private final SrpskaSlavaService srpskaSlavaService;


    public LicniPodaciServiceImpl(LicniPodaciRepository licniPodaciRepository, SrpskaSlavaService srpskaSlavaService) {
        this.licniPodaciRepository = licniPodaciRepository;
        this.srpskaSlavaService = srpskaSlavaService;
    }

//provera ispravnosti maticnog broja
    public void validate (String jmbg) {
        int proracun = (11 - ((7 * (jmbg.charAt(0) - '0' + jmbg.charAt(6) - '0') +
                6 * (jmbg.charAt(1) - '0' + jmbg.charAt(7) - '0') +
                5 * (jmbg.charAt(2) - '0' + jmbg.charAt(8) - '0') +
                4 * (jmbg.charAt(3) - '0' + jmbg.charAt(9) - '0') +
                3 * (jmbg.charAt(4) - '0' + jmbg.charAt(10) - '0') +
                2 * (jmbg.charAt(5) - '0' + jmbg.charAt(11) - '0')))) % 11;
        if (proracun != 0) {
            if (proracun + 11 != jmbg.charAt(12) - '0') {
                //provera = true;
                throw new BazaException(BazaException.JMBG_NIJE_ISPRAVAN);
            }
        } else {
            if (proracun != jmbg.charAt(12) - '0') {
                //provera = true;
                throw new BazaException(BazaException.JMBG_NIJE_ISPRAVAN);

            }
        }
    }


    @Override
    public LicniPodaci save(LicniPodaci object) {
        validate(object.getMlb());
if(object.getSrpskaSlava().getNaziv() != "") {
    if (srpskaSlavaService.findByNaziv(object.getSrpskaSlava().getNaziv()) == null) {
        throw new BazaException(BazaException.ALREADY_EXIST, "srpskaSlava");
    }
}
        object.setSrpskaSlava(srpskaSlavaService.findByNaziv(object.getSrpskaSlava().getNaziv()));
//        try{
//            if(licniPodaciRepository.findByIme(object.getIme())!=null) {
//                throw new BazaException(BazaException.ALREADY_EXIST,"ime");
//            }}catch (RuntimeException ex) {
//            throw new BazaException(BazaException.ALREADY_EXIST,"ime");
//        }

        try{
        if(licniPodaciRepository.findByMlb(object.getMlb())!=null) {
            throw new BazaException(BazaException.ALREADY_EXIST,"mlb");
        }}catch (RuntimeException ex) {
            throw new BazaException(BazaException.ALREADY_EXIST,"mlb");
        }
        System.out.println(object.getMlb());
        //System.out.println(provera);
        return licniPodaciRepository.save(object);

    }
}
