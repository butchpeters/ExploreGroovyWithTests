package exploregroovy.dynamic


class DynamicEcho {
  def methodMissing(String name, args) {
    if (name.startsWith("echo")) {
      name.substring(4)
    } else {
      throw new MissingMethodException(name, DynamicEcho, args)
    }
  }
}
