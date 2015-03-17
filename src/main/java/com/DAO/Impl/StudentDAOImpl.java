package main.java.com.DAO.Impl;

import main.java.com.DAO.StudentDAO;
import main.java.com.logic.Student;
import main.java.com.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Aleksandr Konstantinovitch
 * @version 1.0
 * @date 30/01/2015
 */
public class StudentDAOImpl implements StudentDAO {
    @Override
    public void addStudent(Student student) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void updateStudent(Student student) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(student);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Student getStudentById(Long id) throws SQLException {
        Session session = null;
        Student student = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
//                stud = (Student) session.get(Student.class, id);
            student = (Student) session.load(Student.class, id); // вернется неинициализированный прокси, обращения к базе вообще не будет
            student.getName();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return student;
    }

    @Override
    public List getAllStudents() throws SQLException {
        Session session = null;
        List<Student> student = new ArrayList<Student>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            student = session.createCriteria(Student.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return student;
    }

    @Override
    public List getAllStudents(int maxStudents) throws SQLException {
        Session session = null;
        List<Student> student = new ArrayList<Student>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Student.class); // создаем критерий запроса
            criteria.setMaxResults(maxStudents);                       // ограничиваем число результатов
            student = criteria.list();                                 // помещаем результаты в список
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return student;
    }

    @Override
    public List findStudentBy(String name, Long minAge, Long maxAge) throws SQLException {
        Session session = null;
        List<Student> student = new ArrayList<Student>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            // создаем критерий запроса
            student = session.createCriteria(Student.class)
                    .add(Expression.like("name", name + "%"))
                    .add( Expression.between("age", minAge, maxAge) )
                    .list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return student;
    }

    @Override
    public List findStudentBySort(String name, Long minAge, Long maxAge, int column) throws SQLException {
        Session session = null;
        List<Student> student = new ArrayList<Student>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            // создаем критерий запроса
            if(column == 1) {
                student = session.createCriteria(Student.class)
                        .add(Expression.like("name", name + "%"))
                        .add(Expression.between("age", minAge, maxAge))
                        .addOrder(Order.asc("id"))//по возрастанию
                        .list();
            }
            if(column == 2) {
                student = session.createCriteria(Student.class)
                        .add(Expression.like("name", name + "%"))
                        .add(Expression.between("age", minAge, maxAge))
                        .addOrder(Order.asc("name"))//по возрастанию
                        .list();
            }
            if(column == 3) {
                student = session.createCriteria(Student.class)
                        .add(Expression.like("name", name + "%"))
                        .add(Expression.between("age", minAge, maxAge))
                        .addOrder(Order.asc("age"))//по возрастанию
                        .list();
            }
            if(column == 4) {
                student = session.createCriteria(Student.class)
                        .add(Expression.like("name", name + "%"))
                        .add(Expression.between("age", minAge, maxAge))
                        .addOrder(Order.asc("university")) // по возрастанию
                        .list();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return student;
    }

    @Override
    public void deleteStudent(Student student) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(student);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}