package database;

import entities.Course;
import entities.Education;
import entities.Student;
import entities.Teacher;

import java.util.List;

public interface StatisticsDao {

    List<Student> studentsByDateOfBirth(int birthStart, int birthEnd);

    List<Course> courseHighestPoints();

    List<Course> courseLowestPoints();

    List<Education> educationMostStudents();

    List<Teacher> teacherMostCourses();

    List<Education> educationMostCourses();

    double averageEmploymentYear();

    List<Education> getListOfAllEducations();

    List<Teacher> listEmploymentYearAscOrd();

}
