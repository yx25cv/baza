package com.ds.baza.dsbaza.model.Constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MlbValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface MlbValidatorConstraint {
    String message() default "Jmbg ne valja";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

