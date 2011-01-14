package exploregroovy.dynamic

class MissingMethodTest extends GroovyTestCase {
  void testMissingMethod() {
    def echoChamber = new DynamicEcho()

    shouldFail MissingMethodException, {
      echoChamber.helloButch()
    }

    assert "Butch" == echoChamber.echoButch()
  }

}
