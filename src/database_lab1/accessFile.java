/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database_lab1;

import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Row;
import com.healthmarketscience.jackcess.Table;
import java.io.IOException;
import java.sql.*;


/**
 *
 * @author PritomKumar
 */
public class accessFile {
    
    
    //input the file path
    //example: 'C:\\oralexam.accdb'
    public void roomAccess(String filePath) throws IOException{
        try {
        // specify url, username, pasword - make sure these are valid 
        //Need 'ucanaccess.rar' to run this
        Connection conn = DriverManager.getConnection("jdbc:ucanaccess://"+filePath);
        Statement st= conn.createStatement();
        ResultSet rs=st.executeQuery("select * from room");
        //connecting to MySQL
        dbConnection db= new dbConnection("jdbc:mysql://localhost:3306/database_lab1_access","root","password");
        //sql command
        String insert = "INSERT INTO room  VALUES (?,?,?,?,?,?);";
        while(rs.next()){
        PreparedStatement ps=db.getConnection().prepareStatement(insert);
        ps.setString(1, rs.getString(1));
        ps.setInt(2, rs.getInt(2));
        ps.setInt(3, rs.getInt(3));
        ps.setString(4, rs.getString(4));
        ps.setString(5, rs.getString(5));
        ps.setString(6, rs.getString(6));
        
        System.out.println(rs.getString("kdno")+" "+rs.getString("kcno")+" "+rs.getString("ccno")+" "+rs.getString("kdname")+" "+rs.getString("exptime")+" "+rs.getString("papername"));
        ps.execute();
        }
        
        System.out.println("Connection Succesfull");
        } catch (Exception e) {
            e.printStackTrace();
        System.err.println("Got an exception! ");
        System.err.println(e.getMessage());
        }
    }
    public void studentAccess(String filePath) throws IOException{
        try {
        // specify url, username, pasword - make sure these are valid 
        //Need 'ucanaccess.rar' to run this
        Connection conn = DriverManager.getConnection("jdbc:ucanaccess://"+filePath);
        Statement st= conn.createStatement();
        ResultSet rs=st.executeQuery("select * from student");
        //connecting to MySQL
        dbConnection db= new dbConnection("jdbc:mysql://localhost:3306/database_lab1_access","root","password");
        //sql command
        String insert = "INSERT INTO student  VALUES (?,?,?,?,?,?);";
        while(rs.next()){
        PreparedStatement ps=db.getConnection().prepareStatement(insert);
        ps.setString(1, rs.getString(1));
        ps.setString(2, rs.getString(2));
        ps.setString(3, rs.getString(3));
        ps.setInt(4, rs.getInt(4));
        ps.setInt(5, rs.getInt(5));
        ps.setInt(6, rs.getInt(6));
        
        System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getInt(5)+" "+rs.getInt(6));
        ps.execute();
        }
        
        System.out.println("Connection Succesfull");
        } catch (Exception e) {
            e.printStackTrace();
        System.err.println("Got an exception! ");
        System.err.println(e.getMessage());
        }
    }
    
}
