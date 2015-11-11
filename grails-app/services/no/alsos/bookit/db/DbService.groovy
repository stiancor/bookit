package no.alsos.bookit.db

import datomic.Database
import datomic.Peer
import datomic.Connection

class DbService {

    public static final String dbUri = "datomic:mem://localhost:4334/bookit"

    Connection getConn() {
        Peer.connect(dbUri)
    }

    Database getDb() {
        getConn().db()
    }

}
