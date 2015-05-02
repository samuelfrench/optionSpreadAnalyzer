package core.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.apache.commons.dbutils.RowProcessor;
import org.apache.commons.dbutils.handlers.MapListHandler;

public class PersistServ {
	
	
	MapListHandler mapListHandle;
	
	//parameter is mapping information to turn database rows into a list of maps
	protected boolean setupMapList(RowProcessor convert){
		mapListHandle = new MapListHandler(convert);
		return false;
	}
	
	public List<Map<String, Object>> handleRow(ResultSet rs) throws SQLException{
			return mapListHandle.handle(rs);
	}
	
	public static Connection initConn() throws SQLException{
		try {
			   Class.forName("com.mysql.jdbc.Driver");
			}
			catch(ClassNotFoundException ex) {
			   System.out.println("Error: unable to load driver class!");
			   System.exit(1);
			}
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root");
			c.setSchema("repo");
			return c;
		} 
}
