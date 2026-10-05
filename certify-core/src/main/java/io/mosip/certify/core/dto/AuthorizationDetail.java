package io.mosip.certify.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Authorization Detail DTO for OpenID4VCI specification
 * Represents a single authorization detail in the authorization_details array
 */
@Data
@NoArgsConstructor
public class AuthorizationDetail {

    /**
     * Type of authorization detail - typically "openid_credential"
     */
    @JsonProperty("type")
    private String type;

    /**
     * Credential configuration identifier
     */
    @JsonProperty("credential_configuration_id")
    private String credentialConfigurationId;
}
