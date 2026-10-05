package io.mosip.certify.core.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ResponseWrapper<T> {

    private String responseTime;
    private T response;
    private List<java.lang.Error> errors = new ArrayList<>();
}
