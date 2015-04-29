package function;

public class BaseCalculation {
	/*
	 * premium should be a positive number at all times
	 */
	public static double getLongCallProfit(double mark, double strike, double premium){
		if(mark > strike){ //ITM Expiration
			return (mark - strike) - premium;
		}
		return -premium;
		
	}
	
	public static double getShortCallProfit(double mark, double strike, double premium){
		if(mark > strike){ //ITM Expiration
			return (-(mark - strike)) + premium;
		}
		return premium;
	}
	
	public static double getLongPutProfit(double mark, double strike, double premium){
		if(mark < strike) { //ITM Expiration
			return (strike - mark) - premium;
		}
		return -premium;
	}
	
	public static double getShortPutProfit(double mark, double strike, double premium){
		if(mark < strike){ //ITM Expiration
			return (-(strike-mark)) + premium;
		}
		return premium;
	}
}
