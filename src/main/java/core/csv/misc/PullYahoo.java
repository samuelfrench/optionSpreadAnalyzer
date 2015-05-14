package core.csv.misc;

import java.util.List;

import core.service.YahooQuery;
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
}
