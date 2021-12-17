package controller;

import userinterface.*;

public class MainController {

    static boolean mainLoop = true;
    static boolean studentLoop = true;
    static boolean educationLoop = true;
    static boolean courseLoop = true;
    static boolean teacherLoop = true;
    static boolean statisticsLoop = true;

    MainConsoleUI mIO;
    StudentConsoleUI sIO;
    TeacherConsoleUI tIO;
    CourseConsoleUI cIO;
    EducationConsoleUI eIO;
    StatisticsConsoleUI stcIO;
    ConsoleInput input;

    public MainController(MainConsoleUI mIO, StudentConsoleUI sIO, TeacherConsoleUI tIO, CourseConsoleUI cIO, EducationConsoleUI eIO, StatisticsConsoleUI stcIO, ConsoleInput input) {
        this.mIO = mIO;
        this.sIO = sIO;
        this.tIO = tIO;
        this.cIO = cIO;
        this.eIO = eIO;
        this.stcIO = stcIO;
        this.input = input;
    }

    public void mainProgram() {
        while (mainLoop) {

            studentLoop = true;
            educationLoop = true;
            courseLoop = true;
            teacherLoop = true;
            statisticsLoop = true;

            runSchoolManagementProgram();
        }
    }

    private void runSchoolManagementProgram() {
        mIO.printMainMenu();

        String choice = input.readString();

        switch (choice) {

            case "1" -> {
                while (studentLoop) {
                    studentManagementController();
                }
            }
            case "2" -> {
                while (teacherLoop) {
                    teacherManagementController();
                }
            }
            case "3" -> {
                while (courseLoop) {
                    courseManagementController();
                }
            }
            case "4" -> {
                while (educationLoop) {
                    educationManagementController();
                }
            }
            case "5" -> {
                while (statisticsLoop) {
                    statisticsManagementController();
                }
            }
            case "0" -> {mIO.godJulOchGottNyttÅr(); mainLoop = false;}
            default -> System.out.println("Wrong input, please choose 1-5");
        }
    }


    private void studentManagementController() {
        sIO.printStudentMenu();

        String choice = input.readString();

        switch (choice) {
            case "1" -> sIO.readStudentUI();
            case "2" -> sIO.updateStudentFirstNameUI();
            case "3" -> sIO.updateStudentLastNameUI();
            case "4" -> sIO.updateStudentDateOfBirthUI();
            case "5" -> sIO.addEducationToStudentUI();
            case "6" -> sIO.removeEducationFromStudentUI();
            case "7" -> sIO.removeStudentUI();
            case "8" -> sIO.findStudentByLastNameUI();
            case "9" -> sIO.showAllStudentsUI();
            case "10" -> sIO.showAllStudentsWithoutEducationUI();
            case "11" -> sIO.showDetailedStudentInfoUI();
            case "0" -> studentLoop = false;
            default -> System.out.println("Wrong input, please choose 1-10");
        }
    }

    private void teacherManagementController() {
        tIO.printTeacherMenu();

        String choice = input.readString();

        switch (choice) {
            case "1" -> tIO.readTeacherUI();
            case "2" -> tIO.updateTeacherFirstNameUI();
            case "3" -> tIO.updateTeacherLastNameUI();
            case "4" -> tIO.updateEmploymentYearUI();
            case "5" -> tIO.addCourseToTeacherUI();
            case "6" -> tIO.removeCourseFromTeacherUI();
            case "7" -> tIO.removeTeacherByIDUI();
            case "8" -> tIO.findTeacherByLastNameUI();
            case "9" -> tIO.showAllTeachersUI();
            case "10" -> tIO.showAllTeacherWithoutCourseUI();
            case "11" -> tIO.showCoursesOfTeacherUI();
            case "12" -> tIO.showDetailedStudentInfoUI();
            case "0" -> teacherLoop = false;
            default -> System.out.println("Wrong input, please choose 1-11");
        }
    }

    private void courseManagementController() {
        cIO.printCourseMenu();

        String choice = input.readString();

        switch (choice) {

            case "1" -> cIO.readCourseUI();
            case "2" -> cIO.updateCourseSubjectUI();
            case "3" -> cIO.updateCoursePointsUI();
            case "4" -> cIO.addEducationToCourseUI();
            case "5" -> cIO.addCourseToTeacherUI();
            case "6" -> cIO.removeEducationFromCourseUI();
            case "7" -> cIO.removeCourseFromTeacherUI();
            case "8" -> cIO.removeCourseByIdUI();
            case "9" -> cIO.findCourseBySubjectUI();
            case "10" -> cIO.showAllCoursesUI();
            case "11" -> cIO.showAllCoursesWithoutEducationUI();
            case "12" -> cIO.showAllCoursesWithoutTeacherUI();
            case "13" -> cIO.showDetailedCourseInfoUI();
            case "0" -> courseLoop = false;
            default -> System.out.println("Wrong input, please choose 1-12");
        }
    }

    private void educationManagementController() {
        eIO.printEducationMenu();

        String choice = input.readString();

        switch (choice) {
            case "1" -> eIO.readEducationUI();
            case "2" -> eIO.updateEducationNameUI();
            case "3" -> eIO.addEducationToCourseUI();
            case "4" -> eIO.addEducationToStudentUI();
            case "5" -> eIO.removeEducationFromCourseUI();
            case "6" -> eIO.removeEducationFromStudentUI();
            case "7" -> eIO.removeEducationUI();
            case "8" -> eIO.findEducationByNameUI();
            case "9" -> eIO.showAllEducationsUI();
            case "10" -> eIO.showAllCoursesWithoutEducationUI();
            case "11" -> eIO.listEducationStudentsUI();
            case "12" -> eIO.showAllEducationsWithoutCourseUI();
            case "13" -> eIO.showAllEducationsWithoutStudentsUI();
            case "14" -> eIO.showDetailedEducationInfoUI();
            case "0" -> educationLoop = false;
            default -> System.out.println("Wrong input, please choose 1-13");
        }
    }

    private void statisticsManagementController() {
        stcIO.printStatisticsMenu();

        String choice = input.readString();

        switch (choice) {
            case "1" -> stcIO.showStudentsByDateOfBirthUI();
            case "2" -> stcIO.courseHighestPointUI();
            case "3" -> stcIO.courseLowestPointUI();
            case "4" -> stcIO.educationMostStudentsUI();
            case "5" -> stcIO.teacherMostCoursesUI();
            case "6" -> stcIO.educationMostCoursesUI();
            case "7" -> stcIO.averageEmploymentYearUI();
            case "8" -> stcIO.listEmploymentYearAscOrdUI();
            case "9" -> stcIO.numberOfStudentsByEducationUI();
            case "10" -> stcIO.numberOfCoursesByEducationUI();
            case "0" -> statisticsLoop = false;
            default -> System.out.println("Wrong input, please choose 1-10");
        }
    }
}
