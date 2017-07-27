package logics;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnect {
    static Connection connection;

    public static void main(String[] args) {
        {
            try {
                Driver driver = new FabricMySQLDriver();
                DriverManager.registerDriver(driver);
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/psdatabase", "root", "root");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Test");
        System.out.println(connection);

    }
}
