package com.lbg.ob.aisp.intent.resolver.api.domain.model;
 
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.lbg.ob.aisp.intent.resolver.api.enums.IntentType;
 
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"IntentId", "IntentType", "IntentVersion", "IntentData"})
public class IntentResponse {
 
 
    @JsonProperty("IntentId")
    private String intentId;
 
    @JsonProperty("IntentType")
    private IntentType intentType;
 
    @JsonProperty("IntentVersion")
    private String intentVersion;
   
    @JsonProperty("IntentData")
    private Object intentData;
 
 
    public String getIntentId() {
        return intentId;
    }
 
    public void setIntentId(String intentId) {
        this.intentId = intentId;
    }
 
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
 
    public Object getIntentData() {
                                return intentData;
                }


                public void setIntentData(Object intentData) {
                                this.intentData = intentData;
                }

}
