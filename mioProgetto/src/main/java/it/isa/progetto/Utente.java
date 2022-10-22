package it.isa.progetto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Utente {

    private int id;
    private String username;
    private String password;
    private List<Playlist> playlist = new ArrayList<Playlist>();
    private Map<Brano, Integer> haAscoltato = new HashMap<Brano, Integer>();

    public int getId()
    {
        return this.id;
    }

    public void setId(int id)
    {
        this.id=id;
    }

    public String getUsername()
    {
        return this.username;
    }

    public void setUsername(String username)
    {
        this.username=username;
    }

    public String getPassword()
    {
        return this.password;
    }

    public void setPassword(String password)
    {
        this.password=password;
    }

    public void setPlaylist(List<Playlist> playlist)
    {
        this.playlist=playlist;
    }

    public List<Playlist> getPlaylist()
    {
        return this.playlist;
    }
    
    public void setPlaylist(Playlist playlist, int index)
    {
        this.playlist.add(index, playlist);
    }

    public void setPlaylist(Playlist playlist)
    {
        this.playlist.add(playlist);
    }

    public Playlist getPlaylist(int index)
    {
        return this.playlist.get(index);
    }

    public Map<Brano, Integer> getHaAscoltato()
    {
        return this.haAscoltato;
    }

    public void setHaAscoltato(Map<Brano, Integer> haAscoltato)
    {
        this.haAscoltato=haAscoltato;
    }

    public Integer getHaAscoltato(Brano brano)
    {
        return this.haAscoltato.get(brano);
    }

    public void setHaAscoltato(Brano brano, Integer volte)
    {
        this.haAscoltato.put(brano, volte);
    }


    
}
