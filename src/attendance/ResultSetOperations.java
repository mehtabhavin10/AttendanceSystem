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
    int lecCount=0,lecPresentCount=0,lecAbsentCount=0,pracCount=0,pracPresentCount=0,pracAbsentCount=0;
    ResultSetOperations(String username){
        this.username=username;
        
    }
    ResultSet getSubName(Connection conn,String sql){
        try {
            st=conn.createStatement();
            rs=st.executeQuery(sql);
           
            
            
        } catch (SQLException ex) {
            System.out.print(ex);
        }
        return rs;
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
   void insertInPrac(Connection conn,String sql){
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
   ResultSet populatePracTable(Connection conn,String sql){
       ResultSet rso=null;
        try {
            st=conn.createStatement();
            
            rso=st.executeQuery(sql);
           
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return rso;
     
   }
   boolean checkIfTheoryConducted(Connection conn,String sql){
       boolean exist=false;
        try {
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            if(rs.next()){
                exist=true;
            }
            System.out.println(exist);
        } catch (SQLException ex) {
            System.out.print(ex);
        }
        return exist;
   }
   void setLecCount(Connection conn,String sql){
        try {
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            if(rs.next()){
                lecCount=Integer.parseInt(rs.getString("lecCount"));
                
                
            }
        } catch (SQLException ex) {
           System.out.println(ex);
        }
       
   }
   /*int returnLecCount(){
       return lecCount;
   }*/
   int returnLecPresentCount(Connection conn,String sql){
        try {
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            if(rs.next()){
                lecPresentCount=Integer.parseInt(rs.getString("lecPresentCount"));
                
            }
        } catch (SQLException ex) {
             System.out.println(ex);
        }
        return lecPresentCount;
   }
   int returnLecAbsentCount(){
       
       lecAbsentCount=lecCount-lecPresentCount;
       
       return lecAbsentCount;
   }
   ResultSet getBatch(Connection conn,String sql){
        try {
            st=conn.createStatement();
            rs=st.executeQuery(sql);
        } catch (SQLException ex) {
            
             System.out.println(ex);
             
        }
        return rs;
   }
   
   void setPracCount(Connection conn,String sql){
       try {
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            if(rs.next()){
                pracCount=Integer.parseInt(rs.getString("pracCount"));
                System.out.println("pracocunt: "+pracCount);
                
            }
        } catch (SQLException ex) {
           System.out.println(ex);
        }
   }
   int returnPracPresentCount(Connection conn,String sql){
       try {
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            if(rs.next()){
                pracPresentCount=Integer.parseInt(rs.getString("pracPresentCount"));
                System.out.println("pracprecount:"+pracPresentCount);
            }
        } catch (SQLException ex) {
             System.out.println(ex);
        }
        return pracPresentCount;
   }
     int returnPracAbsentCount(){
       
       pracAbsentCount=pracCount-pracPresentCount;
       System.out.println("abcount:"+pracAbsentCount);
       return pracAbsentCount;
   }
    public static void main(String args[]){
        
    }
}
