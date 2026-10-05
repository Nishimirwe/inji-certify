package io.mosip.certify.core.spi;

import io.mosip.certify.core.dto.RenderingTemplateDTO;

public interface RenderingTemplateService {
    RenderingTemplateDTO getTemplate(String id);
}
