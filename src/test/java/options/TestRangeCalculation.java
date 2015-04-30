/**
 * 
 */
package options;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import function.RangeCalculation;
import function.RangeCalculation.POSITION_TYPE;

/**
 * @author sam
 *
 */
public class TestRangeCalculation extends TestUtil {

	/**
	 * Test method for {@link function.RangeCalculation#getProfitOverRange(function.RangeCalculation.POSITION_TYPE, double, double, double, double, double)}.
	 * @TODO
	 */
	@Test
	public final void testGetProfitOverRange() {
		try {
			List<Map<Double,Double>> toBuild = getTestResultSet(0.001);
			int x = toBuild.get(0).values().size();
			for(Map<Double,Double> m : toBuild){
				assertTrue(m.values().size()==x);
			}
			
		} catch (Exception e){
			fail(e.getMessage());
		}
	}
	
	private void p(String s){
		System.out.println(s);
	}

}
