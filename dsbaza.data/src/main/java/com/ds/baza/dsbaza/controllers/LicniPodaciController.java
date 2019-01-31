package com.ds.baza.dsbaza.controllers;

import com.ds.baza.dsbaza.errorhandling.BazaException;
import com.ds.baza.dsbaza.model.Clanovi;
import com.ds.baza.dsbaza.model.LicniPodaci;
import com.ds.baza.dsbaza.model.PagerModel;
import com.ds.baza.dsbaza.repository.LicniPodaciRepository;
import com.ds.baza.dsbaza.service.LicniPodaciService;
import com.ds.baza.dsbaza.service.SrpskaSlavaService;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Locale;
import java.util.Map;

@Controller
public class LicniPodaciController {


    private final LicniPodaciService licniPodaciService;
    private final SrpskaSlavaService srpskaSlavaService;
    private final LicniPodaciRepository licniPodaciRepository;
    private MessageSource messageSource;

    public LicniPodaciController(LicniPodaciService licniPodaciService, SrpskaSlavaService srpskaSlavaService, LicniPodaciRepository licniPodaciRepository, MessageSource messageSource) {
        this.licniPodaciService = licniPodaciService;
        this.srpskaSlavaService = srpskaSlavaService;
        this.licniPodaciRepository = licniPodaciRepository;
        this.messageSource = messageSource;
    }

    @RequestMapping({"", "/"})
    public String redirect() {
        return "redirect:index";
    }

    @RequestMapping("/unos")
    public String unos(Model model, Map<String, Object> model2) {
        model.addAttribute("licniPodaci", new LicniPodaci());
        model.addAttribute("clanovi", new Clanovi());
        LicniPodaci licniPodaci = new LicniPodaci();
        //model2.put("licniPodaci",licniPodaci);
        model.addAttribute("srpskaSlavas", srpskaSlavaService.findAll());
        return "unos";
    }

    @RequestMapping(value = "/dounos", method = RequestMethod.POST)
    public String doUnos(@Validated LicniPodaci licniPodaci, @Validated Clanovi clanovi, BindingResult bindingResult) {
//ovaj kod dodajem ovde da bih resio problem oko updatea. Morao sam da izvucem validaciju iz validatora i prebacim je ovde direktno u controler
        if(licniPodaciService.findByMlb(licniPodaci.getMlb()) != null){
            bindingResult.rejectValue("mlb", "error.mlb", messageSource.getMessage("com.ds.baza.dsbaza.model.Constraints.MlbValidatorConstraint.jmbgnepostoji",null, Locale.US));
        }
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

    private static final int BUTTONS_TO_SHOW = 3;
    private static final int[] PAGE_SIZES = {5, 10};
    @RequestMapping("/index")
    public String listaLicniPOdaci (@PageableDefault(size = 5) Pageable pageable, Model model) {
        Page<LicniPodaci> page = licniPodaciRepository.findAll(pageable);
        int evalPageSize = page.getSize();
        PagerModel pager = new PagerModel(page.getTotalPages(),page.getNumber(),BUTTONS_TO_SHOW);
        model.addAttribute("selectedPageSize", evalPageSize);
        model.addAttribute("page", page);
        model.addAttribute("pageSizes", PAGE_SIZES);
        model.addAttribute("pager", pager);
        //model.addAttribute("licniPodacis", licniPodaciService.findAll());
        return "index";
    }

    @RequestMapping("/index/{id}")
    public String findLicniPodaciByID (@PathVariable Long id, Model model) {
        model.addAttribute("licniPodaci", licniPodaciService.findById(id));
        return "pregled";
    }

    @GetMapping("/index/{ownerId}/edit")
    public String initUpdateOwnerForm(@PathVariable("ownerId") Long id, Model model) {
        LicniPodaci licniPodaci = licniPodaciService.findById(id);
        model.addAttribute(licniPodaci);
        return "unos";
    }

    @RequestMapping(value = "/index/{ownerId}/edit", method = RequestMethod.POST)
    public String doedit(@Valid LicniPodaci licniPodaci, BindingResult bindingResult, @PathVariable("ownerId") Long id) {
        LicniPodaci LP = licniPodaciService.findByMlb(licniPodaci.getMlb());;
        if(LP != null){
            if(LP.getId()!=id){
                bindingResult.rejectValue("mlb", "error.mlb", messageSource.getMessage("com.ds.baza.dsbaza.model.Constraints.MlbValidatorConstraint.jmbgnepostoji",null, Locale.US));
            }}
        if (bindingResult.hasErrors()) {
            return "unos";
        } else
            try {
            LicniPodaci licniPodaci1 = licniPodaciService.findById(id);
            System.out.println("vrednost objekta je " + licniPodaci1.toString());
            licniPodaci.setId(id);
//            licniPodaci1.setIme(licniPodaci.getIme());
            licniPodaciService.save(licniPodaci);

            } catch (BazaException ex) {
                ObjectError error = new ObjectError(ex.getPolje(),"Ispravite vrednosti u ovom polju");
                bindingResult.rejectValue(ex.getPolje(), ex.getError().getFirst().toString(), ex.getError().getSecond());
                return "unos";
            }

        return "unosuspesan";
    }
}