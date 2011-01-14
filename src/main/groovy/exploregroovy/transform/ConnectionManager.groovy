package exploregroovy.transform

@Singleton(lazy =  true)
class ConnectionManager {
  Map connections = [:]

  def createConnection(name) {
    def conn = new Object()

    connections.put name, conn
    conn
  }
}
