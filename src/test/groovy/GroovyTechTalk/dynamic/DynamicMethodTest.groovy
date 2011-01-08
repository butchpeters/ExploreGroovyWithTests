package GroovyTechTalk.dynamic


class DynamicMethodTest extends GroovyTestCase {
  class MyClass {
    def methodOne() {
      "1"
    }

    def methodTwo() {
      "2"
    }

    def methodWithArgs(arg1, arg2, arg3) {
      arg1 + arg2 + arg3
    }
  }

  void testDynamicMethodInvocation() {
    def myClass = new MyClass();
    assertEquals "1", myClass."methodOne"()
    def methodName = "methodOne"
    assertEquals "1", myClass."$methodName"()
    def methodPart = "One"
    assertEquals "1", myClass."method$methodPart"()
  }

  void testDynamicMethods_SpreadArguments() {
    def myClass = new MyClass();
    def argList = [1,3,6]
    assertEquals 10, myClass.methodWithArgs(*argList)

    argList = [1,3,6,999]
    shouldFail MissingMethodException, {
      myClass.methodWithArgs(*argList)
    }

  }
}
