package exploregroovy.basics


class TypeTest extends GroovyTestCase {
  def __ = "What do you expect here?"

  void testGroovyDuckType() {
    def person = new Person()
    def dog = new Dog()

    assert __ == walkIt(person)
    assert __ == walkIt(dog)
  }

  void testIsGroovyOptionallyStaticallyTypedToo() {
    def person = new Person()
    def dog = new Dog()
    def peopleFood = new PeopleFood()
    def dogFood = new DogFood()

    assert "yum" == dog.eat(dogFood)
    assert "omg yum" == dog.eat(peopleFood)
    assert "yum" == person.eat(peopleFood)
    shouldFail MissingMethodException, {
      person.eat(dogFood)
    }
  }

  void testAnotherCheckOfStaticTyping() {
    def x = "Hello"
    def y = 1

    shouldFail MissingMethodException, {
      staticTypeMethod(y, x)
    }
    shouldFail MissingMethodException, {
      y.substring(x)
    }

    y.metaClass.substring = {
      "sure"
    }

    assert "sure" == y.substring(x)

    shouldFail MissingMethodException, {
      staticTypeMethod y, x
    }
  }

  // Helpers
  def staticTypeMethod(String x, int y) {
    x.substring(y)
  }

  def walkIt(theThing) {
    theThing.walk()
  }

  class Person {
    def walk() {
      "Person walking"
    }

    def eat(PeopleFood food) {
      "yum"
    }
  }

  class Dog {
    def walk() {
      "Dog walking"
    }

    def eat(DogFood food) {
      "yum"
    }

    def eat(PeopleFood food) {
      "omg yum"
    }
  }

  class PeopleFood {

  }

  class DogFood {

  }
}
