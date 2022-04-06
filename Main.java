import java.util.Scanner;
import java.io.*;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;

class Main {


  public static void main(String[] args) {

        Scanner input = new Scanner(System.in);


        Course[] courses = new Course[100];
        int numCourses = 0;
        Student[] students = new Student[100];
        int numStud = 0;
        GeneralStaff[] gaStaff = new GeneralStaff[100];
        int numGaStuff = 0;
        Faculty[] faculties = new Faculty[100];
        int numFac = 0;
  //   public void createCourse(){
  //     System.out.println("Creating new course:");
		// System.out.println("Please enter the information in the following order followed by spaces Name ");
  //   }

  System.out.println("Enter your name? type: Exit to quit");
  String name = input.next();
    System.out.println("Welcome " + name );
  while(!name.equals("Exit")){
    
    String info = "(a) Create 3 new Course objects based on input" + "\n" +"(b) Create 3 new Faculty objects based on input" + "\n" + "(c) Create 3 new GeneralStaff objects based on input" +"\n" + "(d) Create 3 new Student objects based on input" + "\n"+"(e) Add 2 new Courses to a Faculty object" + "\n"+ "(f) Add 2 new Courses to a Student object" + "\n"+ "(g) Add an array of 2 Courses to a Faculty object" + "\n"+ "(h) Add an array of 2 Courses to a Student object" + "\n"+ "(j) Get the Course at index (valid and invalid indexes) from a Faculty object" + "\n"+ "(j) Get the Course at index (valid and invalid indexes) from a Student object" + "\n"+ "(k) Allow the user to select a Faculty object and a Course object from menus and query the Faculty object for the Course to determine whether the Faculty object teaches it or not."+ "\n"+ "(l) Determine which Faculty object teaches the most and the least courses." + "\n"+ "(m) Determine which Course is the minimum of all Course objects in the catalog." + "\n"+ "(n) Determine which Course is the maximum of all Course objects in the catalog." + "\n"+ "(o) Determine which Student has the most and least credits.";
    System.out.println("Choose the operation?");
   System.out.println(info);
    String reply = input.next();
    switch(reply) {
     case "a":
      System.out.println("Creating new course...");
		  System.out.println("Please enter the information for course 1 in the following format followed by a space: (Is it graduate, Enter: True/False) (Course Number) (Course Department) (Course credit)");
      boolean grad = input.next().toLowerCase().equals("true") ? true: false;
      int courseNum = input.nextInt();
      String dep = input.next();
      int credit = input.nextInt();

      courses[numCourses] = new Course(grad, courseNum, dep, credit);
      numCourses++;
      System.out.println("So far you have created " + numCourses + "Course");
 System.out.println("Please enter the information for course 2 in the following format followed by a space: (Is it graduate, Enter: True/False) (Course Number) (Course Department) (Course credit)");
         grad = input.next().toLowerCase().equals("true") ? true: false;
       courseNum = input.nextInt();
      dep = input.next();
     credit = input.nextInt();
      courses[numCourses] = new Course(grad, courseNum, dep, credit);
      numCourses++;
         System.out.println("So far you have created " + numCourses + "Course");
 System.out.println("Please enter the information for course 3 in the following format followed by a space: (Is it graduate, Enter: True/False) (Course Number) (Course Department) (Course credit)");
         grad = input.next().toLowerCase().equals("true") ? true: false;
       courseNum = input.nextInt();
      dep = input.next();
     credit = input.nextInt();
      courses[numCourses] = new Course(grad, courseNum, dep, credit);
      numCourses++;
        System.out.println("Your courses have been created type: 'Exit' to quit or 'continue' to keep going ");
        name = input.next();
        break;
   
     case "b":
        System.out.println("Creating new Faculty...");
		  System.out.println("Please enter the information for Faculty 1 in the following format followed by a space: (Name) (birthYear) (department name) (Is it tenured, Enter: True/False)");
// String name,int birthYear,String deptName,boolean isTenured
        String na = input.next();
        int birth = input.nextInt();
        String depNam = input.next();
        boolean ten = input.next().toLowerCase().equals("true") ? true: false;
        faculties[numFac] = new Faculty(na, birth, depNam, ten);
        numFac++;
        System.out.println("So far you have created " + numFac + " Faculty");
 System.out.println("Please enter the information for Faculty 2 in the following format followed by a space: (Name) (birthYear) (department name) (Is it tenured, Enter: True/False)");
         na = input.next();
         birth = input.nextInt();
         depNam = input.next();
         ten = input.next().toLowerCase().equals("true") ? true: false;
        faculties[numFac] = new Faculty(na, birth, depNam, ten);
        numFac++;
System.out.println("So far you have created " + numFac + " Faculty");
 System.out.println("Please enter the information for Faculty 3 in the following format followed by a space: (Name) (birthYear) (department name) (Is it tenured, Enter: True/False)");
                System.out.println("Your courses have been create type: 'Exit' to quit or continue to keep going ");
        name = input.next();
      break;
      case "c":
    
      break;
   // You can have any number of case statements.
   default : 
        System.out.println("Please type a number or Exit");
}

  }

     String courseOut = "";
      String facultyOut= "";
      
        if (numCourses > 0) {
            for (int i = 0; i < numCourses-1; i++) {
                courseOut += courses[i].toString() + "\n";
            }
        courseOut += courses[numCourses-1].toString();
          }
      if (numFac > 0) {
            for (int k = 0; k < numFac-1; k++) {
                facultyOut += faculties[k].toString() + "\n";
            }
        facultyOut += faculties[numFac-1].toString();
    }
          
 

  PrintWriter outStream = null;
  String filename = "./SchoolDB-write.txt";
     try {
            outStream = new PrintWriter("./SchoolDB-write.txt");
            outStream.println("\n**************************************************************\nSCHOOL DATABASE INFO:\n\n************************************************\nCOURSES:\n" + courseOut); 
outStream.println("************************************************\n************************************************\nFACULTY:\n" + facultyOut);
       
      System.out.println(courseOut);

        } catch (FileNotFoundException e) {
            System.out.println("Could not create file "+ "./SchoolDB-write.txt");
            e.printStackTrace();
        }

    
 
    
          
          //  outStream.println(text); //write to the file
            outStream.flush();//to be sure content is written to destination we flush
    }//main
}//public DB