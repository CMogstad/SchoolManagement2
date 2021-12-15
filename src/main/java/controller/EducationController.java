package controller;

import database.EducationDaoImplementation;
import entities.Course;
import entities.Education;
import entities.Student;

import javax.persistence.EntityManager;
import java.util.List;

public class EducationController {

    EducationDaoImplementation eDao;

    public void addEducationController() {

       // eDao.addEducation();

    }


    public void updateEducationController() {

       // eDao.updateEducation();

    }



    public void removeEducationController() {


       // eDao.removeEducation();

    }


    public void findEducationController() {

       // eDao.findEducation();



    }


    public void findEducationByNameController() {

       // eDao.findEducationByName();

    }


    public void showAllEducationsController() {

       // eDao.showAllEducations();


    }


    public void listEducationCoursesController() {

       // eDao.listEducationCourses();

    }


    public void showAllEducationsWithoutCourseController() {

     eDao.showAllEducationsWithoutCourse();


    }


    public void listEducationStudentsController() {

     // eDao.listEducationStudents();

    }


    public void listEducationWithoutStudentsController() {

        eDao.listEducationWithoutStudents();

    }
}
