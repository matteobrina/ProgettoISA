package it.isa.progetto;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;


import org.junit.Test;

public class UtenteDAOTest {
    
    @Test
    public void testCreate()
    {

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/PROGETTO", "root", "Internazionale99");

            
        
        Utente utente1 = new Utente();
        Utente utente2 = new Utente();

       UtenteDAO dao = new UtenteDAO(con);
       utente1=dao.create("prova", "prova");

       utente2 = dao.findById(utente1.getId());

        assertEquals(utente1.getId(), utente2.getId());
        assertEquals(utente1.getUsername(), utente2.getUsername());
        assertEquals(utente1.getPassword(), utente2.getPassword());

        dao.deleteUtente(utente2);


        

    }
    catch(Exception e){ System.out.println(e.getMessage());}  
 }
    }


