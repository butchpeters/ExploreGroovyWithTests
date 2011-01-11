package exploregroovy.dynamic


class MyClassDoesAnything implements GroovyInterceptable {
  def invokeMethod(String name, args) {
    if (name != "COOKIE") {
      return "I want a COOKIE"
    } else {
      return "YUM!"
    }
  }

  def propertyMap = [:];

  def getProperty(String name) {
    def value = propertyMap[name]
    "Here: $value"
  }

  void setProperty(String name, value) {
    propertyMap[name] = value
  }
}
