package database;

import entities.Course;
import entities.Student;

import java.util.List;

public interface StatisticsDao {

    List<Student> studentsByDateOfBirth(int birthStart, int birthEnd);

    List<Course>  courseHighestPoints();

    List<Course> courseLowestPoints();

    List educationMostStudents();

    List teacherMostCourses();

    List educationMostCourses();

    List averageEmploymentYear();

    List numberOfStudentsByEducation();

    List numberOfCoursesByEducation();

    List listEmployentYearAscOrd();


}
