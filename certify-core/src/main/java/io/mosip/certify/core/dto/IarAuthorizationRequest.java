package io.mosip.certify.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;

/**
 * Interactive Authorization Request DTO for OpenID4VCI
 * Used for POST /iae endpoint to submit Verifiable Presentation response
 */
@Data
@NoArgsConstructor
public class IarAuthorizationRequest {

    /**
     * Authorization session identifier from initial IAR response
     */
    @NotBlank(message = "auth_session is required")
    @JsonProperty("auth_session")
    private String authSession;

    /**
     * OpenID4VP presentation response (unencrypted or encrypted JWT)
     */
    @NotBlank(message = "openid4vp_presentation is required")
    @JsonProperty("openid4vp_presentation")
    private String openid4vpPresentation;
}
