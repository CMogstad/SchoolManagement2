package userinterface;

import entities.Course;
import entities.Education;
import entities.Teacher;

import java.util.List;

public class ConsoleUI {

    public void printMainMenu() {
        System.out.println("""
                _______________________________________________
                                School Management
                                    Main Menu
                _______________________________________________
                1. Student Management
                2. Teacher Management
                3. Course Management
                4. Education Management
                5. Statistics
                0. Exit

                Please choose: """);
    }

    public void printStudentMenu() { //TODO - Implement find student by last name
        System.out.println("""
                _______________________________________________
                                School Management
                                    Student Menu
                _______________________________________________
                1. Add Student
                2. Update First Name
                3. Update Last Name
                4. Update Date of Birth
                5. Add Education To Student
                6. Remove Education From Student
                7. Remove Student 
                8. Find Student By Last Name
                9. Show All Students
                10. Show All Students Without Education
                0. Back to Main Menu

                Please choose: """);
    }

    public void printTeacherMenu() {
        System.out.println("""
                _______________________________________________
                                School Management
                                   Teacher Menu
                _______________________________________________
                1. Add Teacher
                2. Update First Name
                3. Update Last Name
                4. Update Employment Year
                5. Add Course To Teacher
                6. Remove Course From Teacher
                7. Remove Teacher 
                8. Find Teacher By Last Name
                9. Show All Teachers
                10. Show All Teachers Without a Course
                11. Show All Courses of a Teacher
                0. Back to Main Menu

                Please choose: """);
    }

    public void printCourseMenu() {
        System.out.println("""
                _______________________________________________
                                School Management
                                   Course Menu
                _______________________________________________
                1. Add Course
                2. Update Subject
                3. Update Course Points
                4. Add Course to Education
                5. Add Course to Teacher
                6. Remove Course From Education
                7. Remove Course From Teacher
                8. Remove Course
                9. Find Course by Name
                10. Show All Courses
                11. Show All Courses Without an Education
                12. Show All Courses Without a Teacher
                0. Back to Main Menu

                Please choose: """);
    }


    public void printEducationMenu() {
        System.out.println("""
                _______________________________________________
                                School Management
                                 Education Menu
                _______________________________________________
                1. Add Education
                2. Update Education Name
                3. Add Education to Course
                4. Add Education to Student
                5. Remove Education from Course
                6. Remove Education from Student
                7. Remove Education
                8. Find Education by Name
                9. Show All Educations
                10. Show All Courses of an Education
                11. Show All Student of an Education
                12. Show All Educations Without Courses
                13. Show All Educations Without Students
                0. Back to Main Menu

                Please choose: """);
    }

    public void printStatisticsMenu() {
        System.out.println("""
                _______________________________________________
                                School Management
                              Statistics Menu
                _______________________________________________
                1. Show Students by Date Of Birth
                2. Show Course with highest points
                3. Show Course with lowest points
                4. Show Education with most students
                5. Show Teacher with most Courses
                6. Show Education with most Courses
                7. Show average of Employment year
                9. Show number of students by Education
                10. Show numbers of courses by Education

                Please choose: """);
    }



}
