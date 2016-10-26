/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database_lab1;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PritomKumar
 */
public class dbConnection {
   /*
    *setting up connection for database
    */
     String connectionUrl = "jdbc:mysql://localhost:3306/database_lab1";
     String username = "root";
     String Password = "password";
    public dbConnection(String connectionUrl,String username,String password){
        this.connectionUrl=connectionUrl;
        this.username=username;
        this.Password=password;
    }
    
    
    static Connection con;
    public  Connection getConnection() {
        try {
            // class name for mysql driver
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException ex) {
                //System.out.println(ex.getMessage()+" problem 1");
         }
        try {
            //connecting to database
            con = DriverManager.getConnection(connectionUrl,username, Password);
        }catch (SQLException ex) {
            //System.out.println(ex.getMessage()+" problem 2");
         }
        
        //returens connection 
        return con;
    }
}
    
