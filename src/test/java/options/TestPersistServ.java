package options;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import core.service.PersistServ;

public class TestPersistServ {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public final void test() {
		assertTrue(new PersistServ() != null);
	}
	@Test
	public final void getRecordsLength(){
		try{
		Connection c = PersistServ.initConn();
		assertTrue(c.isValid(1));
			Statement s = c.createStatement();
			ResultSet rs = (s.executeQuery("SELECT * FROM `repo`.`daily_historical`"));
			rs.next();
			assertTrue(rs.getString(1).equals("AAPL"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}

}
