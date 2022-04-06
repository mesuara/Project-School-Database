public class Employee extends Person {
  private String deptName;
  private static int numEmployees=1;
  private int employeeID;

    public Employee() {
    this.deptName = "";
    // this.numEmployees = 0;
    this.employeeID= numEmployees++;
  }

  public Employee(String dept) {
    this.deptName = dept;
    // this.numEmployees = 0;
    this.employeeID= numEmployees++;
  }

  public Employee(String name, int birth, String dept) {
    super(name, birth);
    this.deptName = dept;
    
    this.employeeID=numEmployees++;
  }

  public String getDeptName() {
    return this.deptName;
  }
    public int getEmployeeID() {
    return this.employeeID;
  }

  static int getNumEmployees() {
    return numEmployees;
  }

    public void setDeptName(String dept) {
    this.deptName = dept;
  }
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Employee) {
      Employee newObj = (Employee)obj;
return (super.equals(newObj) && newObj.deptName == this.deptName && newObj.numEmployees == this.numEmployees && newObj.employeeID == this.employeeID);
    }
    return false;
  }

  @Override
  public String toString() {
    return String.format(super.toString() + " Employee: Department: %20s | Employee Number: %3d", deptName, employeeID);
  }
  
  public int compareTo(Person obj) {
    int answer = -1;
if (obj instanceof Employee) {
			Employee empl = (Employee) obj;
		if(this.employeeID == empl.employeeID) {
			answer = 0;
		}
		else if(this.employeeID > empl.employeeID) {
			answer = 1;
		}
		else {
			answer = -1;
		}
		}
		return answer;
 }
}