package no.alsos.bookit.db

import datomic.Peer

class RoleService {

    def dbService

    def create(String roleName) {
        def pubId = Peer.squuid()
        dbService.conn.transact([[
                                         ':db/id'         : Peer.tempid(":db.part/user"),
                                         ':role/authority': roleName
                                 ]]).get()
        pubId
    }
}
