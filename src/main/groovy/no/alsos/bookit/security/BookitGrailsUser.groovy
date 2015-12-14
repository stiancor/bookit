package no.alsos.bookit.security

import grails.plugin.springsecurity.userdetails.GrailsUser
import org.springframework.security.core.GrantedAuthority

class BookitGrailsUser extends GrailsUser {

    final String fullName

    BookitGrailsUser(String username, String password, boolean enabled,
    boolean accountNonExpired, boolean credentialsNonExpired,
    boolean accountNonLocked,
            Collection<GrantedAuthority> authorities,
    long id, String fullName) {
        super(username, password, enabled, accountNonExpired,
                credentialsNonExpired, accountNonLocked, authorities, id)

        this.fullName = fullName
    }
}