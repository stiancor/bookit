package no.alsos.bookit.db

import datomic.Peer

class UserService {

    def dbService
    def springSecurityService

    def createUser(String username, String fullName, String phone, String password) {
        def pubId = Peer.squuid()
        dbService.conn.transact([[
                                         ':db/id'               : Peer.tempid(":db.part/user"),
                                         ':user/publicId'       : pubId,
                                         ':user/email'          : username,
                                         ':user/password'       : encodePassword(password),
                                         ':user/fullName'       : fullName,
                                         ':user/phone'          : phone,
                                         ':user/enabled'        : true,
                                         ':user/accountExpired' : false,
                                         ':user/passwordExpired': false,
                                         ':user/accountLocked'  : false,
                                         ':user/role'           : [':role/authority': 'ROLE_USER']
                                 ]]).get()
        pubId
    }

    def getUser(String id) {
        dbService.db.entity([':user/publicId', UUID.fromString(id)])
    }

    def findByEmail(String email) {
        dbService.db.entity([':user/email', email]) ?: [:]
    }

    def addRole(String userPublicId, role) {
        def userId = Peer.query("[:find ?id . :where [?id :user/publicId ?publicId]]", dbService.db, UUID.fromString(userPublicId))
        dbService.conn.transact([[':db/id': userId, ':user/role': [':role/authority': role]]]).get()
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

    String encodePassword(String password) {
        springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
    }

}
