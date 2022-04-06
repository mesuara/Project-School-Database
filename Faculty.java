public class Faculty extends Employee implements Comparable<Person>{

	private Course coursesTaught [] ;
	private int numCoursesTaught;
	private boolean isTenured;


	public Faculty() {
		super();
		this.coursesTaught = new Course[100] ;
		this.numCoursesTaught = 0;
		this.isTenured = false;
	}

	public Faculty(boolean isTenured) {
		super();
		this.coursesTaught = new Course[100] ;
		this.numCoursesTaught = 0;
		this.isTenured = isTenured;
	}

	public Faculty(String deptName,boolean isTenured) {
		super(deptName);
		this.coursesTaught = new Course[100] ;
		this.numCoursesTaught = 0;
		this.isTenured = isTenured;
	}

	public Faculty(String name,int birthYear,String deptName,boolean isTenured) {
		super(name,birthYear,deptName);
		this.coursesTaught = new Course[100] ;
		this.numCoursesTaught = 0;
		this.isTenured = isTenured;
	}

	public boolean isTenured() {
		return this.isTenured;
	}

	public int getNumCoursesTaught() {
		return this.numCoursesTaught;
	}

	public void setisTenured(boolean isTenured) {
		this.isTenured = isTenured;
	}

  public void addCourseTaught(Course cour){
        if (numCoursesTaught < 100) {
          coursesTaught[numCoursesTaught] = cour;
        numCoursesTaught++;
    }
  }

	public void addCoursesTaught(Course[] course) {

			for(int i=0; i < course.length; i++){
        addCourseTaught(course[i]);
      }
	}

    public Course getCourseTaught(int idx) {

  return (idx >= 0 && idx < numCoursesTaught) ? coursesTaught[idx] : null;
      }

		
	  public String getCourseTaughtAsString(int idx) {
    return (idx >= 0 && idx < numCoursesTaught)? coursesTaught[idx].getCourseDept()+ "-" + coursesTaught[idx].getCourseNum(): "";
  }

  public String getAllCoursesTaughtAsString()  {
		String results = "";
		for (int i = 0; i < numCoursesTaught - 1; i++) {

      results += (!getCourseTaughtAsString(i).equals("") && !getCourseTaughtAsString(i+1).equals("")) ? getCourseTaught(i) + ",": getCourseTaught(i);
  
		}
		return results;
	}


@Override
  public boolean equals(Object obj) {
    if (obj instanceof Faculty) {
      Faculty newObj = (Faculty)obj;
return (super.equals(newObj) && newObj.numCoursesTaught == this.numCoursesTaught && newObj.isTenured == this.isTenured && newObj.coursesTaught == this.coursesTaught);
    }
    return false;
  }

  @Override
  public String toString() {
    String ten = isTenured ? " Is Tenured": "Not Tenured";
      return String.format(super.toString() + " Faculty: %s | Number of Courses Taught: %3d | Courses Taught: %s",ten, numCoursesTaught, getAllCoursesTaughtAsString());
    
  }

    @Override
    public int compareTo(Person pers) {
      Faculty obj = (Faculty)pers;
      
    if (obj.numCoursesTaught > this.numCoursesTaught) {
      return -1;
    }
    if (obj.numCoursesTaught < this.numCoursesTaught) {
      return 1;
    }
    return 0;
  }
}