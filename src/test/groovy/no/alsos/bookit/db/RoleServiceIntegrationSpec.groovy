package no.alsos.bookit.db

import grails.test.mixin.integration.Integration
import spock.lang.Specification

@Integration
class RoleServiceIntegrationSpec extends Specification {

    def roleService
    def dbService

    void "role is added to database"() {
        given: "role is created"
        def roleName = 'TEST_ROLE'
        roleService.create(roleName)

        when: "role is fetched from db"
        def role = dbService.db.entity([':role/authority', roleName])

        then: "role exists in db"
        role.get(':role/authority').first() == roleName
    }
}
