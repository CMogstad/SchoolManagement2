package userinterface;

import controller.StudentController;

public class StudentConsoleUI {

    StudentController sc;
    ConsoleInput uInput;

    public StudentConsoleUI(StudentController sc, ConsoleInput uInput) {
        this.sc = sc;
        this.uInput = uInput;
    }
}
