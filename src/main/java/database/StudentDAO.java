package database;

import entities.Education;
import entities.Student;

import java.util.List;

public interface StudentDAO {

    void addStudent(Student student);

    void updateStudent(Student student);

    void removeStudent(Student student);

    Student findStudent(int id);

    List<Student> showAllStudents();

    List<Education> listStudentEducations(int id);

    List<Student> showAllStudentsWithoutEducation();

    /*
    • Add students
• Update student information
• Show information about a specific student
• Show all students
• Remove a student

• remove students from an education
• List all students in an education
     */
}
