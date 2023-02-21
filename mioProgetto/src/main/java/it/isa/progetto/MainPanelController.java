package it.isa.progetto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


import javafx.scene.media.AudioClip;

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

    public void play(String id) throws MissingObjectException, FileNotFoundException, IOException
    {
        final AudioClip sound;
        final String FILEPATH = "songs/l.mp3";
        final File file = new File(FILEPATH);
        Brano brano;
        DAOFactory dao = new DAOFactory();
        dao.beginTransaction();
        BranoDAO branoDao = dao.getBranoDAO();
        brano=branoDao.findById(Integer.parseInt(id));
        brano=branoDao.incrementaAscolti(brano);
        dao.commitTransaction();
        dao.closeTransaction();
        OutputStream os = new FileOutputStream(file);
        os.write(brano.getCanzone());
        os.close();
        sound = new AudioClip(Paths.get("songs/l.mp3").toUri().toString());
        sound.stop();
        sound.play();



    }

    public void stop()
    {
        final AudioClip sound;
        sound = new AudioClip(Paths.get("songs/l.mp3").toUri().toString());
        sound.stop();
    }
    
}
