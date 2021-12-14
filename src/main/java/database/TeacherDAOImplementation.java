package database;

import entities.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class TeacherDAOImplementation implements TeacherDAO {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    @Override
    public void addTeacher(Teacher teacher) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(teacher);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.merge(teacher);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void removeTeacher(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Teacher teacher = em.find(Teacher.class, id);
        em.remove(teacher);

        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Teacher findTeacher(int id) {
        EntityManager em = emf.createEntityManager();

        Teacher teacher = em.find(Teacher.class, id);
        em.close();

        return teacher;
    }

    @Override
    public List<Teacher> showAllTeachers() {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Teacher> tq = em.createQuery("SELECT t from Teacher t", Teacher.class);
        List<Teacher> teachers = tq.getResultList();

        em.close();

        return teachers;
    }

    @Override
    public List<Teacher> showAllTeachersWithoutCourse() {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Teacher> tq = em.createQuery("SELECT t from Teacher t WHERE t.courses IS empty", Teacher.class);
        List<Teacher> teachers = tq.getResultList();

        em.close();

        return teachers;
    }
}
