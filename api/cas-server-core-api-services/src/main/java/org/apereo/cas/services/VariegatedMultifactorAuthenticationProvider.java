package org.apereo.cas.services;

import java.util.Collection;

/**
 * This is {@link VariegatedMultifactorAuthenticationProvider}.
 * Provides multiple instances of the same provider.
 *
 * @author Misagh Moayyed
 * @since 5.1.0
 *
 * @deprecated as of 5.3.4, use {@link MultifactorAuthenticationProviderFactory} to provide multiple instances
 * of multifactor authentication providers.  This interface will be removed in the next 6.0 major release
 */
@Deprecated
public interface VariegatedMultifactorAuthenticationProvider extends MultifactorAuthenticationProvider {

    /**
     * Add provider.
     *
     * @param provider the provider
     */
    void addProvider(MultifactorAuthenticationProvider provider);

    /**
     * Gets providers.
     *
     * @return the providers
     */
    Collection<MultifactorAuthenticationProvider> getProviders();

    /**
     * Find multifactor authentication provider.
     *
     * @param identifier the identifier
     * @return the multifactor authentication provider
     */
    MultifactorAuthenticationProvider findProvider(String identifier);

    /**
     * Find provider .
     *
     * @param <T>        the type parameter
     * @param identifier the identifier
     * @param clazz      the clazz
     * @return the provider
     */
    <T extends MultifactorAuthenticationProvider> T findProvider(String identifier, Class<T> clazz);

}
