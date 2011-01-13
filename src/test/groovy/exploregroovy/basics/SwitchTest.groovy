package exploregroovy.basics


class SwitchTest extends GroovyTestCase {
  void testGroovySwitchStatement() {
    assert "You chose int 1" == methodWithSwitch(1i)
    assert "You chose int 1" == methodWithSwitch(1l)
    assert "You chose int 1" == methodWithSwitch(Integer.valueOf(1))
    assert "You chose String 1" == methodWithSwitch("1")
    def value = 1
    assert "You chose String 1" == methodWithSwitch("$value")

    assert "You chose List" == methodWithSwitch(["1", "2"])
    assert "You chose something in the List" == methodWithSwitch("2")
    assert "You are between 7 and 11 or 21" == methodWithSwitch(9)

    assert "You chose IP Address" == methodWithSwitch("172.16.17.123")
    assert "You chose E-Mail Address" == methodWithSwitch("bpeters@follettsoftware.com")

    assert "You chose something else" == methodWithSwitch("3")
  }

  def methodWithSwitch(arg) {
    def result = ""

    switch (arg) {
      case 1i:
        result = "You chose int 1"
        break
      case 1l:
        result = "You chose long 1"
        break
      case Integer.valueOf(1):
        result = "You chose Integer 1"
        break
      case "1":
        result = "You chose String 1"
        break

      case ["1", "2"]:
        result = "You chose something in the List"
        break
      case List:
        result = "You chose List"
        break

      case 7..11:
        result = "You are between 7 and 11"
      case 21:
        result += " or 21"
        break

      case ~/(([0-1]?\d{1,2}\.)|(2[0-4]\d\.)|(25[0-5]\.)){3}(([0-1]?\d{1,2})|(2[0-4]\d)|(25[0-5]))/:
        result = "You chose IP Address"
        break
      case ~/(\p{Alnum}+(\.|\_|\-)?)*\p{Alnum}@(\p{Alnum}+(\.|\_|\-)?)*\p{Alpha}/:
        result = "You chose E-Mail Address"
        break

      default: // default must be the last case in groovy
        result = "You chose something else"
        break
    }

    result
  }
}
