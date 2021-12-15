package controller;

import database.CourseDAOImplementation;
import entities.Course;
import entities.Education;
import entities.Teacher;

import java.util.List;

public class CourseController {

    CourseDAOImplementation cDAO;

    public CourseController(CourseDAOImplementation cDAO) {
        this.cDAO = cDAO;
    }

    public void createCourse(String subject, int coursePoints) {
        Course course = new Course(subject, coursePoints);

        cDAO.addCourse(course);
    }

    public void removeCourseById(int id) {

        Course course = cDAO.findCourse(id);
        List<Teacher> teachers = course.getTeachers();
        for (Teacher t:
             teachers) {
            t.removeCourse(course);
        }
        List<Education> educations = course.getEducations();
        for (Education e:
             educations) {
            e.removeCourse(course);
        }
        cDAO.removeCourse(id);
    }

    public void updateCourseController(Course course) {

        cDAO.updateCourse(course);
    }
    public void  updateCourseSubjectController (int id, String subject){
        Course course = cDAO.findCourse(id);
        course.setSubject(subject);
        cDAO.updateCourse(course);
    }
    public void  updateCoursePointsController (int id, int coursePoints){
        Course course = cDAO.findCourse(id);
        course.setCoursePoints(coursePoints);
        cDAO.updateCourse(course);
    }

    public void addCourseToEducation(int id){
        Course course = cDAO.findCourse(id);

        Education education = null;

        for (Education e : course.getEducations()) {
            if (e.getId() == id){
                education = e;
            }
        }

        education.addCourse(course);

        cDAO.updateCourse(course);

    }

    public Course findCourseController(int id) {

        return cDAO.findCourse(id);
    }

    public List<Course> findCourseBySubjectController(String subject) {

        return cDAO.findCourseBySubject(subject);
    }

    public List<Course> showAllCoursesController() {

        return cDAO.showAllCourses();
    }

    public List<Education> listCourseEducationsController(int id) {

        return cDAO.listCourseEducations(id);
    }

    public List<Course> showAllCoursesWithoutEducationController() {

        return cDAO.showAllCoursesWithoutEducation();
    }

    public List<Teacher> listAllCourseTeachersController(int id) {

        return cDAO.listCourseTeachers(id);
    }

    public List<Course> showAllCoursesWithoutTeacherController() {

        return cDAO.showAllCoursesWithoutTeacher();
    }
}
