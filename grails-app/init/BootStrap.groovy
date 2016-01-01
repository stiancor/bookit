import datomic.Peer
import datomic.Util

class BootStrap {

    def roleService
    def grailsApplication

    def init = { servletContext ->
        String dbUrl = grailsApplication.config.getProperty('db.url')
        Peer.createDatabase(dbUrl)
        def conn = Peer.connect(dbUrl)
        def schemaRdr = new InputStreamReader(this.class.classLoader.getResourceAsStream("migrations/bookit-schema.edn"))
        List schemaTx = Util.readAll(schemaRdr).get(0)
        conn.transact(schemaTx).get()

        roleService.create('ROLE_USER')
        roleService.create('ROLE_BETA')
        roleService.create('ROLE_ADMIN')
    }

    def destroy = {
    }
}
