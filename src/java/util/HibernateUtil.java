/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.DriverManager;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author cleber
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory = buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            Configuration conf = new Configuration().configure();
            //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //DriverManager.registerDriver(new org.postgresql.Driver());
            ServiceRegistry registro = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();

            SessionFactory fabrica = conf.buildSessionFactory(registro);

            return fabrica;
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial n failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }

    }

}
