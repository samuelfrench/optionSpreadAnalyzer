package options;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import function.DoubleVerticalMapFactory;
import function.Util;
import function.Util.POSITION_TYPE;

public class TestDoubleVertFactory extends TestUtil {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public final void test() {
		List<Map<Double,Double>> toConv = getTestResultSet(0.001);
		//TODO - this part is ready 2 go
		//DoubleVerticalMapFactory.getMap(toConv.get(POSITION_TYPE.LONG_CALL.ordinal()), toConv.get(1), toConv.get(2), toConv.get(3))
	}

}
