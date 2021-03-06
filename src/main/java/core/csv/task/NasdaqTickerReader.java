package core.csv.task;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NasdaqTickerReader {
	
	public static String DEFAULT_TICK_FILE = "nasdaqlisted.txt";
	public static List<String> readFromFile(){
		return scrubbedTickers(NasdaqTickerReader.readFromFile(DEFAULT_TICK_FILE));
	}
	public static List<String> readFromFile(String fileName){
		List<String> ticks = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader( new FileReader(fileName));
			while(br.ready()){
				ticks.add(br.readLine().split("\\|")[0]);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ticks;
	}
	
	public static List<String> scrubbedTickers(List<String> tickers){
		return tickers.parallelStream().filter((p)->p!=null).distinct().filter((p)-> (!p.equalsIgnoreCase("symbol"))).collect(Collectors.toList());
	}
}
