package exploregroovy.transform


class DelegateTest extends GroovyTestCase {
  def __ = "What do you expect?"

  void testDelegateForMultiInheritance() {
    def e = new Employee(name: "Butch Peters", jobName: "Ditch Digger", payGrade: 15)
    assert "Butch Peters" == e.getName()
    assert "Ditch Digger" == e.getJobName()
    assert 15 == e.getPayGrade()
  }

  void testCommonDelegateError() {
    shouldFail NullPointerException, {
      def e = new BadEmployee(name: "Butch Peters", jobName: "Ditch Digger", payGrade: 15)
    }
  }

  void testDuplicateFieldName() {
    def e = new DupEmployee(name: "Butch Peters")
    assert __ == e.getName()
    assert __ == e.getPerson().getName()
    assert __ == e.getDepartment().getName()
  }
}
