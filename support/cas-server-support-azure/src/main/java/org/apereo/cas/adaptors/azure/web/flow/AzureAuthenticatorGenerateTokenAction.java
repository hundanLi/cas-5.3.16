package org.apereo.cas.adaptors.azure.web.flow;

import org.apereo.cas.adaptors.azure.AzureAuthenticatorTokenCredential;
import org.apereo.cas.configuration.model.support.mfa.AzureMultifactorProperties;
import org.apereo.cas.util.RandomUtils;
import org.apereo.cas.web.support.WebUtils;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.webflow.action.AbstractAction;
import org.springframework.webflow.action.EventFactorySupport;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

/**
 * This is {@link AzureAuthenticatorGenerateTokenAction}.
 *
 * @author Misagh Moayyed
 * @since 5.1.0
 */
@Slf4j
@AllArgsConstructor
public class AzureAuthenticatorGenerateTokenAction extends AbstractAction {
    private final AzureMultifactorProperties.AuthenticationModes mode;

    @Override
    public Event doExecute(final RequestContext requestContext) {
        final Integer code = Integer.valueOf(RandomUtils.randomNumeric(8));
        final AzureAuthenticatorTokenCredential c = new AzureAuthenticatorTokenCredential();
        c.setToken(code.toString());
        WebUtils.putCredential(requestContext, c);
        requestContext.getFlowScope().put("azureToken", code);

        if (mode == AzureMultifactorProperties.AuthenticationModes.POUND) {
            return new EventFactorySupport().event(this, "authenticate");
        }
        return success();
    }
}
