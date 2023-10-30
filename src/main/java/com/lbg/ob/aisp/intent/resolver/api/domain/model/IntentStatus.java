package com.lbg.ob.aisp.intent.resolver.api.domain.model;
 
import javax.validation.constraints.NotNull;
 
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lbg.ob.aisp.intent.resolver.api.enums.Status;
 
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IntentStatus {
 
    @NotNull
    private Status status;
   
    private Long entitlementId;
   
    private String entitlementAccessCode;
 
    @JsonProperty("Status")
    public Status getStatus() {
        return status;
    }
 
    public void setStatus(Status status) {
        this.status = status;
    }
 
    @JsonProperty("EntitlementId")
                public Long getEntitlementId() {
                                return entitlementId;
                }
 
                public void setEntitlementId(Long entitlementId) {
                                this.entitlementId = entitlementId;
                }
 
                @JsonProperty("EntitlementAccessCode")
                public String getEntitlementAccessCode() {
                                return entitlementAccessCode;
                }
 
                public void setEntitlementAccessCode(String entitlementAccessCode) {
                                this.entitlementAccessCode = entitlementAccessCode;
                }
   
}