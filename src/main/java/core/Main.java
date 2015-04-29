package core;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import function.RangeCalculation;
import function.RangeCalculation.POSITION_TYPE;

public class Main {

	public static void main(String[] args) {
		Map<Double, Double> longCallMap = 
				RangeCalculation.getProfitOverRange(POSITION_TYPE.LONG_CALL, 0, 100, 0.001, 57.5, 6.50);
		//List<Double> keyList = longCallMap.keySet().stream().sorted().collect(Collectors.toList());
		CSVWriter.writeFile(longCallMap, "longCallMap.csv", null);

	}

}
