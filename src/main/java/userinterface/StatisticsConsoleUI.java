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

            mainUI.printStudentList(list);

        } catch (Exception e) {
            System.out.println("Incorrect input of Date of Birth, please update in update in Student Date of Birth option.");
        }
    }

    public void courseHighestPointUI() {
        List<Course> list = stc.courseHighestPointsController();
        mainUI.printListCourses(list);
    }

    public void courseLowestPointUI() {
        List<Course> list = stc.courseLowestPointsController();
        mainUI.printListCourses(list);
    }

    public void educationMostStudentsUI() {
        List<Education> list = stc.educationMostStudentsController();
        // mainUI.printEducationList(list);

        statisticsHeaderEducationMostStudents();

        for (Education e : list) {

            System.out.println("  " +
                    mainUI.fixString(6, String.valueOf(e.getId())) +
                    mainUI.fixString(25, e.getName()) +
                    mainUI.fixString(18, String.valueOf(e.getStudents().size())));

        }

        mainUI.educationFooter();
    }


    public void teacherMostCoursesUI() {
        List<Teacher> list = stc.teacherMostCoursesController();
       // mainUI.printTeacherList(list);

        statisticsHeaderTeacherMostStudents();

        for (Teacher t : list) {

            System.out.println("  " +
                    MainConsoleUI.fixString(10, String.valueOf(t.getId())) +
                    MainConsoleUI.fixString(13, t.getFirstName()) +
                    MainConsoleUI.fixString(20, t.getLastName()) +
                    MainConsoleUI.fixString(18, String.valueOf(t.getCourses().size())));

                     statisticsFooter();
        }
    }

    public void educationMostCoursesUI() {
        List<Education> list = stc.educationMostCoursesController();

        statisticsHeaderEducationMostCourses();

        for (Education e : list) {

            System.out.println("  " +
                    MainConsoleUI.fixString(7, String.valueOf(e.getId())) +
                    MainConsoleUI.fixString(22, e.getName()) +
                    MainConsoleUI.fixString(18, String.valueOf(e.getCourses().size())));
        }

        statisticsFooter();
    }

    public void averageEmploymentYearUI() {
        double avg = stc.averageEmploymentYearController();

        statisticsHeaderAverage();
        System.out.println("  " +MainConsoleUI.fixString(8, "") +
                        MainConsoleUI.fixString(18, String.valueOf(avg)));


                statisticsFooter();
    }

    public void numberOfStudentsByEducationUI() {
        List<Education> list = stc.getListOfAllEducationsController();

        statisticsHeaderEducationMostStudents();

        for (Education e : list) {

            System.out.println("  " + MainConsoleUI.fixString(8, String.valueOf(e.getId())) +
                    MainConsoleUI.fixString(20, e.getName()) +
                    MainConsoleUI.fixString(18, String.valueOf(e.getStudents().size())));
        }
        statisticsFooter();
    }

    public void numberOfCoursesByEducationUI() {
        List<Education> list = stc.getListOfAllEducationsController();

        statisticsHeaderEducationMostCourses();

        for (Education e : list) {

            System.out.println("  " + MainConsoleUI.fixString(8, String.valueOf(e.getId())) +
                    MainConsoleUI.fixString(18, e.getName()) +
                    MainConsoleUI.fixString(18, String.valueOf(e.getCourses().size())));
        }

        statisticsFooter();
    }

    public void listEmploymentYearAscOrdUI() {
        List<Teacher> list = stc.listEmploymentYearAscOrdController();

        mainUI.printTeacherList(list);

    }

    public void statisticsHeader() {
        System.out.println("""
                _______________________________________________________________________________________
                          STATISTICS RESULTS               
                _______________________________________________________________________________________ """);
    }

    public void statisticsFooter() {
        System.out.println("_______________________________________________________________________________________\n\n");
    }

    public void statisticsHeaderAverage() {
        System.out.println("""
                _______________________________________________________________________________________
                          AVERAGE EMPLOYMENT YEAR           
                _______________________________________________________________________________________ """);
    }


    public void educationHeaderWithSize() {
        System.out.println("""
                _______________________________________________________________________________________
                  ID          NAME OF EDUCATION           
                _______________________________________________________________________________________ """);
    }

    public void statisticsHeaderEducationMostCourses() {
        System.out.println("""
                _______________________________________________________________________________________
                  ID        EDUCATION        NUMBER OF COURSES               
                _______________________________________________________________________________________ """);
    }

    public void statisticsHeaderEducationMostStudents() {
        System.out.println("""
                _______________________________________________________________________________________
                  ID        EDUCATION        NUMBER OF STUDENTS               
                _______________________________________________________________________________________ """);
    }



    public void statisticsHeaderTeacherMostStudents(){
        System.out.println("""
                _______________________________________________________________________________________
                  ID        FIRST NAME       LAST NAME      NUMBER OF STUDENTS               
                _______________________________________________________________________________________ """);
    }
}
