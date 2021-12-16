package application;

import controller.*;
import database.*;
import userinterface.*;

public class SchoolMain {

    public static void main(String[] args) {

        StudentImpDAO sDAO = new StudentImpDAO();
        TeacherDAO tDAO = new TeacherDAOImplementation();
        CourseDAO cDAO = new CourseDAOImplementation();
        EducationDAO eDAO = new EducationDaoImplementation();
        StatisticsDao stcDAO = new StatisticsDaoImplementation();

        StudentController sc = new StudentController(sDAO, eDAO);
        TeacherController tc = new TeacherController(tDAO, cDAO);
        CourseController cc = new CourseController(cDAO, tDAO, eDAO);
        EducationController ec = new EducationController(eDAO, cDAO, sDAO);
        StatisticsController stc = new StatisticsController(stcDAO);

        ConsoleInput input = new ConsoleInput();

        MainConsoleUI mIO = new MainConsoleUI();
        StudentConsoleUI sIO = new StudentConsoleUI(sc, mIO, input);
        TeacherConsoleUI tIO = new TeacherConsoleUI(tc, mIO, input);
        CourseConsoleUI cIO = new CourseConsoleUI(cc, mIO, input);
        EducationConsoleUI eIO = new EducationConsoleUI(ec, mIO, input);
        StatisticsConsoleUI stcIO = new StatisticsConsoleUI(stc, mIO, input);

        MainController mc = new MainController(mIO, sIO, tIO, cIO, eIO, stcIO, input);

        mc.mainProgram();
    }
}
