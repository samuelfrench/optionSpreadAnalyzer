package core.service;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Spliterator;
import java.util.Stack;
import java.util.stream.Stream;

import org.apache.commons.dbutils.RowProcessor;
import org.apache.commons.dbutils.handlers.MapListHandler;

import domain.HistoricalDataRecord;

public class PersistServ {
	
	Stream<Connection> connections; 
	
	MapListHandler mapListHandle;
	
	//parameter is mapping information to turn database rows into a list of maps
	protected boolean setupMapList(RowProcessor convert){
		mapListHandle = new MapListHandler(convert);
		return false;
	}
	public List<Map<String, Object>> handleRow(ResultSet rs) throws SQLException{
			return mapListHandle.handle(rs);
	}
	public boolean initConnPool(int conn){
		try {
			   Class.forName("com.mysql.jdbc.Driver");
			}
			catch(ClassNotFoundException ex) {
			   System.out.println("Error: unable to load driver class!");
			   System.exit(1);
			}
		List<Connection> connPool = new ArrayList<>(conn);
		connPool.parallelStream().forEach((c) -> { try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root");
			c.setSchema("repo");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			c = null;
		}});
		this.connections = connPool.parallelStream();
		return (connPool.size()!=conn);
	}
	
	public boolean insertRows(List<HistoricalDataRecord> record){
		for(HistoricalDataRecord r: record){
			this.getConnection().createStatement(r.toSQL());
		}
		
		
		return false;
	}
	
	public Connection getConnection() throws SQLException{
		Optional<Connection> op = Optional.empty();
		while(!op.isPresent()){
			op = this.connections.filter((c) -> {
				try{
					return c.isValid(5);
				} catch (SQLException e){
					return false;
			}}).findAny();
			if(op.isPresent()){
				try { 
					return op.get();
				} catch (NoSuchElementException e2){
					e2.printStackTrace();
					continue;
				}
			}
		}
		return null;
		
		
	}
}

