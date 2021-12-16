package controller;

import database.CourseDAO;
import database.TeacherDAO;
import database.TeacherDAOImplementation;
import entities.Course;
import entities.Education;
import entities.Student;
import entities.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherController {

    TeacherDAO tDAO;
    CourseDAO cDAO;

    public TeacherController(TeacherDAO tDAO, CourseDAO cDAO) {
        this.tDAO = tDAO;
        this.cDAO = cDAO;
    }

    public void createTeacher(String firstName, String lastName, int employmentYear) {
        Teacher teacher = new Teacher(firstName, lastName, employmentYear);

        tDAO.addTeacher(teacher);
    }

    public void updateTeacherController(Teacher teacher) {
        tDAO.updateTeacher(teacher);
    }

    public void updateTeacherFirstNameController(int id, String name) {
        Teacher teacher = tDAO.findTeacher(id);
        teacher.setFirstName(name);
        tDAO.updateTeacher(teacher);
    }

    public void updateTeacherLastNameController(int id, String name) {
        Teacher teacher = tDAO.findTeacher(id);
        teacher.setLastName(name);
        tDAO.updateTeacher(teacher);
    }

    public void updateTeacherEmploymentYearController(int id, int employmentYear) {
        Teacher teacher = tDAO.findTeacher(id);
        teacher.setEmploymentYear(employmentYear);
        tDAO.updateTeacher(teacher);
    }

    public void deleteTeacherByID(int id) {
        Teacher teacher = tDAO.findTeacher(id);

        List<Course> courses = teacher.getCourses();

        for (Course c : courses) {
            c.removeTeacher(teacher);
        }

        tDAO.removeTeacher(id);
    }

    public Teacher findTeacherController(int id) {
        return tDAO.findTeacher(id);
    }

    public List<Teacher> showAllTeachersController() {
        return tDAO.showAllTeachers();
    }

    public List<Teacher> showAllTeacherWithoutCourseController() {
        return tDAO.showAllTeachersWithoutCourse();
    }

    public void addCourseToTeacherController(int courseId, int teacherId) {
        Course course = cDAO.findCourse(courseId);
        Teacher teacher = tDAO.findTeacher(teacherId);

        teacher.addCourse(course);

        cDAO.updateCourse(course);
        tDAO.updateTeacher(teacher);
    }

    public void removeCourseFromTeacherController(int courseId, int teacherId) { //TODO


        Teacher teacher = tDAO.findTeacher(teacherId);

        Course course = cDAO.findCourse(courseId);

        teacher.removeCourse(course);

        tDAO.updateTeacher(teacher);

        cDAO.updateCourse(course);


    }

    public void removeTeacherByIDController(int teacherId) { //TODO


        Teacher teacher = tDAO.findTeacher(teacherId);

        List<Course> courses = teacher.getCourses();

        for (Course c : courses) {
            c.removeTeacher(teacher);
        }

        tDAO.removeTeacher(teacherId);



    }

    public List<Teacher> findTeacherByLastNameController(String lastName) {
        return tDAO.findTeacherByLastName(lastName);
    }

    public List<Course> showCoursesOfTeacherController(int teacherId) { //TODO

        return tDAO.showCoursesOfTeacher(teacherId);


    }
}
