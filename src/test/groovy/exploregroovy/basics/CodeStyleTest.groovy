package exploregroovy.basics


class CodeStyleTest extends GroovyTestCase {
  void testSemicolonsOptional() {
    assert true == true;
    assert true == true
    assert false == false
  }

  void testParensOptional() {
    assertTrue true
  }

  void testParensOptionalSorta() {
    def x = Integer.valueOf(1) // must use parens on rhs
    assertEquals x, Integer.valueOf(1) // must use parens in nested method calls
  }

  def testUseGroovyAssertOrJunitAssert() {
    def hello = "hellogrumble"
    def world = "worldgrumble"
    def grumble = "grumble"

//    assertEquals "hello, world!", "${hello-grumble}, ${world-grumble}"
//    assert "hello, world!" == "${hello-grumble}, ${world-grumble}"
//    assert "hello, world!" == methodThatLikelyDoesTheWorkForYou(hello, world, grumble)
  }

  void testReturnKeywordOptional() {
    assert "Butch" == methodReturnsAValue()

    assert "Butch" == methodWithIfElseReturnsDifferentValues(true)
    assert "Brian" == methodWithIfElseReturnsDifferentValues(false)

    assert "Brian" == methodWithIfDoesNotImplicitlyReturn(true)
    assert "Brian" == methodWithIfDoesNotImplicitlyReturn(false)
  }

  void testDefAndTypes() {
    def a = "Hello" // Dynamic Type: Preferred
    String b = "Hello" // Static Type: Less preferred, maybe slower? http://groovy.codehaus.org/Runtime+vs+Compile+time,+Static+vs+Dynamic
    def String c = "Hello" // Redundant, idiotic, don't do it

    assert a == b && b == c
  }

  void testBoilerplateBeanCtorAndMethods() {
    def b = new BoilerplateBean(name: "Butch Peters", age: 30)
    assert "Butch Peters" == b.getName()
    b.setAge(31)
    assert 31 == b.getAge()
  }

  void testVisibility() {
    def v = new VisibilityHelper()
    assert "dude" == v.getValue()
    shouldFail MissingMethodException, {
      v.getHiddenValue()
    }
    assert "69" == v.hiddenValue
  }

  void testValidationByAssert() {
    shouldFail Error, {
      AssertHelper.methodWithValidation null, "hi"
    }

    try {
      AssertHelper.methodWithValidation null, "hi"
    } catch (Error e) {
      assert "arg1 must not be blank. Expression: arg1. Values: arg1 = null" == e.getMessage()
    }

    shouldFail Error, {
      AssertHelper.methodWithValidation "hi", "hi"
    }

    assert "yay" == AssertHelper.methodWithValidation("hi", "hello")
  }

  // Helpers
  def methodReturnsAValue() {
    "Butch"
  }

  def methodWithIfElseReturnsDifferentValues(arg) {
    if (arg) {
      "Butch"
    } else {
      "Brian"
    }
  }

  def methodWithIfDoesNotImplicitlyReturn(arg) {
    if (arg) {
      "Butch"
    }
    "Brian"
  }

  def methodThatLikelyDoesTheWorkForYou(hello, world, grumble) {
    "${hello-grumble}, ${world-grumble}"
  }
}
