package core.csv.task;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import core.csv.CSVReader;
import core.service.PersistServ;
import core.service.PullYahoo;
import core.service.YahooQuery;
import domain.HistoricalDataRecord;

public class LoadAllDB {

	public LoadAllDB() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		loadDB();
	}
	
	public static void loadDB(){
		List<String> ticks = PullYahoo.getNasdaqTickers();
		ticks.parallelStream().forEach((t) -> {
			YahooQuery.getStockData(t,"1994","2015", false);
			System.out.println("Downloading: " + t);
		});
		try {
			Connection c = PersistServ.initConn();
			for(String s: ticks){
				CSVReader rd = new CSVReader("csv/" + s + ".csv");
						List<HistoricalDataRecord> list = rd.readFile();
						list.parallelStream().forEach((p) -> p.setTicker(s));
							for(HistoricalDataRecord rec : list){
								Statement statement = c.createStatement();
								statement.execute(rec.toSQL());
							}	
			}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
