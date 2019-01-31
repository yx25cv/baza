package com.ds.baza.dsbaza.model.Constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = RmValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface RmValidatorConstraint {
    String message() default "Odabrano radno mesto ne postoji u bazi radnih mesta";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
