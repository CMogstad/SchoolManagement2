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

    List<Course> listTeacherCourses(int id);

    List<Teacher> showAllTeachersWithoutCourse();

    /*
    • Add teachers to educations
• List all teachers in an education
• remove teachers from educations
• Add teachers to educations
     */
}
