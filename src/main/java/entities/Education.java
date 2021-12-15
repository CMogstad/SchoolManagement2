package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@NamedQueries(
        {
                @NamedQuery(name = "Education.showAll", query = "SELECT e FROM Education e"),
                @NamedQuery(name = "Education.findByEducationName", query = "SELECT e FROM Education e WHERE e.name=:name"),

        }
)

@Entity
public class Education {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany (mappedBy = "educations", cascade = CascadeType.PERSIST)
    private List<Course> courses = new ArrayList<>();

    @ManyToMany
    private List<Student> students = new ArrayList<>();

    public void addCourse(Course course){
        courses.add(course);

        course.getEducations().add(this);
    }

    public void removeCourse(Course course){
        courses.remove(course);

        course.getEducations().remove(this);
    }

    public void addStudent(Student student){
        students.add(student);

        student.getEducations().add(this);
    }

    public void removeStudent(Student student){
        students.remove(student);

        student.getEducations().remove(this);
    }

    public Education() {
    }


    public Education(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Education{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
