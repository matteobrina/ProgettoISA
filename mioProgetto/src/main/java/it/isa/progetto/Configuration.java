package it.isa.progetto;

import java.util.Calendar;




public class Configuration {
  
  /* Database Configruation */
 
  public static final String DATABASE_DRIVER="com.mysql.cj.jdbc.Driver";
  public static final String SERVER_TIMEZONE=Calendar.getInstance().getTimeZone().getID();
  public static final String 
    DATABASE_URL="jdbc:mysql://ec2-18-157-166-237.eu-central-1.compute.amazonaws.com:3306/PROGETTO2?user=prova&password=Internazionale99!&useSSL=true&serverTimezone="+SERVER_TIMEZONE;
  
}
  
  