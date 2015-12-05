package no.alsos.bookit

class UserController {

    def userService
    def dbService

    def db

    def create() {}

    def insert() {
        db = dbService.db
        def pubId = userService.createUser(params.email, params.fullName, params.phone, params.password)
        redirect(action: 'show', id: pubId)
    }

    def show() {
        [result: userService.getUser(params.id)]
    }

}
