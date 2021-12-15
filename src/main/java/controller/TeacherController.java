package controller;

import database.TeacherDAOImplementation;
import entities.Course;
import entities.Teacher;

import java.util.List;

public class TeacherController {

    TeacherDAOImplementation tDAO;

    public TeacherController(TeacherDAOImplementation tDAO) {
        this.tDAO = tDAO;
    }

    public void createTeacher(String firstName, String lastName, int employmentYear) {
        Teacher teacher = new Teacher(firstName, lastName, employmentYear);

        tDAO.addTeacher(teacher);
    }

    public void updateTeacherController(Teacher teacher) {

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
}
