package exploregroovy.transform


class Employee {
  @Delegate Person person  = new Person()
  @Delegate Job job = new Job()
}
