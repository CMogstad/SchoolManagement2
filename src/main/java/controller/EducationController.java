package controller;

import database.*;
import entities.Course;
import entities.Education;
import entities.Student;

import java.util.List;

public class EducationController {

    EducationDAO eDao;
    CourseDAO cDao;
    StudentDAO sDao;

    public EducationController(EducationDAO eDao, CourseDAO cDao, StudentDAO sDao) {
        this.eDao = eDao;
        this.cDao = cDao;
        this.sDao = sDao;
    }

    public void addEducationController(String name) {
        Education education = new Education(name);
        eDao.addEducation(education);
    }


    public void updateEducationController(Education education) {
        eDao.updateEducation(education);
    }

    public void updateEducationController(int id, String newName) {
        Education education = eDao.findEducation(id);

        education.setName(newName);

        eDao.updateEducation(education);
    }

    public void addEducationToCourseController(int eID, int cID) {
        Education education = eDao.findEducation(eID);

        Course course = cDao.findCourse(cID);

        course.addEducation(education);

        cDao.updateCourse(course);

        eDao.updateEducation(education);
    }

    public void addEducationToStudentController(int eID, int sID) {
        Education education = eDao.findEducation(eID);

        Student student = sDao.findStudent(sID);

        student.addEducation(education);

        sDao.updateStudent(student);

        eDao.updateEducation(education);
    }


    public void removeEducationByIDController(int id) {
        Education education = eDao.findEducation(id);

        List<Course> courses = education.getCourses();

        for (Course c : courses) {
            c.removeEducation(education);
        }

        List<Student> students = education.getStudents();

        for (Student s : students) {
            s.removeEducation(education);
        }

        eDao.removeEducation(id);
    }

    public void removeEducationFromStudentController(int eID, int sID) {

        eDao.removeEducationFromStudent(eID, sID);

    }

    public void removeEducationFromCourseController(int eID, int cID) {

        eDao.removeEducationFromCourse(eID, cID);
    }


    public Education findEducationController(int id) {
        return eDao.findEducation(id);
    }


    public List<Education> findEducationByNameController(String name) {
        return eDao.findEducationByName(name);
    }


    public List<Education> showAllEducationsController() {
        return eDao.showAllEducations();
    }


    public List<Course> listEducationCoursesController(int id) {
        return eDao.listEducationCourses(id);
    }


    public List<Education> showAllEducationsWithoutCourseController() {
        return eDao.showAllEducationsWithoutCourse();
    }


    public List<Student> listEducationStudentsController(int id) {
        return eDao.listEducationStudents(id);
    }


    public List<Education> listEducationWithoutStudentsController() {
        return eDao.listEducationWithoutStudents();
    }
}
