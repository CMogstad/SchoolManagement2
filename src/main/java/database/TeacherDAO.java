package database;

import entities.Course;
import entities.Teacher;
import java.util.List;

public interface TeacherDAO {

    void addTeacher(Teacher teacher);

    void updateTeacher(Teacher teacher);

    void removeTeacher(int id);

    Teacher findTeacher(int id);

    List<Teacher> showAllTeachers();

    List<Teacher> showAllTeachersWithoutCourse();

    List<Teacher> findTeacherByLastName(String lastName);

    List<Course> showCoursesOfTeacher(int id);

    void removeTeacherFromCourse(int cID, int tID);

    /*
    • Add teachers to educations
• List all teachers in an education
• remove teachers from educations
• Add teachers to educations
     */
}
