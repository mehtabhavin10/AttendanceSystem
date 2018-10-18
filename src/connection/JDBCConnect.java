/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class JDBCConnect {
    
        private static String DB_URL = "jdbc:mysql://localhost:3306/";
        private static String DB_NAME = "attendance_system";
        private static final String DB_USER = "root";
        private static final String DB_PASSWD = "";
    
        private static Connection conn = null;
        private static Statement stmt = null;
        private static PreparedStatement preparedStmt  = null;
        private static ResultSet res = null;
        
        
        public static void setDB(String dbName) {
            DB_NAME = dbName;
            DB_URL = DB_URL + DB_NAME;
        }
        
        public static Connection getConnection() {
            
/*            try{

                Class.forName("com.mysql.jdbc.Driver");
                conn = (Connection) DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);

            } catch(Exception e) {

                System.out.println(e);
            }*/
            return conn;
        }
        
        public static void setConnection() {
            
            try{

                Class.forName("com.mysql.jdbc.Driver");
                conn = (Connection) DriverManager.getConnection(DB_URL+DB_NAME, DB_USER, DB_PASSWD);

            } catch(Exception e) {

                System.out.println(e);
            }
        }
        
        
        
        public static ResultSet getResults(String query) {
            
            try {
                
            stmt = (Statement) conn.createStatement();
            res = stmt.executeQuery(query);
            
            } catch(Exception e) {
                
                System.out.println(e);
            }
            return res;
        }
        
        
        public static void insertOrUpdateData(String query) {
            
            
            try {
                
                stmt = (Statement) conn.createStatement();
                stmt.executeUpdate(query);

            } catch(Exception e) {
                
                System.out.println(e);
            }
        }
}
