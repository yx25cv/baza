package com.ds.baza.dsbaza.controllers;

import com.ds.baza.dsbaza.errorhandling.BazaException;
import com.ds.baza.dsbaza.errorhandling.Pair;
import com.ds.baza.dsbaza.model.LicniPodaci;
import com.ds.baza.dsbaza.service.LicniPodaciService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class LicniPodaciController {

    private final LicniPodaciService licniPodaciService;

    public LicniPodaciController(LicniPodaciService licniPodaciService) {
        this.licniPodaciService = licniPodaciService;
    }


    @RequestMapping("/unos")
    public String unos(Model model) {
        model.addAttribute("licniPodaci", new LicniPodaci());
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
                ObjectError error = new ObjectError(ex.getPolje(),"An account already exists for this email.");
                bindingResult.rejectValue(ex.getPolje(), ex.getError().getFirst().toString(), ex.getError().getSecond());
            return "unos";
            }

        return "unosuspesan";
    }
}