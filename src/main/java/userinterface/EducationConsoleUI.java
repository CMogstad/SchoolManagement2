package userinterface;

import controller.EducationController;

public class EducationConsoleUI {

    EducationController ec;
    ConsoleInput uInput;

    public EducationConsoleUI(EducationController ec, ConsoleInput uInput) {
        this.ec = ec;
        this.uInput = uInput;
    }
}
