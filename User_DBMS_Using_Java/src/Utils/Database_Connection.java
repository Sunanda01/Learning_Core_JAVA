package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database_Connection {
    private static final String DRIVER_PATH="com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL="jdbc:mysql://localhost:3306/USER_DATABASE";
    private static final String DATABASE_USERNAME="root";
    private static final String DATABASE_PASSWORD="******";
    public void Database_Util(){
        try {
            Class.forName(DRIVER_PATH);
        }
        catch (Exception e){
            throw new RuntimeException("Something Went Wrong in Database_Util()\n"+e);
        }
    }
    public Connection getDBConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL,DATABASE_USERNAME,DATABASE_PASSWORD);
    }
}