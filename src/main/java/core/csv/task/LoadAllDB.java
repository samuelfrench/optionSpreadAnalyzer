package core.csv.task;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import core.csv.CSVReader;
import core.service.PersistServ;
import core.service.YahooQuery;
import domain.HistoricalDataRecord;
import domain.MktDataRow;

public class LoadAllDB {
	public static void main(String[] args) {
		//loadHistoricalDB();
		//ConcurrentHashMap<String,Integer> map = getTickers();
		//map.values().forEach((c)->System.out.println(c.toString()));
		ConcurrentHashMap<String,List<MktDataRow>> map = new ConcurrentHashMap<>();
		ConcurrentMap<String,Integer> workItems = getTickers();
		workItems.keySet().parallelStream().forEach((k)-> {try{map.put(k, new CSVReader("csv/daily/" + k+".CSV").read());} catch (IOException e){e.printStackTrace();} /*System.out.println(k);*/});
		map.keySet().parallelStream().forEach((k)->{loadRecords(map.get(k),k); System.out.println(k);});
	}
	
	public static void loadHistoricalDB(){
		//List<String> ticks = PullYahoo.getAbbrTickers();
		List<String> ticks = YahooQuery.getNasdaqTickers();
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
						"(`date`,`open`,`high`,`low`,`close`,`volume`,`adjusted_close`,`ticker_id`, `date_ts`) " +
						"VALUES"
						+ "( ? ," //date - 1
						+ " ? ," //open - 2
						+ " ?  ," //high - 3
						+ " ?  ," //low - 4
						+ " ?  ," //close - 5
						+ " ?  ," //volume - 6
						+ " ?  ," //adj close - 7
						+ " ?  ," //ticker - 8
						 //date_ts - 9
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
								list = rd.readHistoricalFile();
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
									addRecord.setLong(9, rec.getDateTs());
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
	
	public static ConcurrentHashMap<String,Integer> getTickers(){
		ConcurrentHashMap<String,Integer> map = new ConcurrentHashMap<>();
		Connection c;
		try {
			c = PersistServ.initConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		try {
			ResultSet resultSet = c.createStatement().executeQuery("SELECT * FROM `repo`.`nasdaq_ticker`");
			while(resultSet.next()){
				map.put(resultSet.getString(2).trim().toLowerCase(), resultSet.getInt(1));
			}
			return map;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static boolean loadRecords(List<MktDataRow> rows, String ticker){
		Connection c;
		try {
			c = PersistServ.initConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return true;
		}
		
		Integer tickerId = getTickers().getOrDefault(ticker, -1);
		if(tickerId.equals(-1)){
			return true;
		}
		java.sql.PreparedStatement addRecord;
		try {
			addRecord = c.prepareStatement("INSERT INTO `repo`.`daily_inter`(`timestamp`,`close`,`high`,`low`,`open`,`volume`,`ticker_id`)"
					+ "VALUES"
					+ "(?,"
					+ "?,"
					+ "?,"
					+ "?,"
					+ "?,"
					+ "?,"
					+ "?)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return true;
		}
		for(MktDataRow r : rows){
			try {
				addRecord.setLong(1, r.getTimestamp());
				addRecord.setDouble(2, r.getClose());
				addRecord.setDouble(3, r.getHigh());
				addRecord.setDouble(4, r.getLow());
				addRecord.setDouble(5, r.getOpen());
				addRecord.setLong(6, r.getVolume());
				addRecord.setInt(7, tickerId);
				addRecord.addBatch();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			try {
				addRecord.executeBatch();
			} catch (SQLException e) {
				e.printStackTrace();
				return true;
			} finally{
				
				try {
					addRecord.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		return false;
	}

}
