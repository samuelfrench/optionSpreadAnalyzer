package function;

import java.util.HashMap;
import java.util.Map;

public class RangeCalculation {
	public static enum POSITION_TYPE {LONG_CALL, SHORT_CALL, LONG_PUT, SHORT_PUT};
	
	public static Map<Double, Double> getProfitOverRange(POSITION_TYPE positionType, 
			double min, double max, double interval, double strike, double premium){
		Map<Double, Double> profitMap = new HashMap<>();
		switch(positionType){
		case LONG_CALL:
			for(double x = min; x <= max; x+=interval){
				profitMap.put(x, BaseCalculation.getLongCallProfit(x, strike, premium));
			}
			break;
		case SHORT_CALL:
			for(double x = min; x <= max; x+=interval){
				profitMap.put(x, BaseCalculation.getShortCallProfit(x, strike, premium));
			}
			break;
		case LONG_PUT:
			for(double x = min; x <= max; x+=interval){
				profitMap.put(x, BaseCalculation.getLongPutProfit(x, strike, premium));
			}
			break;
		case SHORT_PUT:
			for(double x = min; x <= max; x+=interval){
				profitMap.put(x, BaseCalculation.getShortPutProfit(x, strike, premium));
			}
			break;
		default:
			System.err.println("getProfitOverRange: position type invalid");
			break;
		}
		
		return profitMap;
	}
}
