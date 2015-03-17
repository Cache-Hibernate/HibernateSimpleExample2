package main.java.com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;

	static {
		try {
            // корень проекта, папка - 'src' - ложим сюда в корень конфигурационный файл 'hibernate.cfg.xml' (по умолчанию, чтобы не делать хитрых путей...)
			sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
//            sessionFactory = new Configuration()
//                .configure("/hibernate.cfg.xml")
//                .buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}