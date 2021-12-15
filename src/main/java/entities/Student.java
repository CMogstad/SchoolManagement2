package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private int birthYear;

    @ManyToMany(mappedBy = "students", cascade = CascadeType.PERSIST)
    List<Education> educations = new ArrayList<>();

    public Student() {
    }

    public Student(String firstName, String lastName, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        birthYear = getBirthYear();
    }

    public int getBirthYear() {
        String yearStr = dateOfBirth.substring(0, 4);
        Integer yearInt = Integer.valueOf(yearStr);
        return yearInt;
    }

    public void addEducation(Education education) {
        educations.add(education);
        education.getStudents().add(this);
    }

    public void removeEducation(Education education) {
        educations.remove(education);
        education.getStudents().remove(this);
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
