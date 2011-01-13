package exploregroovy.basics


class OperatorOverloadTest extends GroovyTestCase {
  void testOperatorOverloading() {
    def lhs = new SupportsOperators("Butch")
    def rhs = new SupportsOperators("Walker")

    assert "You added Butch and Walker" == lhs + rhs
  }

  class SupportsOperators {
    String value

    SupportsOperators(String value) {
      this.value = value
    }

    def plus(rhs) {
      "You added $value and $rhs.value"
    }

    //a + b	 a.plus(b)
    //a - b	 a.minus(b)
    //a * b	 a.multiply(b)
    //a ** b	 a.power(b)
    //a / b	 a.div(b)
    //a % b	 a.mod(b)
    //a | b	 a.or(b)
    //a & b	 a.and(b)
    //a ^ b	 a.xor(b)
    //a++ or ++a	 a.next()
    //a-- or --a	 a.previous()
    //a[b]	 a.getAt(b)
    //a[b] = c	 a.putAt(b, c)
    //a << b	 a.leftShift(b)
    //a >> b	 a.rightShift(b)
    //switch(a) { case(b) : }	 b.isCase(a)
    //~a	 a.bitwiseNegate()
    //-a	 a.negative()
    //+a	 a.positive()
  }
}
