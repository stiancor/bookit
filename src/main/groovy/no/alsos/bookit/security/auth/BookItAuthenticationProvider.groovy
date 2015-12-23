package no.alsos.bookit.security.auth

import no.alsos.bookit.db.UserService
import no.alsos.bookit.security.BookitUserDetailsService
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.userdetails.UserDetails

class BookitAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    UserService userService
    BookitUserDetailsService bookitUserDetailsService

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        if(userDetails.password != userService.encodePassword(authentication.credentials))
            throw new BadCredentialsException(messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials"), userDetails)
        logger.debug "User $authentication.principal authenticated"
    }

//    @Override
//    Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        println('##############')
//        def map = userService.findByEmail(authentication.principal)
//        if (map.isEmpty() || map.get(':user/password') != userService.encodePassword(authentication.credentials))
//            throw AuthenticationException('Could not log in with ' + authentication.principal)
//        authentication
//    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        bookitUserDetailsService.loadUserByUsername(username)
    }

}
