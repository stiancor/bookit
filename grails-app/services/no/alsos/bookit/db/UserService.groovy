package no.alsos.bookit.db

import datomic.Peer

class UserService {

    def dbService
    def springSecurityService

    def createUser(String username, String fullName, String phone, String password) {
        def pubId = Peer.squuid()
        dbService.conn.transact([[
                                         ':db/id'        : Peer.tempid(":db.part/user"),
                                         ':user/publicId': pubId,
                                         ':user/email'   : username,
                                         ':user/password': encodePassword(password),
                                         ':user/fullName': fullName,
                                         ':user/phone'   : phone,
                                         ':user/enabled' : true   ]]).get()
        pubId
    }

    def getUser(String id) {
        def entityId = Peer.q("[:find ?e :in \$ ?publicId :where [?e :user/publicId ?publicId]]", dbService.db, UUID.fromString(id)).iterator().next().get(0)
        dbService.db.entity(entityId)
    }

    def findUser(String email) {
        def entityId = Peer.q("[:find ?e :in \$ ?email :where [?e :user/email ?email]]", dbService.db, email).iterator().next().get(0)
        dbService.db.entity(entityId)
    }

    def updateUser(String userId, String fullName, String phone) {
        dbService.conn.transact([[':db/id'        : userId,
                                  ':user/fullName': fullName,
                                  ':user/phone'   : phone]])
    }

    def changePassword(String userId, String password) {
        dbService.conn.transact([[':db/id'        : userId,
                                  ':user/password': encodePassword(password)]])
    }

    protected String encodePassword(String password) {
        springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
    }

}
