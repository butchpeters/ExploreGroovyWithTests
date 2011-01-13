package exploregroovy.dynamic


class DynamicMethodTest extends GroovyTestCase {

  void testDynamicMethodInvocation() {
    def dummyClass = new DummyClass();
    assert "1" == dummyClass."methodOne"()
    def methodName = "methodOne"
    assert "1" == dummyClass."$methodName"()
    def methodPart = "One"
    assert "1" == dummyClass."method$methodPart"()
  }

  void testDynamicMethods_SpreadArguments() {
    def dummyClass = new DummyClass();
    def argList = [1,3,6]
    assert 10 == dummyClass.methodWithArgs(*argList)

    argList = [1,3,6,999]
    shouldFail MissingMethodException, {
      dummyClass.methodWithArgs(*argList)
    }

  }
}
