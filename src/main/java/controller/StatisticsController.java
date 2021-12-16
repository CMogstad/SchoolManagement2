package controller;

import database.StatisticsDao;
import database.StatisticsDaoImplementation;
import entities.Course;
import entities.Education;
import entities.Student;
import entities.Teacher;

import java.util.List;

public class StatisticsController {

    StatisticsDao sDao;

    public StatisticsController(StatisticsDao sDao) {
        this.sDao = sDao;
    }

    public List<Student> studentsByDateOfBirthController(int start, int end) {

        return sDao.studentsByDateOfBirth(start, end);

    }


    public List<Course> courseHighestPointsController() {

        return sDao.courseHighestPoints();

    }


    public List<Course> courseLowestPointsController() {

        return sDao.courseLowestPoints();

    }


    public List<Education> educationMostStudentsController() {

        return sDao.educationMostStudents();

    }


    public List<Teacher> teacherMostCoursesController() {

        return sDao.teacherMostCourses();

    }


    public List<Education> educationMostCoursesController() {

        return sDao.educationMostCourses();

    }


    public double averageEmploymentYearController() {

       return sDao.averageEmploymentYear();

    }

 /*   public List<Education> numberOfStudentsByEducationController() {

        return sDao.getListOfAllEducations();


    }*/

    public List<Education> getListOfAllEducationsController() {
        return sDao.getListOfAllEducations();

    }

    public List<Teacher> listEmploymentYearAscOrdController() {
        return sDao.listEmploymentYearAscOrd();
    }
    
/*    public void numberOfCoursesByEducationController() {

        sDao.numberOfCoursesByEducation();
    }*/
}
