/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database_lab1;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author PritomKumar
 */
public class studentExcel {
        //String filename = "C:\\bugs reported.xls";
        FileInputStream fis = null;
        
    public void studentExcelFile(String filename) throws IOException, SQLException{
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filename);
            HSSFWorkbook workbook = new HSSFWorkbook(fis);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator rowIter = sheet.rowIterator(); 
            int firstrow=0;
            while(rowIter.hasNext()){
                HSSFRow myRow = (HSSFRow) rowIter.next();
                Iterator cellIter = myRow.cellIterator();
                Vector<String> cellStoreVector=new Vector<String>();
                while(cellIter.hasNext()){
                    HSSFCell myCell = (HSSFCell) cellIter.next();
                    String cellvalue;
                    if(myCell.getCellType()==1)
                        cellvalue = myCell.getStringCellValue();
                    else
                        cellvalue = (int)myCell.getNumericCellValue()+"";
                    cellStoreVector.addElement(cellvalue);
                    System.out.print(cellvalue+"  ");
                    
                }
                System.out.println();
                if(firstrow!=0){    
                    dbConnection db= new dbConnection("jdbc:mysql://localhost:3306/database_lab1","root","password");
                    String insert = "INSERT INTO student  VALUES (?,?,?,?,?,?);";
                    PreparedStatement ps=db.getConnection().prepareStatement(insert);//createStatement().executeUpdate(insert);
                    ps.setString(1, cellStoreVector.get(0));
                    ps.setString(2, cellStoreVector.get(1));
                    ps.setString(3, cellStoreVector.get(2));
                    ps.setString(4, cellStoreVector.get(3));
                    ps.setString(5, cellStoreVector.get(4));
                    ps.setString(6, cellStoreVector.get(5));
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

