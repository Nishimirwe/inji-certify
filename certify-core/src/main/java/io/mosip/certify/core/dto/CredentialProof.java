package io.mosip.certify.core.dto;

import io.mosip.certify.core.constants.VCIErrorConstants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public class CredentialProof {

    @NotNull(message = VCIErrorConstants.INVALID_PROOF)
    private ProofType proofType;

    @NotEmpty(message = VCIErrorConstants.INVALID_PROOF)
    private List<@NotBlank(message = VCIErrorConstants.INVALID_PROOF) String> proofs;

    @Getter
    enum ProofType {
        JWT("jwt");

        private final String value;

        ProofType(String value) {
            this.value = value;
        }
    }
}