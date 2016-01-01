package no.alsos.bookit.db

import datomic.Database
import datomic.Peer
import datomic.Connection

class DbService {

    def grailsApplication

    Connection getConn() {
        Peer.connect(grailsApplication.config.getProperty('db.url'))
    }

    Database getDb() {
        getConn().db()
    }

}
