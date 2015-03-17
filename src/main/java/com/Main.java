package main.java.com;

import main.java.com.DAO.Factory;
import main.java.com.logic.University;
import main.java.com.logic.Student;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

/**
 * @author Aleksandr Konstantinovitch
 * @version 1.0
 * @date 30/01/2015
 ** {@link http://www.dzone.com/tutorials/java/hibernate/hibernate-example/hibernate-mapping-many-to-one-using-annotations-1.html}
 * {@link http://www.tutorialspoint.com/hibernate/hibernate_many_to_one_mapping.htm}
 * {@link http://j4sq.blogspot.com/2011/09/hibernate-reference-manual.html}
 * *****************************************************
 * CREATE DATABASE bookstore2 CHARACTER SET utf8 COLLATE utf8_general_ci
 * *****************************************************
 */
public class Main {

	public static void main(String[] args) throws SQLException{
        Random    rand = new Random();
        int randNumber = rand.nextInt(100);
//        // Создадим двух студентов
//        University university = new University("OMR Road " + randNumber, "Chennai " + randNumber, "TN " + randNumber, String.valueOf(randNumber));
//        add("Ivanov-" + String.valueOf(randNumber), 23l, university);
//        add("Petrova-" + String.valueOf(randNumber), 19l, university);

        // Выведем всех студентов из базы данных
        print();

//        // Выведем только 3-студента из базы данных
//        print(3);

//        // Выведем только одного студента из базы данных
//        printId(3l);

        // Поиск студентов в базе данных по: имени и возрасту
        printFind("Ivanov", 20l, 30l);

        // Поиск студентов в базе данных по: имени/возрасту и сортировка
        printFindSort("Ivanov", 20l, 40l, 2);

        randNumber = rand.nextInt(100);
//        // Обновим только одного студента в базе данных
//        University updateUniversity = new University("OMR Road " + randNumber, "Chennai " + randNumber, "TN " + randNumber, String.valueOf(randNumber));
//        updateId(5l, "Aaaa-" + String.valueOf(randNumber), 33l, updateUniversity);
//        updateId(6l, "Bbbb-" + String.valueOf(randNumber), 29l, updateUniversity);
//        print();

//        // Удалим только одного студента из базы данных
//        delete(1l);
//        delete(2l);
//        print();
	}


    public static void add(String name, Long age, University university) throws SQLException{
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        student.setUniversity(university);
        // Сохраним их в бд, id будут сгенерированы автоматически
        Factory.getInstance().getStudentDAO().addStudent(student);
    }

    public static void print() throws SQLException{
        List<Student> students = Factory.getInstance().getStudentDAO().getAllStudents();
        System.out.println("\nВыведем всех студентов из базы данных");
        System.out.println("+--------+-------------------+-------+-------------+");
        System.out.println("|   ID   |        NAME       |  AGE  |  UNIVERSITY |");
        System.out.println("+--------+-------------------+-------+-------------+");
        for(int i = 0; i < students.size(); ++i) {
            String strOut = "|   " + students.get(i).getId() + "      ";
            strOut = strOut.substring(0,9);
            strOut += strOut = "|   " + students.get(i).getName() + "         ";
            strOut = strOut.substring(0,29);
            strOut += strOut = "|   " + students.get(i).getAge() + "         ";
            strOut = strOut.substring(0,37);
            strOut += strOut = "| " + students.get(i).getUniversity().getCity() + "         ";
            strOut = strOut.substring(0,50) + " |";
            System.out.println( strOut );
            System.out.println("+--------+-------------------+-------+-------------+");
        }
    }

    public static void print(int maxStudents) throws SQLException{
        List<Student> students = Factory.getInstance().getStudentDAO().getAllStudents(maxStudents);
        System.out.println("\nВыведем только 3-студента из базы данных");
        System.out.println("+--------+-------------------+-------+-------------+");
        System.out.println("|   ID   |        NAME       |  AGE  |  UNIVERSITY |");
        System.out.println("+--------+-------------------+-------+-------------+");
        for(int i = 0; i < students.size(); ++i) {
            String strOut = "|   " + students.get(i).getId() + "      ";
            strOut = strOut.substring(0,9);
            strOut += strOut = "|   " + students.get(i).getName() + "         ";
            strOut = strOut.substring(0,29);
            strOut += strOut = "|   " + students.get(i).getAge() + "         ";
            strOut = strOut.substring(0,37);
            strOut += strOut = "| " + students.get(i).getUniversity().getCity() + "         ";
            strOut = strOut.substring(0,50) + " |";
            System.out.println( strOut );
            System.out.println("+--------+-------------------+-------+-------------+");
        }
    }

    public static void printFind(String name, Long minAge, Long maxAge) throws SQLException{
        List<Student> students = Factory.getInstance().getStudentDAO().findStudentBy(name, minAge, maxAge);
        System.out.println("\nПоиск студентов в базе данных по: имени и возрасту");
        System.out.println("+--------+-------------------+-------+-------------+");
        System.out.println("|   ID   |        NAME       |  AGE  |  UNIVERSITY |");
        System.out.println("+--------+-------------------+-------+-------------+");
        for(int i = 0; i < students.size(); ++i) {
            String strOut = "|   " + students.get(i).getId() + "      ";
            strOut = strOut.substring(0,9);
            strOut += strOut = "|   " + students.get(i).getName() + "         ";
            strOut = strOut.substring(0,29);
            strOut += strOut = "|   " + students.get(i).getAge() + "         ";
            strOut = strOut.substring(0,37);
            strOut += strOut = "| " + students.get(i).getUniversity().getCity() + "         ";
            strOut = strOut.substring(0,50) + " |";
            System.out.println( strOut );
            System.out.println("+--------+-------------------+-------+-------------+");
        }
    }

    public static void printFindSort(String name, Long minAge, Long maxAge, int column) throws SQLException{
        List<Student> students = Factory.getInstance().getStudentDAO().findStudentBySort(name, minAge, maxAge, column);
        System.out.println("\nПоиск студентов в базе данных по: имени/возрасту и сортировка");
        System.out.println("+--------+-------------------+-------+-------------+");
        System.out.println("|   ID   |        NAME       |  AGE  |  UNIVERSITY |");
        System.out.println("+--------+-------------------+-------+-------------+");
        for(int i = 0; i < students.size(); ++i) {
            String strOut = "|   " + students.get(i).getId() + "      ";
            strOut = strOut.substring(0,9);
            strOut += strOut = "|   " + students.get(i).getName() + "         ";
            strOut = strOut.substring(0,29);
            strOut += strOut = "|   " + students.get(i).getAge() + "         ";
            strOut = strOut.substring(0,37);
            strOut += strOut = "| " + students.get(i).getUniversity().getCity() + "         ";
            strOut = strOut.substring(0,50) + " |";
            System.out.println( strOut );
            System.out.println("+--------+-------------------+-------+-------------+");
        }
    }

    public static void printId(Long id) throws SQLException{
        Student student = Factory.getInstance().getStudentDAO().getStudentById(id);
        System.out.println("\nВыведем только одного студента из базы данных");
        System.out.println("+--------+-------------------+-------+-------------+");
        System.out.println("|   ID   |        NAME       |  AGE  |  UNIVERSITY |");
        System.out.println("+--------+-------------------+-------+-------------+");
        String strOut = "|   " + student.getId() + "      ";
        strOut = strOut.substring(0,9);
        strOut += strOut = "|   " + student.getName() + "         ";
        strOut = strOut.substring(0,29);
        strOut += strOut = "|   " + student.getAge() + "         ";
        strOut = strOut.substring(0,37);
        strOut += strOut = "| " + student.getUniversity().getCity() + "         ";
        strOut = strOut.substring(0,50) + " |";
        System.out.println( strOut );
        System.out.println("+--------+-------------------+-------+-------------+");
    }

    public static void updateId(Long id, String name, Long age, University university) throws SQLException{
        System.out.println("\nОбновим только одного студента в базе данных");
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        student.setUniversity(university);
        // Обновим их в бд
        Factory.getInstance().getStudentDAO().updateStudent(student);
    }

    public static void delete(Long id) throws SQLException{
        System.out.println("\nУдалим только одного студента из базы данных");
        Student student = Factory.getInstance().getStudentDAO().getStudentById(id);
        Factory.getInstance().getStudentDAO().deleteStudent(student);
    }

}