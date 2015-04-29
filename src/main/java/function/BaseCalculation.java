package function;

public class BaseCalculation {
	/*
	 * tradePrice should be a positive number at all times
	 */
	public static double getLongCallProfit(double mark, double strike, double tradePrice){
		if(mark <= strike){ //ITM Expiration
			return -tradePrice;
		}
		return (mark-strike) - tradePrice;
	}
	
	public static double getShortCallProfit(double mark, double strike, double tradePrice){
		if(mark >= strike){ //ITM Expiration
			return (mark - strike) + tradePrice;
		}
		return tradePrice;
	}
	
	public static double getLongPutProfit(double mark, double strike, double tradePrice){
		if(strike > mark) { //ITM Expiration
			return (strike-mark) - tradePrice;
		}
		return -tradePrice;
	}
	
	public static double getShortPutProfit(double mark, double strike, double tradePrice){
		if(strike > mark){ //ITM Expiration
			return (strike - mark) + tradePrice;
		}
		return tradePrice;
	}
}
