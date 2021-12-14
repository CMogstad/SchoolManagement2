package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
