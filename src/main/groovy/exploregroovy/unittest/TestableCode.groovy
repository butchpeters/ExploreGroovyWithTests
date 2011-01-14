package exploregroovy.unittest


class TestableCode {
  def testThisMethod(externalDependency, multiplier) {
    def result = externalDependency.computeValue(multiplier)
    "External returned $result"
  }

  def testThisMethod(multiplier) {
    def external = new ExternalDependency(name: "external", input: 50)
    external.anotherMethod()
    testThisMethod(external, multiplier)
  }
}
