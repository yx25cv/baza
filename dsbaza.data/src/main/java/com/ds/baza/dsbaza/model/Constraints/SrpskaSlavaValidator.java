package com.ds.baza.dsbaza.model.Constraints;

import com.ds.baza.dsbaza.model.SrpskaSlava;
import com.ds.baza.dsbaza.service.SrpskaSlavaService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.*;

public class SrpskaSlavaValidator implements ConstraintValidator<SrpskaSlavaValidatorConstraint, SrpskaSlava> {

    @Autowired
    private SrpskaSlavaService srpskaSlavaService;

    @Override
    public void initialize(SrpskaSlavaValidatorConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(SrpskaSlava srpskaSlavaField, ConstraintValidatorContext context) {

        try{if(srpskaSlavaService.findByNaziv(srpskaSlavaField.getNaziv())!=null) {
            return true;
        }}catch (RuntimeException ex) {
            context.buildConstraintViolationWithTemplate( "{com.ds.baza.dsbaza.model.Constraints.MlbValidatorConstraint.srpskaslavanepostoji}").addConstraintViolation().disableDefaultConstraintViolation();
            return false;
        }
        return false;
    }
}
