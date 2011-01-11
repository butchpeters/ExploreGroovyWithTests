package exploregroovy.dynamic


class OverrideMethodsAndPropertiesTest extends GroovyTestCase {
  void testOverrideMethod() {
    def cookieMonster = new MyClassDoesAnything()
    assertEquals "I want a COOKIE", cookieMonster.equals(5)
    assertEquals "I want a COOKIE", cookieMonster.biscuit()
    assertEquals "I want a COOKIE", cookieMonster.cookie()
    assertEquals "YUM!", cookieMonster.COOKIE()
  }

  void testOverridePropertyHandling() {
    def flexible = new MyClassDoesAnything();
    flexible.garbage = "some garbage"
    assertEquals "Here: some garbage", flexible.garbage
  }

  void testInterceptorClass() {
    def interceptor = new InterceptorClass()
    assertEquals "Here: Echoing: Hello", interceptor.echo("Hello")
    shouldFail MissingMethodException, {
      interceptor.wtf()
    }
  }

}
