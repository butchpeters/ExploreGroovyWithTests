package exploregroovy.transform

class DupEmployee {
  @Delegate Person person = new Person()
  @Delegate Job job = new Job()
  @Delegate Department department = new Department()
}
