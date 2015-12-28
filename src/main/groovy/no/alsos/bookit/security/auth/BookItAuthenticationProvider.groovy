package no.alsos.bookit.security.auth

import grails.plugin.springsecurity.authentication.encoding.BCryptPasswordEncoder
import no.alsos.bookit.security.BookitUserDetailsService
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.userdetails.UserDetails

class BookitAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    BookitUserDetailsService bookitUserDetailsService
    BCryptPasswordEncoder passwordEncoder

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        if (!passwordEncoder.isPasswordValid(userDetails.password, authentication.credentials, null))
            throw new BadCredentialsException(messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"), userDetails)
        logger.debug "User $authentication.principal authenticated"
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        bookitUserDetailsService.loadUserByUsername(username)
    }

}
