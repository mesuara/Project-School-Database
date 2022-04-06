class Person{
  private String name;
  private int birthYear;

  public Person(){
    this.name = "";
    this.birthYear = 0;
  }

  public Person(String nam, int birth){
    this.name = nam;
    this.birthYear = birth;
  }

  public String getName(){
    return this.name;
  }
  
  public int getBirthYear(){
    return this.birthYear;
  }

  public void setName(String nam){
    this.name = nam;
  }

  public void setBirthYear(int birth){
    this.birthYear = birth;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Person) {
      Person newObj = (Person)obj;
return (newObj.name == this.name && newObj.birthYear == this.birthYear);
    }
    return false;
  }

  @Override
  public String toString() {
    return String.format("Person: Name: %30s | Birth Year: %4d", name, birthYear);
  }
  
  public int compareTo(Person obj) {
    if (obj.birthYear > this.birthYear) {
      return -1;
    }
    if (obj.birthYear < this.birthYear) {
      return 1;
    }
    return 0;
  }
}
  
