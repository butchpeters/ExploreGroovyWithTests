package exploregroovy.basics


class SafeNavigationTest extends GroovyTestCase {
  def personA = [name: "Butch Peters", techTalks: ["Neo4j", "Groovy", "Grails"]]
  def personB = [name: "Butch Walker", albums: ["Letters", "Sycamore Meadows", "I Liked it Better When You Had No Heart"]]

  void testSafeNavigation() {
    shouldFail NullPointerException, {
      personB.techTalks.size()
    }

    assert personB.techTalks?.size() == null
  }

  void testElvisOperator() {
    def techTalkCounter = { person ->
      person.techTalks?.size() ?: 0
    }
    assert 3 == techTalkCounter(personA)
    assert 0 == techTalkCounter(personB)
  }
}
