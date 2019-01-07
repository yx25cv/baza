package com.ds.baza.dsbaza;

import com.ds.baza.dsbaza.model.LicniPodaci;
import com.ds.baza.dsbaza.model.SrpskaSlava;
import com.ds.baza.dsbaza.service.LicniPodaciService;
import com.ds.baza.dsbaza.service.SrpskaSlavaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class DsbazaApplication implements CommandLineRunner {


    private static final Logger logger = LoggerFactory.getLogger(DsbazaApplication.class);
    @Autowired
    LicniPodaciService licniPodaciService;

    @Autowired
    SrpskaSlavaService srpskaSlavaService;




    public static void main(String[] args) {
        SpringApplication.run(DsbazaApplication.class, args);
    }

        @Override
        public void run(String... args) throws Exception {
//            SrpskaSlava srpskaSlava = new SrpskaSlava();
//            srpskaSlava.setNaziv("Sveti Arandjel");
//            srpskaSlavaService.save(srpskaSlava);
//            srpskaSlava = srpskaSlavaService.findByNaziv("Sveti Arandjel");
//            logger.info("vrednost objekta iz baze je: {}", srpskaSlava.toString());
//
//            LicniPodaci licni_podaci = new LicniPodaci();
//            licni_podaci.setSrpskaSlava(srpskaSlava);
//            licni_podaci.setAdresa("asdf");
//            licni_podaci.setMlb("3009987710193");
//
//            licniPodaciService.save(licni_podaci);
        }









}

