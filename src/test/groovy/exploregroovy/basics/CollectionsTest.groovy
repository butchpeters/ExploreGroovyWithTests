package exploregroovy.basics

class CollectionsTest extends GroovyTestCase {
  def __ = "What do you expect?"

  void testLists() {
    def list = ["a", 2, Double.valueOf(3)]
    assert 2 == list.get(1)
    assert 2 == list[1]
    assert list instanceof java.util.List
    assert 3 == list.size()
    list.add("4")
    assert "4" == list.last()
    list << "fifth"
    assert "fifth" == list.last()
  }

  void testArrays() {
    def array1 = [1, 2, 3]
    assert array1 instanceof java.util.List

    int[] array2 = [1, 2, 3]
    assert array2 instanceof int[]
    assert !(array2 instanceof java.util.List)

    array1 << 4
    assert 4 == array1[3]

    shouldFail MissingMethodException, {
      array2 << 4
    }
  }

  void testSets() {
    def mySet = [1, 2, 3, 2, 1] as Set
    assert __ == mySet.size()
    mySet << 3
    assert __ == mySet.size()

    def mySortedSet = ["cows", "aardvarks", "mice"] as SortedSet
    def sortedList = []
    mySortedSet.each {
      sortedList << it
    }

    assert "aardvarks" == sortedList[0]
    assert "cows" == sortedList[1]
    assert "mice" == sortedList[2]
  }

  void testRanges() {
    def myRange = 1..10
    assert __ == myRange.size()
    assert __ == myRange.first()
    assert __ == myRange.last()
    assert myRange instanceof java.util.List

    def backwards = 10..1
    assert __ == backwards.size()
    assert __ == backwards.first()
    assert __ == backwards.last()
  }

  void testMaps() {
    def myMap = [1: "one", "two": 2]
    assert "one" == myMap[1]
    assert 2 == myMap["two"]
    assert 2 == myMap.two
    assert !myMap.gibberish
  }

  void testFindAll() {
    def bandList = ["The Beach Boys", "Rage Against the Machine", "Daft Punk", "Against Me!"]
    assert ["Rage Against the Machine", "Against Me!"] ==
            bandList.findAll {
              it.contains "Against"
            }

    def colors = ["red": "F00", "green": "0F0", "blue": "00F"]
    assert __ ==
            colors.find { key, value ->
              value == "F00"
            }.key
  }

  void testGroupBy() {
    def wordList = ["one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"]
    def grouped = wordList.groupBy {
      it.length()
    }

    assert !grouped[2]
    assert __ == grouped[3].size()
    assert __ == grouped[4].size()
  }
}
