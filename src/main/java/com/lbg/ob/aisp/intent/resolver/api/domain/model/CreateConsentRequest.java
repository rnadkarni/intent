package com.lbg.ob.aisp.intent.resolver.api.domain.model;
 
import java.util.HashMap;
import java.util.Map;
 
import javax.validation.Valid;
 
import com.fasterxml.jackson.annotation.JsonProperty;
 
public class CreateConsentRequest {
    @Valid
    private CreateConsentInputData createConsentInputData;
   
    private Map<String, Object> risk = new HashMap<>();
 
    @JsonProperty("Data")
    public CreateConsentInputData getCreateConsentInputData() {
        return createConsentInputData;
    }
 
    public void setCreateCosentInputData(CreateConsentInputData createConsentInputData) {
        this.createConsentInputData = createConsentInputData;
    }
 
    @JsonProperty("Risk")
    public Map<String, Object> getRisk() {
        return risk;
    }
 
    public void setRisk(Map<String, Object> risk) {
        this.risk = risk;
    }
   
}
 
 