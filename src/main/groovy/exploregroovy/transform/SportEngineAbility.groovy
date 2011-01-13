package exploregroovy.transform


@Category(Automobile)
class SportEngineAbility {
  def accelerate(footPressure) {
    switch (footPressure) {
      case 67..100:
        speed += 3
      case 34..66:
        speed += 3
      case 0..33:
        speed += 3
        break
      default:
        speed += 0
        break
    }
  }
}
