package function;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import domain.spread.impl.DoubleVertical;

public class Util {
	//should be moved to a class for final enums
	public static enum POSITION_TYPE {LONG_CALL, SHORT_CALL, LONG_PUT, SHORT_PUT}

	public static List<Double> sortedSet(Set<Double> s){
		return s.stream().sorted().collect(Collectors.toList());
	}

	private final static String DV_ROW_HEADER = "Mark, Long Call Profit, Long Put Profit, Short Call Profit, Short Put Profit, Net Profit";
	
	public static String getRowHeader(Object obj){
	    if(obj.getClass().equals(DoubleVertical.class)){
		return DV_ROW_HEADER;
	    }
	    return null;
	}
}
