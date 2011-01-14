package exploregroovy.transform


class CategoryTest extends GroovyTestCase {
  void testCategory() {
    shouldFail MissingMethodException, {
      1.second()
    }

    use(exploregroovy.transform.TimeCategory) {  // there's a groovy API one too
      assert 4.seconds() == 1.second() + 3.seconds()
      assert 1.minute() == 60.seconds()
    }
  }

  void testUseCategoriesAndMixinsForMultipleInheritancePattern() {
    def modelT = new ModelT()
    def porsche = new Porsche()

    modelT.accelerate(60)
    assert 2 == modelT.speed
    assert "full" == modelT.brake(95)
    shouldFail MissingMethodException, {
      modelT.playMusic()
    }

    porsche.accelerate(60)
    assert 6 == porsche.speed
    assert "pulse" == porsche.brake(95)
    assert "Do Re Me Fa So La Ti Do" == porsche.playMusic()
  }

  // Helpers
  class ModelT extends Automobile {
  }

  @Mixin([AntilockBrakesAbility, SportEngineAbility, CarRadioAbility])
  class Porsche extends Automobile {
  }

}
