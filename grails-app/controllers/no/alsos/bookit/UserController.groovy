package no.alsos.bookit

class UserController {

    def userService

    def create() {}

    def insert() {
        log.info("Trying to create new user with email: ${params.email}")
        def pubId = userService.createUser(params.email, params.fullName, params.phone, params.password)
        redirect(action: 'show', id: pubId)
    }

    def show() {
        [result: userService.getUser(params.id)]
    }

}
