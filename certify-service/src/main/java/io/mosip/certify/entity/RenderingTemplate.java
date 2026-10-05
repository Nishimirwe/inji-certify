package io.mosip.certify.entity;

import io.mosip.certify.core.constants.ErrorConstants;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rendering_template")
public class RenderingTemplate {
    @Id
    private String id;

    @NotBlank(message = ErrorConstants.EMPTY_TEMPLATE_CONTENT)
    @Column(name = "template")
    private String template;

    @Column(name = "cr_dtimes")
    private LocalDateTime createdtimes;

    @Column(name = "upd_dtimes")
    private LocalDateTime updatedtimes;
}
