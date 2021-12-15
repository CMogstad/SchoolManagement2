package database;

import entities.Course;
import entities.Education;
import entities.Student;
import entities.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class StatisticsDaoImplementation implements StatisticsDao {

    //Sortera baserat på poäng
    // Sortera baserat på arraylist

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    @Override
    public List<Student> studentsByDateOfBirth(int birthStart, int birthEnd) {

        EntityManager em = emf.createEntityManager();

        /* List list = em.createQuery("SELECT c FROM Customer c WHERE c.bank.bankName=:bankName", Customer.class)
                .setParameter("bankName", bankName)
                .getResultList();*/

        List<Student> students = em.createQuery("SELECT s FROM Student s WHERE s.dateOfBirth >=:birthStart AND s.dateOfBirth <=:birthEnd", Student.class)
                .setParameter("birthStart", birthStart)
                .setParameter("birthEnd", birthEnd)
                .getResultList();

        em.close();

        return students;

    }

    @Override
    public List<Course> courseHighestPoints() {

        EntityManager em = emf.createEntityManager();

        List<Course> courses = em.createQuery("SELECT max(c.coursePoints) FROM Course c ", Course.class)
                .getResultList();

        //SELECT p FROM Product p WHERE p.value(SELECT AVG(q.value) FROM Product q)

        //(count, sum, avg, max, min)

        em.close();

        return courses;


    }

    @Override
    public List<Course> courseLowestPoints() {
        EntityManager em = emf.createEntityManager();

        List<Course> courses = em.createQuery("SELECT min(c.coursePoints) FROM Course c ", Course.class)
                .getResultList();



        em.close();

        return courses;

    }

    @Override
    public List educationMostStudents() {

        EntityManager em = emf.createEntityManager();

       /* List list = em.createQuery("SELECT c FROM Customer c WHERE c.banks is empty", Customer.class)
                .getResultList();*/

        List list = em.createQuery("SELECT max(e.students) FROM Education e", Education.class)
                .getResultList();

        em.close();

         return list;

    }

    @Override
    public List teacherMostCourses() {

        EntityManager em = emf.createEntityManager();

        List list = em.createQuery("SELECT max(t.courses) FROM Teacher t", Teacher.class)
                .getResultList();

        em.close();

        return list;

    }

    @Override
    public List educationMostCourses() {

        EntityManager em = emf.createEntityManager();

        List list = em.createQuery("SELECT max(e.courses) FROM Education e", Education.class)
                .getResultList();

        em.close();

        return list;


    }

    @Override
    public List averageEmploymentYear() {

        EntityManager em = emf.createEntityManager();

        List list = em.createQuery("SELECT avg(t.employmentYear) FROM Teacher t", Teacher.class)
                .getResultList();

        em.close();

        return list;

    }

    @Override
    public List numberOfStudentsByEducation() {

        EntityManager em = emf.createEntityManager();

        List list = em.createQuery("SELECT count(e.students) FROM Education e", Education.class)
                .getResultList();

        em.close();

        return list;


    }

    @Override
    public List listEmploymentYearAscOrd() {

        EntityManager em = emf.createEntityManager();

        List list = em.createQuery("SELECT t FROM Teacher t ORDER BY t.employmentYear ASC", Teacher.class)
                .getResultList();

        return list;


    }


    @Override
    public List numberOfCoursesByEducation() {

        EntityManager em = emf.createEntityManager();

        List list = em.createQuery("SELECT count(e.courses) FROM Education e", Education.class)
                .getResultList();

        return list;


    }
}
