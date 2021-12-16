package database;

import entities.Course;
import entities.Education;
import entities.Student;

import java.util.List;

public interface EducationDAO {

    void addEducation(Education education);

    void updateEducation(Education education);

    void removeEducation(int id);

    Education findEducation(int id);

    List<Education> findEducationByName(String name);

    List<Education> showAllEducations();

    List<Course> listEducationCourses(int id);

    List<Education> showAllEducationsWithoutCourse();

    List<Student> listEducationStudents(int id);

    List<Education> listEducationWithoutStudents();

    void removeEducationFromCourse(int eId, int cId);

    void removeEducationFromStudent(int eID, int sId);

    List<Course> showAllCoursesWithoutEducation();
}
