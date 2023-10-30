package com.lbg.ob.aisp.intent.resolver.api.services;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.lbg.ob.aisp.intent.resolver.api.domain.model.IntentRequest;
import com.lbg.ob.aisp.intent.resolver.api.domain.model.IntentResponse;
import com.lbg.ob.aisp.intent.resolver.api.domain.model.IntentStatus;

public interface IntentService {

    public IntentResponse createIntent(IntentRequest intentRequest, String xFapiFinancialId, String xFapiCustomerLastLoggedTime, String xFapiCustomerIpAddress,
              String xFapiInteractionId, String xCustomerUserAgent, String xLbgTxnCorrelationId, String xLbgBrand, String xLbgInternalUserRole, String xLbgClientId,
              Boolean xLbgFovIndicator);

    public IntentResponse getIntentDetails(String intentId, String xLbgInternalUserRole, String xLbgTxnCorrelationId, String xLbgFovIndicator,
           String xLbgClientId, String financialId, String interactionId, String obieVersion);

    public IntentResponse updateIntentStatus(IntentStatus intentStatus, String intentId, String correlationID, String internalUserRole, Boolean fovIndicator, String obieVersion);
    
    public void revokeIntent(String intentId, Map<String, String> headersMap, String obieVersion) throws IOException, URISyntaxException, ExecutionException, InterruptedException;

    public IntentResponse getIntentDetailsByIntentIdAndClientId(String intentId, String xLbgInternalUserRole, String xLbgTxnCorrelationId, String xLbgFovIndicator,
            String xLbgClientId, String financialId, String interactionId, String obieVersion);
}
