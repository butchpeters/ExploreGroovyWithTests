package exploregroovy.transform


class SingletonTest extends GroovyTestCase {
  void testSingleton() {
    def manager = ConnectionManager.getInstance()
    def conn = manager.createConnection("myConn")

    shouldFail {
      def m2 = new ConnectionManager()
    }

    assert manager.is(ConnectionManager.getInstance())
    assert conn.is(ConnectionManager.getInstance().connections["myConn"])
  }
}
