package function;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Util {
	//should be moved to a class for final enums
	public static enum POSITION_TYPE {LONG_CALL, SHORT_CALL, LONG_PUT, SHORT_PUT}

	public static List<Double> sortedSet(Set<Double> s){
		return s.stream().sorted().collect(Collectors.toList());
	}
}
