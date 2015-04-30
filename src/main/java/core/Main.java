package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import function.RangeCalculation;
import function.Util;
import function.Util.POSITION_TYPE;

public class Main {

	public static void main(String[] args) {
		Map<Double, Double> longCallMap = 
				RangeCalculation.getProfitOverRange(Util.POSITION_TYPE.LONG_CALL, 0, 100, 0.001, 57.5, 6.50);
		//List<Double> keyList = longCallMap.keySet().stream().sorted().collect(Collectors.toList());
		//CSVWriter.writeFile(longCallMap, "longCallMap.csv", null);
		
		/*
		 * TODO:
		 * 1. create each of the maps needed via the range calculation thingy
		 * 2. use them to create a double vertical map
		 * 3. print the resulting map with the CSV writer's generalized method
		 */
		
		List<Map<Double,Double>> completeNetProfit = new ArrayList<>();
		completeNetProfit.forEach((c) -> c = new HashMap<Double,Double>());
		Map<Double, Double> lc = RangeCalculation.getProfitOverRange(Util.POSITION_TYPE.LONG_CALL, 0, 500, 0.01, 100, 5);
		Map<Double, Double> lp = RangeCalculation.getProfitOverRange(Util.POSITION_TYPE.LONG_PUT, 0, 500, 0.01, 100, 5);
		Map<Double, Double> sc = RangeCalculation.getProfitOverRange(Util.POSITION_TYPE.SHORT_CALL, 0, 500, 0.01, 100, 5);
		Map<Double, Double> sp = RangeCalculation.getProfitOverRange(Util.POSITION_TYPE.SHORT_PUT, 0, 500, 0.01, 100, 5);

		
	}

}
