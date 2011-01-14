package exploregroovy.interfaces

import java.sql.ResultSet

class ClosureAsInterfaceTest extends GroovyTestCase {

  void testJavaInterface_JavaCode() {
    SomeJavaClass javaClass = new SomeJavaClass()
    assert 11 == javaClass.computeWithJavaInterface(javaImpl, 3)
  }

  void testJavaInterface_GroovyCode() {
    SomeGroovyClass groovyClass = new SomeGroovyClass()
    assert 11 == groovyClass.computeWithJavaInterface(javaImpl, 3)
  }

  void testGroovyInterface_JavaCode() {
//    SomeJavaClass javaClass = new SomeJavaClass()
//    assert 11 == javaClass.computeWithGroovyInterface(groovyImpl, 3)
  }

  void testGroovyInterface_GroovyCode() {
    SomeGroovyClass groovyClass = new SomeGroovyClass()
    assert 11 == groovyClass.computeWithGroovyInterface(groovyImpl, 3)
  }

  void testImplementInterfaceWithOneMethod() {
    // implicit compareTo method
    Comparable<Integer> comparable = { Integer o ->
      o == null ? -1 : o.intValue() - 4
    } as Comparable

    assert -1 == comparable.compareTo (3)
    assert 0 == comparable.compareTo(4)
    assert 1 == comparable.compareTo(5)
  }

  void testPartiallyImplementedInterface() {
    ResultSet rs = [
            next: {true},
            getString: {"oh hai"}
    ] as ResultSet

    assert rs.next()
    assert "oh hai" == rs.getString(2)

    shouldFail UnsupportedOperationException, {
      rs.getInt(3)
    }
  }

  // Helpers

  def javaImpl = [
          foo: {
            3
          },

          bar: {
            it + 5
          }
  ] as MyJavaInterface

  def groovyImpl = [
          foo: {
            3
          },

          bar: {
            it + 5
          }
  ] as MyGroovyInterface
}
