package com.lbg.ob.aisp.intent.resolver.api.controller;

import com.lbg.ob.aisp.intent.resolver.api.domain.model.IntentRequest;
import com.lbg.ob.aisp.intent.resolver.api.testData.IntentResolverControllerTest;
import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.*;

import com.lbg.ob.aisp.intent.resolver.api.constants.IntentConstants;
import com.lbg.ob.aisp.intent.resolver.api.domain.model.IntentResponse;
import com.lbg.ob.aisp.intent.resolver.api.services.IntentService;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.*;

import java.util.Map;


@Path(value = "/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class IntentResolverController {
    private static final Logger logger = Logger.getLogger(IntentResolverController.class);
    private IntentService intentService;

    @POST
    @Path(value = "/intents")
    public RestResponse<IntentResponse> postCreateIntent(IntentRequest intentRequest,
                                                           @RestHeader(value = IntentConstants.X_FAPI_FINANCIAL_ID)
                                                           @NotBlank(message = "Financial id is missing") final String xFapiFinancialId,
                                                           @RestHeader(value = IntentConstants.X_FAPI_CUSTOMER_LAST_LOGGED_TIME) final String xFapiCustomerLastLoggedTime,
                                                           @RestHeader(value = IntentConstants.X_FAPI_CUSTOMER_IP_ADDRESS) final String xFapiCustomerIpAddress,
                                                           @RestHeader(value = IntentConstants.X_FAPI_INTERACTION_ID) final String xFapiInteractionId,
                                                           @RestHeader(value = IntentConstants.X_CUSTOMER_USER_AGENT) final String xCustomerUserAgent,
                                                           @RestHeader(value = IntentConstants.X_LBG_TXN_CORRELATION_ID)
                                                           @NotBlank(message = "Co-relation id is missing") final String xLbgTxnCorrelationId,
                                                           @RestHeader(value = IntentConstants.X_LBG_BRAND) String xLbgBrand,
                                                           @RestHeader(value = IntentConstants.X_LBG_INTERNAL_USER_ROLE)
                                                           @NotNull(message = "Internal User role is missing") final String xLbgInternalUserRole,
                                                           @RestHeader(value = IntentConstants.X_LBG_CLIENT_ID)
                                                                             @NotBlank(message = "Client id is missing") final String xLbgClientId,
                                                           @RestHeader(value = IntentConstants.X_LBG_FOV_INDICATOR) final Boolean xLbgFovIndicator){

        logger.info("POST Intent Request Entry ----> ");


        //IntentRequest intentRequest = new IntentRequest();
        //IntentResponse intentResponse = intentService.createIntent(intentRequest, xFapiFinancialId, xFapiCustomerLastLoggedTime, xFapiCustomerIpAddress, xFapiInteractionId, xCustomerUserAgent, xLbgTxnCorrelationId, xLbgBrand, xLbgInternalUserRole, xLbgClientId, xLbgFovIndicator);

        IntentResolverControllerTest test = new IntentResolverControllerTest();
        RestResponse<IntentResponse> build = test.createIntent(intentRequest, xFapiFinancialId, xFapiCustomerLastLoggedTime, xFapiCustomerIpAddress, xFapiInteractionId, xCustomerUserAgent, xLbgTxnCorrelationId, xLbgBrand, xLbgInternalUserRole, xLbgClientId, xLbgFovIndicator);

        /*if (intentResponse != null) {
            Response.status(Response.Status.OK);
        } else {
            Response.status(Response.Status.INTERNAL_SERVER_ERROR);
        }

         */
        logger.info("POST Intent Request Exit ----> ");
        return build;

        //return RestResponse.ResponseBuilder.create(Response.Status.OK,intentResponse);

    }


    @GET
    @Path(value="/intents/{intentId}")
    public RestResponse<IntentResponse> getIntent(
            @PathParam(value = IntentConstants.INTENTID) String intentId,
            @RestHeader(value = IntentConstants.X_LBG_INTERNAL_USER_ROLE) 
            @NotNull(message = "Internal User role is missing") final String xLbgInternalUserRole,
            @RestHeader(value = IntentConstants.X_LBG_TXN_CORRELATION_ID)
            @NotBlank(message = "Co-relation id is missing") final String xLbgTxnCorrelationId,
            @RestHeader(value = IntentConstants.X_LBG_FOV_INDICATOR) final String xLbgFovIndicator,
            @RestHeader(value = IntentConstants.X_LBG_CLIENT_ID) final String xLbgClientId,
            @RestHeader(value = IntentConstants.X_FAPI_FINANCIAL_ID) final String financialId,
            @RestHeader(value = IntentConstants.X_FAPI_INTERACTION_ID) final String interactionId,
            @RestQuery(value = IntentConstants.OBIEVERSION) final String obieVersion){
 
        logger.info("GET Intent Request Entry ----> ");

        IntentResolverControllerTest test = new IntentResolverControllerTest();
        RestResponse<IntentResponse> build = test.getIntentDetails(intentId,xLbgInternalUserRole,xLbgTxnCorrelationId,xLbgFovIndicator,xLbgClientId,financialId,interactionId,obieVersion);





        //IntentResponse intentResponse = intentService.getIntentDetails(intentId, xLbgInternalUserRole, xLbgTxnCorrelationId, xLbgFovIndicator, xLbgClientId, financialId, interactionId,obieVersion);
       // if (intentResponse != null) {
                //responseStatus = HttpStatus.OK;
         //       Response.status(Response.Status.OK);
           // }
            logger.info("GET Intent Request Exit ----> ");
            return build;

        
 
    }


    @DELETE
    @Path(value = "/intents/{intentId}")
    public RestResponse<Void> deleteIntentForIntentId(
            @RestHeader(value = IntentConstants.X_LBG_INTERNAL_USER_ROLE)
            @NotNull(message = "Internal User role is missing") final String xLbgInternalUserRole,
            @RestHeader(value = IntentConstants.X_LBG_TXN_CORRELATION_ID)
            @NotBlank(message = "Co-relation id is missing") final String xLbgTxnCorrelationId,
            @RestHeader(value = IntentConstants.X_LBG_CLIENT_ID)
            @NotBlank(message = "Client id is missing") final String xLbgClientId,
            @RestHeader(value = IntentConstants.X_FAPI_FINANCIAL_ID)
            @NotBlank(message = "Financial id is missing") final String xFapiFinancialId,
            @RestHeader(value = IntentConstants.X_FAPI_INTERACTION_ID) final String interactionId,
            @RestHeader(value = IntentConstants.X_LBG_FOV_INDICATOR) final Boolean fovIndicator,
            @PathParam(IntentConstants.INTENTID) final String intentId,
            @RestQuery(value = IntentConstants.OBIEVERSION) final String obieVersion)  {


        logger.trace("ENTRY --> deleteIntentForIntentId" + intentId);

        IntentResolverControllerTest test = new IntentResolverControllerTest();
        RestResponse build = test.deleteIntent(intentId);


       /* if (!StringUtils.isEmpty(interactionId)) {
            response.setHeader(IntentConstants.X_FAPI_INTERACTION_ID, interactionId);
        }
        Map<String, String> headersMap = headers.toSingleValueMap();
        Map<String, String> headersTreeMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        headersTreeMap.putAll(headersMap);
        intentService.revokeIntent(intentId, headersTreeMap, obieVersion);*/

        logger.trace("EXIT --> deleteIntentForIntentId");
        return build;
        //return new ResponseEntity<>(null,HttpStatus.OK);

    }


}
