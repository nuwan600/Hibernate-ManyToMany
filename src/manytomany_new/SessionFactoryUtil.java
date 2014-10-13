/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manytomany_new;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author nuwan600
 */
public class SessionFactoryUtil {
    
    private static final SessionFactory sessionFactory;
    static {
        try {
        // Create the SessionFactory from standard (hibernate.cfg.xml)
        // config file.
            sessionFactory = new AnnotationConfiguration().configure()
            .buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception.
            System.err.println("Initial SessionFactory creation failed."
            + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    
}
