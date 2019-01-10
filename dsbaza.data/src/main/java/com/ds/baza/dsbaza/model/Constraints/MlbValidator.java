package com.ds.baza.dsbaza.model.Constraints;



import com.ds.baza.dsbaza.service.LicniPodaciService;
import com.ds.baza.dsbaza.service.SrpskaSlavaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
;

import javax.validation.*;

public class MlbValidator implements ConstraintValidator<MlbValidatorConstraint, String> {

    private static final Logger logger = LoggerFactory.getLogger(MlbValidator.class);

    @Autowired
    private LicniPodaciService licniPodaciService;


    @Override
    public void initialize(MlbValidatorConstraint mlb) {

    }

    public static boolean validacija(String jmbg) {
        if (jmbg.length() != 13) {
            return true;
        }
        int proracun = (11 - ((7 * (jmbg.charAt(0) - '0' + jmbg.charAt(6) - '0') +
                6 * (jmbg.charAt(1) - '0' + jmbg.charAt(7) - '0') +
                5 * (jmbg.charAt(2) - '0' + jmbg.charAt(8) - '0') +
                4 * (jmbg.charAt(3) - '0' + jmbg.charAt(9) - '0') +
                3 * (jmbg.charAt(4) - '0' + jmbg.charAt(10) - '0') +
                2 * (jmbg.charAt(5) - '0' + jmbg.charAt(11) - '0')))) % 11;
        if (proracun != 0) {

            if (proracun + 11 == jmbg.charAt(12) - '0') {
                logger.info("Vrednsot proracuna je {}", proracun);
                logger.info("vrednost stringa je {}", jmbg.charAt(12) - '0');
                logger.info("Sada sam u prvom if-u");
                //provera = true;
                return false;
            }
        }
        if (proracun == jmbg.charAt(12) - '0') {
            logger.info("Vrednsot proracuna je {}", proracun);
            logger.info("vrednost stringa je {}", jmbg.charAt(12) - '0');
            logger.info("Sada sam u drgom if-u");
            //provera = true;
            return false;


        }
        return true;
    }


    @Override
    public boolean isValid(String mlbField, ConstraintValidatorContext context) {

        if (validacija(mlbField)) {
            context.buildConstraintViolationWithTemplate("JMBG nije ispravanććć")
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
            return false;
        }

        try {if (licniPodaciService.findByMlb(mlbField) != null) {
            context.buildConstraintViolationWithTemplate( "{com.ds.baza.dsbaza.model.Constraints.MlbValidatorConstraint.jmbgnepostoji}").addConstraintViolation().disableDefaultConstraintViolation();
            return false;
        } } catch (RuntimeException ex) {
            return true;
        }
        return true;
    }
}

