package options;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import core.csv.CSVReader;
import core.service.PersistServ;
import domain.HistoricalDataRecord;
import function.Util;

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
		CSVReader rd = new CSVReader("AAPL_1430608706544.csv");
		List<HistoricalDataRecord> list = rd.readFile();
		list.parallelStream().forEach((p) -> p.setTicker("AAPL"));
		list.stream().forEachOrdered((p2) -> System.out.println(p2.toSQL()));
			Statement s = c.createStatement();
			boolean rs = (s.execute(list.get(1).toSQL()));
			ResultSet rs2 = (s.executeQuery("SELECT * FROM `repo`.`daily_historical`"));
			rs2.next();
			assertTrue(rs2.getString(1).equals("AAPL"));
			
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}

}
