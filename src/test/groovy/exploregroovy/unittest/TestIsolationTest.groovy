package exploregroovy.unittest

import groovy.mock.interceptor.MockFor
import groovy.mock.interceptor.StubFor

class TestIsolationTest extends GroovyTestCase {
  void testMockUsingClosureMap() {
    def obj = new TestableCode()

//    def external = new ExternalDependency(name: "external", input: 50)
    def external = [
            computeValue: {
              "Result external: 100"
            }
    ] as ExternalDependency
    assert "External returned Result external: 100" == obj.testThisMethod(external, 2)
  }

  void testMockUsingStubFor() {
    def obj = new TestableCode()

    def external = new StubFor(ExternalDependency)
    external.demand.computeValue {
      "Result external: 100"
    }
    external.demand.anotherMethod {
      "From mock"
    }

    assert "External returned Result external: 100" == obj.testThisMethod(external.proxyInstance(), 2)

    external.use {
      assert "External returned Result external: 100" == obj.testThisMethod(2)
    }
  }

  void testMockUsingMockFor() {
    def obj = new TestableCode()

    def external = new MockFor(ExternalDependency)
    external.demand.anotherMethod {
      "From mock"
    }
    external.demand.computeValue {
      "Result external: 100"
    }

    external.use {
      assert "External returned Result external: 100" == obj.testThisMethod(2)
    }

    def externalIncorrect = new MockFor(ExternalDependency)
    externalIncorrect.demand.computeValue {
      "Result external: 100"
    }
    externalIncorrect.demand.anotherMethod {
      "From mock"
    }

    assert "External returned Result external: 100" == obj.testThisMethod(externalIncorrect.proxyInstance(), 2)

    shouldFail {
      externalIncorrect.use {
        assert "External returned Result external: 100" == obj.testThisMethod(2)
      }
    }
  }


  void testMockJavaUsingMap() {
    def obj = new JTestableCode()

//    def external = new JExternalDependency("external", 50)
    def external = [
            computeValue: {
              "Result external: 100"
            }
    ] as JExternalDependency
    assert "External returned Result external: 100" == obj.testThisMethod(external, 2)
  }

  void testMockJavaUsingStubFor() {
    def obj = new JTestableCode()

    def external = new StubFor(JExternalDependency)
    external.demand.computeValue {
      "Result external: 100"
    }
    external.demand.anotherMethod {
      "From mock"
    }

//    assert "External returned Result external: 100" == obj.testThisMethod(external.proxyInstance(), 2)

//    external.use {
//      assert "External returned Result external: 100" == obj.testThisMethod(2)
//    }
  }

}
