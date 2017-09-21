package com.simplify.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;


import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class BaseDto implements Serializable {

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
