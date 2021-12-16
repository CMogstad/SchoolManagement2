package userinterface;

import controller.EducationController;
import entities.Course;
import entities.Education;
import entities.Student;
import entities.Teacher;

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
                14. Show Detailed Education Information
                0. Back to Main Menu

                Please choose: """);
    }

    public void updateEducationNameUI() {
        try {
            System.out.print("\nPlease enter ID of education: ");
            int id = input.readInt();

            System.out.print("Please enter new first name of Education: ");
            String newName = input.readString();

            ec.updateEducationController(id, newName);
            System.out.println("\nEducation has been updated!");

        } catch (Exception e) {
            System.out.print("ID was not found, Please insert right ID.");
        }
    }

    public void addEducationToCourseUI() {
        try {
            System.out.print("\nPlease enter ID of education: ");
            int eID = input.readInt();

            System.out.print("Please enter ID of course: ");
            int cID = input.readInt();

            ec.addEducationToCourseController(eID, cID);

            System.out.println("\nEducation and Course has been joined!");

        } catch (Exception e) {
            System.out.print("ID was not found, Please insert right ID.");
        }
    }

    public void addEducationToStudentUI() {
        try {
            System.out.print("\nPlease enter ID of education: ");
            int eID = input.readInt();

            System.out.print("Please enter ID of student: ");
            int sID = input.readInt();

            ec.addEducationToStudentController(eID, sID);
            System.out.println("Education and student has been joined!");

        } catch (Exception e) {
            System.out.print("ID was not found, Please insert right ID.");
        }
    }

    public void removeEducationUI() {
        try {
            System.out.print("\nPlease enter ID of the education you want to remove: ");
            int id = input.readInt();

            ec.removeEducationByIDController(id);
            System.out.println("\nEducation has been removed! ");

        } catch (Exception e) {
            System.out.print("ID was not found, Please insert right ID.");
        }
    }

    public void removeEducationFromStudentUI() {
        try {
            System.out.print("\nPlease enter ID of education you want to remove: ");
            int eID = input.readInt();

            System.out.print("Please enter ID of student: ");
            int sID = input.readInt();

            ec.removeEducationFromStudentController(eID, sID);
            System.out.println("\nEducation has been removed from student!");

        } catch (Exception e) {
            System.out.print("ID was not found, Please insert right ID.");
        }
    }

    public void removeEducationFromCourseUI() {
        try {
            System.out.print("\nPlease enter ID of education you want to remove: ");
            int eID = input.readInt();

            System.out.print("Please enter ID of course: ");
            int cID = input.readInt();

            ec.removeEducationFromCourseController(eID, cID);
            System.out.println("\nEducation has been removed from course!");

        } catch (Exception e) {
            System.out.print("ID was not found, Please insert right ID.");
        }
    }

    public void findEducationByNameUI() {
        try {
            System.out.println("\nPlease enter name of education: ");
            String name = input.readString();

            mainUI.printEducationList(ec.findEducationByNameController(name));

        } catch (Exception e) {
            System.out.print("Name was not found, please try again.");
        }
    }

    public void showAllEducationsUI() {
        mainUI.printEducationList(ec.showAllEducationsController());
    }

    public void listEducationCoursesController() {
        System.out.print("\nPlease enter ID of education: ");
        int id = input.readInt();

        mainUI.printListCourses(ec.listEducationCoursesController(id));
    }

    public void showAllEducationsWithoutCourseUI() {
        mainUI.printEducationList(ec.showAllEducationsWithoutCourseController());
    }

    public void listEducationStudentsUI() {
        try {
            System.out.print("\nPlease enter ID of education: ");
            int id = input.readInt();

            mainUI.printStudentList(ec.listEducationStudentsController(id));

        } catch (Exception e) {
            System.out.print("ID was not found, Please insert right ID.");
        }
    }

    public void listEducationWithoutStudentsUI() {
        mainUI.printEducationList(ec.listEducationWithoutStudentsController());
    }

    public void readEducationUI() {
        System.out.print("\nPlease enter name of Education: ");
        String educationName = input.readString();

        ec.addEducationController(educationName);
        System.out.println("\nEducation has been added!");
    }

    public void showAllCoursesWithoutEducationUI() {
        List<Course> courses = ec.showAllCoursesWithoutEducationController();
        mainUI.printListCourses(courses);
    }

    public void showAllEducationsWithoutStudentsUI() {
        List<Education> list = ec.listEducationWithoutStudentsController();
        mainUI.printEducationList(list);
    }

    public void showDetailedEducationInfoUI() {
        try {
            System.out.print("\nPlease enter ID of education: ");
            int eID = input.readInt();

            Education education = ec.findEducationController(eID);

            System.out.println("""
                    \n________________________________________________________
                                  DETAILED EDUCATION INFORMATION          
                    ________________________________________________________ """);
            System.out.println("Name: " + education.getName());
            System.out.println("Courses: ");
            for (Course c : education.getCourses()) {
                System.out.println("   " + c.getId() + ". " + c.getSubject());
            }
            System.out.println("Students: ");
            for (Student s : education.getStudents()) {
                System.out.println("   " + s.getId() + ". " + s.getFirstName() + " " + s.getLastName());
            }

        } catch (Exception e) {
            System.out.println("ID was not found, Please insert right ID: ");
        }
    }

}

