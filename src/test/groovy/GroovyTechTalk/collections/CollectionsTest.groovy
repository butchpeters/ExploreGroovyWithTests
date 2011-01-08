package GroovyTechTalk.collections

class CollectionsTest extends GroovyTestCase {

  void testLists() {
    def list = ["a", 2, Double.valueOf(3)]
    assertEquals 2, list.get(1)
    assertEquals 2, list[1]
    assertTrue list instanceof java.util.List
    assertEquals 3, list.size()
    list.add("4")
    assertEquals "4", list.last()
  }

  void testListOperators() {

  }
}
