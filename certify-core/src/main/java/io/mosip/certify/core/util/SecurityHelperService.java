package io.mosip.certify.core.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SecurityHelperService {

    public String generateSecureRandomString(int length) {
        //TODO
        return CommonUtil.generateRandomAlphaNumeric(length);
    }
}
