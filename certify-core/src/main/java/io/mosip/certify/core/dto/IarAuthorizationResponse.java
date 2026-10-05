package io.mosip.certify.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.mosip.certify.core.constants.IarStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Interactive Authorization Response DTO for OpenID4VCI
 * Response from POST /iae endpoint for Verifiable Presentation submission
 */
@Data
@NoArgsConstructor
public class IarAuthorizationResponse extends IarResponse{

    /**
     * OAuth 2.0 authorization code (if status is "ok")
     */
    @JsonProperty("code")
    private String code;

}