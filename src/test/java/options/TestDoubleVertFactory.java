package options;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import domain.DoubleVertical;
import function.DoubleVerticalMapFactory;
import function.Util;
import function.Util.POSITION_TYPE;

public class TestDoubleVertFactory extends TestUtil {

    	List<Map<Double,Double>> toConv;
	@Before
	public void setUp() throws Exception {
	    toConv = getTestResultSet(0.001);
	}

	@Test
	public final void test() {
	    assert(toConv.size() == 4);
		Map<Double, DoubleVertical> verticalMap = DoubleVerticalMapFactory.getMap(toConv.get(POSITION_TYPE.LONG_CALL.ordinal()), toConv.get(POSITION_TYPE.LONG_PUT.ordinal()), 
			toConv.get(POSITION_TYPE.SHORT_CALL.ordinal()), toConv.get(POSITION_TYPE.SHORT_PUT.ordinal()));
		for(Double d: verticalMap.keySet()){
		    DoubleVertical dv = verticalMap.get(d);
		    assert(dv.getMark().equals(d));
		    assert(dv.getLongCallProfit() != null);
		    assert(dv.getLongPutProfit() != null);
		    assert(dv.getShortCallProfit() != null);
		    assert(dv.getShortPutProfit() != null);
		}
	}
}
