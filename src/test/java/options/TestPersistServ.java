package options;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import core.service.PersistServ;

public class TestPersistServ {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public final void test() {
		PersistServ persistServ = new PersistServ();
		assert(persistServ.initConnPool(1));
	}

}
