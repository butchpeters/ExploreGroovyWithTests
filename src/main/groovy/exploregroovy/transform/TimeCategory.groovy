package exploregroovy.transform

@Category(Number)
class TimeCategory {
  def milli() {
    this
  }
  def millis() {
    milli()
  }

  def second() {
    this * 1000
  }
  def seconds() {
    second()
  }

  def minute() {
    this * 1000 * 60
  }
  def minutes() {
    minute()
  }

  def hour() {
    this * 1000 * 60 * 60
  }
  def hours() {
    hour()
  }

  def day() {
    this * 1000 * 60 * 60 * 24
  }
  def days() {
    day()
  }
}
