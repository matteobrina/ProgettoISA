package it.isa.progetto;



public class Brano {

    private int id;
    private String titolo;
    private String album;
    private byte[] canzone = new byte[32768];
    private String artista;
    private int ascolti;

    


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

    
}
