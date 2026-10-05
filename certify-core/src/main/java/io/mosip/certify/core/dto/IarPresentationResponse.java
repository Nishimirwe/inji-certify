package io.mosip.certify.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.mosip.certify.core.constants.IarStatus;
import io.mosip.certify.core.constants.InteractionType;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Interactive Authorization Response (IAR) DTO for OpenID4VCI
 * Response from POST /iae endpoint
 */
@Data
@NoArgsConstructor
public class IarPresentationResponse extends IarResponse{

    /**
     * Type of interaction required
     * - "urn:openid:dcp:iae:openid4vp_presentation": OpenID4VP presentation required
     */
    @JsonProperty("type")
    private InteractionType type;

    /**
     * Authorization session identifier for tracking the auth flow
     */
    @JsonProperty("auth_session")
    private String authSession;

    /**
     * OpenID4VP request details when interaction is required
     * Using Object to handle dynamic structure from Verify service
     */
    @JsonProperty("openid4vp_request")
    private Object openid4vpRequest;
}
