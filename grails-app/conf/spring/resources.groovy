import no.alsos.bookit.security.BookitUserDetailsService
import no.alsos.bookit.security.auth.BookitAuthenticationProvider

// Place your Spring DSL code here
beans = {
    userDetailsService(BookitUserDetailsService) {
        userService = ref('userService')
    }

    bookitAuthenticationProvider(BookitAuthenticationProvider) {

    }
}
