package it.isa.progetto;

import java.util.Calendar;




public class Configuration {
  
  /* Database Configruation */
 
  public static final String DATABASE_DRIVER="com.mysql.cj.jdbc.Driver";
  public static final String SERVER_TIMEZONE=Calendar.getInstance().getTimeZone().getID();
  public static final String 
    DATABASE_URL="jdbc:mysql://localhost:3306/PROGETTO?user=root&password=Internazionale99&useSSL=false&serverTimezone="+SERVER_TIMEZONE;
  
}
  
  