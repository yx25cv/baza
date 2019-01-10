package com.ds.baza.dsbaza.model.Constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = SrpskaSlavaValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface SrpskaSlavaValidatorConstraint {
    String message() default "Odabrana slava ne postoji u bazi slava";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
