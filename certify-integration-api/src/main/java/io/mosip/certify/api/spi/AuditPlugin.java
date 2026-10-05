package io.mosip.certify.api.spi;

import io.mosip.certify.api.dto.AuditDTO;
import io.mosip.certify.api.util.Action;
import io.mosip.certify.api.util.ActionStatus;

public interface AuditPlugin {

    /**
     + Plugin method to audit all the actions in certify service.
     +
     +  @param action Action to audit @{@link Action}
     +  @param actionStatus Action status to audit @{@link ActionStatus}
     +  @param audit @{@link AuditDTO} during this action
     +  @param t Any error / exception occurred during this action, null if no errors / exception found.
     */
    void logAudit(Action action, ActionStatus status, AuditDTO audit, Throwable t);

    /**
    + Plugin method to audit all the actions in certify service.
    +
    +  @param username Session username for audit
    +  @param action Action to audit @{@link Action}
    +  @param actionStatus Action status to audit @{@link ActionStatus}
    +  @param audit @{@link AuditDTO} during this action
    +  @param t Any error / exception occurred during this action, null if no errors / exception found.
    */
	void logAudit(String username, Action action, ActionStatus status, AuditDTO audit, Throwable t);
}
