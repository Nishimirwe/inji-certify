package io.mosip.certify.core.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.mosip.certify.core.constants.ErrorConstants;
import io.mosip.certify.core.constants.VCIErrorConstants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class CredentialDefinition {

    @JsonProperty("@context")
    private List<@NotBlank(message = VCIErrorConstants.INVALID_CREDENTIAL_REQUEST) String> context;

    @NotEmpty(message = VCIErrorConstants.INVALID_CREDENTIAL_REQUEST)
    private List<@NotBlank(message = VCIErrorConstants.INVALID_CREDENTIAL_REQUEST) String> type;
}
