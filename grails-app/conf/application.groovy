// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.password.algorithm = 'bcrypt'
//grails.plugin.springsecurity.userLookup.userDomainClassName = 'no.alsos.bookit.User'
//grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'no.alsos.bookit.UserRole'
//grails.plugin.springsecurity.authority.className = 'no.alsos.bookit.Role'
grails.plugins.springsecurity.providerNames = ['bookitAuthenticationProvider','anonymousAuthenticationProvider','rememberMeAuthenticationProvider' ]
grails.plugin.springsecurity.securityConfigType = "InterceptUrlMap"
grails.plugin.springsecurity.interceptUrlMap = [
		[pattern: '/',               access: ['permitAll']],
		[pattern: '/user/**',	     access: ['permitAll']],
		[pattern: '/error',          access: ['permitAll']],
		[pattern: '/index',          access: ['permitAll']],
		[pattern: '/index.gsp',      access: ['permitAll']],
		[pattern: '/shutdown',       access: ['permitAll']],
		[pattern: '/assets/**',      access: ['permitAll']],
		[pattern: '/**/js/**',       access: ['permitAll']],
		[pattern: '/**/css/**',      access: ['permitAll']],
		[pattern: '/**/images/**',   access: ['permitAll']],
		[pattern: '/**/favicon.ico', access: ['permitAll']],
		[pattern: '/login',          access: ['permitAll']],
		[pattern: '/login/**',       access: ['permitAll']],
		[pattern: '/logout',         access: ['permitAll']],
		[pattern: '/logout/**',      access: ['permitAll']]
]