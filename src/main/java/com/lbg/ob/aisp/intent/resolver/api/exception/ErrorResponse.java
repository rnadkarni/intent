package com.lbg.ob.aisp.intent.resolver.api.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ErrorResponse {

    @JsonProperty("code")
    public String errorCode;

    @JsonProperty("message")
    public String errorMessage;

    public int statusCode;

}