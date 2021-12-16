package userinterface;

import controller.EducationController;
import entities.Course;
import entities.Education;

import java.util.List;

public class EducationConsoleUI {

    EducationController ec;
    MainConsoleUI mainUI;
    ConsoleInput input;

    public EducationConsoleUI(EducationController ec, MainConsoleUI mainUI, ConsoleInput input) {
        this.ec = ec;
        this.mainUI = mainUI;
        this.input = input;
    }


    public void printEducationMenu() {
        System.out.print("""
                                
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

    public void updateEducationNameUI() {
        System.out.print("\nPlease enter ID of education: ");
        int id = input.readInt();

        System.out.print("Please enter new first name of Education: ");
        String newName = input.readString();

        ec.updateEducationController(id, newName);

        System.out.println("\nEducation has been updated!");
    }

    public void addEducationToCourseUI() {
        System.out.print("\nPlease enter ID of education: ");
        int eID = input.readInt();

        System.out.print("Please enter ID of course: ");
        int cID = input.readInt();

        ec.addEducationToCourseController(eID, cID);

        System.out.println("\nEducation and Course has been joined! ");
    }

    public void addEducationToStudentUI() {

        System.out.print("\nPlease enter ID of education: ");
        int eID = input.readInt();

        System.out.print("Please enter ID of student: ");
        int sID = input.readInt();

        ec.addEducationToStudentController(eID, sID);

        System.out.println("Education and student has been joined! ");
    }

    public void removeEducationUI() {
        System.out.print("\nPlease enter ID of the education you want to remove: ");
        int id = input.readInt();

        ec.removeEducationByIDController(id);

        System.out.println("\nEducation has been removed! ");
    }

    public void removeEducationFromStudentUI() {
        System.out.print("\nPlease enter ID of education you want to remove: ");
        int eID = input.readInt();

        System.out.print("Please enter ID of student: ");
        int sID = input.readInt();

        ec.removeEducationFromStudentController(eID, sID);

        //sc.removeStudentFromEducationController(eID, sID);

        System.out.println("\nEducation has been removed from student!");
    }

    public void removeEducationFromCourseUI() {
        System.out.print("\nPlease enter ID of education you want to remove: ");
        int eID = input.readInt();

        System.out.print("Please enter ID of course: ");
        int cID = input.readInt();

        ec.removeEducationFromCourseController(eID, cID);

        System.out.println("\nEducation has been removed from course!");
    }

    public void findEducationByNameUI() {
        System.out.println("\nPlease enter name of education: ");
        String name = input.readString();

        mainUI.printList(ec.findEducationByNameController(name));
    }

    public void showAllEducationsUI() {
        mainUI.printList(ec.showAllEducationsController());
    }

    public void listEducationCoursesController() {
        System.out.print("\nPlease enter ID of education: ");
        int id = input.readInt();

        mainUI.printList(ec.listEducationCoursesController(id));
    }

    public void showAllEducationsWithoutCourseUI() {
        mainUI.printList(ec.showAllEducationsWithoutCourseController());
    }

    public void listEducationStudentsUI() {
        System.out.print("\nPlease enter ID of education: ");
        int id = input.readInt();

        mainUI.printList(ec.listEducationStudentsController(id));
    }

    public void listEducationWithoutStudentsUI() {
        mainUI.printList(ec.listEducationWithoutStudentsController());
    }


    public void readEducationUI() {
        System.out.print("\nPlease enter name of Education: ");
        String educationName = input.readString();

        ec.addEducationController(educationName);

        System.out.println("\nEducation has been added!");
    }

    public void showAllCoursesWithoutEducationUI() {
        List<Course> courses = ec.showAllCoursesWithoutEducationController();

        mainUI.printList(courses);
    }

    public void showAllEducationsWithoutStudentsUI(){
        List<Education> list = ec.listEducationWithoutStudentsController();
        mainUI.printList(list);
    }

}
