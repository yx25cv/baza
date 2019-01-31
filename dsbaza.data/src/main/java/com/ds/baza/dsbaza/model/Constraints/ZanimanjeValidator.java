package com.ds.baza.dsbaza.model.Constraints;

import com.ds.baza.dsbaza.model.SrpskaSlava;
import com.ds.baza.dsbaza.model.Zanimanje;
import com.ds.baza.dsbaza.service.SrpskaSlavaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ZanimanjeValidator implements ConstraintValidator<ZanimanjeValidatorConstraint, Zanimanje> {

    private static final Logger logger = LoggerFactory.getLogger(ZanimanjeValidator.class);

    @Autowired
    private SrpskaSlavaService srpskaSlavaService;

    @Override
    public void initialize(ZanimanjeValidatorConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(Zanimanje zanimanjeField, ConstraintValidatorContext context) {
if(zanimanjeField == null) {
    return true;
}
        if(zanimanjeField.getNaziv().equals("")){
            return true;
        } else {
        try {
            if (srpskaSlavaService.findByNaziv(zanimanjeField.getNaziv()) == null) {
                logger.info("prvi log");
                return false;
            }
        } catch (RuntimeException ex) {
            logger.info("drugi log");
            context.buildConstraintViolationWithTemplate("{com.ds.baza.dsbaza.model.Constraints.SrpskaSlavaValidatorConstraint.srpskaslavanepostoji}").addConstraintViolation().disableDefaultConstraintViolation();
            return false;
        }
        return true;
    }}
}

