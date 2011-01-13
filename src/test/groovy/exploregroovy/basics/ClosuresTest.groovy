package exploregroovy.basics


class ClosuresTest extends GroovyTestCase {
  void testWhatIsAClosure() {
    def closure = {
      "from closure"
    }

    assert "from closure" == closure()
  }

  void testClosureCanTakeArguments() {
    def closure = { arg1, arg2 ->
      "from closure $arg1 $arg2"
    }

    assert "from closure hello there" == closure("hello", "there")
  }

  void testClosureDefaultArgument() {
    def closure = {
      "Echo: $it"
    }

    assert "Echo: Hello" == closure("Hello")
  }

  void testClosureVariablesBoundToScopeAtDefinition() {
    def closure = closureBuilder()
    assert "Butch" == closure()
  }

  void testClosureWithCurriedArguments() {
    def closure = {arg1, arg2 ->
      arg1 + arg2
    }

    def curried = closure.curry(7)
    assert 12 == curried(5)

    curried = closure.curry(7, 5)
    assert 12 == curried()
  }

  void testClosureWhatIsThis() {
    def closure = {
      this
    }

    assert this.is(closure())

    def otherClass = new SomeOtherClass()
    assert this.is(otherClass.validateClosure(closure))

    def outerClosure = {
      def innerClosure = {
        this
      }
      innerClosure()
    }

    assert this.is(outerClosure())
  }

  void testClosureWhatIsOwner() {
    def closure = {
      owner
    }

    assert this.is(closure())

    def otherClass = new SomeOtherClass()
    assert this.is(otherClass.validateClosure(closure))

    def outerClosure = {
      def innerClosure = {
        owner
      }
      innerClosure()
    }

    assert outerClosure.is(outerClosure())
  }

  void testClosureThisAndOwnerAreReadOnly() {
    def x = "Who me?"
    def closure = {
      "Hiya"
    }

    shouldFail MissingPropertyException, {
      closure.owner = x
    }

    shouldFail MissingPropertyException, {
      closure.thisObject = x
    }
  }

  void testClosureWhatIsDelegate() {
    def closure = {
      delegate
    }

    assert this.is(closure())

    def otherClass = new SomeOtherClass()
    assert this.is(otherClass.validateClosure(closure))

    def outerClosure = {
      def innerClosure = {
        delegate
      }
      innerClosure.delegate = owner
      innerClosure()
    }

    assert this.is(outerClosure())
  }

  void testJavaCanRunMyClosureToo() {
    def closure = {
      "Echo: $it"
    }

    def javaClass = new JavaClosureHelper()
    assert "Echo: Hello", javaClass.runClosure(closure)
  }

  // Helpers
  def closureBuilder() {
    def localVariable = "Butch"
    def closure = {
      localVariable
    }
    closure
  }

  class SomeOtherClass {
    def validateClosure(closure) {
      closure()
    }
  }
}
