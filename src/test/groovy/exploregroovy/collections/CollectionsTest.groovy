package exploregroovy.collections

class CollectionsTest extends GroovyTestCase {

  void testLists() {
    def list = ["a", 2, Double.valueOf(3)]
    assertEquals 2, list.get(1)
    assertEquals 2, list[1]
    assertTrue list instanceof java.util.List
    assertEquals 3, list.size()
    list.add("4")
    assertEquals "4", list.last()
    list << "fifth"
    assertEquals "fifth", list.last()
  }

  void testArrays() {
    def array1 = [1, 2, 3]
    assertTrue array1 instanceof java.util.List

    int[] array2 = [1, 2, 3]
    assertTrue array2 instanceof int[]
    assertFalse array2 instanceof java.util.List

    array1 << 4
    assertEquals 4, array1[3]

    shouldFail MissingMethodException, {
      array2 << 4
    }
  }

  void testSets() {
    def mySet = [1, 2, 3, 2, 1] as Set
    assertEquals 3, mySet.size()
    mySet << 3
    assertEquals 3, mySet.size()

    def mySortedSet = ["cows", "aardvarks", "mice"] as SortedSet
    def sortedList = []
    mySortedSet.each {
      sortedList << it
    }

    assertEquals "aardvarks", sortedList[0]
    assertEquals "cows", sortedList[1]
    assertEquals "mice", sortedList[2]
  }

  void testRanges() {
    def myRange = 1..10
    assertEquals 10, myRange.size()
    assertEquals 1, myRange.first()
    assertEquals 10, myRange.last()
    assertTrue myRange instanceof java.util.List

    def backwards = 10..1
    assertEquals 10, backwards.size()
    assertEquals 10, backwards.first()
    assertEquals 1, backwards.last()
  }

  void testMaps() {
    def myMap = [1: "one", "two": 2]
    assertEquals "one", myMap[1]
    assertEquals 2, myMap["two"]
    assertEquals 2, myMap.two
    assertNull myMap.gibberish
  }

  void testFindAll() {
    def bandList = ["The Beach Boys", "Rage Against the Machine", "Daft Punk", "Against Me!"]
    assertEquals(["Rage Against the Machine", "Against Me!"],
            bandList.findAll {
              it.contains "Against"
            }
    )

    def colors = ["red": "F00", "green": "0F0", "blue": "00F"]
    assertEquals "red",
            colors.find { key, value ->
              value == "F00"
            }.key
  }

  void testGroupBy() {
    def wordList = ["one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"]
    def grouped = wordList.groupBy {
      it.length()
    }

    assertNull grouped[2]
    assertEquals 4, grouped[3].size()
    assertEquals 3, grouped[4].size()
  }
}
