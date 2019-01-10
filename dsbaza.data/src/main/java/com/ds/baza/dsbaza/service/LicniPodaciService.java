package com.ds.baza.dsbaza.service;

import com.ds.baza.dsbaza.model.LicniPodaci;

import java.util.Set;

public interface LicniPodaciService extends CrudService<LicniPodaci, Long> {

    LicniPodaci findByMlb(String jmbg);
}
