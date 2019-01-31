package com.ds.baza.dsbaza.model.Constraints;

import com.ds.baza.dsbaza.model.Firme;
import com.ds.baza.dsbaza.model.Rm;
import com.ds.baza.dsbaza.service.FirmeService;
import com.ds.baza.dsbaza.service.RmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RmValidator implements ConstraintValidator<RmValidatorConstraint, Rm> {

    private static final Logger logger = LoggerFactory.getLogger(RmValidator.class);

    @Autowired
    private RmService rmService;

    @Override
    public void initialize(RmValidatorConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(Rm rmField, ConstraintValidatorContext context) {
        if (rmField == null) {
            return true;
        }
        if (rmField.getNaziv().equals("")) {
            return true;
        } else {
            try {
                if (rmService.findByNaziv(rmField.getNaziv()) == null) {
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

