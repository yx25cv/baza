package com.ds.baza.dsbaza.model.Constraints;

import com.ds.baza.dsbaza.service.LicniPodaciService;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

//public class JmbgControllerValidator implements Validator {
//
//    private LicniPodaciService licniPodaciService;
//
//    public JmbgControllerValidator(LicniPodaciService licniPodaciService) {
//        this.licniPodaciService = licniPodaciService;
//    }
//
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return LicniPodaciService.class.equals(clazz);
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        ValidationUtils.rejectIfEmpty(errors, "mlb", "mlb.empty", "JMBG je prazan");
//        LicniPodaciService u = (LicniPodaciService) target;
//        licniPodaciService.
//    }
//}
