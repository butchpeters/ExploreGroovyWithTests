package exploregroovy.transform


class ImmutableTest extends GroovyTestCase {
  void testImmutable() {
    shouldFail {
      def colorless = new Color()
    }

    def fuchsia = new Color(red: 255, blue: 255)
    assert !fuchsia.getGreen()

    def white = new Color(255, 255, 255)

    shouldFail {
      white.setRed(250)
    }

    shouldFail {
      white.red = 250
    }
  }
}
