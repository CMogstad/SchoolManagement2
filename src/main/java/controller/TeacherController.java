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
    public void  updateTeacherFirstNameController (int id, String name){
        Teacher teacher = tDAO.findTeacher(id);
        teacher.setFirstName(name);
        tDAO.updateTeacher(teacher);
    }
    public void  updateTeacherLastNameController (int id, String name){
        Teacher teacher = tDAO.findTeacher(id);
        teacher.setLastName(name);
        tDAO.updateTeacher(teacher);
    }
    public void  updateTeacherEmploymentYearController (int id, int employmentYear){
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
        System.out.println("This function has not been implemented yet");
    }

    public void removeCourseFromTeacherController(int courseId, int teacherId) {
        System.out.println("This function has not been implemented yet");
    }

    public void removeTeacherByIDController(int teacherId) {
        System.out.println("This function has not been implemented yet");
    }

    public List<Teacher> findTeacherByLastNameController(String lastName) {
        System.out.println("This function has not been implemented yet");
        return null;
    }

    public List<Course> showCoursesOfTeacherController(int teacherId) {
        System.out.println("This function has not been implemented yet");
        return null;
    }
}
