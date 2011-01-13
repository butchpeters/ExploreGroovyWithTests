package exploregroovy.transform


class Automobile {
  Integer speed = 0

  def brake(footPressure) {
    "full"
  }

  def accelerate(footPressure) {
    switch (footPressure) {
      case 67..100:
        speed += 1
      case 34..66:
        speed += 1
      case 0..33:
        speed += 1
        break
      default:
        speed += 0
        break
    }
  }
}
