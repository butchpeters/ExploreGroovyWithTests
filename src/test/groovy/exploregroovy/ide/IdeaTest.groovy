package exploregroovy.ide


class IdeaTest extends GroovyTestCase {
  def absValue(value) {
    value.abs()
  }

  def absValueExplicit(Double value) {
    value.abs()
  }

  void testDynamic_Basic() {
    def myDouble = Double.valueOf(-5)

    assertEquals 5, myDouble.abs()
    assertEquals 5, absValue(myDouble)
  }

  void testDynamic_MetaClass() {
    Double.metaClass.butch = "dynamicProperty"
    assertEquals "dynamicProperty", Double.valueOf(5).butch
  }
}