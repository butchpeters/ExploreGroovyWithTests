package exploregroovy.dynamic

class InterceptorClass implements GroovyInterceptable {

  def invokeMethod(String name, args) {
    def metaMethod = metaClass.getMetaMethod(name, args)
    if (metaMethod == null) {
      throw new MissingMethodException(name, InterceptorClass, args)
    }

    //println "Beginning $name"  -- Don't do this
    System.out.println("Beginning $name")

    def result = metaMethod.invoke(this, args)
    System.out.println("Completed $name")
    "Here: $result"
  }

  def echo(arg) {
    "Echoing: $arg"
  }
}
