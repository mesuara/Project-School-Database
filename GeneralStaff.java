public class GeneralStaff extends Employee{
  private String duty;

  public GeneralStaff(){
    this.duty = "";
  }

  public GeneralStaff(String str){
    this.duty = str;
  }

  public GeneralStaff(String dept, String str) {
    super(dept);
    this.duty = str;
  }

    public GeneralStaff(String na, int birth, String dept, String str) {
    super(na, birth, dept);
    this.duty = str;
  }

  public String getDuty(){
    return this.duty;
  }

    @Override
  public boolean equals(Object obj) {
    if (obj instanceof GeneralStaff) {
      GeneralStaff newObj = (GeneralStaff)obj;
return (super.equals(newObj) && newObj.duty == this.duty);
    }
    return false;
  }

    @Override
  public String toString() {
    return String.format(super.toString() + " GeneralStaff: Duty: %10s", duty);
  }
}