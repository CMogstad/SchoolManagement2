package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private String subject;
    private int coursePoints;

    @ManyToMany(mappedBy = "courses", cascade = CascadeType.PERSIST)
    private List<Teacher> teachers = new ArrayList<>();

    @ManyToMany
    private List<Education> educations = new ArrayList<>();

    public Course() {
    }

    public Course(String subject, int coursePoints) {
        this.subject = subject;
        this.coursePoints = coursePoints;
    }

    public void addEducation(Education education) {
        educations.add(education);
        education.getStudents().add(this);
    }

    public void removeEducation(Education education) {
        educations.remove(education);
        education.getStudents().remove(this);
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
        teacher.getCourses().add(this);
    }

    public void removeTeacher(Teacher teacher) {
        teachers.remove(teacher);
        teacher.getCourses().add(this);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getCoursePoints() {
        return coursePoints;
    }

    public void setCoursePoints(int coursePoints) {
        this.coursePoints = coursePoints;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", points=" + coursePoints +
                '}';
    }
}
