package io.mosip.certify.core.dto;

public class OAuthTokenError extends ErrorResponse {
    
    public OAuthTokenError() {
        super();
    }
    
    public OAuthTokenError(String error, String errorDescription) {
        super();
        setError(error);
        setErrorDescription(errorDescription);
    }
}
