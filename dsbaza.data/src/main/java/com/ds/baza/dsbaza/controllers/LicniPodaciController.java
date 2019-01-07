package com.ds.baza.dsbaza.controllers;

import com.ds.baza.dsbaza.errorhandling.BazaException;
import com.ds.baza.dsbaza.model.LicniPodaci;
import com.ds.baza.dsbaza.service.LicniPodaciService;
import com.ds.baza.dsbaza.service.SrpskaSlavaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LicniPodaciController {

    private final LicniPodaciService licniPodaciService;
    private final SrpskaSlavaService srpskaSlavaService;

    public LicniPodaciController(LicniPodaciService licniPodaciService, SrpskaSlavaService srpskaSlavaService) {
        this.licniPodaciService = licniPodaciService;
        this.srpskaSlavaService = srpskaSlavaService;
    }

    @RequestMapping("/unos")
    public String unos(Model model) {
        model.addAttribute("licniPodaci", new LicniPodaci());
        model.addAttribute("srpskaSlavas", srpskaSlavaService.findAll());
        return "unos";
    }

    @RequestMapping(value = "/dounos", method = RequestMethod.POST)
    public String doUnos(@Valid LicniPodaci licniPodaci, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "unos";
        } else
            try {
            licniPodaciService.save(licniPodaci);
            } catch (BazaException ex) {
                ObjectError error = new ObjectError(ex.getPolje(),"Ispravite vrednosti u ovom polju");
                bindingResult.rejectValue(ex.getPolje(), ex.getError().getFirst().toString(), ex.getError().getSecond());
            return "unos";
            }

        return "unosuspesan";
    }
}