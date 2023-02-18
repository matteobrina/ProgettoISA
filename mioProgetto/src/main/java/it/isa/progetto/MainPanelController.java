package it.isa.progetto;

import java.util.ArrayList;
import java.util.List;

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
    
}
