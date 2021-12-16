package controller;

import database.*;
import entities.Course;
import entities.Education;
import entities.Student;
import entities.Teacher;

import java.util.List;

public class CourseController {

    CourseDAO cDao;
    TeacherDAO tDao;
    EducationDAO eDao;

    public CourseController(CourseDAO cDao, TeacherDAO tDao, EducationDAO eDao) {
        this.cDao = cDao;
        this.tDao = tDao;
        this.eDao = eDao;
    }

    public void createCourse(String subject, int coursePoints) {
        Course course = new Course(subject, coursePoints);

        cDao.addCourse(course);
    }

    public void removeCourseById(int id) {

        Course course = cDao.findCourse(id);
        List<Teacher> teachers = course.getTeachers();

        for (int i = teachers.size(); i < 0; i--) {
            teachers.get(i).removeCourse(course);
        }

        List<Education> educations = course.getEducations();

        for (int i = educations.size(); i < 0; i--) {
            educations.get(i).removeCourse(course);
        }

        cDao.removeCourse(id);
    }


    public void updateCourseController(Course course) {

        cDao.updateCourse(course);
    }

    public void updateCourseSubjectController(int id, String subject) {
        Course course = cDao.findCourse(id);
        course.setSubject(subject);
        cDao.updateCourse(course);
    }

    public void updateCoursePointsController(int id, int coursePoints) {
        Course course = cDao.findCourse(id);
        course.setCoursePoints(coursePoints);
        cDao.updateCourse(course);
    }

    public void addCourseToEducationController(int cID, int eID) {
        Course course = cDao.findCourse(cID);

        Education education = eDao.findEducation(eID);

        course.addEducation(education);

        eDao.updateEducation(education);

        cDao.updateCourse(course);
    }

    public void addCourseToTeacherController(int cID, int tID) {
        Course course = cDao.findCourse(cID);

        Teacher teacher = tDao.findTeacher(tID);

        course.addTeacher(teacher);

        cDao.updateCourse(course);

        tDao.updateTeacher(teacher);
    }

    public void removeCourseFromEducationController(int cID, int eID) {

        cDao.removeCourseFromEducation(cID, eID);

    }

    public void removeCourseFromTeacher(int cID, int tID) {


        cDao.removeCourseFromTeacher(cID, tID);

    }


    public Course findCourseController(int id) {
        return cDao.findCourse(id);
    }

    public List<Course> findCourseBySubjectController(String subject) {
        return cDao.findCourseBySubject(subject);
    }

    public List<Course> showAllCoursesController() {
        return cDao.showAllCourses();
    }

    public List<Education> listCourseEducationsController(int id) {
        return cDao.listCourseEducations(id);
    }

    public List<Course> showAllCoursesWithoutEducationController() {
        return cDao.showAllCoursesWithoutEducation();
    }

    public List<Teacher> listAllCourseTeachersController(int id) {
        return cDao.listCourseTeachers(id);
    }

    public List<Course> showAllCoursesWithoutTeacherController() {
        return cDao.showAllCoursesWithoutTeacher();
    }
}
