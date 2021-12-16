package userinterface;

import controller.StatisticsController;
import entities.Course;
import entities.Education;
import entities.Student;
import entities.Teacher;

import java.util.List;

public class StatisticsConsoleUI {

    StatisticsController stc;
    MainConsoleUI mainUI;
    ConsoleInput input;

    public StatisticsConsoleUI(StatisticsController stc, MainConsoleUI mainUI, ConsoleInput input) {
        this.stc = stc;
        this.mainUI = mainUI;
        this.input = input;
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
                8. List Employment year Ascending Order
                9. Show number of students by Education
                10. Show numbers of courses by Education
                0. Back to Main Menu

                Please choose: """);
    }

    public void showStudentsByDateOfBirthUI() {

        try {
            System.out.print("Please enter earliest year: ");
            int eYear = input.readInt();

            System.out.print("Please enter latest year: ");
            int lYear = input.readInt();

            List<Student> list = stc.studentsByDateOfBirthController(eYear, lYear);

            mainUI.printList(list);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Incorrect input of Date of Birth, please update in update in Student Date of Birth option.");
        }
    }

    public void courseHighestPointUI() {

        List<Course> list = stc.courseHighestPointsController();

        mainUI.printList(list);
    }

    public void courseLowestPointUI() {

        List<Course> list = stc.courseLowestPointsController();

        mainUI.printList(list);
    }

    public void educationMostStudentsUI() {

        List<Education> list = stc.educationMostStudentsController();

        mainUI.printList(list);
    }

    public void teacherMostCoursesUI(){

        List<Teacher> list  = stc.teacherMostCoursesController();

        mainUI.printList(list);

    }
    public void educationMostCoursesUI(){

        List<Education> list = stc.educationMostCoursesController();

        mainUI.printList(list);

    }
    public void averageEmploymentYearUI(){

        double avg = stc.averageEmploymentYearController();
        System.out.println("Average employment year: " + avg);

    }

    public void numberOfStudentsByEducationUI(){

        List<Education> list = stc.getListOfAllEducationsController();

        for (Education e: list) {
            System.out.println(e.getName() + " " + e.getStudents().size());
        }

    }
    public void numberOfCoursesByEducationUI(){

        List<Education> list = stc.getListOfAllEducationsController();

        for (Education e : list) {

            System.out.println(e.getName() + " " + e.getCourses().size());
        }

    }
    public void listEmploymentYearAscOrdUI(){
        List<Teacher> list = stc.listEmploymentYearAscOrdController();
        mainUI.printList(list);
    }
}
