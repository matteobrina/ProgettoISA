package it.isa.progetto;

import java.sql.*;

public class App 
{
    public static void main( String[] args )
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/PROGETTO", "root", "Internazionale99");

            
        }
        catch(Exception e){ System.out.println(e.getMessage());}  
     }
   
 }


