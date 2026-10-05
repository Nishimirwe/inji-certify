package io.mosip.certify.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuditDTO {

    String transactionId;
    String clientId;
    String idType;
}
