package controller;

import database.StatisticsDao;
import database.StatisticsDaoImplementation;
import entities.Course;
import entities.Education;
import entities.Student;
import entities.Teacher;

import javax.persistence.EntityManager;
import java.util.List;

public class StatisticsController {

    StatisticsDaoImplementation sDao;

    public void studentsByDateOfBirthController() {

       // sDao.studentsByDateOfBirth();

    }


    public void courseHighestPointsController() {

      sDao.courseHighestPoints();

    }


    public void courseLowestPointsController() {

        sDao.courseLowestPoints();

    }


    public void educationMostStudentsController() {

     sDao.educationMostStudents();

    }


    public void teacherMostCoursesController() {

        sDao.teacherMostCourses();


    }


    public void educationMostCoursesController() {

     sDao.educationMostCourses();


    }


    public void averageEmploymentYearController() {

        sDao.averageEmploymentYear();


    }


    public void numberOfStudentsByEducationController() {

     sDao.numberOfStudentsByEducation();


    }


    public void numberOfCoursesByEducationController() {

    sDao.numberOfCoursesByEducation();


    }
}
