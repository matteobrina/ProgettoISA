package it.isa.progetto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Brano {

    private int id;
    private String titolo;
    private String album;
    private byte[] canzone = new byte[32768];
    private String artista;
    private int ascolti;

    private Map<Utente, Integer> haAscoltato = new HashMap<Utente, Integer>();
    private List<Playlist> contiene = new ArrayList<Playlist>();


    public void setId(int id)
    {
        this.id=id;
    }

    public int getId()
    {
        return this.id;
    }

    public void setTitolo(String titolo)
    {
        this.titolo=titolo;
    }

    public String getTitolo()
    {
        return this.titolo;
    }

    public void setAlbum(String album)
    {
        this.album=album;
    }

    public String getAlbum()
    {
        return this.album;
    }

    public void setCanzone(byte[] canzone)
    {
        this.canzone=canzone;
    }

    public byte[] getCanzone()
    {
        return this.canzone;
    }

    public void setArtista(String artista)
    {
        this.artista=artista;
    }

    public String getArtista()
    {
        return this.artista;
    }

    public void setAscolti(int ascolti)
    {
        this.ascolti=ascolti;
    }

    public int getAscolti()
    {
        return this.ascolti;
    }

    public void setHaAscoltato(Map<Utente, Integer> haAscoltato)
    {
        this.haAscoltato=haAscoltato;
    }

    public Map<Utente, Integer> getHaAscoltato()
    {
        return this.haAscoltato;
    }

    public void setHaAscoltato(Utente utente, Integer ascolti)
    {
        this.haAscoltato.put(utente, ascolti);

    }

    public Integer getHaAscoltato(Utente utente)
    {
        return this.haAscoltato.get(utente);
    }

    public void setContiene(List<Playlist> contiene)
    {
        this.contiene=contiene;
    }

    public List<Playlist> getContiene()
    {
        return this.contiene;
    }

    public void setContiene(Playlist playlist)
    {
        this.contiene.add(playlist);
    }
    
    public Playlist getContiene(int index)
    {
        return this.contiene.get(index);
    }
}
