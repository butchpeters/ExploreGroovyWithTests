package exploregroovy.basics

class TruthTest extends GroovyTestCase {
  def __ = "true or false?"
  void testTruthAndCoercion() {
    assert true
    assert !false

    assert (null && true) == __
    def undefinedVariable
    assert (undefinedVariable && true) == __
    def definedVariable = new Object()
    assert (definedVariable && true) == __

    shouldFail MissingPropertyException, {
        assert !unknownVariable
    }

    assert (1 && true) == __
    assert (0 && true) == __

    assert ("hi" && true) == __
    assert ("" && true) == __

    assert (["1", "2"] && true) == __
    assert ([] && true) == __

    assert ([key: "value"] && true) == __
    assert ([:] && true) == __

    def iter = ["1"].iterator()
    assert (iter && true) == __
    iter.next()
    assert (iter && true) == __

    assert (("Hello World" =~ /World/) && true) == __
    assert (("Hello" =~ /World/) && true) == __
  }
}
