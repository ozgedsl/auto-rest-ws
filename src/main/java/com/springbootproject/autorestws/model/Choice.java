package com.springbootproject.autorestws.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
@Data
public class Choice implements Serializable {
    private String text;
    private Integer index;
    @JsonProperty("finish_reason")
    private String finishReason;
}
