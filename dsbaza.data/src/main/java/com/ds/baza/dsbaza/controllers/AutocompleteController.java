package com.ds.baza.dsbaza.controllers;

import com.ds.baza.dsbaza.model.Firme;
import com.ds.baza.dsbaza.model.Rm;
import com.ds.baza.dsbaza.model.SrpskaSlava;
import com.ds.baza.dsbaza.model.Zanimanje;
import com.ds.baza.dsbaza.service.FirmeService;
import com.ds.baza.dsbaza.service.RmService;
import com.ds.baza.dsbaza.service.SrpskaSlavaService;
import com.ds.baza.dsbaza.service.ZanimanjeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AutocompleteController {

    private SrpskaSlavaService srpskaSlavaService;
    private ZanimanjeService zanimanjeService;
    private FirmeService firmeService;
    private RmService rmService;

    public AutocompleteController(SrpskaSlavaService srpskaSlavaService, ZanimanjeService zanimanjeService, FirmeService firmeService, RmService rmService) {
        this.srpskaSlavaService = srpskaSlavaService;
        this.zanimanjeService = zanimanjeService;
        this.firmeService = firmeService;
        this.rmService = rmService;
    }

    @RequestMapping(value = "/suggestion", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public SuggestionWrapper autocompleteSuggestions(@RequestParam("searchstr") String searchstr) {
        System.out.println("searchstr: " + searchstr);

        ArrayList<String> suggestions = new ArrayList<>();

        for (SrpskaSlava obj : srpskaSlavaService.findAll()) {
            if (obj.getNaziv().toLowerCase().contains(searchstr.toLowerCase())) {
                suggestions.add(new String(obj.getNaziv()));
            }
        }

        // ogranicavanje predlozene liste za unos na maksimalno 20 elemenata
        int n = suggestions.size() > 20 ? 20 : suggestions.size();
        List<String> sulb = new ArrayList<>(suggestions.subList(0, n));

        SuggestionWrapper sw = new SuggestionWrapper();
        sw.setSuggestions(sulb);
        return sw;
    }

    @RequestMapping(value = "/suggestion2", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public SuggestionWrapper autocompleteSuggestions2(@RequestParam("searchstr2") String searchstr2) {
        System.out.println("searchstr: " + searchstr2);

        ArrayList<String> suggestions = new ArrayList<>();

        for (Zanimanje obj2 : zanimanjeService.findAll()) {
            if (obj2.getNaziv().toLowerCase().contains(searchstr2.toLowerCase())) {
                suggestions.add(new String(obj2.getNaziv()));
            }
        }

        // ogranicavanje predlozene liste za unos na maksimalno 20 elemenata
        int n = suggestions.size() > 20 ? 20 : suggestions.size();
        List<String> sulb = new ArrayList<>(suggestions.subList(0, n));

        SuggestionWrapper sw = new SuggestionWrapper();
        sw.setSuggestions(sulb);
        return sw;
    }

    @RequestMapping(value = "/suggestion3", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public SuggestionWrapper autocompleteSuggestions3(@RequestParam("searchstr3") String searchstr3) {
        System.out.println("searchstr: " + searchstr3);

        ArrayList<String> suggestions = new ArrayList<>();

        for (Firme obj2 : firmeService.findAll()) {
            if (obj2.getNaziv().toLowerCase().contains(searchstr3.toLowerCase())) {
                suggestions.add(new String(obj2.getNaziv()));
            }
        }

        // ogranicavanje predlozene liste za unos na maksimalno 20 elemenata
        int n = suggestions.size() > 20 ? 20 : suggestions.size();
        List<String> sulb = new ArrayList<>(suggestions.subList(0, n));

        SuggestionWrapper sw = new SuggestionWrapper();
        sw.setSuggestions(sulb);
        return sw;
    }

    @RequestMapping(value = "/suggestion4", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public SuggestionWrapper autocompleteSuggestions4(@RequestParam("searchstr4") String searchstr4) {
        System.out.println("searchstr: " + searchstr4);

        ArrayList<String> suggestions = new ArrayList<>();

        for (Rm obj2 : rmService.findAll()) {
            if (obj2.getNaziv().toLowerCase().contains(searchstr4.toLowerCase())) {
                suggestions.add(new String(obj2.getNaziv()));
            }
        }

        // ogranicavanje predlozene liste za unos na maksimalno 20 elemenata
        int n = suggestions.size() > 20 ? 20 : suggestions.size();
        List<String> sulb = new ArrayList<>(suggestions.subList(0, n));

        SuggestionWrapper sw = new SuggestionWrapper();
        sw.setSuggestions(sulb);
        return sw;
    }

}
