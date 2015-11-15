import datomic.Peer
import datomic.Util

import static no.alsos.bookit.db.DbService.DB_URI

class BootStrap {

    def init = { servletContext ->
        Peer.createDatabase(DB_URI)
        def conn = Peer.connect(DB_URI)
        def schemaRdr = new InputStreamReader(this.class.classLoader.getResourceAsStream("migrations/bookit-schema.edn"))
        List schemaTx = Util.readAll(schemaRdr).get(0)
        conn.transact(schemaTx).get()
    }

    def destroy = {
    }
}
