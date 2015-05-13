package options;

import java.util.List;

import org.junit.Test;

import core.csv.task.NasdaqTickerReader;
import core.service.PullYahoo;
import core.service.YahooQuery;

public class TestYahooQuery {

	
	//final static String[] tickers = {"AAPL", "INTC", "AMD", "AMZN", "NVDA","ORCL", "EBAY","FB","SAP", "TWTR", "YHOO", "MSFT", "GOOGL"};
	@Test
	public final void testYahooQuery() {
		List<String> ticks = readTicksFromFile();
		//YahooQuery query = new YahooQuery();
		for(int x = 0; x < ticks.size(); x++){
			YahooQuery.getHistoricalStockData(ticks.get(x),"1994","2015", false);
			System.out.println(x + " " + ticks.get(x));
		}
	}
	
	@Test
	public final void testGetDailyStockCSV() {
		PullYahoo.getAndWriteDailyCsv(true);
	}

	

	public List<String> readTicksFromFile() {
		return NasdaqTickerReader.readFromFile();
		/*List<String> ticks = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader( new FileReader("nasdaqlisted.txt"));
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
		return ticks; */
	}

}
