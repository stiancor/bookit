import datomic.Peer
import no.alsos.bookit.db.DbService

class BootStrap {

    def init = { servletContext ->
        Peer.createDatabase(DbService.dbUri)
    }

    def destroy = {
    }
}
