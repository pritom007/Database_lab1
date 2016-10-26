/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database_lab1;

import com.healthmarketscience.jackcess.Database;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author PritomKumar
 */
public class Database_lab1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, SQLException {
       
       
       ExcelToMySQL excelToSQL= new ExcelToMySQL();
       //give the filepath as input
       //room.xls file
       excelToSQL.ExcelFileReader("F:\\fudan 5th semester\\Database\\lab\\data\\room.xls");
       //student.xls file
       excelToSQL.ExcelFileReader("F:\\fudan 5th semester\\Database\\lab\\data\\student.xls");
       
       accessFile af= new accessFile();
       System.out.println("--------Access file is going to be prossed----------");
       System.out.println("--------Table room is going to be inserted in mysql----------");
       //file path as input
       //af.roomAccess("F:\\fudan 5th semester\\Database\\lab\\data\\access db\\oralexam.accdb");
       
       System.out.println("--------Table student is going to be inserted in mysql----------");
       //file path as input
       //af.studentAccess("F:\\fudan 5th semester\\Database\\lab\\data\\access db\\oralexam.accdb");
    }
    
}
