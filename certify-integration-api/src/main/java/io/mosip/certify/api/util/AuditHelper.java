package io.mosip.certify.api.util;


import io.mosip.certify.api.dto.AuditDTO;

public class AuditHelper {

    public static AuditDTO buildAuditDto(String clientId) {
        AuditDTO auditDTO = new AuditDTO();
        auditDTO.setClientId(clientId);
        auditDTO.setTransactionId(clientId);
        auditDTO.setIdType("ClientId");
        return auditDTO;
    }

    public static AuditDTO buildAuditDto(String transactionId, String idType) {
        AuditDTO auditDTO = new AuditDTO();
        auditDTO.setTransactionId(transactionId);
        auditDTO.setIdType(idType);
        return auditDTO;
    }
}
