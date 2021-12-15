package userinterface;

import controller.CourseController;
import controller.EducationController;
import controller.StudentController;
import controller.TeacherController;
import database.EducationDaoImplementation;
import database.TeacherDAOImplementation;
import entities.Course;
import entities.Education;
import entities.Student;
import entities.Teacher;

import java.util.List;

public class ConsoleUI {

    ConsoleInput input;

    StudentController sc;

    TeacherController tc;

    CourseController cc;

    EducationController ec;

    public void printMainMenu() {
        System.out.println("""
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
        System.out.println("""
                _______________________________________________
                                School Management
                                    Student Menu
                _______________________________________________
                1. Add Student
                2. Update First Name
                3. Update Last Name
                4. Update Date of Birth
                5. Add Education To Student
                6. Remove Education From Student
                7. Remove Student
                8. Find Student By Last Name
                9. Show All Students
                10. Show All Students Without Education
                0. Back to Main Menu

                Please choose: """);
    }

    public void printTeacherMenu() {
        System.out.println("""
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
        System.out.println("""
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
                9. Find Course by Name
                10. Show All Courses
                11. Show All Courses Without an Education
                12. Show All Courses Without a Teacher
                0. Back to Main Menu

                Please choose: """);
    }


    public void printEducationMenu() {
        System.out.println("""
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


    public void updateStudentFirstNameUI(){

        System.out.println("Please enter id of student: ");

        int id = input.readInt();

        System.out.println("Please enter new first name of student: ");

        String newName = input.readString();

        sc.updateStudentFirstNameController(id, newName);

        System.out.println("Student has been updated!");

    }
    public void updateStudentLastNameUI(){

        System.out.println("Please enter id of student: ");

        int id = input.readInt();

        System.out.println("Please enter new last name of student: ");

        String newName = input.readString();

        sc.updateStudentFirstNameController(id, newName);

        System.out.println("Student has been updated!");

        System.out.println("Hej");

    }
    public void updateStudentDateOfBirthUI(){

        System.out.println("Please enter id of student: ");

        int id = input.readInt();

        System.out.println("Please enter new date of birth of student: ");

        String newDateOfBirth = input.readString();

        sc.updateStudentDateOfBirthController(id, newDateOfBirth);

        System.out.println("Student has been updated!");

    }

    public void removeEducationFromStudent(){


        }

       public void removeStudentUI(){


}


       public void findStudentByLastNameUI(){

        }

        public void showAllStudentsUI(){


        }

      public void  showAllStudentsWithoutEducationUI(){


        }



    public void updateTeacherFirstNameUI() {


    }

    public void updateTeacherLastNameUI() {


    }

    public void updateEmploymentYearUI(){


    }

    public void addCourseToTeacherUI(){


    }

    public void removeCourseFromTeacherUI(){


    }

    public void removeTeacherByIDUI(){


    }


    public void findTeacherByLastNameUI() {


    }

    public void showAllTeachersUI() {



    }

    public void showAllTeacherWithoutCourseUI() {


    }

    public void showCoursesOfTeacherUI(){


    }

    public void removeCourseById() {


    }

    public void updateCourseController() {


    }

    public void findCourseController() {


    }

    public void findCourseBySubjectUI() {


    }

    public void showAllCoursesUI() {


    }

    public void listCourseEducationsUI() {


    }

    public void showAllCoursesWithoutEducationUI() {

    }

    public void listAllCourseTeachersUI() {

    }

    public void showAllCoursesWithoutTeacherUI() {

    }



    public void updateEducationByNameUI() {
        System.out.println("Please enter id of education: ");

        int id = input.readInt();

        System.out.println("Please enter new first name of Education: ");

        String newName = input.readString();

        ec.updateEducationController(id, newName);

        System.out.println("Education has been updated!");

    }

    public void addEducationToCourseUI(){

        System.out.println("Please enter id of education: ");

        int eID = input.readInt();

        System.out.println("Please enter id of course: ");

        int cID = input.readInt();

        ec.addEducationToCourseController(eID, cID);

        System.out.println("Education and Course has been joined! ");


    }

    public void addEducationToStudentUI(){

        System.out.println("Please enter id of education: ");

        int eID = input.readInt();

        System.out.println("Please enter id of student: ");

        int sID = input.readInt();


        ec.addEducationToStudentController(eID, sID);

        System.out.println("Education and student has been joined! ");


    }


    public void removeEducationUI() {

        System.out.println("Please enter id of the education you want to remove: ");

        int id = input.readInt();

        ec.removeEducationByIDController(id);

        System.out.println("Education has been removed! ");


    }

    public void removeEducationFromStudentUI(){

        System.out.println("Please enter id of education you want to remove: ");

        int eID = input.readInt();

        System.out.println("Please enter id of student: ");

        int sID = input.readInt();

        ec.removeEducationFromStudentController(eID, sID);

        System.out.println("Education has been removed from student!");


    }

    public void removeEducationFromCourse(){

        System.out.println("Please enter id of education you want to remove: ");

        int eID = input.readInt();

        System.out.println("Please enter id of course: ");

        int cID = input.readInt();

        ec.removeEducationFromCourseController(eID, cID);

        System.out.println("Education has been removed from student!");

    }


    public void findEducationByNameUI() {

        System.out.println("Please enter name of education : ");

        String name = input.readString();

        printList(ec.findEducationByNameController(name));




    }


    public void showAllEducationsUI() {

        printList(ec.showAllEducationsController());

    }


    public void listEducationCoursesController() {

        System.out.println("Please enter id of education: ");

        int id = input.readInt();

        printList(ec.listEducationCoursesController(id));

    }


    public void showAllEducationsWithoutCourseUI() {


        printList(ec.showAllEducationsWithoutCourseController());


    }


    public void listEducationStudentsUI() {

        System.out.println("Please enter id of education: ");

        int id = input.readInt();

        printList(ec.listEducationStudentsController(id));

    }


    public void listEducationWithoutStudentsUI() {

        printList(ec.listEducationWithoutStudentsController());

    }


    public void readCourseUI() {


        System.out.println("Please enter name of course subject : ");

        String subject = input.readString();

        System.out.println("Please enter course points: ");

        int points = input.readInt();

        cc.createCourse(subject, points);

        System.out.println("Course has been added!");

    }
    public void readEducationUI() {



        System.out.println("Please enter name of Education: ");

        String educationName = input.readString();

        ec.addEducationController(educationName);

        System.out.println("Student has been updated!");

    }

    public void readStudentUI() {


        System.out.println("Please enter first name : ");

        String firstName = input.readString();

        System.out.println("Please enter last name : ");

        String lastName = input.readString();

        System.out.println("Please enter date of birth");

        String dateOfBirth = input.readString();

        sc.createStudentController(firstName, lastName, dateOfBirth);

        System.out.println("Education has been added!");



    }

    public void readTeacherUI() {


        System.out.println("Please enter first name : ");

        String firstName = input.readString();


        System.out.println("Please enter last name : ");

        String lastName = input.readString();


        System.out.println("Please enter employment Year : ");

        int employmentYear = input.readInt();

        tc.createTeacher(firstName, lastName, employmentYear);


    }

    public void printMessage(String message) {

        System.out.println(message);

    }

    public void printEducation(Education education){

        System.out.println(education);

    }

    public void printTeacher(Teacher teacher){

        System.out.println(teacher);

    }

    public void printCourse(Course course){

        System.out.println(course);

    }

    public void printStudent(Student student){

        System.out.println(student);

    }

    public void printList(List list) {

        list.forEach(System.out::println);

    }
}
