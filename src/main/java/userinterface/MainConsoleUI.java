package userinterface;

import entities.Course;
import entities.Education;
import entities.Student;
import entities.Teacher;

import java.util.List;

public class MainConsoleUI {

    public void printMainMenu() {
        System.out.print("""
                                
                _______________________________________________
                                School Management
                                    Main Menu
                _______________________________________________
                1. Student Management
                2. Teacher Management
                3. Course Management
                4. Education Management
                5. Statistics
                0. Exit

                Please choose: """);
    }

    public static String fixString(int wantedSize, String stringToFix) {
        if (stringToFix.length() < wantedSize) {
            while (stringToFix.length() < wantedSize) {
                stringToFix = stringToFix + " ";
            }
            return stringToFix + "  ";
        } else
            return stringToFix.substring(0, wantedSize) + "  ";
    }

    public void teacherHeader() {
        System.out.println("""
                _______________________________________________________________________________________
                  ID          FIRST NAME                 LAST NAME               YEAR OF EMPLOYMENT               
                _______________________________________________________________________________________ """);
    }

    public void teacherFooter() {
        System.out.println("_______________________________________________________________________________________\n\n");
    }

    public void printTeacherList(List<Teacher> teachers) {
        teacherHeader();

        for (Teacher t : teachers) {
            System.out.println("  " +
                    fixString(12, String.valueOf(t.getId())) +
                    fixString(23, t.getFirstName()) +
                    fixString(26, t.getLastName()) +
                    fixString(18, String.valueOf(t.getEmploymentYear())));
        }

        teacherFooter();
    }

    public void printTeacher(Teacher teacher) {
        teacherHeader();

        System.out.println("  " +
                fixString(12, String.valueOf(teacher.getId())) +
                fixString(23, teacher.getFirstName()) +
                fixString(26, teacher.getLastName()) +
                fixString(18, String.valueOf(teacher.getEmploymentYear())));

        teacherFooter();
    }

    public void printCourse(Course course) {
        courseHeader();

        System.out.println("  " +
                MainConsoleUI.fixString(10, String.valueOf(course.getId())) +
                MainConsoleUI.fixString(18, course.getSubject()) +
                MainConsoleUI.fixString(18, String.valueOf(course.getCoursePoints())));

        courseFooter();
    }

    public void printListCourses(List<Course> courses) {
        courseHeader();

        for (Course c : courses) {
            System.out.println("  " +
                    fixString(11, String.valueOf(c.getId())) +
                    fixString(18, c.getSubject()) +
                    fixString(18, String.valueOf(c.getCoursePoints())));
        }

        courseFooter();
    }

    public void courseHeader() {
        System.out.println("""
                _______________________________________________________________________________________
                  ID          SUBJECT         COURSE POINTS    
                _______________________________________________________________________________________ """);
    }

    public void courseFooter() {
        System.out.println("_______________________________________________________________________________________\n\n");
    }

    public void studentHeader() {
        System.out.println("""
                _______________________________________________________________________________________
                  ID          FIRST NAME                 LAST NAME               DATE OF BIRTH               
                _______________________________________________________________________________________ """);
    }

    public void studentFooter() {
        System.out.println("_______________________________________________________________________________________\n\n");
    }


    public void printStudentList(List<Student> students) {
        studentHeader();

        for (Student s : students) {
            System.out.println("  " +
                    fixString(10, String.valueOf(s.getId())) +
                    fixString(25, s.getFirstName()) +
                    fixString(24, s.getLastName()) +
                    fixString(18, String.valueOf(s.getDateOfBirth())));
        }

        studentFooter();
    }

    public void educationHeader() {
        System.out.println("""
                _______________________________________________________________________________________
                  ID          NAME OF EDUCATION           
                _______________________________________________________________________________________ """);
    }

    public void educationFooter() {
        System.out.println("______________________________________________________________________________________________\n\n");
    }


    public void printEducationList(List<Education> educations) {
        educationHeader();

        for (Education e : educations) {


            System.out.println("  " +
                    fixString(10, String.valueOf(e.getId())) +
                    fixString(25, e.getName()));


        }

        educationFooter();
    }

    public void godJulOchGottNyttÅr() {
        System.out.println("""
                _______________________________________________________________________________________
                                  ✧･ﾟ:𝓜𝓮𝓻𝓻𝔂 𝓒𝓱𝓻𝓲𝓼𝓽𝓶𝓪𝓼 𝓪𝓷𝓭 𝓪 𝓱𝓪𝓹𝓹𝔂 𝓷𝓮𝔀 𝔂𝓮𝓪𝓻:･ﾟ✧      
                _______________________________________________________________________________________ """);
    }
}
