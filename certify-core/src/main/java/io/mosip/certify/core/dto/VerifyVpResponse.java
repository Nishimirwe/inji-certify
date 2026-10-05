package io.mosip.certify.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Response DTO from Verify Service VP Request endpoint
 * Contains the generated VP request details
 */
@Data
@NoArgsConstructor
public class VerifyVpResponse {

    @JsonProperty("transactionId")
    private String transactionId;

    @JsonProperty("requestId")
    private String requestId;

    @JsonProperty("authorizationDetails")
    private AuthorizationDetails authorizationDetails;

    @JsonProperty("expiresAt")
    private Long expiresAt;

    @Data
    @NoArgsConstructor
    public static class AuthorizationDetails {
        @JsonProperty("clientId")
        private String clientId;

        @JsonProperty("dcqlQuery")
        private Object dcqlQuery;

        @JsonProperty("nonce")
        private String nonce;

        @JsonProperty("responseUri")
        private String responseUri;

        @JsonProperty("responseType")
        private String responseType;

        @JsonProperty("responseMode")
        private String responseMode;

        @JsonProperty("issuedAt")
        private Long issuedAt;
    }
}
