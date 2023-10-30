package com.lbg.ob.aisp.intent.resolver.api.domain.model;
 
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
 
public final class CreateConsentInputData {
   
  //@MetadataConstraint
    private Map<String, Object> metadata = new HashMap<>();
 
    @JsonAnyGetter
    public Map<String, Object> any() {
        return metadata;
    }
 
    @JsonAnySetter
    public void set(String name, Object value) {
        this.metadata.put(name, value);
    }
 
    @JsonIgnore
    public Map<String, Object> getMetadata() {
        return metadata;
    }
}
