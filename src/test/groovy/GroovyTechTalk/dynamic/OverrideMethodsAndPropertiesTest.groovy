package GroovyTechTalk.dynamic


class OverrideMethodsAndPropertiesTest extends GroovyTestCase {
  class MyClassDoesAnything implements GroovyInterceptable {
    def invokeMethod(String name, args) {
      if (name != "COOKIE") {
        return "I want a COOKIE"
      } else {
        return "YUM!"
      }
    }

    def propertyMap = [:];

    def getProperty(String name) {
      "Here: $propertyMap[name]"
    }

    void setProperty(String name, value) {
      propertyMap[name] = value
    }
  }

  void testOverrideMethod() {
    def cookieMonster = new MyClassDoesAnything()
    assertEquals "I want a COOKIE", cookieMonster.equals(5)
    assertEquals "I want a COOKIE", cookieMonster.biscuit()
    assertEquals "I want a COOKIE", cookieMonster.cookie()
    assertEquals "YUM!", cookieMonster.COOKIE()
  }

  class InterceptorClass implements GroovyInterceptable {

    def invokeMethod(String name, args) {
        def metaMethod = metaClass.getMetaMethod(name, args)
        if (metaMethod == null) {
          throw new MissingMethodException(name, InterceptorClass, args)
        }

        //println "Beginning $name"
        System.out.println ("Beginning $name")

        def result = metaMethod.invoke(this, args)
        System.out.println ("Completed $name")
        "Here: $result"
    }

    def echo(arg) {
      arg
    }
  }

  void testInterceptorClass() {
    def interceptor = new InterceptorClass()
    assertEquals "Here: Hello", interceptor.echo("Hello")
    shouldFail MissingMethodException, {
      interceptor.wtf()
    }
  }

}
