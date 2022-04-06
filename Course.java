class Course {
  /*
   * isGraduateCourse: boolean courseNum: int courseDept: String numCredits: int
   * 
   */

  private boolean isGraduateCourse;
  private int courseNum;
  private String courseDept;
  private int numCredits;
  
   public Course() {
    this.isGraduateCourse = false;
    this.courseNum = 0;
    this.courseDept = "";
    this.numCredits = 0;
  }

  public Course(boolean isGraduateCourse, int courseNum, String courseDept, int numCredits) {
    this.isGraduateCourse = isGraduateCourse;
    this.courseNum = courseNum;
    this.courseDept = courseDept;
    this.numCredits = numCredits;
  }

  /*
   * Course(boolean isGraduateCourse, int courseNum, String courseDept, int
   * numCredits) isGraduateCourse(): boolean getCourseNum(): int getCourseDept():
   * String getNumCredits(): int getCourseName: String //return String of “U” or
   * “G” + courseDept + courseNum equals(Object obj): boolean //all attributes
   * must match for 2 Course objects to be considered equal toString(): String
   * //”Course: %3s-%3d | Number of Credits: %02d | Graduate/Undergraduate”,
   * courseDept, courseNum, numCredits, isGraduateCourse compareTo(Course c): int
   * //use the Comparable interface specification. Sort by courseNum
   */
  public boolean isGraduateCourse() {
    return this.isGraduateCourse;
  }

  public int getCourseNum() {
    return this.courseNum;
  }

  public String getCourseDept() {
    return this.courseDept;
  }

  public int getNumCredits() {
    return this.numCredits;
  }

  
  public String getCourseName() {
    return this.isGraduateCourse() ? "G"+ courseDept + courseNum : "U" + courseDept + courseNum;
  }

  @Override
  public boolean equals(Object obj) {
    boolean answer = false;
    if (obj instanceof Course) {
      Course newCourse = (Course) obj;
      if (this.isGraduateCourse == newCourse.isGraduateCourse && this.courseNum == newCourse.courseNum
          && this.courseDept == newCourse.courseDept && this.numCredits == newCourse.numCredits) {
        answer = true;
      } else {
        answer = false;
      }
    } 

    return answer;
  }

  @Override
  public String toString(){
    String degree = this.isGraduateCourse ? "Graduate" : "Undergraduate";

    return String.format("Course: %3s-%3d | Number of Credits: %02d | %s", courseDept, courseNum, numCredits, degree);
			
  }

  public int compareTo(Course obj){
    int answer = 0;
    if(obj.courseNum < this.courseNum){
      answer =1;
    }
    if(obj.courseNum > this.courseNum){
      answer = -1;
    }

    return answer;
  }
}