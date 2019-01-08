package com.ds.baza.dsbaza.controllers;

import com.ds.baza.dsbaza.model.SrpskaSlava;
import com.ds.baza.dsbaza.service.SrpskaSlavaService;
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

    public AutocompleteController(SrpskaSlavaService srpskaSlavaService) {
        this.srpskaSlavaService = srpskaSlavaService;
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

}
