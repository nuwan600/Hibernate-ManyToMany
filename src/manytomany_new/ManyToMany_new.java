/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manytomany_new;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author nuwan600
 */
public class ManyToMany_new {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("Hibernate many to many (XML Mapping)");
	Session session = SessionFactoryUtil.getSessionFactory().openSession();
 
	session.beginTransaction();
 
	Stock stock = new Stock();
        stock.setStockId(0013);
        stock.setStockCode("7052");
        stock.setStockName("PADINI");
 
        Category category1 = new Category(1,"CONSUMER", "CONSUMER COMPANY");
        Category category2 = new Category(2,"INVESTMENT", "INVESTMENT COMPANY");
 
        Set<Category> categories = new HashSet<Category>();
        categories.add(category1);
        categories.add(category2);
 
        stock.setCategories(categories);
        
        createPerson(stock);
        listPerson();
	System.out.println("Done");
        
        
    }
    
    
    private static void listPerson() {
        Transaction tx = null;
        Session session = SessionFactoryUtil.getCurrentSession();
        try {
        tx = session.beginTransaction();
        List persons = session.createQuery(
        "select p from Stock as p").list();
        System.out.println("*** Content of the Person Table ***");
        System.out.println("*** Start ***");
        for (Iterator iter = persons.iterator(); iter.hasNext();) {
        Stock element = (Stock) iter.next();
        System.out.println(element);
        }
        System.out.println("*** End ***");
        tx.commit();
    } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
            try {
                // Second try catch as the rollback could fail as well
                tx.rollback();
            } catch (HibernateException e1) {
                System.out.println("Error rolling back transaction");
            }
                throw e;
            }
        }
    }
    
    
    private static void deletePerson(Stock person) {
        Transaction tx = null;
        Session session = SessionFactoryUtil.getCurrentSession();
        try {
            tx = session.beginTransaction();
            session.delete(person);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                try {
                    // Second try catch as the rollback could fail as well
                    tx.rollback();
                } catch (HibernateException e1) {
                    System.out.println("Error rolling back transaction");

                }
            }
            // throw again the first exception
            throw e;
        }
    }
    
    private static void createPerson(Stock person) {
        Transaction tx = null;
        Session session = SessionFactoryUtil.getCurrentSession();
        try {
            tx = session.beginTransaction();
            session.save(person);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                try {
                    // Second try catch as the rollback could fail as well
                    tx.rollback();
                } catch (HibernateException e1) {
                    System.out.println("Error rolling back transaction");
                }
                    // throw again the first exception
                    throw e;
            }
        }
    }
    
    private static void updatePerson(Stock  person) {
Transaction tx = null;
Session session = SessionFactoryUtil.getCurrentSession();
try {
tx = session.beginTransaction();
session.update(person);
tx.commit();
} catch (RuntimeException e) {
if (tx != null && tx.isActive()) {
try {
// Second try catch as the rollback could fail as well
tx.rollback();
} catch (HibernateException e1) {
System.out.println("Error rolling back transaction");
}
// throw again the first exception
throw e;
}
}
}
    
    
}
