package application;

import controller.*;
import database.*;
import entities.Student;
import entities.Teacher;
import userinterface.ConsoleInput;
import userinterface.ConsoleUI;

import java.util.List;

public class SchoolMain {

    public static void main(String[] args) {

        StudentImpDAO sDAO = new StudentImpDAO();
        TeacherDAO tDAO = new TeacherDAOImplementation();
        CourseDAO cDAO = new CourseDAOImplementation();
        EducationDAO eDAO = new EducationDaoImplementation();

        ConsoleInput uInput = new ConsoleInput();
        StudentController sc = new StudentController(sDAO);
        TeacherController tc = new TeacherController(tDAO, cDAO);
        CourseController cc = new CourseController(cDAO, tDAO, eDAO);
        EducationController ec = new EducationController(eDAO, cDAO, sDAO);
        StatisticsController stc = new StatisticsController();

        ConsoleUI io = new ConsoleUI(uInput, sc, tc, cc, ec, stc);

        MainController mc = new MainController(io, uInput);
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
