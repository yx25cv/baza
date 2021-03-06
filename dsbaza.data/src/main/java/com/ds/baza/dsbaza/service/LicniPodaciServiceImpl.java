package com.ds.baza.dsbaza.service;

import com.ds.baza.dsbaza.errorhandling.BazaException;
import com.ds.baza.dsbaza.model.LicniPodaci;
import com.ds.baza.dsbaza.repository.LicniPodaciRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class LicniPodaciServiceImpl implements LicniPodaciService {

    //boolean provera = false;

    private static final Logger logger = LoggerFactory.getLogger(LicniPodaciServiceImpl.class);

    private final LicniPodaciRepository licniPodaciRepository;
    private final SrpskaSlavaService srpskaSlavaService;
    private final ZanimanjeService zanimanjeService;
    private final FirmeService firmeService;
    private final RmService rmService;


    public LicniPodaciServiceImpl(LicniPodaciRepository licniPodaciRepository, SrpskaSlavaService srpskaSlavaService, ZanimanjeService zanimanjeService, FirmeService firmeService, RmService rmService) {
        this.licniPodaciRepository = licniPodaciRepository;
        this.srpskaSlavaService = srpskaSlavaService;
        this.zanimanjeService = zanimanjeService;
        this.firmeService = firmeService;
        this.rmService = rmService;
    }

    @Override
    public Set<LicniPodaci> findAll() {
        Set<LicniPodaci> licniPodacis = new HashSet<>();

        licniPodaciRepository.findAll().forEach(licniPodacis::add);

        return licniPodacis;
    }

    //provera ispravnosti maticnog broja
    private void validate(String jmbg) {
        int proracun = (11 - ((7 * (jmbg.charAt(0) - '0' + jmbg.charAt(6) - '0') +
                6 * (jmbg.charAt(1) - '0' + jmbg.charAt(7) - '0') +
                5 * (jmbg.charAt(2) - '0' + jmbg.charAt(8) - '0') +
                4 * (jmbg.charAt(3) - '0' + jmbg.charAt(9) - '0') +
                3 * (jmbg.charAt(4) - '0' + jmbg.charAt(10) - '0') +
                2 * (jmbg.charAt(5) - '0' + jmbg.charAt(11) - '0')))) % 11;
        if (proracun != 0) {
            logger.info("Sada sam u prvom if-u");
            if (proracun + 11 != jmbg.charAt(12) - '0') {
                //provera = true;
                throw new BazaException(BazaException.JMBG_NIJE_ISPRAVAN, "mlb");
            }
        } else {
            if (proracun != jmbg.charAt(12) - '0') {
                logger.info("Sada sam u drgom if-u");
                //provera = true;
                throw new BazaException(BazaException.JMBG_NIJE_ISPRAVAN, "mlb");

            }
        }
    }

    @Override
    public LicniPodaci findByMlb(String jmbg) {
        return licniPodaciRepository.findByMlb(jmbg);
    }

    @Override
    public LicniPodaci findById(Long id) {
        return licniPodaciRepository.findById(id).orElse(null);
    }

    @Override
    public LicniPodaci save(LicniPodaci licniPodaci) {
        logger.info("Vrednost JMBG je {}", licniPodaci.getMlb());
        validate(licniPodaci.getMlb());
        if (!licniPodaci.getSrpskaSlava().getNaziv().equals("")) {
            if (srpskaSlavaService.findByNaziv(licniPodaci.getSrpskaSlava().getNaziv()) == null) {
                throw new BazaException(BazaException.ALREADY_EXIST, "srpskaSlava");
            }
        }
        if (!licniPodaci.getZanimanje().getNaziv().equals("")) {
            if (zanimanjeService.findByNaziv(licniPodaci.getZanimanje().getNaziv()) == null) {
                throw new BazaException(BazaException.ALREADY_EXIST, "zanimanje");
            }
        }
        if (!licniPodaci.getFirme().getNaziv().equals("")) {
            if (firmeService.findByNaziv(licniPodaci.getFirme().getNaziv()) == null) {
                throw new BazaException(BazaException.ALREADY_EXIST, "nazivFirme");
            }
        }

        if (!licniPodaci.getRm().getNaziv().equals("")) {
            if (rmService.findByNaziv(licniPodaci.getFirme().getNaziv()) == null) {
                throw new BazaException(BazaException.ALREADY_EXIST, "rm");
            }
        }
        licniPodaci.setSrpskaSlava(srpskaSlavaService.findByNaziv(licniPodaci.getSrpskaSlava().getNaziv()));
        licniPodaci.setZanimanje(zanimanjeService.findByNaziv(licniPodaci.getZanimanje().getNaziv()));
        licniPodaci.setFirme(firmeService.findByNaziv(licniPodaci.getFirme().getNaziv()));
        licniPodaci.setRm(rmService.findByNaziv(licniPodaci.getRm().getNaziv()));
//        try{
//            if(licniPodaciRepository.findByIme(licniPodaci.getIme())!=null) {
//                throw new BazaException(BazaException.ALREADY_EXIST,"ime");
//            }}catch (RuntimeException ex) {
//            throw new BazaException(BazaException.ALREADY_EXIST,"ime");
//        }

//        try {
//            if (licniPodaciRepository.findByMlb(licniPodaci.getMlb()) != null) {
//                throw new BazaException(BazaException.ALREADY_EXIST, "mlb");
//            }
//        } catch (RuntimeException ex) {
//            throw new BazaException(BazaException.ALREADY_EXIST, "mlb");
//        }
        System.out.println(licniPodaci.getMlb());
        //System.out.println(provera);
        return licniPodaciRepository.save(licniPodaci);

    }


//    public boolean validateMlb(String mlb) {
//        if (licniPodaciRepository.findByMlb(mlb) != null) {
//            return false;
//        }
//        return true;
//    }
}
