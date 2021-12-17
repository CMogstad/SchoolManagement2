package database;

import entities.Education;
import entities.Student;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;

public class StudentImpDAO implements StudentDAO {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    @Override
    public void addStudent(Student student) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();

        t.begin();

        em.persist(student);

        t.commit();
        em.close();
    }

    @Override
    public void updateStudent(Student student) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.merge(student);
        em.getTransaction().commit();

        em.close();
    }

    public void removeStudentFromEducation(int sID, int eID) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Student student = em.find(Student.class, sID);
        Education education = em.find(Education.class, eID);

        education.removeStudent(student);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void removeStudent(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();

        Student student = em.find(Student.class, id);

        t.begin();

        em.remove(student);

        t.commit();
        em.close();
    }

    @Override
    public Student findStudent(int id) {
        EntityManager em = emf.createEntityManager();

        HashMap<String, Object> props = new HashMap<String, Object>();
        props.put("javax.persistence.cache.retrieveMode", CacheRetrieveMode.BYPASS);

        Student student = em.find(Student.class, id, props);

        em.close();
        return student;
    }

    @Override
    public List<Student> showAllStudents() {
        EntityManager em = emf.createEntityManager();

        List<Student> students = em.createQuery("SELECT s FROM Student s", Student.class)
                .getResultList();

        em.close();
        return students;
    }

    @Override
    public List<Student> showAllStudentsWithoutEducation() {
        EntityManager em = emf.createEntityManager();

        List<Student> students = em.createQuery("SELECT s FROM Student s WHERE s.educations is empty", Student.class)
                .getResultList();

        em.close();
        return students;
    }

    @Override
    public List<Student> findStudentByLastName(String lastName) {
        EntityManager em = emf.createEntityManager();

        List<Student> students = em.createQuery("SELECT s FROM Student s WHERE s.lastName = :name", Student.class)
                .setParameter("name", lastName)
                .getResultList();

        em.close();

        return students;
    }
}