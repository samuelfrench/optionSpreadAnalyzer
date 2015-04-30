package function;

import java.util.HashMap;
import java.util.Map;

import domain.DoubleVertical;

public class DoubleVerticalMapFactory {
	public static Map<Double, DoubleVertical> getMap(
			Map<Double, Double> longCallMap,
			Map<Double,Double> shortCallMap, 
			Map<Double,Double> longPutMap,
			Map<Double,Double> shortPutMap){
		
		int size = longCallMap.keySet().size();
		
		if((!checkMap(shortCallMap,size))||(!checkMap(longPutMap,size))||(!checkMap(shortPutMap,size))){
			throw new IllegalArgumentException
				("DoubleVerticalMapFactory,getMap: maps do not have the same sized keysets.");
		}
		
		Map<Double, DoubleVertical> resultMap = new HashMap<Double, DoubleVertical>();
		
		longCallMap.keySet().stream().forEachOrdered((k) -> {
			DoubleVertical dv = new DoubleVertical();
			dv.setMark(k);
			dv.setLongCallProfit(longCallMap.get(k));
			dv.setShortCallProfit(shortCallMap.get(k));
			dv.setLongPutProfit(shortPutMap.get(k));
			dv.setShortPutProfit(shortPutMap.get(k));
			resultMap.put(k, dv);
		});
		return resultMap;
	}
	
	public static boolean checkMap(Map<Double,Double> map, int size){
		if(map.keySet().size()==size){
			return true;
		}
		return false;
	}
}
