package logics;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;

public class DBPool {

    static Connection connection = null;
    static {
        try {
            InitialContext initContext = new InitialContext();
            DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/appname");
            connection = ds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static Connection getConnection(){
        return connection;
    }

}
