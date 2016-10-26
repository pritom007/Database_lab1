/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database_lab1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
/**
 *
 * @author PritomKumar
 */
public class roomExcel{
   /*
    *method takes input of file name and takes the data from excel file
    *after taking input connects to database and put the data there
    */
    public void roomExcelFile(String filename) throws IOException, SQLException{
        FileInputStream fis = null;
        try {
 
            fis = new FileInputStream(filename);
            HSSFWorkbook workbook = new HSSFWorkbook(fis);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator rowIter = sheet.rowIterator(); 
            //variable that will use to find the first row
            int firstrow=0;
            //iterator for the row values 
            while(rowIter.hasNext()){
                HSSFRow myRow = (HSSFRow) rowIter.next();
                Iterator cellIter = myRow.cellIterator();
                Vector<String> cellStoreVector=new Vector<String>();
                while(cellIter.hasNext()){
                    HSSFCell myCell = (HSSFCell) cellIter.next();
                    String cellvalue;
                    
                    //determines if cell value is string or numaric
                    
                    if(myCell.getCellType()==1)
                        cellvalue = myCell.getStringCellValue();
                    else
                        cellvalue = (int)myCell.getNumericCellValue()+"";
                    //adds the value in the vector
                    cellStoreVector.addElement(cellvalue);
                    //prints out the cell valuse
                    System.out.print(cellvalue+"  ");
                    
                }
                System.out.println();
                //if the row is not the first row then,
                //insert the data in database
                if(firstrow!=0){
                    dbConnection db= new dbConnection("jdbc:mysql://localhost:3306/database_lab1","root","password");
                    //sql comment
                    String insert = "INSERT INTO room  VALUES (?,?,?,?,?,?);";
                    PreparedStatement ps=db.getConnection().prepareStatement(insert);//createStatement().executeUpdate(insert);
                    ps.setString(1, cellStoreVector.get(0));
                    ps.setString(2, cellStoreVector.get(1));
                    ps.setString(3, cellStoreVector.get(2));
                    ps.setString(4, cellStoreVector.get(3));
                    ps.setString(5, cellStoreVector.get(4));
                    ps.setString(6, "");
                    Boolean rs=ps.execute();
                }
                firstrow++;
            }
        } catch (IOException e) {
 
            e.printStackTrace();
 
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
    }
}

