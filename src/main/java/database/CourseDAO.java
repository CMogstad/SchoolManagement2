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

    List<Course> findCourseByName(String name);

    List<Course> showAllCourses();

    List<Education> listCourseEducations(int id);

    List<Course> showAllCoursesWithoutEducation();

    List<Teacher> listCourseTeachers(int id);

    List<Course> showAllCoursesWithoutTeacher();







    /*
• Add courses of different kind
• Update course information
• Show information about a specific course
• Show all courses
• Remove a course
         */

}
