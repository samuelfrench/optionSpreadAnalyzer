package options;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import core.csv.CSVReader;
import domain.MktDataRow;

public class CSVReaderTest {



	@Test
	public final void testRead() {
		CSVReader rd = new CSVReader("testInterDaily.CSV");
		List<MktDataRow> rows;
		try {
			rows = rd.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
			return;
		}
		if(rows.parallelStream().anyMatch((p)-> (
			p.getTimestamp()==null || p.getClose()==null 
			|| p.getHigh() ==null || p.getLow() == null || p.getOpen()==null ||p.getVolume()==null)
		)){
			fail("null value");
		}
		rows.stream().sequential().forEachOrdered((p)->System.out.println(p.getTimestamp() + " " + p.getVolume()));
	}

}
