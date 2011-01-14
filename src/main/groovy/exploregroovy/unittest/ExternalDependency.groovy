package exploregroovy.unittest


class ExternalDependency {
  String name
  Integer input

  def computeValue(multiplier) {
    for (i in 1..5) {
      sleep 1000
      println "Calculating ${i*20}%"
    }
    "Result $name: ${input*multiplier}"
  }

  def anotherMethod() {
    "From real method"
  }
}
