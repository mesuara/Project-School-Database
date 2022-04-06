//https://youtu.be/hpqNtgwJFw8

import java.util.Scanner;
import java.io.*;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
public class Driver_SchoolDB {


    public static void main(String[] args) throws IOException {
        FileInputStream fileByteStream = null;
        Scanner inputFile = null;
        fileByteStream = new FileInputStream("SchoolDB_Initial.txt");
        inputFile = new Scanner(fileByteStream);

        Course[] courses = new Course[100];
        int numCourses = 0;
        Student[] students = new Student[100];
        int numStud = 0;
        GeneralStaff[] gaStaff = new GeneralStaff[100];
        int numGaStuff = 0;
        Faculty[] faculties = new Faculty[100];
        int numFac = 0;


        while (inputFile.hasNextLine()) {
            String obj = inputFile.next();
            if (obj.equals("Course:")) {
                String[] str = inputFile.nextLine().split(",");
              //check if first thing is a boolean
                if (str[0].equals(" false") || str[0].equals(" true")) {
                    Boolean objIsGraduate = str[0].equals(" true") ? true: false;
                // check if there is more than one argument 
                    if (str.length > 1) {
                      // replaceAll??
                        int objCourseNum = parseInt(str[1].replace(" ", ""));
                        String objCourseDept = str[2].replace(" ", "");
                        int objNumCredits = parseInt(str[3].replace(" ", ""));
                        Course course = new Course(objIsGraduate, objCourseNum, objCourseDept, objNumCredits);
                        courses[numCourses] = course;
                        numCourses++;
                    }
                    else {
                      //if no arguments at all
                        Course course = new Course();
                        courses[numCourses] = course;
                        numCourses++;
                    }
                }
            }
            else if (obj.equals("Faculty:")) {
                String[] str = inputFile.nextLine().split(",");

  // one argument Faculty: true
                if (str[0].equals(" true") || str[0].equals(" false")) {
                    if (str[0].equals(" true")) {
                        Faculty faculty = new Faculty(true);
                        faculties[numFac] = faculty;
                        numFac++;
                    }
                }
                  //more than one argument
                else if (str.length > 1) {
                  //Faculty: MAT,false
                    if (str[1].replace(" ", "").equals("true") || str[1].replace(" ", "").equals("false")) {
                        String objDeptName = str[0];
                        Boolean objIsTenured;
                      objIsTenured = str[1].equals(" true") ? true: false;
                        Faculty faculty = new Faculty(objDeptName, objIsTenured);
                        faculties[numFac] = faculty;
                        numFac++;
                    }

                      // Faculty: Superman,1938,PHY,true
                    else {
                        String objName = str[0] ;
                        str[1] = str[1].replace(" ", "");
                        int objBirthYear = Integer.parseInt(str[1]);
                        String objDeptName = str[2].replace(" ", "");
                        Boolean objIsTenured;
                      objIsTenured = str[3].replace(" ", "").equals("true") ? true: false;
                        Faculty faculty = new Faculty(objName, objBirthYear, objDeptName, objIsTenured);
                        faculties[numFac] = faculty;
                        numFac++;
                    }
                }
                else {
                  // no arguments Faculty:
                    Faculty faculty = new Faculty();
                    faculties[numFac] = faculty;
                    numFac++;
                }
            } else if (obj.equals("GeneralStaff:")) {
           
                String[] str = inputFile.nextLine().split(",");
              // no arguments passed    GeneralStaff:
                if (str.length == 0) {
                    GeneralStaff generalStaff = new GeneralStaff();
                    gaStaff[numGaStuff] = generalStaff;
                    numGaStuff++;
                }
              //one argument passed GeneralStaff: advise students
                if (str.length == 1) {
                    str[0] = str[0].trim();
                    GeneralStaff generalStaff = new GeneralStaff(str[0]);
                    gaStaff[numGaStuff] = generalStaff;
                    numGaStuff++;
                }
              // two arguments passed GeneralStaff: Sanitation,clean
                if (str.length == 2) {
                    GeneralStaff generalStaff = new GeneralStaff(str[0], str[1]);
                    gaStaff[numGaStuff] = generalStaff;
                    numGaStuff++;
                }
              // four arguments passed GeneralStaff: Flash Gordon,1934,Security,safety
            
                if (str.length == 4) {
                    GeneralStaff generalStaff = new GeneralStaff(str[0], Integer.parseInt(str[1].replace(" ", "")), str[2], str[3]);
                    gaStaff[numGaStuff] = generalStaff;
                    numGaStuff++;
                }
            }
            else if (obj.equals("Student:")) {
                String[] str = inputFile.nextLine().split(",");
              // Student: false
              
                if (str[0].equals("true")) {
                    Student student = new Student(true);
                    students[numStud] = student;
                    numStud++;
                }
                if (str[0].equals("false")) {
                    Student student = new Student(false);
                    students[numStud] = student;
                    numStud++;
                }
                if (str.length > 1) {

                  // Student: Math,false
                    if (str[1].replace(" ", "").equals("true") ||  str[1].replace(" ", "").equals("false")) {
                    Boolean grad = (str[1].replace(" ", "").equals("true")) ? true: false;
                        Student student = new Student(str[0], grad);
                        students[numStud] = student;
                        numStud++;
                    }
                    else {
                      // Student: Wonderwoman,1941,JST,true
                        String objName = str[0];
                        int objBirthYear = Integer.parseInt(str[1].replace(" ", ""));
                        Boolean objIsGraduate = (str[3].replace(" ", "").equals("true"))? true:false;
                        Student student = new Student(str[0], objBirthYear, str[2].replace(" ", ""), objIsGraduate);
                        students[numStud] = student;
                        numStud++;
                    }
                }
                else {
                  // Student:
                    Student student = new Student();
                    students[numStud] = student;
                    numStud++;
                }
            }


        }
        try (BufferedReader br = new BufferedReader(new FileReader("SchoolDB_Initial.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
//for clarity first get the items then system.out

      String courseOut = "";
      String facultyOut= "";
      String gaOut = "";
      String studOut = "";
      
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
          
       if (numGaStuff > 0) {
            for (int j = 0; j < numGaStuff-1; j++) {
                gaOut+= gaStaff[j].toString() + "\n";
            } 
        gaOut += gaStaff[numGaStuff-1].toString();
         }
         if (numStud > 0) {
            for (int l = 0; l < numStud-1; l++) {
                studOut += students[l].toString()+"\n";
            }
          studOut+= students[numStud-1].toString();
           }
           System.out.println("\n**************************************************************\nSCHOOL DATABASE INFO:\n\n************************************************\nCOURSES:");
      System.out.println(courseOut);     System.out.println("************************************************\n************************************************\nPERSONS:\n************************************************\n************************************************\nEMPLOYEES:\n************************************************\n************************************************\nGENERAL STAFF:");
      System.out.println(gaOut); System.out.println("************************************************\n************************************************\nFACULTY:");
           System.out.println(facultyOut); System.out.println("************************************************\n************************************************\nSTUDENTS:");   
        System.out.println(studOut);    System.out.println("************************************************\n**************************************************************\n");

        fileByteStream.close();
         
}
}
