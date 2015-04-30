package options;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import core.CSVWriter;
import domain.DoubleVertical;

public class TestCSVWriter extends TestUtil {

    final double PRECISION = 0.01; // should make a global

    @Before
    public void setUp() {

    }

    @Test
    public final void testWriteFileMapOfDoubleRecordRowString() {

	Map<Double, DoubleVertical> toWrite = TestUtil
		.createDoubleVerticalSet(PRECISION);
	CSVWriter writer = new CSVWriter();
	try {
	    writer.writeFile(toWrite, "testWriteFileMapOfDoubleRecordRowString"
		    + Long.toString((new java.util.Date().getTime())) + ".csv");
	} catch (IOException e) {
	    fail(e.getMessage());
	    e.printStackTrace();
	}
    }

}
