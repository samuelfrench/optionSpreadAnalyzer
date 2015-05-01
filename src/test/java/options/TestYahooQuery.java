package options;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import core.service.YahooQuery;

public class TestYahooQuery {

	
	final static String[] tickers = {"AAPL", "INTC", "AMD", "AMZN", "NVDA","ORCL", "EBAY","FB","SAP", "TWTR", "YHOO", "MSFT", "GOOGL"};
	@Test
	public final void testYahooQuery() {
		List<String> ticks = new ArrayList<>();
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
		YahooQuery query = new YahooQuery();
		for(int x = 0; x < ticks.size(); x++){
			query.getStockData(ticks.get(x),"1994","2015");
			System.out.println(x + " " + ticks.get(x));
		}
	}

}
