package exploregroovy.transform


@Category(Automobile)
class AntilockBrakesAbility {
  def brake(footPressure) {
    if (footPressure > 90) {
      "pulse"
    } else {
      "full"
    }
  }
}
