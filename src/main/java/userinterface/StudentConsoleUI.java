package userinterface;

import controller.StudentController;
import entities.Student;

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
                0. Back to Main Menu

                Please choose: """);
    }

    public void readStudentUI() {
        System.out.print("\nPlease enter first name: ");
        String firstName = input.readString();

        System.out.print("Please enter last name: ");
        String lastName = input.readString();

        System.out.print("Please enter date of birth: ");
        String dateOfBirth = input.readString();

        sc.createStudentController(firstName, lastName, dateOfBirth);

        System.out.println("\nStudent has been added!");
    }

    public void updateStudentFirstNameUI() {
        System.out.print("\nPlease enter ID of student: ");
        int studentId = input.readInt();

        System.out.print("Please enter new first name of student: ");
        String newName = input.readString();

        sc.updateStudentFirstNameController(studentId, newName);

        System.out.println("\nStudent has been updated!");
    }

    public void updateStudentLastNameUI() {
        System.out.print("\nPlease enter ID of student: ");
        int studentId = input.readInt();

        System.out.print("Please enter new last name of student: ");
        String newName = input.readString();

        sc.updateStudentLastNameController(studentId, newName);

        System.out.println("\nStudent has been updated!");
    }

    public void updateStudentDateOfBirthUI() {
        System.out.print("\nPlease enter ID of student: ");
        int studentId = input.readInt();

        System.out.print("Please enter new date of birth of student: ");
        String newDateOfBirth = input.readString();

        sc.updateStudentDateOfBirthController(studentId, newDateOfBirth);

        System.out.println("\nStudent has been updated!");
    }

    public void removeStudentUI() {
        System.out.print("\nPlease enter ID of student: ");
        int studentId = input.readInt();

        sc.deleteStudentByID(studentId);

        System.out.println("\nStudent has been removed!");
    }

    public void findStudentByLastNameUI() {
        System.out.print("\nPlease enter last name: ");
        String lastName = input.readString();

        List<Student> students = sc.findStudentByLastNameController(lastName);

        mUI.printList(students);
    }

    public void showAllStudentsUI() {
        List<Student> students = sc.showAllStudentsController();

        mUI.printList(students);
    }

    public void showAllStudentsWithoutEducationUI() {
        List<Student> students = sc.showAllStudentsWithoutEducationController();

        mUI.printList(students);
    }

    public void addEducationToStudentUI() {
        System.out.print("\nPlease enter ID of education: ");
        int eID = input.readInt();

        System.out.print("Please enter ID of student: ");
        int sID = input.readInt();

        sc.addEducationToStudentController(eID, sID);

        System.out.println("Education and student has been joined! ");
    }

    public void removeEducationFromStudentUI() {
        System.out.print("\nPlease enter ID of education you want to remove: ");
        int eID = input.readInt();

        System.out.print("Please enter ID of student: ");
        int sID = input.readInt();

        sc.removeStudentFromEducationController(eID, sID);

        System.out.println("\nEducation has been removed from student!");
    }
}
