package exploregroovy.basics

class AssertHelper {
  static methodWithValidation(arg1, arg2) {
    assert arg1, "arg1 must not be blank"
    assert arg2?.size() > 3, "arg2 must be bigger than size 3"
    "yay"
  }
}
