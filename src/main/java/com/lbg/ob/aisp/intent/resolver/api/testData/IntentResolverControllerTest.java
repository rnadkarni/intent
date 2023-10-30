package com.lbg.ob.aisp.intent.resolver.api.testData;


//import com.lbg.ob.aisp.intent.resolver.api.domain.*;
import com.lbg.ob.aisp.intent.resolver.api.domain.model.IntentRequest;
import com.lbg.ob.aisp.intent.resolver.api.domain.model.IntentResponse;
import com.lbg.ob.aisp.intent.resolver.api.enums.IntentType;
import com.lbg.ob.aisp.intent.resolver.api.exception.ErrorData;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.RestResponse;

public class IntentResolverControllerTest {
    private static final Logger logger = Logger.getLogger(IntentResolverControllerTest.class);

    public RestResponse createIntent(IntentRequest intentRequest, String xFapiFinancialId, String xFapiCustomerLastLoggedTime, String xFapiCustomerIpAddress,
                                                     String xFapiInteractionId, String xCustomerUserAgent, String xLbgTxnCorrelationId, String xLbgBrand, String xLbgInternalUserRole, String xLbgClientId,
                                                     Boolean xLbgFovIndicator){
        if (intentRequest.getIntentType()!=null && IntentType.COF.toString().equals(intentRequest.getIntentType().toString())){
            IntentResponse response = new IntentResponse();
            logger.info("Successfully inserted COF intents into database");
            response.setIntentId("123");
            response.setIntentType(IntentType.COF);
            response.setIntentVersion(intentRequest.getIntentVersion());
            response.setIntentData(intentRequest.getCreateConsentRequest());

            return RestResponse.status(Response.Status.ACCEPTED,response);
        }
        else if (intentRequest.getIntentType()!=null && IntentType.AISP.toString().equals(intentRequest.getIntentType().toString())){
            IntentResponse response = new IntentResponse();
            logger.info("Successfully inserted AISP intents into database");
            response.setIntentId("123");
            response.setIntentType(IntentType.AISP);
            response.setIntentVersion(intentRequest.getIntentVersion());
            response.setIntentData(intentRequest.getCreateConsentRequest());

            return RestResponse.status(Response.Status.ACCEPTED,response);
        }
        else{
            ErrorData errorResponse = new ErrorData();
            errorResponse.setCode("Error Code 404");
            errorResponse.setMessage("Invalid intent");
            errorResponse.setStatusCode(404);
            return RestResponse.status(Response.Status.BAD_REQUEST,errorResponse);
        }
    }


    public RestResponse getIntentDetails(String intentId, String xLbgInternalUserRole, String xLbgTxnCorrelationId, String xLbgFovIndicator,
                                                         String xLbgClientId, String financialId, String interactionId, String obieVersion){
        IntentResponse response = new IntentResponse();
        if (intentId!=null && !intentId.equals("err")) {
            if (intentId.equals("123")) {
                logger.info("Getting intent ID of IntentType AISP");
                response.setIntentId(intentId.toString());
                response.setIntentType(IntentType.AISP);
                response.setIntentVersion("v3.0");
                //response.setIntentData(new String());

                return RestResponse.status(Response.Status.ACCEPTED, response);
            } else {
                logger.info("Getting intent ID of IntentType COF ");
                response.setIntentId(intentId.toString());
                response.setIntentType(IntentType.COF);
                response.setIntentVersion("v3.0");
                //response.setIntentData("COF Intent");

                return RestResponse.status(Response.Status.ACCEPTED, response);
            }
        }
        else{
            ErrorData errorResponse = new ErrorData();
            errorResponse.setCode("Error Code 404");
            errorResponse.setMessage("Cannot get intent");
            errorResponse.setStatusCode(404);
            return RestResponse.status(Response.Status.BAD_REQUEST,errorResponse);
        }


    }



    public RestResponse deleteIntent(String intentId){
        //IntentResponse response = new IntentResponse();
        if (intentId==null || intentId.equals("12345")){
            logger.info("Error deleting intent ID");
            ErrorData errorResponse = new ErrorData();
            errorResponse.setCode("Error Code 404");
            errorResponse.setMessage("Cannot get intent for deletion");
            errorResponse.setStatusCode(404);
            return RestResponse.status(Response.Status.BAD_REQUEST,errorResponse);
        }
        logger.info("Deleting intent ID...");
        return RestResponse.status(Response.Status.OK);

    }



}
