package userinterface;

import controller.CourseController;
import database.*;

public class CourseConsoleUI {

    CourseController cc;
    ConsoleInput uInput;

    public CourseConsoleUI(CourseController cc, ConsoleInput uInput) {
        this.cc = cc;
        this.uInput = uInput;
    }
}
