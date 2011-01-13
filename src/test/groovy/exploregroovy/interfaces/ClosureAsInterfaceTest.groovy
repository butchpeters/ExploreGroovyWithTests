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
    SomeJavaClass javaClass = new SomeJavaClass()
    assert 11 == javaClass.computeWithGroovyInterface(groovyImpl, 3)
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

  void testTryUsingWrongInterfaceInGroovy() {
    try {
      SomeGroovyClass groovyClass = new SomeGroovyClass()
      groovyClass.computeWithGroovyInterface(javaImpl, 3)
      fail "Should have thrown missing method exception"
    } catch (MissingMethodException ex) {
      // expected
    }

//    SomeGroovyClass groovyClass = new SomeGroovyClass()
//    shouldFail MissingMethodException, {
//      groovyClass.computeWithGroovyInterface(javaImpl, 3)
//    }

  }

  void testTryUsingWrongInterfaceInJava() {
    try {
      SomeJavaClass javaClass = new SomeJavaClass()
      javaClass.computeWithGroovyInterface(javaImpl, 3)
      fail "Should have thrown missing method exception"
    } catch (MissingMethodException ex) {
      // expected
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
