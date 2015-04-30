package options;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import domain.DoubleVertical;
import function.DoubleVerticalMapFactory;
import function.RangeCalculation;
import function.Util;
import function.Util.POSITION_TYPE;

public abstract class TestUtil {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented"); // TODO
	}

	public static List<Map<Double, Double>> getTestResultSet(Double precision){
		//completeNetProfit.forEach((c) -> c = new HashMap<Double,Double>());
		Map<Double, Double> lc = RangeCalculation.getProfitOverRange(Util.POSITION_TYPE.LONG_CALL, 0, 500, 0.01, 100, 5);
		Map<Double, Double> lp = RangeCalculation.getProfitOverRange(Util.POSITION_TYPE.LONG_PUT, 0, 500, 0.01, 100, 5);
		Map<Double, Double> sc = RangeCalculation.getProfitOverRange(Util.POSITION_TYPE.SHORT_CALL, 0, 500, 0.01, 100, 5);
		Map<Double, Double> sp = RangeCalculation.getProfitOverRange(Util.POSITION_TYPE.SHORT_PUT, 0, 500, 0.01, 100, 5);
		List<Map<Double, Double>> testList = new ArrayList<>();
		testList.add(lc);
		testList.add(lp);
		testList.add(sc);
		testList.add(sp);
		return testList;
	}
	
	public static Map<Double, DoubleVertical> createDoubleVerticalSet(Double precision){
	    List<Map<Double,Double>> toConv = getTestResultSet(precision);
	    Map<Double, DoubleVertical> verticalMap = DoubleVerticalMapFactory.getMap(
		    toConv.get(POSITION_TYPE.LONG_CALL.ordinal()), 
		    toConv.get(POSITION_TYPE.LONG_PUT.ordinal()), 
		    toConv.get(POSITION_TYPE.SHORT_CALL.ordinal()), 
		    toConv.get(POSITION_TYPE.SHORT_PUT.ordinal()));
	    return verticalMap;
	}
}
