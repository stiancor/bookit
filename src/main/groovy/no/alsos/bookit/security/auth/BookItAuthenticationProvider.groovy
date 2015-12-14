package no.alsos.bookit.security.auth

import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException

class BookitAuthenticationProvider implements  AuthenticationProvider{

    @Override
    Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return null
    }

    @Override
    boolean supports(Class<?> authentication) {
        return false
    }
}
