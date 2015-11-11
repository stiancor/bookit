// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'no.alsos.bookit.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'no.alsos.bookit.UserRole'
grails.plugin.springsecurity.authority.className = 'no.alsos.bookit.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	'/*':                ['permitAll'],
	'/error':           ['permitAll'],
	'/index':           ['permitAll'],
	'/index.gsp':       ['permitAll'],
	'/shutdown':        ['permitAll'],
	'/assets/**':       ['permitAll'],
	'/**/js/**':        ['permitAll'],
	'/**/css/**':       ['permitAll'],
	'/**/images/**':    ['permitAll'],
	'/**/favicon.ico':  ['permitAll']
]