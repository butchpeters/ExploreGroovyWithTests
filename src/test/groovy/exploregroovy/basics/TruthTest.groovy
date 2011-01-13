package exploregroovy.basics

class TruthTest extends GroovyTestCase {
  void testTruthAndCoercion() {
    assert true
    assert !false

    assert !null
    def undefinedVariable
    assert !undefinedVariable
    def definedVariable = new Object()
    assert definedVariable

    shouldFail MissingPropertyException, {
        assert !unknownVariable
    }

    assert 1
    assert !0

    assert "hi"
    assert !""

    assert ["1", "2"]
    assert ![]

    assert [key: "value"]
    assert ![:]

    def iter = ["1"].iterator()
    assert iter
    iter.next()
    assert !iter

    assert "Hello World" =~ /World/
    assert !("Hello" =~ /World/)
  }
}
