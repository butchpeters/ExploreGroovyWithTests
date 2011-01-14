package exploregroovy.interfaces;

public class SomeJavaClass {
    public int computeWithJavaInterface(MyJavaInterface x, int arg) {
        return x.foo() + x.bar(arg);
    }
}
