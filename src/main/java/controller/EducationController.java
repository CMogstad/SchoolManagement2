package controller;

import database.EducationDaoImplementation;
import entities.Course;
import entities.Education;
import entities.Student;

import java.util.List;

public class EducationController {

    EducationDaoImplementation eDao;

    public EducationController(EducationDaoImplementation eDao) {
        this.eDao = eDao;
    }

    public void addEducationController(String name) {

        Education education = new Education(name);

        eDao.addEducation(education);

    }


    public void updateEducationController(Education education) {

        eDao.updateEducation(education);

    }


    public void removeEducationController(int id) {

        Education education = eDao.findEducation(id);

        List<Course> courses = education.getCourses();

        for(Course c : courses){
            c.removeEducation(education);
        }

        List<Student> students = education.getStudents();

        for(Student s : students){
            s.removeEducation(education);
        }

        eDao.removeEducation(id);

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
