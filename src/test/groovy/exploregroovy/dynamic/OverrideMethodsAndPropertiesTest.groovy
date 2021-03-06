package exploregroovy.dynamic


class OverrideMethodsAndPropertiesTest extends GroovyTestCase {
  def __ = "What do you expect?"

  void testOverrideMethod() {
    def cookieMonster = new MyClassDoesAnything()
    assert "I want a COOKIE" == cookieMonster.equals(5)
    assert "I want a COOKIE" == cookieMonster.biscuit()
    assert "I want a COOKIE" == cookieMonster.cookie()
    assert "YUM!" == cookieMonster.COOKIE()
  }

  void testOverridePropertyHandling() {
    def flexible = new MyClassDoesAnything();
    flexible.garbage = "some garbage"
    assert "Here: some garbage" == flexible.garbage
  }

  void testInterceptorClass() {
    def interceptor = new InterceptorClass()
    assert __ == interceptor.echo("Hello")
    shouldFail MissingMethodException, {
      interceptor.wtf()
    }
  }

}
