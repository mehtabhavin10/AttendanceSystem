/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance;

import java.sql.*;
import java.sql.DriverManager;

/**
 *
 * @author priyamvora
 */
public class DbConnect {
   
    String DB_URL ="jdbc:mysql://localhost/attendance_system";
   String DB_DRV ="com.mysql.jdbc.Driver";
    String DB_USER = "root";
    String DB_PASSWD = "";
   Connection getConn(){
        Connection conn = null;
      
        try{
           
            conn = (Connection) DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            
        }catch(Exception e){
            System.out.println("hi");
            System.out.print(e);
        }
        return conn;
   }
}
