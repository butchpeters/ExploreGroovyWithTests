package exploregroovy.unittest;

public class JTestableCode {
    public String testThisMethod(JExternalDependency externalDependency, int multiplier) {
        String result = externalDependency.computeValue(multiplier);
        return "External returned " + result;
    }

    public String testThisMethod(int multiplier) {
        JExternalDependency external = new JExternalDependency("external", 50);
        return testThisMethod(external, multiplier);
    }
}
