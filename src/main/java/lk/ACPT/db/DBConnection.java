package lk.ACPT.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//singilton
public class DBConnection {
   private static DBConnection dbConnection;

   private final Connection connection;

   public DBConnection() throws SQLException, ClassNotFoundException {
       Class.forName("com.mysql.cj.jdbc.Driver");
       connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
   }

   public static DBConnection getDBConnection() throws SQLException, ClassNotFoundException {
       if(dbConnection == null){
           dbConnection = new DBConnection();
       }
       return dbConnection;
   }
   public Connection getConnection(){
       return connection;
   }

}

//stand alog