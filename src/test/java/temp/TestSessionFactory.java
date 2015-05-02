package temp;

import org.junit.Test;

import core.service.HibernateServ;

public class TestSessionFactory {

	@Test
	public void test() throws Exception {
		HibernateServ sessFact = new HibernateServ();
		sessFact.setUp();
	}
}
