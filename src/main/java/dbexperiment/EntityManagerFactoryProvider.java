package dbexperiment;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryProvider {

    private static final EntityManagerFactory emf;

    static {
        try {
            // Create the SessionFactory from persistence.xml
            emf = Persistence.createEntityManagerFactory("testDB");
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * This method return the Application EntityManagerFactory.
     * The method is in a singleton class, so we will be using
     * the same emf trough the application.
     * @return EntityManagerFactory
     */
    public static EntityManagerFactory getEntityManagerFactory() {

        return emf;
    }
}


