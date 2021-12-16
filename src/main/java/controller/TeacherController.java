package controller;

import database.CourseDAO;
import database.TeacherDAO;
import entities.Course;
import entities.Teacher;

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
        tDAO.removeTeacherFromCourse(courseId, teacherId);
    }

    public void removeTeacherByIDController(int teacherId) { //TODO
        Teacher teacher = tDAO.findTeacher(teacherId);

        List<Course> courses = teacher.getCourses();

        for (int i = courses.size() - 1; i >= 0; i--) {
            courses.get(i).removeTeacher(teacher);
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
