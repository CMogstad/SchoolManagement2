package userinterface;

import controller.TeacherController;

public class TeacherConsoleUI {

    TeacherController tDAO;
    ConsoleInput uInput;

    public TeacherConsoleUI(TeacherController tDAO, ConsoleInput uInput) {
        this.tDAO = tDAO;
        this.uInput = uInput;
    }
}
