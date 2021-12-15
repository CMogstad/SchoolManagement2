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



      public void mainProgram(){

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

            case "1" ->{ /*addStudentController();*/}
            case "2" -> {/*updateStudentFirstNameController();*/}
            case "3" -> {/*updateStudentLastNameController();*/}
            case "4" -> {/*updateStudentDateOfBirthController();*/}
            case "5" -> {/*removeEducationFromStudentController();*/}
            case "6" -> {/*removeStudentController();*/}
            case "7" -> {/*findStudentByLastNameController();*/}
            case "8" -> {/*showAllStudentsController()*/;}
            case "9" -> {/*showAllStudentsWithoutEducationController();*/}
            case "0" -> studentLoop = false;
            default -> System.out.println("Wrong input, please choose 1-6");
        }
    }

    private void teacherManagementController() {


        io.printTeacherMenu();

        String choice = uInput.readString();

        switch (choice) {

            case "1" ->{ /*addTeacherController();*/}
            case "2" -> {/*updateTeacherFirstNameController();*/}
            case "3" -> {/*updateTeacherLastNameController();*/}
            case "4" -> {/*updateTeacherEmploymentYearController();*/}
            case "5" -> {/*adTeacherToCurseController();*/}
            case "6" -> {/*removeTeacherFromCourseController();*/}
            case "7" -> {/*removeTeacherController();*/}
            case "8" -> {/*findTeacherByLastNameController()*/;}
            case "9" -> {/*showAllTeachersController();*/}
            case "10" -> {/*showAllTeachersWithoutCourseController();*/}
            case "11" -> {/*showAllCoursesOfTeacherController();*/}
            case "0" -> teacherLoop = false;
            default -> System.out.println("Wrong input, please choose 1-6");
        }

    }

    private void courseManagementController() {

        io.printCourseMenu();

        String choice = uInput.readString();

        switch (choice) {

            case "1" ->{ /*addTeacherController();*/}
            case "2" -> {/*updateTeacherFirstNameController();*/}
            case "3" -> {/*updateTeacherLastNameController();*/}
            case "4" -> {/*updateTeacherEmploymentYearController();*/}
            case "5" -> {/*adTeacherToCurseController();*/}
            case "6" -> {/*removeTeacherFromCourseController();*/}
            case "7" -> {/*removeTeacherController();*/}
            case "8" -> {/*findTeacherByLastNameController()*/;}
            case "9" -> {/*showAllTeachersController();*/}
            case "10" -> {/*showAllTeachersWithoutCourseController();*/}
            case "11" -> {/*showAllCoursesOfTeacherController();*/}
            case "0" -> courseLoop = false;
            default -> System.out.println("Wrong input, please choose 1-6");
        }

    }

    private void educationManagementController() {


        io.printEducationMenu();

        String choice = uInput.readString();

        switch (choice) {

            case "1" ->{ /*addTeacherController();*/}
            case "2" -> {/*updateTeacherFirstNameController();*/}
            case "3" -> {/*updateTeacherLastNameController();*/}
            case "4" -> {/*updateTeacherEmploymentYearController();*/}
            case "5" -> {/*adTeacherToCurseController();*/}
            case "6" -> {/*removeTeacherFromCourseController();*/}
            case "7" -> {/*removeTeacherController();*/}
            case "8" -> {/*findTeacherByLastNameController()*/;}
            case "9" -> {/*showAllTeachersController();*/}
            case "10" -> {/*showAllTeachersWithoutCourseController();*/}
            case "11" -> {/*showAllCoursesOfTeacherController();*/}
            case "0" -> educationLoop = false;
            default -> System.out.println("Wrong input, please choose 1-6");
        }

    }


    private void statisticsManagementController() {


        io.printStatisticsMenu();

        String choice = uInput.readString();

        switch (choice) {

            case "1" ->{ /*studentsByDateOfBirthController()*/}
            case "2" -> {/*courseHighestPointsController();*/}
            case "3" -> {/*courseLowestPointsController();*/}
            case "4" -> {/*educationMostStudentsController();*/}
            case "5" -> {/*teacherMostCoursesController();*/}
            case "6" -> {/*educationMostCoursesController();*/}
            case "7" -> {/*averageEmploymentYearController();*/}
            case "8" -> {/*listEmploymentYearAscOrdController();*/;}
            case "9" -> {/* numberOfStudentsByEducationController();*/}
            case "10" -> {/*numberOfCoursesByEducationController();*/}
            case "0" -> statisticsLoop = false;
            default -> System.out.println("Wrong input, please choose 1-6");
        }

    }
    //Run program

    //Implement Statistics here
}
