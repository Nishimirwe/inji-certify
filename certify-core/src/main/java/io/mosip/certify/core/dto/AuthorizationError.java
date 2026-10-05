package io.mosip.certify.core.dto;

public class AuthorizationError extends ErrorResponse {
    
    public AuthorizationError() {
        super();
    }
    
    public AuthorizationError(String error, String errorDescription) {
        super();
        setError(error);
        setErrorDescription(errorDescription);
    }
}
