package userinterface;

import controller.*;
import entities.Course;
import entities.Education;
import entities.Student;
import entities.Teacher;

import javax.persistence.EntityManager;
import java.util.List;

public class ConsoleUI {

    ConsoleInput input;
    StudentController sc;
    TeacherController tc;
    CourseController cc;
    EducationController ec;
    StatisticsController stc;

    public ConsoleUI(ConsoleInput input, StudentController sc, TeacherController tc, CourseController cc, EducationController ec, StatisticsController stc) {
        this.input = input;
        this.sc = sc;
        this.tc = tc;
        this.cc = cc;
        this.ec = ec;
        this.stc = stc;
    }

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

    public void printStudentMenu() { //TODO - Implement find student by last name
        System.out.print("""
                
                _______________________________________________
                                School Management
                                    Student Menu
                _______________________________________________
                1. Add Student
                2. Update First Name
                3. Update Last Name
                4. Update Date of Birth
                5. Add Student To Education
                6. Remove Student From Education
                7. Remove Student
                8. Find Student By Last Name
                9. Show All Students
                10. Show All Students Without Education
                0. Back to Main Menu

                Please choose: """);
    }

    public void printTeacherMenu() {
        System.out.print("""
                
                _______________________________________________
                                School Management
                                   Teacher Menu
                _______________________________________________
                1. Add Teacher
                2. Update First Name
                3. Update Last Name
                4. Update Employment Year
                5. Add Course To Teacher
                6. Remove Course From Teacher
                7. Remove Teacher
                8. Find Teacher By Last Name
                9. Show All Teachers
                10. Show All Teachers Without a Course
                11. Show All Courses of a Teacher
                0. Back to Main Menu

                Please choose: """);
    }

    public void printCourseMenu() {
        System.out.print("""
                
                _______________________________________________
                                School Management
                                   Course Menu
                _______________________________________________
                1. Add Course
                2. Update Subject
                3. Update Course Points
                4. Add Course to Education
                5. Add Course to Teacher
                6. Remove Course From Education
                7. Remove Course From Teacher
                8. Remove Course
                9. Find Course by Subject
                10. Show All Courses
                11. Show All Courses Without an Education
                12. Show All Courses Without a Teacher
                0. Back to Main Menu

                Please choose: """);
    }


    public void printEducationMenu() {
        System.out.print("""
                
                _______________________________________________
                                School Management
                                 Education Menu
                _______________________________________________
                1. Add Education
                2. Update Education Name
                3. Add Education to Course
                4. Add Education to Student
                5. Remove Education from Course
                6. Remove Education from Student
                7. Remove Education
                8. Find Education by Name
                9. Show All Educations
                10. Show All Courses of an Education
                11. Show All Student of an Education
                12. Show All Educations Without Courses
                13. Show All Educations Without Students
                0. Back to Main Menu

                Please choose: """);
    }

    public void printStatisticsMenu() {
        System.out.println("""
                
                _______________________________________________
                                School Management
                                 Statistics Menu
                _______________________________________________
                1. Show Students by Date Of Birth
                2. Show Course with highest points
                3. Show Course with lowest points
                4. Show Education with most students
                5. Show Teacher with most Courses
                6. Show Education with most Courses
                7. Show average of Employment year
                8. List Employment year Ascending Order
                9. Show number of students by Education
                10. Show numbers of courses by Education
                0. Back to Main Menu

                Please choose: """);
    }


    public void updateStudentFirstNameUI() {
        System.out.print("\nPlease enter ID of student: ");
        int studentId = input.readInt();

        System.out.print("Please enter new first name of student: ");
        String newName = input.readString();

        sc.updateStudentFirstNameController(studentId, newName);

        System.out.println("\nStudent has been updated!");
    }

    public void updateStudentLastNameUI() {
        System.out.print("\nPlease enter ID of student: ");
        int studentId = input.readInt();

        System.out.print("Please enter new last name of student: ");
        String newName = input.readString();

        sc.updateStudentLastNameController(studentId, newName);

        System.out.println("\nStudent has been updated!");
    }

    public void updateStudentDateOfBirthUI() {
        System.out.print("\nPlease enter ID of student: ");
        int studentId = input.readInt();

        System.out.print("Please enter new date of birth of student: ");
        String newDateOfBirth = input.readString();

        sc.updateStudentDateOfBirthController(studentId, newDateOfBirth);

        System.out.println("\nStudent has been updated!");
    }

   /* public void addStudentToEducationUI(){

        System.out.print("Please enter ID of student: ");

        int sID = input.readInt();

        System.out.print("Please enter ID of education: ");

        int eID = input.readInt();

        sc.addStudentToEducationController(eID, sID);

        System.out.println("Student and education has been joined! ");

    }

    public void removeStudentFromEducationUI(){

        System.out.print("Please enter ID of student: ");

        int sID = input.readInt();

        System.out.print("Please enter ID of education: ");

        int eID = input.readInt();

        sc.removeStudentFromEducationController(eID, sID);

        System.out.println("Student has been removed from education! ");

    }*/

    public void removeStudentUI() {
        System.out.print("\nPlease enter ID of student: ");
        int studentId = input.readInt();

        sc.deleteStudentByID(studentId);

        System.out.println("\nStudent has been removed!");
    }

    public void findStudentByLastNameUI() {
        System.out.print("\nPlease enter last name: ");
        String lastName = input.readString();

        List<Student> students = sc.findStudentByLastNameController(lastName);

        printList(students);
    }

    public void showAllStudentsUI() {
        List<Student> students = sc.showAllStudentsController();

        printList(students);
    }

    public void showAllStudentsWithoutEducationUI() {
        List<Student> students = sc.showAllStudentsWithoutEducationController();

        printList(students);
    }

    public void updateTeacherFirstNameUI() {
        System.out.print("\nPlease enter ID of Teacher: ");
        int teacherId = input.readInt();

        System.out.print("Please enter the new first name: ");
        String firstName = input.readString();

        tc.updateTeacherFirstNameController(teacherId, firstName);

        System.out.println("\nTeacher has been updated!");
    }

    public void updateTeacherLastNameUI() {
        System.out.print("\nPlease enter ID of Teacher: ");
        int teacherId = input.readInt();

        System.out.print("Please enter the new last name: ");
        String lastName = input.readString();

        tc.updateTeacherLastNameController(teacherId, lastName);

        System.out.println("\nLast name has been updated!");
    }

    public void updateEmploymentYearUI() {
        System.out.print("\nPlease enter ID of Teacher: ");
        int teacherId = input.readInt();

        System.out.print("Please enter new employment year: ");
        int employmentYear = input.readInt();

        tc.updateTeacherEmploymentYearController(teacherId, employmentYear);

        System.out.println("\nThe employment year has been updated!");
    }

    public void addCourseToTeacherUI() {
        System.out.print("\nPlease enter ID of Course: ");
        int courseId = input.readInt();

        System.out.print("Please enter ID of Teacher: ");
        int teacherId = input.readInt();

        tc.addCourseToTeacherController(courseId, teacherId);

        System.out.println("\nCourse has been added to teacher!");
    }

    public void removeCourseFromTeacherUI() {
        System.out.print("\nPlease enter ID of Course: ");
        int courseId = input.readInt();

        System.out.print("Please enter ID of Teacher: ");
        int teacherId = input.readInt();

        tc.removeCourseFromTeacherController(courseId, teacherId);

        System.out.println("\nCourse has been removed from teacher!");
    }

    public void removeTeacherByIDUI() {
        System.out.print("\nPlease enter ID of Teacher: ");
        int teacherId = input.readInt();

        tc.removeTeacherByIDController(teacherId);

        System.out.println("\nThe teacher has been removed!");
    }

    public void findTeacherByLastNameUI() {
        System.out.print("\nPlease enter the last name of a teacher: ");
        String lastName = input.readString();

        List<Teacher> teachers = tc.findTeacherByLastNameController(lastName);

        printList(teachers);
    }

    public void showAllTeachersUI() {
        List<Teacher> teachers = tc.showAllTeachersController();

        printList(teachers);
    }

    public void showAllTeacherWithoutCourseUI() {
        List<Teacher> teachers = tc.showAllTeacherWithoutCourseController();

        printList(teachers);
    }

    public void showCoursesOfTeacherUI() {
        System.out.print("\nPlease enter ID of Teacher: ");
        int teacherId = input.readInt();

        List<Course> courses = tc.showCoursesOfTeacherController(teacherId);

        printList(courses);
    }

    public void removeCourseByIdUI() {
        System.out.print("\nPlease enter ID of course: ");
        int courseId = input.readInt();

        cc.removeCourseById(courseId);

        System.out.println("\nThe course has been removed!");
    }

    public void findCourseByIdUI() {
        System.out.print("\nPlease enter ID of course: ");
        int courseId = input.readInt();

        Course course = cc.findCourseController(courseId);

        printCourse(course);
    }

    public void findCourseBySubjectUI() {
        System.out.print("\nPlease enter subject of course: ");
        String subject = input.readString();

        List<Course> courses = cc.findCourseBySubjectController(subject);

        printList(courses);
    }

    public void showAllCoursesUI() {
        List<Course> courses = cc.showAllCoursesController();

        printList(courses);
    }

    public void listCourseEducationsUI() {
        System.out.print("\nPlease enter ID of course: ");
        int courseId = input.readInt();

        List<Education> educations = cc.listCourseEducationsController(courseId);

        printList(educations);
    }

    public void showAllCoursesWithoutEducationUI() {
        List<Course> courses = cc.showAllCoursesWithoutEducationController();

        printList(courses);
    }

    public void listAllCourseTeachersUI() {
        System.out.print("\nPlease enter ID of course: ");
        int courseId = input.readInt();

        List<Teacher> teachers = cc.listAllCourseTeachersController(courseId);

        printList(teachers);
    }

    public void showAllCoursesWithoutTeacherUI() {
        List<Course> courses = cc.showAllCoursesWithoutTeacherController();

        printList(courses);
    }

    public void updateEducationNameUI() {
        System.out.print("\nPlease enter ID of education: ");
        int id = input.readInt();

        System.out.print("Please enter new first name of Education: ");
        String newName = input.readString();

        ec.updateEducationController(id, newName);

        System.out.println("\nEducation has been updated!");
    }

    public void addEducationToCourseUI() {
        System.out.print("\nPlease enter ID of education: ");
        int eID = input.readInt();

        System.out.print("Please enter ID of course: ");
        int cID = input.readInt();

        ec.addEducationToCourseController(eID, cID);

        System.out.println("\nEducation and Course has been joined! ");
    }

    public void addEducationToStudentUI() {
        System.out.print("\nPlease enter ID of education: ");
        int eID = input.readInt();

        System.out.print("Please enter ID of student: ");
        int sID = input.readInt();

        ec.addEducationToStudentController(eID, sID);

        System.out.println("Education and student has been joined! ");
    }

    public void removeEducationUI() {
        System.out.print("\nPlease enter ID of the education you want to remove: ");
        int id = input.readInt();

        ec.removeEducationByIDController(id);

        System.out.println("\nEducation has been removed! ");
    }

    public void removeEducationFromStudentUI() {
        System.out.print("\nPlease enter ID of education you want to remove: ");
        int eID = input.readInt();

        System.out.print("Please enter ID of student: ");
        int sID = input.readInt();

        ec.removeEducationFromStudentController(eID, sID);

        System.out.println("\nEducation has been removed from student!");
    }

    public void removeEducationFromCourseUI() {
        System.out.print("\nPlease enter ID of education you want to remove: ");
        int eID = input.readInt();

        System.out.print("Please enter ID of course: ");
        int cID = input.readInt();

        ec.removeEducationFromCourseController(eID, cID);

        System.out.println("\nEducation has been removed from student!");
    }

    public void findEducationByNameUI() {
        System.out.println("\nPlease enter name of education: ");
        String name = input.readString();

        printList(ec.findEducationByNameController(name));
    }

    public void showAllEducationsUI() {
        printList(ec.showAllEducationsController());
    }

    public void listEducationCoursesController() {
        System.out.print("\nPlease enter ID of education: ");
        int id = input.readInt();

        printList(ec.listEducationCoursesController(id));
    }

    public void showAllEducationsWithoutCourseUI() {
        printList(ec.showAllEducationsWithoutCourseController());
    }

    public void listEducationStudentsUI() {
        System.out.print("\nPlease enter ID of education: ");
        int id = input.readInt();

        printList(ec.listEducationStudentsController(id));
    }

    public void listEducationWithoutStudentsUI() {
        printList(ec.listEducationWithoutStudentsController());
    }

    public void readCourseUI() {
        System.out.print("\nPlease enter name of course subject: ");
        String subject = input.readString();

        System.out.print("Please enter course points: ");
        int points = input.readInt();

        cc.createCourse(subject, points);

        System.out.println("\nCourse has been added!");
    }

    public void readEducationUI() {
        System.out.print("\nPlease enter name of Education: ");
        String educationName = input.readString();

        ec.addEducationController(educationName);

        System.out.println("\nEducation has been added!");
    }

    public void readStudentUI() {
        System.out.print("\nPlease enter first name: ");
        String firstName = input.readString();

        System.out.print("Please enter last name: ");
        String lastName = input.readString();

        System.out.print("Please enter date of birth: ");
        String dateOfBirth = input.readString();

        sc.createStudentController(firstName, lastName, dateOfBirth);

        System.out.println("\nStudent has been added!");
    }

    public void readTeacherUI() {
        System.out.print("\nPlease enter first name: ");
        String firstName = input.readString();

        System.out.print("Please enter last name: ");
        String lastName = input.readString();

        System.out.print("Please enter employment Year: ");
        int employmentYear = input.readInt();

        tc.createTeacher(firstName, lastName, employmentYear);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printEducation(Education education) {
        System.out.println(education);
    }

    public void printTeacher(Teacher teacher) {
        System.out.println(teacher);
    }

    public void printCourse(Course course) {
        System.out.println(course);
    }

    public void printStudent(Student student) {
        System.out.println(student);
    }

    public void printList(List list) {
        list.forEach(System.out::println);
    }

    public void updateCourseSubjectUI() {

        System.out.println("Please enter ID of course: ");

        int id = input.readInt();

        System.out.println("Please enter new subject: ");

        String subject = input.readString();

        cc.updateCourseSubjectController(id, subject);

        System.out.println("Course subject has been updated!");

    }

    public void updateCoursePointsUI() {
        System.out.println("Please enter ID of Course: ");

        int id = input.readInt();

        System.out.println("Please enter new course points: ");

        int coursePoints = input.readInt();

        cc.updateCoursePointsController(id, coursePoints);

        System.out.println("Course points have been updated!");

    }

    public void showAllEducationsWithoutStudentsUI() { //TODO
        System.out.println("Not implemented yet!");

    }

}
