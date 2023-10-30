package com.lbg.ob.aisp.intent.resolver.api.domain.model;
 
 
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
 
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
//import com.lbg.ob.aisp.intent.resolver.api.domain.model.cof.CreateCoFConsentRequest;
import com.lbg.ob.aisp.intent.resolver.api.enums.IntentType;
 
 
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"IntentType", "IntentVersion"})
public class IntentRequest {
 
    @NotNull
    @JsonProperty(value = "IntentType", required = true)
    private IntentType intentType;
 
    @NotNull
    @JsonProperty(value = "IntentVersion", required = true)
    private String intentVersion;
   
    @Valid
    @JsonProperty("IntentData")
    private CreateConsentRequest createConsentRequest;
 
    public IntentType getIntentType() {
        return intentType;
    }
 
    public void setIntentType(IntentType intentType) {
        this.intentType = intentType;
    }
 
    public String getIntentVersion() {
        return intentVersion;
    }
 
    public void setIntentVersion(String intentVersion) {
        this.intentVersion = intentVersion;
    }
 
    public CreateConsentRequest getCreateConsentRequest() {
        return createConsentRequest;
    }
 
    public void setCreateConsentRequest(CreateConsentRequest createConsentRequest) {
        this.createConsentRequest = createConsentRequest;
    }
   
}
