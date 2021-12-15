package application;

import controller.MainController;
import entities.Student;
import entities.Teacher;
import userinterface.ConsoleInput;
import userinterface.ConsoleUI;

import java.util.List;

public class SchoolMain {

    public static void main(String[] args) {


        ConsoleUI io = new ConsoleUI();

        ConsoleInput uInput = new ConsoleInput();

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
