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
    
    public void roomAccess() throws IOException{
        try {
        
           
        // Load MS accces driver class
        //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        
        // C:\\databaseFileName.accdb" - location of your database 
       // String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=" + "F:\\fudan 5th semester\\Database\\lab\\data\\access db\\oralexam.accdb";
        
        // specify url, username, pasword - make sure these are valid 
        Connection conn = DriverManager.getConnection("jdbc:ucanaccess://F:\\fudan 5th semester\\Database\\lab\\data\\access db\\oralexam.accdb");
        Statement st= conn.createStatement();
        ResultSet rs=st.executeQuery("select * from room");
        dbConnection db= new dbConnection("jdbc:mysql://localhost:3306/database_lab1_access","root","password");
        //sql comment
        String insert = "INSERT INTO room  VALUES (?,?,?,?,?,?);";
        while(rs.next()){
        PreparedStatement ps=db.getConnection().prepareStatement(insert);
        ps.setString(1, rs.getString(1));
        ps.setInt(2, rs.getInt(2));
        ps.setInt(3, rs.getInt(3));
        ps.setString(4, rs.getString(4));
        ps.setString(5, rs.getString(5));
        ps.setString(6, rs.getString(6));
        
        System.out.println(rs.getString("kdno")+" "+rs.getString("kcno")+" "+rs.getString("ccno")+" "+rs.getString("kdname")+" "+rs.getString("exptime")+" "+rs.getString("papername")+ " hoise");
        System.out.println(rs.getType());
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
