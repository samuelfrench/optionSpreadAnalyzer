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
}
