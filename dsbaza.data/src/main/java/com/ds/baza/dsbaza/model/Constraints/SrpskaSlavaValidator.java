package com.ds.baza.dsbaza.model.Constraints;

import com.ds.baza.dsbaza.model.SrpskaSlava;
import com.ds.baza.dsbaza.service.SrpskaSlavaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.*;

public class SrpskaSlavaValidator implements ConstraintValidator<SrpskaSlavaValidatorConstraint, SrpskaSlava> {

    private static final Logger logger = LoggerFactory.getLogger(SrpskaSlavaValidator.class);

    @Autowired
    private SrpskaSlavaService srpskaSlavaService;

    @Override
    public void initialize(SrpskaSlavaValidatorConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(SrpskaSlava srpskaSlavaField, ConstraintValidatorContext context) {

        if(srpskaSlavaField.getNaziv()==""){
            return true;
        } else {
        try {
            if (srpskaSlavaService.findByNaziv(srpskaSlavaField.getNaziv()) == null) {
                logger.info("prvi log");
                return false;
            }
        } catch (RuntimeException ex) {
            logger.info("drugi log");
            context.buildConstraintViolationWithTemplate("{com.ds.baza.dsbaza.model.Constraints.SrpskaSlavaValidatorConstraint.srpskaslavanepostoji}").addConstraintViolation().disableDefaultConstraintViolation();
            return true;
        }
        return true;
    }}
}

