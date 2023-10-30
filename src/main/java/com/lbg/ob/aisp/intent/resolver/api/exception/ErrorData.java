package com.lbg.ob.aisp.intent.resolver.api.exception;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeName(value = "error")
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
public class ErrorData {
    private Integer statusCode;

    private String code;

    private String message;

    public ErrorData() {
        //@TODO
    }

    public ErrorData(Integer statusCode, String code, String message) {
        super();
        this.statusCode = statusCode;
        this.code = code;
        this.message = message;
    }

    public ErrorData(String message2) {
        // TODO Auto-generated constructor stub
    }

    @JsonProperty("statusCode")
    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorData [statusCode=" + statusCode + ", code=" + code + ", message=" + message
                + "]";
    }
}