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

        ConsoleInput input = new ConsoleInput();

        StudentController sc = new StudentController(sDAO, eDAO);
        TeacherController tc = new TeacherController(tDAO, cDAO);
        CourseController cc = new CourseController(cDAO, tDAO, eDAO);
        EducationController ec = new EducationController(eDAO, cDAO, sDAO);
        StatisticsController stc = new StatisticsController(stcDAO);

        MainConsoleUI mIO = new MainConsoleUI(input, sc, tc, cc, ec, stc);

        StudentConsoleUI sIO = new StudentConsoleUI(sc, mIO, input);
        TeacherConsoleUI tIO = new TeacherConsoleUI(tc, mIO, input);
        CourseConsoleUI cIO = new CourseConsoleUI(cc, mIO, input);
        EducationConsoleUI eIO = new EducationConsoleUI(ec, mIO, input);
        StatisticsConsoleUI stcIO = new StatisticsConsoleUI(stc, mIO, input);

        MainController mc = new MainController(mIO, sIO, tIO, cIO, eIO, stcIO, input);
        mc.mainProgram();



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
