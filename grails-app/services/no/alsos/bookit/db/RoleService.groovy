package no.alsos.bookit.db

import datomic.Peer

class RoleService {

    def dbService

    def create(String roleName) {
        dbService.conn.transact([[
                                         ':db/id'         : Peer.tempid(":db.part/user"),
                                         ':role/authority': roleName
                                 ]]).get()
    }

    def addRole(String userPublicId, role) {
        def userId = Peer.query("[:find ?id . :where [?id :user/publicId ?publicId]]", dbService.db, UUID.fromString(userPublicId))
        dbService.conn.transact([[':db/id': userId, ':user/role': [':role/authority': role]]]).get()
    }
}
