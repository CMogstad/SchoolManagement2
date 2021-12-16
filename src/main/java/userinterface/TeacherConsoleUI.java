package userinterface;

import controller.TeacherController;
import entities.Course;
import entities.Teacher;

import javax.persistence.NoResultException;
import java.util.List;

public class TeacherConsoleUI {

    TeacherController tc;
    MainConsoleUI mainUI;
    ConsoleInput input;


    public TeacherConsoleUI(TeacherController tc, MainConsoleUI mainUI, ConsoleInput input) {
        this.tc = tc;
        this.input = input;
        this.mainUI = mainUI;
    }

    public void printTeacherMenu() {
        System.out.print("""
                                
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
    public void readTeacherUI() {
        System.out.print("\nPlease enter first name: ");
        String firstName = input.readString();

        System.out.print("Please enter last name: ");
        String lastName = input.readString();

        System.out.print("Please enter employment Year [YYYY]: ");
        int employmentYear = input.readInt();

        tc.createTeacher(firstName, lastName, employmentYear);
    }

    public void updateTeacherFirstNameUI() {


            System.out.print("\nPlease enter ID of Teacher: ");
            int teacherId = input.readInt();

            System.out.print("Please enter the new first name: ");
            String firstName = input.readString();
        try {
            tc.updateTeacherFirstNameController(teacherId, firstName);
        } catch (Exception e) {
            System.out.println("ID was not found, Please insert right ID: .");
        }
            System.out.println("\nTeacher has been updated!");
            System.out.println(" ");

            Teacher teacher = tc.findTeacherController(teacherId);
            printTeacher(teacher);
        }





    public void updateTeacherLastNameUI() {
        System.out.print("\nPlease enter ID of Teacher: ");
        int teacherId = input.readInt();

        System.out.print("Please enter the new last name: ");
        String lastName = input.readString();

        try {

            tc.updateTeacherLastNameController(teacherId, lastName);
        } catch (Exception e) {
            System.out.println("ID was not found, Please insert right ID: .");
        }

        System.out.println("\nLast name has been updated!");
        System.out.println(" ");

        Teacher teacher = tc.findTeacherController(teacherId);
        printTeacher(teacher);
    }
    public void updateEmploymentYearUI() {

    try {
        System.out.print("\nPlease enter ID of Teacher: ");
        int teacherId = input.readInt();

        System.out.print("Please enter new employment year [YYYY]: ");
        int employmentYear = input.readInt();

        tc.updateTeacherEmploymentYearController(teacherId, employmentYear);
    } catch (Exception e) {
        System.out.println("ID was not found, Please insert right ID: .");
    }

        System.out.println("\nThe employment year has been updated!");
    }

    public void addCourseToTeacherUI() {

    try {
        System.out.print("\nPlease enter ID of Course: ");
        int courseId = input.readInt();

        System.out.print("Please enter ID of Teacher: ");
        int teacherId = input.readInt();

        tc.addCourseToTeacherController(courseId, teacherId);
    } catch (Exception e) {
        System.out.println("ID was not found, Please insert right ID: .");
    }

        System.out.println("\nCourse has been added to teacher!");
    }
    public void removeCourseFromTeacherUI() {

    try {
        System.out.print("\nPlease enter ID of Course: ");
        int courseId = input.readInt();

        System.out.print("Please enter ID of Teacher: ");
        int teacherId = input.readInt();

        tc.removeCourseFromTeacherController(courseId, teacherId);
    } catch (Exception e) {
        System.out.println("ID was not found, Please insert right ID: .");
    }

        System.out.println("\nCourse has been removed from teacher!");
    }
    public void removeTeacherByIDUI() {

    try {
        System.out.print("\nPlease enter ID of Teacher: ");
        int teacherId = input.readInt();

        tc.removeTeacherByIDController(teacherId);
    } catch (Exception e) {
        System.out.println("ID was not found, Please insert right ID: .");
    }

        System.out.println("\nThe teacher has been removed!");
    }
    public void findTeacherByLastNameUI() {

    try {
        System.out.print("\nPlease enter the last name of a teacher: ");
        String lastName = input.readString();

        List<Teacher> teachers = tc.findTeacherByLastNameController(lastName);


        mainUI.printList(teachers);
    } catch (Exception e) {
        System.out.println("Last Name was not found, Please insert other name: .");
    }
    }
    public void showAllTeachersUI() {
        List<Teacher> teachers = tc.showAllTeachersController();

        mainUI.printList(teachers);
    }

    public void showAllTeacherWithoutCourseUI() {
        List<Teacher> teachers = tc.showAllTeacherWithoutCourseController();

       mainUI.printList(teachers);
    }
    public void showCoursesOfTeacherUI() {

    try {
        System.out.print("\nPlease enter ID of Teacher: ");
        int teacherId = input.readInt();

        List<Course> courses = tc.showCoursesOfTeacherController(teacherId);
        Teacher teacher = tc.findTeacherController(teacherId);

        printTeacher(teacher);
        mainUI.printList(courses);

    } catch (Exception e) {
        System.out.println("ID was not found, Please insert right ID: .");
        }
    }

    public void printTeacher(Teacher teacher) {
        System.out.println(teacher);
    }

}
