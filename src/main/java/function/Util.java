package function;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Util {
	public static List<Double> sortedSet(Set<Double> s){
		return s.stream().sorted().collect(Collectors.toList());
	}
}
