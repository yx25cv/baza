package com.ds.baza.dsbaza.repository;

import com.ds.baza.dsbaza.model.LicniPodaci;
import org.springframework.data.repository.CrudRepository;

public interface LicniPodaciRepository extends CrudRepository<LicniPodaci, Long> {

    LicniPodaci findByMlb(String jmbg);
    LicniPodaci findByIme(String name);


}
