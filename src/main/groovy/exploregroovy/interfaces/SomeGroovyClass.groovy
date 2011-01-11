package exploregroovy.interfaces

class SomeGroovyClass {
  def computeWithJavaInterface(MyJavaInterface x, int arg) {
    x.foo() + x.bar(arg)
  }

  def computeWithGroovyInterface(MyGroovyInterface x, int arg) {
    x.foo() + x.bar(arg)
  }
}
