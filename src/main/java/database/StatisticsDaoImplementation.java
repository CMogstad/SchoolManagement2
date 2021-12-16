package database;

import entities.Course;
import entities.Education;
import entities.Student;
import entities.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;


public class StatisticsDaoImplementation implements StatisticsDao {


    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    @Override
    public List<Student> studentsByDateOfBirth(int birthStart, int birthEnd) {

        EntityManager em = emf.createEntityManager();

        /* List list = em.createQuery("SELECT c FROM Customer c WHERE c.bank.bankName=:bankName", Customer.class)
                .setParameter("bankName", bankName)
                .getResultList();*/

        /*List<Student> students = em.createQuery("SELECT s FROM Student s WHERE s.dateOfBirth >=:birthStart AND s.dateOfBirth <=:birthEnd", Student.class)
                .setParameter("birthStart", birthStart)
                .setParameter("birthEnd", birthEnd)
                .getResultList();
        em.close();
        return students;*/

        List<Student> students = em.createQuery("SELECT s FROM Student s WHERE s.birthYear >=:birthStart AND s.birthYear <=:birthEnd", Student.class)
                .setParameter("birthStart", birthStart)
                .setParameter("birthEnd", birthEnd)
                .getResultList();
        em.close();
        return students;
    }

    @Override
    public List<Course> courseHighestPoints() {
        EntityManager em = emf.createEntityManager();

        // List<Course> courses = em.createQuery("SELECT max(c.coursePoints) FROM Course c ", Course.class)
        //       .getResultList();

        //SELECT p FROM Product p WHERE p.value(SELECT AVG(q.value) FROM Product q)

        //(count, sum, avg, max, min)

        TypedQuery<Course> tq = em.createQuery("SELECT c FROM Course c", Course.class);
        int maxPoints = tq.getResultStream().mapToInt(c -> c.getCoursePoints()).max().orElse(0);

        List<Course> list = tq.getResultStream().filter(c -> c.getCoursePoints() == maxPoints).collect(Collectors.toList());

        em.close();

        return list;
    }

    @Override
    public List<Course> courseLowestPoints() {
        EntityManager em = emf.createEntityManager();

       /* List<Course> courses = em.createQuery("SELECT min(c.coursePoints) FROM Course c ", Course.class)
                .getResultList();*/

        TypedQuery<Course> tq = em.createQuery("SELECT c FROM Course c", Course.class);
        int minPoints = tq.getResultStream().mapToInt(c -> c.getCoursePoints()).min().orElse(0);

        List<Course> list = tq.getResultStream().filter(c -> c.getCoursePoints() == minPoints).collect(Collectors.toList());

        em.close();

        return list;
    }

    @Override
    public List<Education> educationMostStudents() {

        EntityManager em = emf.createEntityManager();

       /* List list = em.createQuery("SELECT c FROM Customer c WHERE c.banks is empty", Customer.class)
                .getResultList();*/

        /*List list = em.createQuery("SELECT max(e.students) FROM Education e", Education.class)
                .getResultList();*/

        TypedQuery<Education> tq = em.createQuery("SELECT e FROM Education e", Education.class);
        int mostStudents = tq.getResultStream().mapToInt(e -> e.getStudents().size()).max().orElse(0);

        List<Education> list = tq.getResultStream().filter(e -> e.getStudents().size() == mostStudents).collect(Collectors.toList());

        em.close();

        return list;
    }

    @Override
    public List<Teacher> teacherMostCourses() {

        EntityManager em = emf.createEntityManager();

        /*List list = em.createQuery("SELECT max(t.courses) FROM Teacher t", Teacher.class)
                .getResultList();*/

        TypedQuery<Teacher> tq = em.createQuery("SELECT t FROM Teacher t", Teacher.class);
        int mostCourses = tq.getResultStream().mapToInt(t -> t.getCourses().size()).max().orElse(0);

        List<Teacher> list = tq.getResultStream().filter(t -> t.getCourses().size() == mostCourses).collect(Collectors.toList());

        em.close();

        return list;
    }

    @Override
    public List<Education> educationMostCourses() {

        EntityManager em = emf.createEntityManager();

        /*List list = em.createQuery("SELECT max(e.courses) FROM Education e", Education.class)
                .getResultList();*/

        TypedQuery<Education> tq = em.createQuery("SELECT e FROM Education e", Education.class);
        int mostCourses = tq.getResultStream().mapToInt(e -> e.getCourses().size()).max().orElse(0);

        List<Education> list = tq.getResultStream().filter(e -> e.getCourses().size() == mostCourses).collect(Collectors.toList());

        em.close();

        return list;
    }

    @Override
    public double averageEmploymentYear() {

        EntityManager em = emf.createEntityManager();

       /* List list = em.createQuery("SELECT avg(t.employmentYear) FROM Teacher t", Teacher.class)
                .getResultList();*/

        TypedQuery<Teacher> tq = em.createQuery("SELECT t FROM Teacher t", Teacher.class);
        double avgYear = tq.getResultStream().mapToInt(t -> t.getEmploymentYear()).average().orElse(0);

        em.close();

        return avgYear;
    }

    @Override
    public List<Education> getListOfAllEducations() {

        EntityManager em = emf.createEntityManager();

        TypedQuery<Education> tq = em.createQuery("SELECT e FROM Education e", Education.class);

        List<Education> list = tq.getResultList();

        em.close();

        return list;
    }

    @Override
    public List<Teacher> listEmploymentYearAscOrd() {

        EntityManager em = emf.createEntityManager();

        /*List list = em.createQuery("SELECT t FROM Teacher t ORDER BY t.employmentYear ASC", Teacher.class)
                .getResultList();*/

        TypedQuery<Teacher> tq = em.createQuery("SELECT t FROM Teacher t", Teacher.class);

        List<Teacher> list = tq.getResultStream()
                .sorted((t1, t2) -> t1.getEmploymentYear() - t2.getEmploymentYear())
                .collect(Collectors.toList());

        em.close();

        return list;
    }


/*    @Override
    public List numberOfCoursesByEducation() {

        EntityManager em = emf.createEntityManager();

        *//*List list = em.createQuery("SELECT count(e.courses) FROM Education e", Education.class)
                .getResultList();*//*



        return list;


    }*/
}
