package exploregroovy.basics;

import groovy.lang.Closure;

public class JavaClosureHelper {
    public String runClosure(Closure c) {
        return c.call("Hello").toString();
    }
}
