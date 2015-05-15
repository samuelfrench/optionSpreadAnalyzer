package core.service;

import java.beans.PropertyVetoException;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionPool {
	private boolean created = false;
	private ComboPooledDataSource cpds;

	public void create() {
		if (created) {
			return;
		}
	cpds = new ComboPooledDataSource();
		try {
			cpds.setDriverClass("com.mysql.jdbc.Driver");
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // loads the jdbc driver
		cpds.setJdbcUrl("jdbc:mysql://localhost:3306/?user=root&rewriteBatchedStatements=true");
		// cpds.setUser("swaldman");

		// the settings below are optional -- c3p0 can work with defaults
		cpds.setMinPoolSize(10);
		cpds.setAcquireIncrement(20);
		cpds.setMaxPoolSize(400);
		cpds.setAutoCommitOnClose(true);
		cpds.setCheckoutTimeout(800000);
		
		this.created = true;
		// The DataSource cpds is now a fully configured and usable pooled
		// DataSource
	}

	public java.sql.Connection getConnection() {
		try {
			return cpds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean close() {
		if (this.created) {
			this.cpds.close();
			return false;
		}
		return true;
	}
}
