package it.isa.progetto;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class BranoDAO {
    
private Connection conn;

BranoDAO(Connection conn)
{
    this.conn=conn;
}

public Brano findById(int id) throws MissingObjectException
{
    PreparedStatement ps;
    Brano brano = new Brano();

    try{
        String sql="SELECT *"
                +" FROM Brano"
                +" WHERE ID= ?";

        ps=conn.prepareStatement(sql);
        int i=1;
        ps.setInt(i++, id);
        ResultSet rs=ps.executeQuery();
        if(rs.next())
        {
            brano.setId(rs.getInt("Id"));
            brano.setTitolo(rs.getString("Titolo"));
            brano.setAlbum(rs.getString("Album"));
            brano.setArtista(rs.getString("Artista"));
            brano.setAscolti(rs.getInt("Ascolti"));
            Blob blob = rs.getBlob("Canzone");
            int blobLength = (int) blob.length();
            byte[] blobAsBytes = blob.getBytes(1, blobLength);
            blob.free();
            brano.setCanzone(blobAsBytes);
            rs.close();
            ps.close();
            
        }
        else 
        {
            rs.close();
            ps.close();
            throw new MissingObjectException("brano non trovato");
        }

    }

    

    catch(SQLException e)
    {
        System.out.println(e.getMessage());
    }

    return brano;
}


public List<Brano> findByString(String titolo) throws MissingObjectException
{
    PreparedStatement ps;
    List <Brano> brani = new ArrayList<Brano>();
    Brano brano = new Brano();

    try{
        String sql="SELECT *"
                +" FROM Brano"
                +" WHERE ( INSTR(Titolo,?)>0"
                +" OR ( INSTR(Album,?)>0"
                +" OR ( INSTR(Artista,?)>0"
                +" OR ( INSTR(Album,?)>0";

        ps=conn.prepareStatement(sql);
        int i=1;
        ps.setString(i++, titolo);
        ResultSet rs=ps.executeQuery();
        if(rs.next())
        {
            rs.previous();
            while(rs.next())
            {
            brano.setId(rs.getInt("Id"));
            brano.setTitolo(rs.getString("Titolo"));
            brano.setAlbum(rs.getString("Album"));
            brano.setArtista(rs.getString("Artista"));
            brano.setAscolti(rs.getInt("Ascolti"));
            Blob blob = rs.getBlob("Canzone");
            int blobLength = (int) blob.length();
            byte[] blobAsBytes = blob.getBytes(1, blobLength);
            blob.free();
            brano.setCanzone(blobAsBytes);
            brani.add(brano);
            }

            rs.close();
            ps.close();
            
        }
        else 
        {
            rs.close();
            ps.close();
            throw new MissingObjectException("brano non trovato");
        }

    }

    

    catch(SQLException e)
    {
        System.out.println(e.getMessage());
    }

    return brani;
}







}
