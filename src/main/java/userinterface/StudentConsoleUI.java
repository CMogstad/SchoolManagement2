package userinterface;

import controller.StudentController;
import entities.Education;
import entities.Student;
import entities.Teacher;

import java.util.List;

public class StudentConsoleUI {

    StudentController sc;
    MainConsoleUI mUI;
    ConsoleInput input;

    public StudentConsoleUI(StudentController sc, MainConsoleUI mUI, ConsoleInput uInput) {
        this.sc = sc;
        this.mUI = mUI;
        this.input = uInput;
    }

    public void printStudentMenu() {
        System.out.print("""
                                
                _______________________________________________
                                School Management
                                    Student Menu
                _______________________________________________
                1. Add Student
                2. Update First Name
                3. Update Last Name
                4. Update Date of Birth
                5. Add Student To Education
                6. Remove Student From Education
                7. Remove Student
                8. Find Student By Last Name
                9. Show All Students
                10. Show All Students Without Education
                11. Show Detailed Student information
                0. Back to Main Menu

                Please choose: """);
    }

    public void readStudentUI() {
        System.out.print("\nPlease enter first name: ");
        String firstName = input.readString();

        System.out.print("Please enter last name: ");
        String lastName = input.readString();

        try {

            System.out.print("Please enter date of birth(YYYYMMDD): ");
            String dateOfBirth = input.readString();

            sc.createStudentController(firstName, lastName, dateOfBirth);

        } catch (Exception e) {
            System.out.print("Please use correct birth format :");
        }

        System.out.println("\nStudent has been added!");
    }

    public void updateStudentFirstNameUI() {
        try {
            System.out.print("\nPlease enter ID of student: ");
            int studentId = input.readInt();

            System.out.print("Please enter new first name of student: ");
            String newName = input.readString();

            sc.updateStudentFirstNameController(studentId, newName);
            System.out.println("\nStudent has been updated!");

        } catch (Exception e) {
            System.out.print("ID was not found, Please insert right ID:");
        }
    }

    public void updateStudentLastNameUI() {
        try {
            System.out.print("\nPlease enter ID of student: ");
            int studentId = input.readInt();

            System.out.print("Please enter new last name of student: ");
            String newName = input.readString();

            sc.updateStudentLastNameController(studentId, newName);
            System.out.println("\nStudent has been updated!");

        } catch (Exception e) {
            System.out.print("ID was not found, Please insert right ID: ");
        }
    }

    public void updateStudentDateOfBirthUI() {
        try {
            System.out.print("\nPlease enter ID of student: ");
            int studentId = input.readInt();

            System.out.print("Please enter new date of birth of student(YYYYMMDD): ");

            String newDateOfBirth = input.readString();

            sc.updateStudentDateOfBirthController(studentId, newDateOfBirth);
            System.out.println("\nStudent has been updated!");

        } catch (Exception e) {
            System.out.print("ID was not found, Please insert right ID: ");
        }
    }

    public void removeStudentUI() {
        try {
            System.out.print("\nPlease enter ID of student: ");
            int studentId = input.readInt();

            sc.deleteStudentByID(studentId);
            System.out.println("\nStudent has been removed!");

        } catch (Exception e) {
            System.out.print("ID was not found, Please insert right ID: ");
        }
    }

    public void findStudentByLastNameUI() {
        try {
            System.out.print("\nPlease enter last name: ");
            String lastName = input.readString();

            List<Student> students = sc.findStudentByLastNameController(lastName);

            mUI.printStudentList(students);

        } catch (Exception e) {
            System.out.print("Last name was not found, please insert other name: ");
        }
    }

    public void showAllStudentsUI() {
        List<Student> students = sc.showAllStudentsController();
        mUI.printStudentList(students);
    }

    public void showAllStudentsWithoutEducationUI() {
        List<Student> students = sc.showAllStudentsWithoutEducationController();
        mUI.printStudentList(students);
    }

    public void addEducationToStudentUI() {
        try {
            System.out.print("\nPlease enter ID of education: ");
            int eID = input.readInt();

            System.out.print("Please enter ID of student: ");
            int sID = input.readInt();

            sc.addEducationToStudentController(eID, sID);
            System.out.println("Education and student has been joined!");

        } catch (Exception e) {
            System.out.print("ID was not found, Please insert right ID: ");
        }
    }

    public void removeEducationFromStudentUI() {
        try {
            System.out.print("\nPlease enter ID of education you want to remove: ");
            int eID = input.readInt();

            System.out.print("Please enter ID of student: ");
            int sID = input.readInt();

            sc.removeStudentFromEducationController(eID, sID);
            System.out.println("\nEducation has been removed from student!");
        } catch (Exception e) {
            System.out.println("ID was not found, Please insert right ID: ");
        }
    }

    public void showDetailedStudentInfoUI() {
        try {
            System.out.print("\nPlease enter ID of student: ");
            int sID = input.readInt();

            Student student = sc.findStudentController(sID);

            System.out.println("""
                    \n________________________________________________________
                                  DETAILED STUDENT INFORMATION          
                    ________________________________________________________ """);
            System.out.println("Name: " + student.getFirstName() + " " + student.getLastName());
            System.out.println("Date of Birth: " + student.getDateOfBirth());
            System.out.println("Educations: ");
            for (Education e : student.getEducations()) {
                System.out.println("   " + e.getId() + ". " + e.getName());
            }

        } catch (Exception e) {
            System.out.println("ID was not found, Please insert right ID: ");
        }
    }


}