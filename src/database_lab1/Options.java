/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database_lab1;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author PritomKumar
 */
public class Options {
    //importing scanner for the input
    Scanner sc = new Scanner(System.in);
    //method for the all options
    public void chooseOption() throws IOException, SQLException{
        //will print all the options in the program
        String options = printOptions();
        while(options!="5"){
           if(validInt(options)){
               //System.out.println(new File(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParentFile().toString().replace("\\build", "\\room.xls"));
               switch(options){
                   //same process for case 1 and 2
                   //case 1 is for room.xls file case 2 is for student.xls file
                   case "1":
                   case "2":    
                       ExcelToMySQL excelToSQL = new ExcelToMySQL();
                       System.out.print("Please input the file path(ex. 'C:\\room.xls' or 'C:\\student.xls'(without the quotation)):");
                       String filePath = sc.next();
                       excelToSQL.ExcelFileReader(filePath);
                       break;
                   //case 3 is for access file data
                   //here name of the table is room    
                   case "3":
                       accessFile roomAccess = new accessFile();
                       System.out.print("Please input the file path(ex. 'C:\\oralexam.accdb'(without the quotation)):");
                       filePath = sc.next();
                       roomAccess.roomAccess(filePath);
                       break;
                   //case 4 is for access file data
                   //here name of the table is student
                   case "4":
                       accessFile  studentAccess = new accessFile();
                       System.out.print("Please input the file path(ex. 'C:\\oralexam.accdb'(without the quotation)):");
                       filePath = sc.next();
                       studentAccess.roomAccess(filePath);
                       break;
                   //Quit the program    
                   case "5":
                       System.exit(0);
                   default:
                       System.out.println("Invalid input!!!");
                       break;
               }
           }
           else{
               System.out.println("Invalid input!!!");
           }
           options=printOptions();
        }
    
    }
    //method for all the options and input
    private String printOptions(){
        System.out.println("1) input 1 to put 'room.xls' file data in database.");
        System.out.println("2) input 2 to put 'student.xls' file data in database.");
        System.out.println("3) input 3 to put 'room' table of 'oralexam.accdb' file data in database.");
        System.out.println("4) input 4 to put 'student' table of 'oralexam.accdb' file data in database.");
        System.out.println("5) Quit.");
        System.out.print("Please give your input:");
        String myOption = sc.next();
        return myOption; 
    }
    //validate the inputs
    private boolean validInt(String input){
        System.out.println(input.length());
        if((input.equals("1")||input.equals("2")||input.equals("3")||input.equals("4")||input.equals("5"))&&(input.length()==1)){
            return true;
        }
        else{
            System.err.println("error");
            return false;
        }
    }
}
