package exploregroovy.unittest;

public class JExternalDependency {
    private String name;
    private Integer input;

    public JExternalDependency() {
    }

    public JExternalDependency(String name, Integer input) {
        this.name = name;
        this.input = input;
    }

    public String computeValue(int multiplier) {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // ignore
            }
            System.out.println("Calculating " + (i * 20) + "%");
        }
        return "Result " + name + ": " + (input * multiplier);
    }

    public String anotherMethod() {
        return "From real method";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getInput() {
        return input;
    }

    public void setInput(Integer input) {
        this.input = input;
    }
}
