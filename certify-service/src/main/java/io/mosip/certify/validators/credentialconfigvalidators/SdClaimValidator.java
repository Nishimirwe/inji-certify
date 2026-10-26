package io.mosip.certify.validators.credentialconfigvalidators;

import io.mosip.certify.core.constants.ErrorConstants;
import io.mosip.certify.core.exception.CertifyException;
import io.mosip.certify.utils.SDJsonUtils;
import org.apache.commons.codec.binary.Base64;

/**
 * Validates the selective disclosure paths configured in {@code sdClaim} when a dc+sd-jwt credential
 * configuration is added or updated. Other formats do not use {@code sdClaim}, so they are not checked.
 */
public class SdClaimValidator {

    private SdClaimValidator() {
    }

    /**
     * @param sdClaim the comma separated paths as configured, or null when the configuration declares no
     *                selective disclosure
     * @throws CertifyException with {@link ErrorConstants#INVALID_SD_CLAIM} for the first entry that is
     *                          blank or not a well formed selective disclosure path
     */
    public static void validateSdClaim(String sdClaim) {
        if (sdClaim == null) {
            return;
        }
        // The -1 limit keeps trailing empty entries. A plain split(",") reads "$.fullName," as one valid
        // path and "," as no paths at all, so both would pass.
        for (String entry : sdClaim.split(",", -1)) {
            if (entry.isBlank()) {
                throw new CertifyException(ErrorConstants.INVALID_SD_CLAIM,
                        "The sdClaim '" + sdClaim + "' contains a blank entry.");
            }
            if (!SDJsonUtils.isPathSyntaxValid(entry)) {
                throw new CertifyException(ErrorConstants.INVALID_SD_CLAIM,
                        "The sdClaim entry '" + entry.trim() + "' is not a valid selective disclosure path,"
                                + " such as $.fullName, $.address.region, $.phoneNumbers[0] or $.phoneNumbers[*].");
            }
        }
    }

    /**
     * Each path must be declared in the template the credential is rendered from, or VC fetch fails it for
     * every holder. Run after {@link #validateSdClaim(String)}, so a malformed entry is reported first. Only
     * the field names are compared: whether the data has the shape a path expects, such as an array for
     * [*], still needs a rendered credential, so that stays at VC fetch.
     *
     * @param sdClaim    the comma separated paths as configured, or null when the configuration declares no
     *                   selective disclosure
     * @param vcTemplate the base64 encoded template, as the configuration stores it
     * @throws CertifyException with {@link ErrorConstants#INVALID_SD_CLAIM} for the first path the template
     *                          does not declare
     */
    public static void validateSdClaimInTemplate(String sdClaim, String vcTemplate) {
        if (sdClaim == null || vcTemplate == null) {
            return;
        }
        // Decoded as VelocityTemplatingEngineImpl.getTemplate does, so this agrees with the check at VC fetch.
        String template = new String(Base64.decodeBase64(vcTemplate));
        for (String entry : sdClaim.split(",", -1)) {
            String path = entry.trim();
            // The root names no field, so there is nothing to look up. VC fetch accepts it.
            if (path.equals("$")) {
                continue;
            }
            if (!SDJsonUtils.isPathInTemplate(template, path)) {
                throw new CertifyException(ErrorConstants.INVALID_SD_CLAIM,
                        "The sdClaim entry '" + path + "' is not declared in the vcTemplate.");
            }
        }
    }
}
