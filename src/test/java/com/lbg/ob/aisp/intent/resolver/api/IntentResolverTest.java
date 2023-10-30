package com.lbg.ob.aisp.intent.resolver.api;

import com.lbg.ob.aisp.intent.resolver.api.controller.IntentResolverController;
import com.lbg.ob.aisp.intent.resolver.api.domain.model.IntentRequest;
import com.lbg.ob.aisp.intent.resolver.api.enums.IntentType;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;


@QuarkusTest
public class IntentResolverTest {

    @Inject
    IntentResolverController controller;

    String fapiId = "test";
    String last_logged = "22:07:00";
    String address = "NA";
    String user_agent = "abc";
    String fapiInteractionId = "testInteractionId";
    String correlationId = "testCorrId";
    String brand = "LYDS";
    String internalUserRole = "SYSTEM";
    String clientId = "testClient";
    Boolean fovIndicator = false;
    String fovIndicator1 = "false";
    String obieVersion = "3.0.0";
    String intentID1 = "456";
    String intentID2 = "123";
    String intentID3 = "12345";


    @Test
    public void post_COF(){
        IntentRequest intentRequest = new IntentRequest();
        intentRequest.setIntentType(IntentType.COF);
        intentRequest.setIntentVersion("v3.0");
        controller.postCreateIntent(intentRequest,fapiId,last_logged,address,fapiInteractionId,user_agent,correlationId,brand,internalUserRole,clientId,fovIndicator);
    }

    @Test
    public void post_AISP(){
        IntentRequest intentRequest = new IntentRequest();
        intentRequest.setIntentType(IntentType.AISP);
        intentRequest.setIntentVersion("v3.0");
        controller.postCreateIntent(intentRequest,fapiId,last_logged,address,fapiInteractionId,user_agent,correlationId,brand,internalUserRole,clientId,fovIndicator);

    }

    @Test
    public void get_COF(){
        controller.getIntent(intentID1,internalUserRole,correlationId,fovIndicator1,clientId,fapiId,fapiInteractionId,obieVersion);
    }

    @Test
    public void get_AISP(){
        controller.getIntent(intentID2,internalUserRole,correlationId,fovIndicator1,clientId,fapiId,fapiInteractionId,obieVersion);
    }

    @Test
    public void delete_intent_error(){
        controller.deleteIntentForIntentId(internalUserRole,correlationId,clientId,fapiId,fapiInteractionId,fovIndicator,intentID3,obieVersion);
    }

    @Test
    public void delete_intent(){
        controller.deleteIntentForIntentId(internalUserRole,correlationId,clientId,fapiId,fapiInteractionId,fovIndicator,intentID1,obieVersion);
    }


}
