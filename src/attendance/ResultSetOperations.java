/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author priyamvora
 */
public class ResultSetOperations {
    static String username,faculty_id,subject_id;
    Statement st;
    static ResultSet rs;
    ResultSetOperations(String username){
        this.username=username;
        
    }
    String getFid(Connection conn,String sql){
        try {
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                faculty_id=rs.getString("fid");
            }
            rs.close();
            st.close();
            
        } catch (SQLException ex) {
            System.out.print(ex);
        }
        return faculty_id;
    }
    String getSubId(Connection conn,String sql){
        try {
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                subject_id=rs.getString("sid");
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            System.out.print(ex);
        }
        return subject_id;
    }
   void  insertInAttendance(Connection conn,String sql){
        try{
            st=conn.createStatement();
            st.executeUpdate(sql);
        }catch(SQLException ex){
            System.out.print(ex);
        }
    }
   void insertInD1(Connection conn,String sql){
       try{
            st=conn.createStatement();
            st.executeUpdate(sql);
        }catch(SQLException ex){
            System.out.print(ex);
        }
   }
   void insertInD2(Connection conn,String sql){
       try{
            st=conn.createStatement();
            st.executeUpdate(sql);
        }catch(SQLException ex){
            System.out.print(ex);
        }
   }
   void insertInD3(Connection conn,String sql){
       try{
            st=conn.createStatement();
            st.executeUpdate(sql);
        }catch(SQLException ex){
            System.out.print(ex);
        }
   }
   void insertInD4(Connection conn,String sql){
       try{
            st=conn.createStatement();
            st.executeUpdate(sql);
        }catch(SQLException ex){
            System.out.print(ex);
        }
   }
   ResultSet populateTable(Connection conn,String sql){
        try {
            st=conn.createStatement();
            rs=st.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return rs;
     
   }
   
    public static void main(String args[]){
        
    }
}
