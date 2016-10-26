/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database_lab1;

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
       
       
       roomExcel rx= new roomExcel();
       //rx.roomExcelFile("F:\\fudan 5th semester\\Database\\lab\\data\\room.xls");
       studentExcel ex= new studentExcel();
       //ex.studentExcelFile("F:\\fudan 5th semester\\Database\\lab\\data\\student.xls");
       accessFile af= new accessFile();
       af.roomAccess();
    }
    
}
