package budgeting.app.example;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public final class HibernateUtil {

	public static SessionFactory getSession() {
		SessionFactory sessionFactory;
		
		try {
			StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata metaData = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
			sessionFactory = metaData.getSessionFactoryBuilder().build();
		}
		catch (Throwable th) {
			System.out.println("Initial SessionFactory creation failed" + th);
			throw new ExceptionInInitializerError(th);
		}
		
		return sessionFactory;
	}

}
