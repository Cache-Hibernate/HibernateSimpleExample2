package main.java.com.DAO;

import main.java.com.logic.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Aleksandr Konstantinovitch
 * @version 1.0
 * @date 30/01/2015
 */
public interface StudentDAO {

    public void addStudent(Student student) throws SQLException;                                          // добавить студента
    public void updateStudent(Student student) throws SQLException;                                       // обновить студента
    public Student getStudentById(Long id) throws SQLException;                                           // получить стедента по id
    public List getAllStudents() throws SQLException;                                                     // получить всех студентов
    public List getAllStudents(int maxStudents) throws SQLException;                                      // ограничиваем число результатов
    public List findStudentBy(String name, Long minAge, Long maxAge) throws SQLException;                 // ограничить поиск стедента по имени и возрасту
    public List findStudentBySort(String name, Long minAge, Long maxAge, int column) throws SQLException; // ограничить поиск стедента по имени и возрасту
    public void deleteStudent(Student student) throws SQLException;                                       // удалить студента

}