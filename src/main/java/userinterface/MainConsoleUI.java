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

}
