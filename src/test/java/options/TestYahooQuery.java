package options;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import core.csv.task.NasdaqTickerReader;
import core.service.YahooQuery;

public class TestYahooQuery {

	
	//final static String[] tickers = {"AAPL", "INTC", "AMD", "AMZN", "NVDA","ORCL", "EBAY","FB","SAP", "TWTR", "YHOO", "MSFT", "GOOGL"};
	//@Test
	public final void testYahooQuery() {
		List<String> ticks = readTicksFromFile();
		//YahooQuery query = new YahooQuery();
		ticks.parallelStream().forEach((t)->{
			YahooQuery.getHistoricalStockData(t,"2000","2015", false);
			System.out.println(t);
		});
	}
	
	@Test
	public final void testGetDailyStockCSV() {
		//YahooQuery.getAndWriteDailyCsv(false,1,"test");
		YahooQuery.getAndWriteDailyCsv(false,500,"500");
		//YahooQuery.getAndWriteDailyCsv(true,1);
	}

	

	public List<String> readTicksFromFile() {
		return NasdaqTickerReader.readFromFile();
	}

}
