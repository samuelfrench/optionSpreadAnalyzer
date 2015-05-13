package function;

public class Bollinger {
	
	public static double getBandWidth(double upperBb,
			double lowerBb, double middleBb){
		double result = (upperBb-lowerBb)/middleBb;
		if(result<=0){
			throw new IllegalArgumentException("BandWidth should not be less than or equal to 0.");
		}
		return result;
	}
	
	public static double getPercentB(double last,
			double upperBb, double lowerBb) {
		return (last-lowerBb)/(upperBb-lowerBb);
	}
	
	/*
	 * A squeeze candidate is identified when the bandwidth is at a six-month low-low value.

		When Bollinger Bands® are far apart, volatility is high, 
		and when they are close together, it is low. A squeeze is 
		triggered when volatility reaches a six-month low and is identified 
		when Bollinger Bands® reach a six-month minimum distance apart.
		
		
		Determining breakout direction
		////////////////////////////////////
			The next step in deciding which way stocks will go once they breakout 
		is somewhat more challenging. Bollinger suggests that, to determine breakout direction,
		it is necessary to look to other indicators for confirmation. He suggests using the 
		relative strength index along with one or two volume-based indicators such as the 
		intraday intensity index (developed by David Bostian) or the accumulation/distribution 
		index (developed by Larry William).

			If there is a positive divergence - that is, if indicators are heading upward 
		while price is heading down or neutral - it is a bullish sign. For further confirmation, 
		look for volume to build on up days. On the other hand, if price is moving higher but the
		indicators are showing negative divergence, look for a downside breakout, especially if 
		there have been increasing volume spikes on down days.

			Another indication of breakout direction is the way the bands move on expansion. When a powerful 
		trend is born, the resulting explosive volatility increase is often so great that the lower 
		band will turn downward in an upside break, or the upper band will turn higher in a downside breakout.

		Read more: http://www.investopedia.com/articles/technical/04/030304.asp#ixzz3a2xZdwK8 
	 */
}
