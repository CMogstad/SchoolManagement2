package database;

import entities.Education;
import entities.Student;

import java.util.List;

public interface StudentDAO {

    void addStudent(Student student);

    void updateStudent(Student student);

    void removeStudent(int id);

    Student findStudent(int id);

    List<Student> showAllStudents();

    List<Student> showAllStudentsWithoutEducation();

    List<Student> findStudentByLastName(String lastName);

}
