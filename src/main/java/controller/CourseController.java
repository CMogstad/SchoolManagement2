package controller;

import database.CourseDAOImplementation;
import entities.Course;

public class CourseController {

    CourseDAOImplementation cDAO = new CourseDAOImplementation();

    public void createCourse(String subject, int coursePoints) {
        Course course = new Course(subject, coursePoints);

        cDAO.addCourse(course);
    }

    public void removeCourseById(int id) {

        cDAO.removeCourse(id);
    }

    public void updateCourseController(Course course) {

        cDAO.updateCourse(course);
    }

    public void findCourseController(int id) {

        cDAO.findCourse(id);
    }

    public void findCourseBySubjectController(String subject) {

        cDAO.findCourseBySubject(subject);
    }

    public void showAllCoursesController() {

        cDAO.showAllCourses();
    }

    public void listCourseEducationsController(int id) {

        cDAO.listCourseEducations(id);
    }

    public void showAllCoursesWithoutEducationController() {

        cDAO.showAllCoursesWithoutEducation();
    }

    public void listAllCourseTeachersController(int id) {

        cDAO.listCourseTeachers(id);
    }

    public void showAllCoursesWithoutTeacherController() {

        cDAO.showAllCoursesWithoutTeacher();
    }
}
