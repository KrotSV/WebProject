package logics;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

class DBPool {
    private static DataSource ds = null;
    static {try{
        InitialContext initContext = new InitialContext();
        ds = (DataSource) initContext.lookup("java:comp/env/jdbc/dbconnect");
    } catch (NamingException e) {
        e.printStackTrace();
    }
    }

    static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
