package GroovyTechTalk.interfaces;

public class SomeJavaClass {
    public int computeWithJavaInterface(MyJavaInterface x, int arg) {
        return x.foo() + x.bar(arg);
    }

    public int computeWithGroovyInterface(MyGroovyInterface x, int arg) {
        return x.foo() + x.bar(arg);

    }
}
