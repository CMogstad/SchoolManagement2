package controller;

import database.StudentImpDAO;
import entities.Education;
import entities.Student;

import java.util.List;

public class StudentController {

    StudentImpDAO sDAO = new StudentImpDAO();

    public void createStudent(String firstName, String lastName, String dateOfBirth) {
        Student student = new Student(firstName, lastName, dateOfBirth);

        sDAO.addStudent(student);

    }

    public void updateStudentController(Student student) {

        sDAO.updateStudent(student);

    }

    public void deleteStudentByID(int id) {

        Student student = sDAO.findStudent(id);
        List<Education> list = student.getEducations();

        for (Education e : list) {
            e.removeStudent(student);
        }
        sDAO.removeStudent(id);

    }

    public Student findStudentController(int id) {

        return sDAO.findStudent(id);

    }

    public List<Student> showAllStudentsController() {

        return sDAO.showAllStudents();

    }

    public List<Student> showAllStudentsWithoutEducationController() {

        return sDAO.showAllStudentsWithoutEducation();

    }

}
