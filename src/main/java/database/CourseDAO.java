package database;

import entities.Course;
import entities.Education;
import entities.Teacher;

import java.util.List;

public interface CourseDAO {

    void addCourse(Course course);

    void updateCourse(Course course);

    void removeCourse(int id);

    Course findCourse(int id);

    List<Course> findCourseBySubject(String subject);

    List<Course> showAllCourses();

    List<Education> listCourseEducations(int id);

    List<Course> showAllCoursesWithoutEducation();

    List<Teacher> listCourseTeachers(int id);

    List<Course> showAllCoursesWithoutTeacher();

    void removeCourseFromTeacher(int cID, int tID);

    void removeCourseFromEducation(int cId, int eId);


}
