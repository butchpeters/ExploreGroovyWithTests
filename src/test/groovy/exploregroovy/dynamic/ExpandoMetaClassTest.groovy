package exploregroovy.dynamic


class ExpandoMetaClassTest extends GroovyTestCase {
  void testExpandClassFunctionality() {
    def stringBeforeChange = "before"
    String.metaClass.capitalize = {->
      delegate.toUpperCase()
    }
    assertEquals "BEFORE", stringBeforeChange.capitalize()
    assertEquals "AFTER", "after".capitalize()
  }

  void testExpandClassStaticFunctionality() {
    String.metaClass.static.chuckNorris = {
      "Chuck Norris destroyed $it!"
    }

    assertEquals "Chuck Norris destroyed polio!", String.chuckNorris("polio")
  }

  void testExpandClassConstructor() {
    String.metaClass.constructor = { List input ->
      new String(input.head())
    }

    assertEquals "first", new String(["first", "second", "third"])
  }

  void testExpandClassMethodOverloading() {
    String.metaClass.static.valueOf = { List input ->
      println "In here for list"
      String.valueOf(input.head())
    }

    assertEquals "first", String.valueOf(["first", "second", "third"])
    assertEquals "5", String.valueOf(Long.valueOf(5))
  }

  void testExpandClassMethodOverriding() {
    String.metaClass.static.valueOf = { long l -> "No long for you!" }

    assertEquals "1", String.valueOf(1i)
    assertEquals "No long for you!", String.valueOf(1l)
  }
}
