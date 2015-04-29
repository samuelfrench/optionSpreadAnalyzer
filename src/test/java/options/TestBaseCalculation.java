package options;

import static org.junit.Assert.*;

import org.junit.Test;

import function.BaseCalculation;

public class TestBaseCalculation {
	
	final public double tolerance = 0.1;
	
	@Test
	public void testGetLongCallProfit() {
		double strike = 55;
		double mark = 50;
		double premium = 2;
		assertEquals(3, BaseCalculation.getLongCallProfit(mark, strike, premium),tolerance);
	}
	
	@Test
	public void testGetLongCallLoss() {
		double strike = 460;
		double mark = 412;
		double price = 30;
		assertEquals(-price, BaseCalculation.getLongCallProfit(mark, strike, price),tolerance);
	}

	@Test
	public void testGetShortCallProfit() {
		double strike = 235;
		double mark = 248.22;
		double price = 24.78;
		assertEquals(11.56, BaseCalculation.getShortCallProfit(mark, strike, price),tolerance);
	}
	
	@Test
	public void testGetShortCallLoss() {
		double strike = 555;
		double mark = 654.777;
		double price = 35.87;
		assertEquals((-63.907), BaseCalculation.getShortCallProfit(mark, strike, price),tolerance);
	}

	@Test
	public void testGetLongPutProfit() {
		double strike = 22.500;
		double mark = 22.334;
		double premium = 0.110;
		assertEquals(0.056, BaseCalculation.getShortPutProfit(mark, strike, premium),tolerance);
	}
	
	@Test
	public void testGetLongPutLoss() {
		double strike = 41.0;
		double mark = 42.437;
		double premium = 0.110;
		assertEquals(0.110, BaseCalculation.getLongPutProfit(mark, strike, premium),tolerance);
	}
	
	@Test
	public void testGetLongPutLossByPremium() {
		double strike = 32.0000;
		double mark = 31.437;
		double premium = 1.110;
		assertEquals((-0.547), BaseCalculation.getLongPutProfit(mark, strike, premium), tolerance);
	}
	
	@Test
	public void testGetShortPutProfit() {
		double strike = 32.000;
		double mark = 31.64;
		double premium = 0.9355;
		//should equal 1.2955
		assertNotEquals(3.25, BaseCalculation.getShortPutProfit(mark, strike, premium), tolerance);
		assertEquals(1.29, BaseCalculation.getShortPutProfit(mark, strike, premium), tolerance);
	}
	
	@Test
	public void testGetShortPutLoss() {
		fail("Not yet implemented");
	}

}
