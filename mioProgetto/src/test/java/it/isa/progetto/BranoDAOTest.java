package it.isa.progetto;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.nio.file.Files;

import java.sql.Connection;
import java.sql.DriverManager;



import org.junit.Test;

public class BranoDAOTest {

    @Test
    public void findByIdExistingTest()
    {
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/PROGETTO", "root", "Internazionale99");

            
            Brano brano = new Brano();
            Brano brano2 = new Brano();
            File file = new File("/Users/matteobrina/ProgettoISA/mioProgetto/src/test/java/it/isa/progetto/Files/05. Mone.mp3");
            byte[] bytes = Files.readAllBytes(file.toPath());
            brano.setId(5);
            brano.setTitolo("Money");
            brano.setAlbum("The Dark Side Of The Moon");
            brano.setArtista("Pink Floyd");
            brano.setAscolti(0);
            brano.setCanzone(bytes);

            BranoDAO dao = new BranoDAO(con);
            brano2=dao.findById(brano.getId());
            assertEquals(brano.getId(), brano2.getId());
            assertEquals(brano.getTitolo(), brano2.getTitolo());
            assertEquals(brano.getAlbum(), brano2.getAlbum());
            assertEquals(brano.getArtista(), brano2.getArtista());
            boolean uguali=true;
            for (int i=0; i<(brano.getCanzone().length); i++)
            {
                if(brano.getCanzone()[i]!=brano2.getCanzone()[i])
                uguali=false;
            }
            assertTrue(uguali);
            

        }

        catch(Exception e)
        {
            System.out.println(e.getMessage()+" eccezione");
        }
    }

    @Test
    public void findByIdNotExistingTest()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/PROGETTO", "root", "Internazionale99");

                BranoDAO dao = new BranoDAO(con);
                dao.findById(0);

        }

        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
    
}
