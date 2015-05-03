package core.csv.task;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.mysql.jdbc.MySQLConnection;
import com.mysql.jdbc.PreparedStatement;

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
		//ticks.parallelStream().forEach((t) -> {
		//	YahooQuery.getStockData(t,"1994","2015", false);
		//	System.out.println("Downloading: " + t);
		//});
			Connection c;
			try {
				c = PersistServ.initConn();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}
			try {
				java.sql.PreparedStatement addRecord = c.prepareStatement("INSERT INTO `repo`.`daily_historical`" +
						"(`date`,`open`,`high`,`low`,`close`,`volume`,`adjusted_close`,`ticker_id`) " +
						"VALUES"
						+ "( ? ," //date - 1
						+ " ? ," //open - 2
						+ " ?  ," //high - 3
						+ " ?  ," //low - 4
						+ " ?  ," //close - 5
						+ " ?  ," //volume - 6
						+ " ?  ," //adj close - 7
						 //ticker - 8
						+ " ? )");
				for(String s: ticks){
					CSVReader rd = new CSVReader("csv/" + s + ".csv");
							List<HistoricalDataRecord> list;
							try {
								list = rd.readFile();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								continue;
							}
							list.parallelStream().forEach((p) -> p.setTicker(s));
								for(HistoricalDataRecord rec : list){
									addRecord.setString(0, rec.getDate());
									addRecord.setDouble(1, rec.getOpen());
									addRecord.setDouble(2, rec.getHigh());
									addRecord.setDouble(4, rec.getLow());
									addRecord.setDouble(5, rec.getClose());
									addRecord.setInt(6, rec.getVolume());
									addRecord.setDouble(7, rec.getAdjClose());
									try{
										addRecord.executeUpdate();	
									} catch (SQLException e4){
										e4.printStackTrace();
									}
								}
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return;
			}
			
		
	}

}
