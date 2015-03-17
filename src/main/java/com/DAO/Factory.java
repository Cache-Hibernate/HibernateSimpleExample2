package main.java.com.DAO;

import main.java.com.DAO.Impl.StudentDAOImpl;

/**
 * @author Aleksandr Konstantinovitch
 * @version 1.0
 * @date 30/01/2015
 */
public class Factory {

    private static StudentDAO studentDAO = null;
    private static Factory      instance = null;

    public static synchronized Factory getInstance(){
        if (instance == null){
            instance = new Factory();
        }
        return instance;
    }

    public StudentDAO getStudentDAO(){
        if (studentDAO == null){
            studentDAO = new StudentDAOImpl();
        }
        return studentDAO;
    }

}
