package io.mosip.certify.core.exception;

public class InvalidRequestException extends CertifyException {

    private String errorCode;

    public InvalidRequestException(String errorCode) {
        super(errorCode);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

}
