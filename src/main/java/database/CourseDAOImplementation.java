package database;

import entities.Course;
import entities.Education;
import entities.Teacher;

import javax.persistence.*;
import java.util.List;
import java.util.OptionalInt;

public class CourseDAOImplementation implements CourseDAO {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    @Override
    public void addCourse(Course course) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.persist(course);
        t.commit();
        em.close();
    }

    @Override
    public void updateCourse(Course course) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.merge(course);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void removeCourse(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        Course course = em.find(Course.class, id);
        t.begin();
        em.remove(course);
        t.commit();
        em.close();
    }
    @Override
    public Course findCourse(int id) {
        EntityManager em = emf.createEntityManager();
        Course course = em.find(Course.class,id);
        em.close();
        return course;
    }

    @Override
    public List<Course> findCourseBySubject(String subject) {
        EntityManager em = emf.createEntityManager();

        List<Course> courses = em.createNamedQuery("Course.findByCourseSubject", Course.class).setParameter("subject", subject).getResultList();

        em.close();

        return courses;
    }

    @Override
    public List<Course> showAllCourses() {
        EntityManager em = emf.createEntityManager();

        List<Course> courses = em.createNamedQuery("Course.showAll", Course.class).getResultList();

        em.close();

        return courses;
    }

    @Override
    public List<Education> listCourseEducations(int id){
        EntityManager em = emf.createEntityManager();


        Course course = em.find(Course.class, id);


        em.close();

        return course.getEducations();
    }

    @Override
    public List<Course> showAllCoursesWithoutEducation(){
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        List<Course> list = em.createQuery("SELECT c FROM Course c WHERE c.educations is empty", Course.class).getResultList();

        em.getTransaction().commit();

        em.close();

        return list;
    }

    @Override
    public List<Teacher> listCourseTeachers(int id) {
        EntityManager em = emf.createEntityManager();


        Course course = em.find(Course.class, id);


        em.close();

        return course.getTeachers();

    }

    @Override
    public List<Course> showAllCoursesWithoutTeacher() {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        List<Course> courses = em.createQuery("SELECT c FROM Course c WHERE c.teachers is empty", Course.class).getResultList();

        em.getTransaction().commit();

        em.close();

        return courses;
    }

    @Override
    public void removeCourseFromEducation(int cId, int eId){

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Education education = em.find(Education.class, eId);

        Course course = em.find(Course.class, cId);

        education.removeCourse(course);

        em.getTransaction().commit();

        em.close();

    }

    @Override
    public void removeCourseFromTeacher(int cID, int tID){

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Teacher teacher = em.find(Teacher.class, tID);

        Course course = em.find(Course.class, cID);

        teacher.removeCourse(course);

       // course.removeTeacher(teacher);

        em.getTransaction().commit();

        em.close();

    }

}
