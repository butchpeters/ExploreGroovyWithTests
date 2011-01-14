package exploregroovy.dynamic


class StringHelper {
    static isEmptyOrWhitespace(String self) {
      self.isEmpty() || self.isAllWhitespace()
    }
}
