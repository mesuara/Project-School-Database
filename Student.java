public class Student extends Person{
	private static int numStudents; 
	private int studentID; 
	private Course[] coursesTaken;
	private int numCoursesTaken;
	private boolean isGraduate; 
	private String major;
	
	public Student() {
		coursesTaken = new Course[50];
		numCoursesTaken = 0;
		studentID = numStudents + 1;
		numStudents++;
    isGraduate = false;
		major = "undeclared";
    
	}
	
	public Student(boolean graduate) {
		coursesTaken = new Course[50];
		numCoursesTaken = 0;
		studentID = numStudents + 1;
		numStudents++;
		major = "undeclared";
		this.isGraduate = graduate;
	}
	
	public Student(String major, boolean graduate) {
    this.isGraduate = graduate;
		coursesTaken = new Course[50];
		numCoursesTaken = 0;
		studentID = numStudents + 1;
		numStudents++;
		this.major = major;
	}
	
	public Student(String name, int birth, String major, boolean graduate) {
		super(name, birth);
    this.isGraduate = graduate;
		this.major = major;
		coursesTaken = new Course[50];
		numCoursesTaken = 0;
		studentID = numStudents + 1;
		numStudents++;

	}
	
	public boolean isGraduate() {
		return isGraduate;
	}
	
	public int getNumCoursesTaken() {
		return numCoursesTaken;
	}
	
	public static int getNumStudents() {
		return numStudents;
	}
	
	public int getStudentID() {
		return studentID;
	}
	
	public void setIsGraduate(boolean graduate) {
		this.isGraduate = graduate;
	}
	
	public String getMajor() {
		return major;
	}
	
	public void setMajor(String maj) {
		this.major = maj;
	}

	public void addCourseTaken(Course course) {
	    if (numCoursesTaken >= 0 && numCoursesTaken < coursesTaken.length) {
	      coursesTaken[numCoursesTaken] = course;
	      numCoursesTaken++;
	    }
	  }
	
	public void addCoursesTaken(Course[] course) {
		if (numCoursesTaken < coursesTaken.length && course.length <= coursesTaken.length - numCoursesTaken) {
			for(int i=0; i < course.length; i++){
        addCourseTaken(course[i]);
      }

		}
	}
	
   public Course getCourseTaken(int idx) {
    return (idx >= 0 && idx < numCoursesTaken) ? coursesTaken[idx]: null;
  }
	
  public String getCourseTakenAsString(int idx) {
    return (idx >= 0 && idx < numCoursesTaken)? coursesTaken[idx].getCourseDept()+ "-" + coursesTaken[idx].getCourseNum(): "";
  }
	
	public String getAllCoursesTakenAsString()  {
		String results = "";
		for (int i = 0; i < numCoursesTaken - 1; i++) {
			results += getCourseTakenAsString(i) + ", ";
		}
		results = results + getCourseTakenAsString(numCoursesTaken-1);
		return results;
	}
	
	 @Override
  public boolean equals(Object obj) {
    if (obj instanceof Student) {
      Student newObj = (Student)obj;
return (super.equals(newObj) && this.studentID == newObj.studentID && this.coursesTaken == newObj.coursesTaken && this.numCoursesTaken == newObj.numCoursesTaken && this.isGraduate == newObj.isGraduate && this.major == newObj.major);
    }
    return false;
  }

  	@Override
	public String toString() {

    String grad = isGraduate ? "Graduate" :"Undergraduate";

		      return String.format(super.toString() + " Student: studentID: %04d | Major %20s | %14s | Number of Courses Taken: %3d | Courses Taken: %s", studentID, major, grad,numCoursesTaken, getAllCoursesTakenAsString());
		   
	}


  @Override
    public int compareTo(Person pers) {
      Student obj = (Student)pers;
    if (obj.studentID > this.studentID) {
      return -1;
    }
    if (obj.studentID < this.studentID) {
      return 1;
    }
    return 0;
  }

}