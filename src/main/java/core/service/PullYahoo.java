package core.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import core.csv.task.NasdaqTickerReader;
import edu.emory.mathcs.backport.java.util.Arrays;

public class PullYahoo {

	public final static String[] tickers = {"INTC","AMD","AMZN", "ARMH"};
	public static void main(String[] args) {
		//List<String> ticks = getNasdaqTickers();
		@SuppressWarnings("unchecked")
		List<String> ticks = Arrays.asList(tickers);
		ticks.parallelStream().forEach((t) -> {
			YahooQuery.getHistoricalStockData(t,"2005","2015",false);
			System.out.println("Downloading: " + t);
		});
		
	}

	
	@SuppressWarnings("unchecked")
	public static List<String> getAbbrTickers(){
		return Arrays.asList(tickers);
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
		ticks.remove("Symbol");
		return ticks;
	}
	/**
	 * @todo need to find a better name for this - not daily - not sure what a proper name would be
	 * @param timeStamp - append timestamp to file
	 */
	public static void getAndWriteDailyCsv(boolean timeStamp) {
		List<String> ticks = NasdaqTickerReader.readFromFile();
		//YahooQuery query = new YahooQuery();
		ticks.parallelStream().forEach((t)->{
			YahooQuery.getDailyStockCSV(t,t, timeStamp);
			//System.out.println(" " + t);
		});
	}
}
