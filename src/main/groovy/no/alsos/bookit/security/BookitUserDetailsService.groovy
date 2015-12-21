package no.alsos.bookit.security

import grails.plugin.springsecurity.SpringSecurityUtils
import grails.plugin.springsecurity.userdetails.GrailsUserDetailsService
import grails.plugin.springsecurity.userdetails.NoStackUsernameNotFoundException
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException

class BookitUserDetailsService implements GrailsUserDetailsService {

    def userService

    /**
     * Some Spring Security classes (e.g. RoleHierarchyVoter) expect at least
     * one role, so we give a user with no granted roles this one which gets
     * past that restriction but doesn't grant anything.
     */
    static final List NO_ROLES = [new SimpleGrantedAuthority(SpringSecurityUtils.NO_ROLE)]

    UserDetails loadUserByUsername(String username, boolean loadRoles)
            throws UsernameNotFoundException {
        return loadUserByUsername(username)
    }

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        def user = userService.findByEmail(username)
        if (user.get(':user/email') != username) throw new NoStackUsernameNotFoundException()

        def authorities = user.authorities.collect {
            new SimpleGrantedAuthority(it.authority)
        }

        return new BookitGrailsUser(user.get(':user/email'), user.get(':user/password'), user.get(':user/enabled'),
                user.get(':user/accountExpired'), user.get(':user/passwordExpired'),
                user.get(':user/accountLocked'), authorities ?: NO_ROLES, user.get(':user/publicId'),
                user.get(':user/fullName'))
    }
}
