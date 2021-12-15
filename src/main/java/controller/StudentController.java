package controller;

import database.EducationDAO;
import database.EducationDaoImplementation;
import database.StudentImpDAO;
import entities.Education;
import entities.Student;

import java.util.List;

public class StudentController {

    StudentImpDAO sDAO;

    public StudentController(StudentImpDAO sDAO) {
        this.sDAO = sDAO;
    }

    public void createStudentController(String firstName, String lastName, String dateOfBirth) {
        Student student = new Student(firstName, lastName, dateOfBirth);

        sDAO.addStudent(student);
    }

    public void updateStudentController(Student student) {
        sDAO.updateStudent(student);
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

   /* public void addStudentToEducationController(int eID, int sID){

        Education education = eDAO.findEducation(eID);

        Student student = sDAO.findStudent(sID);

        education.addStudent(student);

        sDAO.updateStudent(student);

        eDAO.updateEducation(education);

    }

    public void removeStudentFromEducationController(int eID, int sID){

        Education education = eDAO.findEducation(eID);

        Student student = sDAO.findStudent(sID);

        education.removeStudent(student);

        eDAO.updateEducation(education);

        sDAO.updateStudent(student);


    }*/

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

    public void removeStudentController(int studentId) {
        sDAO.removeStudent(studentId);
    }

    public List<Student> findStudentByLastNameController(String lastName) {
        return sDAO.findStudentByLastName(lastName);
    }
}
