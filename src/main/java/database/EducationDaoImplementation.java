package database;

import entities.Course;
import entities.Education;
import entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EducationDaoImplementation implements EducationDAO{

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    @Override
    public void addEducation(Education education) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(education);

        em.getTransaction().commit();

        em.close();

    }

    @Override
    public void updateEducation(Education education) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.merge(education);

        em.getTransaction().commit();

        em.close();


    }




    @Override
    public void removeEducation(int id) {

        EntityManager em = emf.createEntityManager();


        Education education = em.find(Education.class, id);

        em.getTransaction().begin();


        em.remove(education);

        em.getTransaction().commit();

        em.close();

    }

    @Override
    public Education findEducation(int id) {

        EntityManager em = emf.createEntityManager();


        Education education = em.find(Education.class, id);



        em.close();

        return education;


    }

    @Override
    public List<Education> findEducationByName(String name) {
        EntityManager em = emf.createEntityManager();

        List<Education> educations = em.createNamedQuery("Education.findByEducationName", Education.class)
                .setParameter("name", name)
                .getResultList();

        em.close();

        return educations;
    }

    @Override
    public List<Education> showAllEducations() {
        EntityManager em = emf.createEntityManager();

        List<Education> educations = em.createNamedQuery("Education.showAll", Education.class)
                .getResultList();

        em.close();

        return educations;
    }

    @Override
    public List<Course> listEducationCourses(int id) {
        EntityManager em = emf.createEntityManager();

        Education education = em.find(Education.class, id);

        em.close();

        return education.getCourses();
    }

    @Override
    public List<Education> showAllEducationsWithoutCourse() {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        List<Education> list = em.createQuery("SELECT e FROM Education e WHERE e.courses is empty", Education.class)
                .getResultList();

        em.getTransaction().commit();

        em.close();

        return list;


    }

    @Override
    public List<Student> listEducationStudents(int id) {

        EntityManager em = emf.createEntityManager();


        Education education = em.find(Education.class, id);


        em.close();

        return education.getStudents();

    }

    @Override
    public List<Education> listEducationWithoutStudents() {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        List<Education> educations = em.createQuery("SELECT e FROM Education e WHERE e.students is empty", Education.class)
                .getResultList();

        em.getTransaction().commit();

        em.close();

        return educations;
    }

    public void removeEducationFromCourse(int eId, int cId){
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Education education = em.find(Education.class, eId);

        Course course = em.find(Course.class, cId);

        course.removeEducation(education);

        em.getTransaction().commit();

        em.close();

    }

    public void removeEducationFromStudent(int eID, int sId){

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Education education = em.find(Education.class, eID);

        Student student = em.find(Student.class, sId);

        em.getTransaction().commit();

        em.close();



    }
}
