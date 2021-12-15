package application;

import userinterface.ConsoleInput;
import userinterface.ConsoleUI;

public class SchoolMain {

    static boolean mainLoop = true;
    static boolean studentLoop = true;
    static boolean educationLoop = true;
    static boolean courseLoop = true;
    static boolean teacherLoop = true;
    static boolean statisticsLoop = true;

    ConsoleUI io;

    ConsoleInput uInput;


    public static void main(String[] args) {


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

        private static void employeeManagement() {

            showManagementMenu();

            String choice = getStringInput();

            switch (choice) {

                case "1" -> chooseDepartment();
                case "2" -> deleteEmployeeById();
                case "3" -> updateEmployee();
                case "4" -> searchEmployeeName();
                case "5" -> searchEmployeeIdNumber();
                case "6" -> searchByDepartment();
                case "7" -> showAllEmployees();
                case "0" -> managementLoop = false;
                default -> System.out.println("Wrong input, please choose 1-6");
            }
        }

        private static void employeeStatistics() {

            showStatisticsMenu();

            String input = getStringInput();

            switch (input) {
                case "1" -> averageSalary();
                case "2" -> averageSalaryDepartment();
                case "3" -> maximumSalary();
                case "4" -> minimumSalary();
                case "5" -> womenPercentage();
                case "6" -> menPercentageDepartment();
                case "7" -> bonusInDepartment();
                case "0" -> statisticsLoop = false;
                default -> System.out.println("Wrong input, please choose 1-6");
            }
        }

        private static void employeeSortManagement() {

            showSortMenu();

            String input = getStringInput();

            switch (input) {
                case "1" -> sortByFirstName();
                case "2" -> sortByLastName();
                case "3" -> sortSalaryAscendingOrder();
                case "4" -> sortSalaryDescendingOrder();
                case "0" -> sortLoop = false;
                default -> System.out.println("Wrong input, please choose 1-4");
            }
        }


        /*
        Add educations of different kind
• Update education information
• Show information about a specific education
• Show all educations
• Remove an education

• Add courses of different kind
• Update course information
• Show information about a specific course
• Show all courses
• Remove a course

• Add students
• Update student information
• Show information about a specific student
• Show all students
• Remove a student

• Add teachers to educations
• List all teachers in an education
• remove teachers from educations
• Add teachers to educations

• remove students from an education
• List all students in an education
         */

    }

}
