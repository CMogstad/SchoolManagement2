package database;

import entities.Course;
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

    @Override
    public List<Teacher> findTeacherByLastName(String lastName) {
        EntityManager em = emf.createEntityManager();

        List<Teacher> teachers = em.createQuery("SELECT t FROM Teacher t WHERE t.lastName = :name", Teacher.class)
                .setParameter("name", lastName)
                .getResultList();

        em.close();

        return teachers;
    }

    public List<Course> showCoursesOfTeacher(int id) {
        EntityManager em = emf.createEntityManager();

        Teacher teacher = em.find(Teacher.class, id);

        em.close();
        return teacher.getCourses();
    }

    public void removeTeacherFromCourse(int cID, int tID) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Teacher teacher = em.find(Teacher.class, tID);
        Course course = em.find(Course.class, cID);

        course.removeTeacher(teacher);

        em.getTransaction().commit();
        em.close();
    }
}
