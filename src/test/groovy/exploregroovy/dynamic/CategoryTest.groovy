package exploregroovy.dynamic


class CategoryTest extends GroovyTestCase {
  void testCategories() {
    shouldFail MissingMethodException, {
      "  ".isEmptyOrWhitespace()
    }

    use (StringHelper) {
      assert true == "".isEmptyOrWhitespace()
      assert true == "   ".isEmptyOrWhitespace()
      assert false == "x".isEmptyOrWhitespace()

      shouldFail MissingMethodException, {
        1.isEmptyOrWhitespace()
      }
    }
  }
}
