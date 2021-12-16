package controller;

import database.EducationDAO;
import database.StudentImpDAO;
import entities.Education;
import entities.Student;

import java.util.List;

public class StudentController {

    StudentImpDAO sDAO;
    EducationDAO eDAO;

    public StudentController(StudentImpDAO sDAO, EducationDAO eDAO) {
        this.sDAO = sDAO;
        this.eDAO = eDAO;
    }

    public void createStudentController(String firstName, String lastName, String dateOfBirth) {
        Student student = new Student(firstName, lastName, dateOfBirth);
        sDAO.addStudent(student);
    }

    public List<Student> findStudentByLastNameController(String lastName) {
        return sDAO.findStudentByLastName(lastName);
    }

    public void updateStudentFirstNameController(int id, String name) {
        Student student = sDAO.findStudent(id);
        student.setFirstName(name);
        sDAO.updateStudent(student);
    }

    public void updateStudentLastNameController(int id, String name) {
        Student student = sDAO.findStudent(id);
        student.setLastName(name);
        sDAO.updateStudent(student);
    }

    public void updateStudentDateOfBirthController(int id, String dateOfBirth) {
        Student student = sDAO.findStudent(id);
        student.setDateOfBirth(dateOfBirth);
        sDAO.updateStudent(student);
    }

    public void removeStudentFromEducationController(int eID, int sID) {
        sDAO.removeStudentFromEducation(sID, eID);
    }

    public void deleteStudentByID(int id) {
        Student student = sDAO.findStudent(id);
        List<Education> list = student.getEducations();

        for (int i = list.size() - 1; i >= 0; i--) {
            list.get(i).removeStudent(student);
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

    public void addEducationToStudentController(int eID, int sID) {
        Education education = eDAO.findEducation(eID);
        Student student = sDAO.findStudent(sID);

        student.addEducation(education);

        sDAO.updateStudent(student);
        eDAO.updateEducation(education);
    }

}
