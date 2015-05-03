package core.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PullYahoo {

	public static void main(String[] args) {
		List<String> ticks = getNasdaqTickers();
		ticks.parallelStream().forEach((t) -> {
			YahooQuery.getStockData(t,"1994","2015",true);
			System.out.println("Downloading: " + t);
		});
		
	}

	/**
	 * @return
	 */
	public static List<String> getNasdaqTickers() {
		List<String> ticks = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("nasdaqlisted.txt"));
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

}
