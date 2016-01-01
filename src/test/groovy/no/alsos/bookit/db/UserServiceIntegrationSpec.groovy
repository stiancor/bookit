package no.alsos.bookit.db

import grails.test.mixin.integration.Integration
import spock.lang.Specification

@Integration
class UserServiceIntegrationSpec extends Specification {

    def userService

    void "user is added to database"() {
        given: "user is created"
        def publicId = userService.createUser('test@test.com', 'Alice', '123', 'password')

        when: "user is fetched from db"
        def user = userService.getUser(publicId.toString())

        then: "user exists and has values"
        user.get(':user/email') == 'test@test.com'
        user.get(':user/fullName') == 'Alice'
        user.get(':user/phone') == '123'
        user.get(':user/password') != null
    }
}
