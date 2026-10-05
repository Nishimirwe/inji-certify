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
@Constraint(validatedBy = OAuthTokenRequestValidator.class)
@Documented
public @interface ValidOAuthTokenRequest {
    String message() default "Invalid OAuth token request: grant_type must be 'authorization_code' and required fields must be provided";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
