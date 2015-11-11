package bookit

import datomic.Peer

class TestController {

    def dbService

    def index() {
        def datom = ["db/add", Peer.tempid("db.part/user"),
                     "db/doc", "Good morning Vietnam!"]
        dbService.conn.transact([datom])
    }

}


