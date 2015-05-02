package core.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateServ {
	protected void setUp() throws Exception {
		// A SessionFactory is set up once for an application

		p("Trying to create a test connection with the database.");
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb
				.build());
		Session session = sessionFactory.openSession();
		p("Test connection with the database created successfuly.");

	}

	private static void p(String s) {
		System.out.println("test: " + s);
	}
}
