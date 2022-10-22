package it.isa.progetto;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    
    private int id;
    private String nome;
    private Utente utente;
    private List<Brano> brano = new ArrayList<Brano>();

    public void setId(int id)
    {
        this.id=id;
    }

    public int getId()
    {
        return this.id;
    }

    public void setNome(String nome)
    {
        this.nome=nome;
    }

    public String getNome()
    {
        return this.nome;
    }

    public void setUtente(Utente utente)
    {
        this.utente=utente;
    }

    public Utente getUtente()
    {
        return this.utente;
    }

    public void setBrano(List<Brano> brano)
    {
        this.brano=brano;
    }

    public List<Brano> getBrano()
    {
        return this.brano;
    }

    public void setBrano(Brano brano, int index)
    {
        this.brano.add(index, brano);
    }

    public void setBrano(Brano brano)
    {
        this.brano.add(brano);
    }

    public Brano getBrano(int index)
    {
        return this.brano.get(index);
    }

}
