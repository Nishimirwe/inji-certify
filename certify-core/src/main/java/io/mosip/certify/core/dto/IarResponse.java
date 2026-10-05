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
public class IarResponse {

    /**
     * Status of the authorization request
     * - "require_interaction": Interaction is required (OpenID4VP presentation)
     * - "complete": Authorization is complete, no interaction needed
     */
    @JsonProperty("status")
    private IarStatus status;
}
