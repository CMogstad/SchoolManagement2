package userinterface;

import controller.StatisticsController;
import database.StatisticsDao;

public class StatisticsConsoleUI {

    StatisticsController stc;
    ConsoleInput uInput;

    public StatisticsConsoleUI(StatisticsController stc, ConsoleInput uInput) {
        this.stc = stc;
        this.uInput = uInput;
    }
}
