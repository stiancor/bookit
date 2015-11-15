package no.alsos.bookit.db

import datomic.Database
import datomic.Peer
import datomic.Connection

class DbService {

    public static final String DB_URI = "datomic:mem://localhost:4334/bookit"

    Connection getConn() {
        Peer.connect(DB_URI)
    }

    Database getDb() {
        getConn().db()
    }

}
