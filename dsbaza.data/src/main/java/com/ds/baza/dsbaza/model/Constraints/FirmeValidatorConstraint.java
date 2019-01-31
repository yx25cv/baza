package com.ds.baza.dsbaza.model.Constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = FirmeValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface FirmeValidatorConstraint {
    String message() default "Odabrana firma ne postoji u bazi firmi";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
