package com.ds.baza.dsbaza.repository;

import com.ds.baza.dsbaza.model.LicniPodaci;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface LicniPodaciRepository extends PagingAndSortingRepository<LicniPodaci, Long> {

    LicniPodaci findByMlb(String jmbg);
    LicniPodaci findByIme(String name);
    //Optional<LicniPodaci> findById (int id);


}
