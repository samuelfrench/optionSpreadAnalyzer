package core.csv.task;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import core.csv.CSVReader;
import core.service.PersistServ;
import core.service.PullYahoo;
import domain.HistoricalDataRecord;

public class LoadAllDB {
	public static void main(String[] args) {
		loadDB();
	}
	
	public static void loadDB(){
		List<String> ticks = PullYahoo.getAbbrTickers();
		//List<String> ticks = PullYahoo.getNasdaqTickers();
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
				c.createStatement().execute("TRUNCATE `repo`.`daily_historical`");
				ticks.parallelStream().forEach((s)->{
					//System.out.println(s);
					if(s.startsWith("File Creation Time")){
						return;
					}
					CSVReader rd = new CSVReader("csv/" + s + ".csv");
							List<HistoricalDataRecord> list;
							try {
								list = rd.readFile();
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								return;
							}
							list.parallelStream().forEach((p) -> p.setTicker(s));
								list.parallelStream().forEach((rec) -> {
									try{
									addRecord.setString(1, rec.getDate());
									addRecord.setDouble(2, rec.getOpen());
									addRecord.setDouble(3, rec.getHigh());
									addRecord.setDouble(4, rec.getLow());
									addRecord.setDouble(5, rec.getClose());
									addRecord.setInt(6, rec.getVolume());
									addRecord.setDouble(7, rec.getAdjClose());
									addRecord.setString(8, rec.getTicker());
									} catch (SQLException e){
										e.printStackTrace();
										return;
									}
									try{
										addRecord.addBatch();
										
									} catch (SQLException e4){
										e4.printStackTrace();
									}
								});
								System.out.println(s);
								try {
									addRecord.executeBatch();
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
				});
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return;
			}
			
		
	}

}
