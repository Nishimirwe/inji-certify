package io.mosip.certify.proof;

import io.mosip.certify.core.constants.ErrorConstants;
import io.mosip.certify.core.exception.CertifyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProofValidatorFactory {

    @Autowired
    private List<ProofValidator> proofValidators;

    public ProofValidator getProofValidator(String proofType) {
       return proofValidators.stream()
                .filter(v -> v.getProofType().equals(proofType))
                .findFirst()
                .orElseThrow(
                        () -> new CertifyException(ErrorConstants.UNSUPPORTED_PROOF_TYPE, "The proof type " + proofType + " is not supported."));
    }
}
