package exploregroovy.basics


class GStringTest extends GroovyTestCase {
  def __ = "What do  you expect?"

  void testStringQuotes() {
    def doubleQuotes = "I am a string"
    assert java.lang.String == doubleQuotes.class

    def singleQuotes = 'I am a string'
    assert java.lang.String == singleQuotes.class

    def slashQuotes = /I am a string/
    assert java.lang.String == slashQuotes.class

    assert singleQuotes == doubleQuotes
    assert singleQuotes == slashQuotes
  }

  void testMultilineStrings() {
    def longString = """\
    <html>
      <body id="theBody">
        Hello, world!
      </body>
    </html>
    """

    assert '    <html>\n      <body id="theBody">\n        Hello, world!\n      </body>\n    </html>\n    ' == longString
  }

  void testSimpleStringInterpolation() {
    def name = "Butch"
    def greeting = "Hello, my name is $name"
    def realString = "Hello, my name is Butch"
    assert realString == greeting
    assert greeting instanceof groovy.lang.GString
    assert !realString.is(greeting)

    def singleQuoteGreeting = 'Hello, my name is $name'
    assert "Hello, my name is \$name" == singleQuoteGreeting

    def multiLineGreeting = """\
Hello,
Sincerely,
$name
    """

    assert "Hello,\nSincerely,\nButch\n    " == multiLineGreeting
  }

  void testAdvancedStringInterpolation() {
    def name = "Butch";
    def greeting = "Hello, my name is $name"
    name = "Brian"
    assert "Hello, my name is $__" == greeting

    def person = [name: "Butch"]
    def personGreeting = "Hello, my name is ${person.name}"
    assert "Hello, my name is Butch" == personGreeting
    person.name = "Brian"
    assert "Hello, my name is $__" == personGreeting

    def closureGreeting = "Hello, my name is ${-> person.name}"
    person.name = "Peters"
    assert "Hello, my name is $__" == closureGreeting
  }

  void testRegularExpressions() {
    def m = "Area 51 69" =~ /(\d+)/
    assert "51" == m[0][1]
    assert "69" == m[1][1]
  }
}

