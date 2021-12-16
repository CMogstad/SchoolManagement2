package userinterface;

import java.util.List;

public class MainConsoleUI {

    public void printMainMenu() {
        System.out.print("""
                                
                _______________________________________________
                                School Management
                                    Main Menu
                _______________________________________________
                1. Student Management
                2. Teacher Management
                3. Course Management
                4. Education Management
                5. Statistics
                0. Exit

                Please choose: """);
    }

    public void printList(List list) {
        list.forEach(System.out::println);
    }

    public static String fixString(int wantedSize, String stringToFix) {
        if (stringToFix.length() < wantedSize) {
            while (stringToFix.length() < wantedSize) {
                stringToFix = stringToFix + " ";
            }
            return stringToFix + "  ";
        } else
            return stringToFix.substring(0, wantedSize) + "  ";
    }

    public static void header() {
        System.out.println("""
                ________________________________________________________________________________________________
                  ID          NAME                 BIRTHDAY               SALARY               DEPARTMENT
                ________________________________________________________________________________________________ """);
    }

    public static void footer() {
        System.out.println("________________________________________________________________________________________________\n\n");
    }

    public static void headerStudents() {
        System.out.println("""
                ________________________________________________________________________________________________
                  ID          NAME                 BIRTHDAY               SALARY               DEPARTMENT
                ________________________________________________________________________________________________ """);
    }

    public static void showAllEmployees() {
      /*  UI.header();
        for (Employee e : alEmployees) {
            System.out.println("  " +
                    fixString(6, String.valueOf(e.getId())) +
                    fixString(22, e.getFirstname() + " " + e.getLastname()) +
                    fixString(22, e.getBirthday()) +
                    fixString(19, String.valueOf(e.getSalary())) +
                    fixString(18, e.getDepartment()));
        }
        UI.footer();
        System.out.println("\n Press any key to continue.");
        getStringInput();*/
    }

}
