package controller;

import userinterface.ConsoleInput;
import userinterface.ConsoleUI;

public class MainController {

    static boolean mainLoop = true;
    static boolean studentLoop = true;
    static boolean educationLoop = true;
    static boolean courseLoop = true;
    static boolean teacherLoop = true;
    static boolean statisticsLoop = true;

    ConsoleUI io;
    ConsoleInput uInput;

    public MainController(ConsoleUI io, ConsoleInput uInput) {
        this.io = io;
        this.uInput = uInput;
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
        io.printMainMenu();

        String choice = uInput.readString();

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

                }
            }
            case "0" -> mainLoop = false;
            default -> System.out.println("Wrong input, please choose 1-5");
        }
    }


    private void studentManagementController() {
        io.printStudentMenu();

        String choice = uInput.readString();

        switch (choice) {
            case "1" -> io.readStudentUI();
            case "2" -> io.updateStudentFirstNameUI();
            case "3" -> io.updateStudentLastNameUI();
            case "4" -> io.updateStudentDateOfBirthUI();
            case "5" -> io.addEducationToStudentUI();
            case "6" -> io.removeEducationFromStudentUI();
            case "7" -> io.removeStudentUI();
            case "8" -> io.findStudentByLastNameUI();
            case "9" -> io.showAllStudentsUI();
            case "10" -> io.showAllStudentsWithoutEducationUI();
            case "0" -> studentLoop = false;
            default -> System.out.println("Wrong input, please choose 1-6");
        }
    }

    private void teacherManagementController() {
        io.printTeacherMenu();

        String choice = uInput.readString();

        switch (choice) {
            case "1" -> io.readTeacherUI();
            case "2" -> io.updateTeacherFirstNameUI();
            case "3" -> io.updateTeacherLastNameUI();
            case "4" -> io.updateEmploymentYearUI();
            case "5" -> io.addCourseToTeacherUI();
            case "6" -> io.removeCourseFromTeacherUI();
            case "7" -> io.removeTeacherByIDUI();
            case "8" -> io.findTeacherByLastNameUI();
            case "9" -> io.showAllTeachersUI();
            case "10" -> io.showAllTeacherWithoutCourseUI();
            case "11" -> io.showCoursesOfTeacherUI();
            case "0" -> teacherLoop = false;
            default -> System.out.println("Wrong input, please choose 1-6");
        }
    }

    private void courseManagementController() {
        io.printCourseMenu();

        String choice = uInput.readString();

        switch (choice) {

            case "1" -> io.readCourseUI();
            case "2" -> io.updateCourseSubjectUI();
            case "3" -> io.updateCoursePointsUI();
            case "4" -> io.addEducationToCourseUI();
            case "5" -> io.addCourseToTeacherUI();
            case "6" -> io.removeEducationFromCourseUI();
            case "7" -> io.removeCourseFromTeacherUI();
            case "8" -> io.removeCourseByIdUI();
            case "9" -> io.findCourseBySubjectUI();
            case "10" -> io.showAllCoursesUI();
            case "11" -> io.showAllCoursesWithoutEducationUI();
            case "12" -> io.showAllCoursesWithoutTeacherUI();
            case "0" -> courseLoop = false;
            default -> System.out.println("Wrong input, please choose 1-6");
        }
    }

    private void educationManagementController() {
        io.printEducationMenu();

        String choice = uInput.readString();

        switch (choice) {
            case "1" -> io.readEducationUI();
            case "2" -> io.updateEducationNameUI();
            case "3" -> io.addEducationToCourseUI();
            case "4" -> io.addEducationToStudentUI();
            case "5" -> io.removeEducationFromCourseUI();
            case "6" -> io.removeEducationFromStudentUI();
            case "7" -> io.removeEducationUI();
            case "8" -> io.findEducationByNameUI();
            case "9" -> io.showAllEducationsUI();
            case "10" -> io.showAllCoursesWithoutEducationUI();
            case "11" -> io.showAllStudentsWithoutEducationUI();
            case "12" -> io.showAllEducationsWithoutCourseUI();
            case "13" -> io.showAllEducationsWithoutStudentsUI();
            case "0" -> educationLoop = false;
            default -> System.out.println("Wrong input, please choose 1-6");
        }
    }


    private void statisticsManagementController() {
        io.printStatisticsMenu();

        String choice = uInput.readString();

        switch (choice) {
            case "1" -> { /*studentsByDateOfBirthController()*/}
            case "2" -> {/*courseHighestPointsController();*/}
            case "3" -> {/*courseLowestPointsController();*/}
            case "4" -> {/*educationMostStudentsController();*/}
            case "5" -> {/*teacherMostCoursesController();*/}
            case "6" -> {/*educationMostCoursesController();*/}
            case "7" -> {/*averageEmploymentYearController();*/}
            case "8" -> {/*listEmploymentYearAscOrdController();*/
                ;
            }
            case "9" -> {/* numberOfStudentsByEducationController();*/}
            case "10" -> {/*numberOfCoursesByEducationController();*/}
            case "0" -> statisticsLoop = false;
            default -> System.out.println("Wrong input, please choose 1-6");
        }
    }
}
