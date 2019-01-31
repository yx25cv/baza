package com.ds.baza.dsbaza.model.Constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ZanimanjeValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ZanimanjeValidatorConstraint {
    String message() default "Odabrano zanimanje ne postoji u bazi zanimanja";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
