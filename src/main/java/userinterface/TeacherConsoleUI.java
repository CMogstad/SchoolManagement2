package userinterface;

import controller.TeacherController;
import entities.Course;
import entities.Teacher;

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
                12. Show Detailed Teacher Information
                0. Back to Main Menu

                Please choose: """);
    }

    public void readTeacherUI() {
        System.out.print("\nPlease enter first name: ");
        String firstName = input.readString();

        System.out.print("Please enter last name: ");
        String lastName = input.readString();

        System.out.print("Please enter employment Year(YYYY): ");
        int employmentYear = input.readInt();

        tc.createTeacher(firstName, lastName, employmentYear);
    }

    public void updateTeacherFirstNameUI() {
        try {
            System.out.print("\nPlease enter ID of Teacher: ");
            int teacherId = input.readInt();

            System.out.print("Please enter the new first name: ");
            String firstName = input.readString();

            tc.updateTeacherFirstNameController(teacherId, firstName);
            System.out.println("\nTeacher has been updated!");
            System.out.println(" ");

            Teacher teacher = tc.findTeacherController(teacherId);
            mainUI.printTeacher(teacher);

        } catch (Exception e) {
            System.out.print("ID was not found, Please insert right ID.");
        }
    }


    public void updateTeacherLastNameUI() {
        System.out.print("\nPlease enter ID of Teacher: ");
        int teacherId = input.readInt();

        System.out.print("Please enter the new last name: ");
        String lastName = input.readString();

        try {

            tc.updateTeacherLastNameController(teacherId, lastName);

            System.out.println("\nLast name has been updated!");
            System.out.println(" ");

            Teacher teacher = tc.findTeacherController(teacherId);
            mainUI.printTeacher(teacher);
        } catch (Exception e) {
            System.out.print("ID was not found, Please insert right ID.");
        }
    }

    public void updateEmploymentYearUI() {
        try {
            System.out.print("\nPlease enter ID of Teacher: ");
            int teacherId = input.readInt();

            System.out.print("Please enter new employment year (YYYY): ");
            int employmentYear = input.readInt();

            tc.updateTeacherEmploymentYearController(teacherId, employmentYear);
            System.out.println("\nThe employment year has been updated!");

        } catch (Exception e) {
            System.out.print("ID was not found, Please insert right ID.");
        }
    }

    public void addCourseToTeacherUI() {
        try {
            System.out.print("\nPlease enter ID of Course: ");
            int courseId = input.readInt();

            System.out.print("Please enter ID of Teacher: ");
            int teacherId = input.readInt();

            tc.addCourseToTeacherController(courseId, teacherId);
            System.out.println("\nCourse has been added to teacher!");
        } catch (Exception e) {
            System.out.print("ID was not found, Please insert right ID.");
        }
    }

    public void removeCourseFromTeacherUI() {
        try {
            System.out.print("\nPlease enter ID of Course: ");
            int courseId = input.readInt();

            System.out.print("Please enter ID of Teacher: ");
            int teacherId = input.readInt();

            tc.removeCourseFromTeacherController(courseId, teacherId);
            System.out.println("\nCourse has been removed from teacher!");

        } catch (Exception e) {
            System.out.print("ID was not found, Please insert right ID.");
        }
    }

    public void removeTeacherByIDUI() {
        try {
            System.out.print("\nPlease enter ID of Teacher: ");
            int teacherId = input.readInt();

            tc.removeTeacherByIDController(teacherId);
            System.out.println("\nThe teacher has been removed!");

        } catch (Exception e) {
            System.out.print("ID was not found, Please insert right ID.");
        }
    }

    public void findTeacherByLastNameUI() {
        try {
            System.out.print("\nPlease enter the last name of a teacher: ");
            String lastName = input.readString();

            List<Teacher> teachers = tc.findTeacherByLastNameController(lastName);

            mainUI.printTeacherList(teachers);

        } catch (Exception e) {
            System.out.print("Last Name was not found, Please insert other name.");
        }
    }

    public void showAllTeachersUI() {
        List<Teacher> teachers = tc.showAllTeachersController();

        mainUI.printTeacherList(teachers);
    }

    public void showAllTeacherWithoutCourseUI() {
        List<Teacher> teachers = tc.showAllTeacherWithoutCourseController();

        mainUI.printTeacherList(teachers);
    }

    public void showCoursesOfTeacherUI() {
        try {
            System.out.print("\nPlease enter ID of Teacher: ");
            int teacherId = input.readInt();

            List<Course> courses = tc.showCoursesOfTeacherController(teacherId);
            Teacher teacher = tc.findTeacherController(teacherId);

            mainUI.printTeacher(teacher);
            mainUI.printListCourses(courses);

        } catch (Exception e) {
            System.out.print("ID was not found, Please insert right ID.");
        }
    }


    public void showDetailedStudentInfoUI() {
        try {
            System.out.print("\nPlease enter ID of teacher: ");
            int tID = input.readInt();

            Teacher teacher = tc.findTeacherController(tID);

            System.out.println("""
                                        
                    ________________________________________________________
                                  DETAILED TEACHER INFORMATION          
                    ________________________________________________________ """);
            System.out.println("Name: " + teacher.getFirstName() + " " + teacher.getLastName());
            System.out.println("Year of Employment: " + teacher.getEmploymentYear());
            System.out.println("Courses: ");
            for (Course c : teacher.getCourses()) {
                System.out.println("   " + c.getId() + ". " + c.getSubject());
            }

        } catch (Exception e) {
            System.out.println("ID was not found, Please insert right ID.");
        }
    }


}

