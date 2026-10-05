package io.mosip.certify.core.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = IarValidator.class)
@Documented
public @interface ValidIar {
	String message() default "Invalid IAR request: provide either (auth_session and openid4vp_response) or initial authorization parameters";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
