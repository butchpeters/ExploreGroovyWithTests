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

    assert 5 == myDouble.abs()
    assert 5 == absValue(myDouble)
  }

  void testDynamic_MetaClass() {
    Double.metaClass.butch = "dynamicProperty"
    assert "dynamicProperty" == Double.valueOf(5).butch
  }
}