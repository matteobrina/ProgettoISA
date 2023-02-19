package it.isa.progetto;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MainPanelController {

    public int contaAllSong() throws MissingObjectException
    {
        DAOFactory dao = new DAOFactory();
        dao.beginTransaction();
        BranoDAO branoDao = dao.getBranoDAO();
        int count = branoDao.countAllBrani();
        dao.commitTransaction();
        dao.closeTransaction();
        return count;
    }

    public List<Brano> findAllBrani() 
    {
        DAOFactory dao = new DAOFactory();
        List<Brano> brani = new ArrayList<Brano>();
        dao.beginTransaction();
        BranoDAO branoDao = dao.getBranoDAO();
        brani  = branoDao.findAllBrani();
        dao.commitTransaction();
        dao.closeTransaction();
        return brani;
    }

    public List<Brano> findByString(String stringa) throws MissingObjectException
    {
        DAOFactory dao = new DAOFactory();
        List<Brano> brani = new ArrayList<Brano>();
        dao.beginTransaction();
        BranoDAO branoDao = dao.getBranoDAO();
        brani  = branoDao.findByString(stringa);
        dao.commitTransaction();
        dao.closeTransaction();
        return brani;
    }

    public String makeButtonText(Brano brano)
    {
        return ("Titolo: "+brano.getTitolo()+"\t Album: "+brano.getAlbum()+"\t Artista: "+brano.getArtista()+"\t Ascolti: "+brano.getAscolti());
    }

    
    
}
