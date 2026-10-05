package io.mosip.certify.core.exception;

import io.mosip.certify.core.constants.ErrorConstants;

public class NotAuthenticatedException extends CertifyException {

    public NotAuthenticatedException() {
        super(ErrorConstants.INVALID_AUTH_TOKEN);
    }

    public NotAuthenticatedException(String errorCode) {
        super(errorCode);
    }
}
