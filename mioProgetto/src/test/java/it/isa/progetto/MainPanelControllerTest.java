package it.isa.progetto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;



public class MainPanelControllerTest{

    @Test
    public void contaAllSongTest()
    {
        MainPanelController mpc = new MainPanelController();
        try
        {
            int a = mpc.contaAllSong();
            DAOFactory dao = new DAOFactory();
            dao.beginTransaction();
            BranoDAO bd = dao.getBranoDAO();
            int b = bd.countAllBrani();
            dao.commitTransaction();
            dao.closeTransaction();
            assertEquals(a, b);
        }

        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }

    }

    @Test
    public void findByStringTest()
    {
        MainPanelController mpc = new MainPanelController();
        List<Brano> brani = new ArrayList<Brano>();
        try{
                brani= mpc.findByString("The dark side of the");
                for(int i=0; i<brani.size(); i++)
                {
                    assertEquals(brani.get(i).getId(), (i+1));
                }
            }
            catch(Exception ex)
            {
                System.out.println(ex.getMessage());
            }
    }

    @Test
    public void playTest()
    {
        MainPanelController mpc = new MainPanelController();
        try
        {
            File file = new File("songs/l.mp3");
            mpc.play("1");
            file.delete();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        
    }

    @Test
    public void stopTest()
    {
        MainPanelController mpc = new MainPanelController();
        try
        {
            File file = new File("songs/l.mp3");
            mpc.stop();
            file.delete();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

}