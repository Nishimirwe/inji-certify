package io.mosip.certify.core.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;

@Data
public class CredentialResponse<T> {

    /**
     * Contains issued Credentials for immediate issuance.
     * Each credential MAY be a JSON string or a JSON object, depending on the Credential format.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<CredentialWrapper<T>> credentials;

    @Data
    public static class CredentialWrapper<T> {
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private T credential;
    }
}