package options;

import static org.junit.Assert.*;

import org.junit.Test;

import function.BaseCalculation;

public class TestBaseCalculation {

	
	@Test
	public void testGetLongCallProfit() {
		double strike = 55;
		double mark = 50;
		double price = 2;
		assert(BaseCalculation.getLongCallProfit(mark, strike, price)==3);
	}
	
	@Test
	public void testGetLongCallLoss() {
		double strike = 460;
		double mark = 412;
		double price = 30;
		assert(BaseCalculation.getLongCallProfit(mark, strike, price)==price);
	}

	@Test
	public void testGetShortCallProfit() {
		double strike = 235;
		double mark = 248.22;
		double price = 24.78;
		assert(BaseCalculation.getShortCallProfit(mark, strike, price)==11.56);
	}
	
	@Test
	public void testGetShortCallLoss() {
		double strike = 555;
		double mark = 654.777;
		double price = 35.87;
		assert(BaseCalculation.getShortCallProfit(mark, strike, price)==(-63.907));
	}
	//@TODO
	@Test
	public void testGetLongPutProfit() {
		fail("Not yet implemented");
	}
	
	//@TODO
	@Test
	public void testGetShortPutProfit() {
		fail("Not yet implemented");
	}

}
