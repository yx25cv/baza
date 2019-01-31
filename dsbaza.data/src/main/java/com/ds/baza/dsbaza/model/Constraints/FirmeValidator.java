package com.ds.baza.dsbaza.model.Constraints;

import com.ds.baza.dsbaza.model.Firme;
import com.ds.baza.dsbaza.model.SrpskaSlava;
import com.ds.baza.dsbaza.service.FirmeService;
import com.ds.baza.dsbaza.service.SrpskaSlavaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FirmeValidator implements ConstraintValidator<FirmeValidatorConstraint, Firme> {

    private static final Logger logger = LoggerFactory.getLogger(FirmeValidator.class);

    @Autowired
    private FirmeService firmeService;

    @Override
    public void initialize(FirmeValidatorConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(Firme firmeField, ConstraintValidatorContext context) {
        if (firmeField == null) {
            return true;
        }
        if (firmeField.getNaziv().equals("")) {
            return true;
        } else {
            try {
                if (firmeService.findByNaziv(firmeField.getNaziv()) == null) {
                    logger.info("prvi log");
                    //context.buildConstraintViolationWithTemplate("{com.ds.baza.dsbaza.model.Constraints.SrpskaSlavaValidatorConstraint.srpskaslavanepostoji}").addConstraintViolation().disableDefaultConstraintViolation();
                    return false;
                }
            } catch (RuntimeException ex) {
                logger.info("drugi log");
                context.buildConstraintViolationWithTemplate("{com.ds.baza.dsbaza.model.Constraints.SrpskaSlavaValidatorConstraint.srpskaslavanepostoji}").addConstraintViolation().disableDefaultConstraintViolation();
                return true;
            }
            return true;
        }
    }
}

