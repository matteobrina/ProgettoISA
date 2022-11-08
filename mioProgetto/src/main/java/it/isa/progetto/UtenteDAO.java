package it.isa.progetto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class UtenteDAO {

    private Connection conn;

    UtenteDAO(Connection conn)
    {
        this.conn=conn;
    }


    public Utente create(String username, String password) throws DuplicatedObjectException
    {
        PreparedStatement ps;

        Utente utente = new Utente();
        utente.setUsername(username);
        utente.setPassword(password);

        try{
        String sql = "select id"
                    + " from Utente"
                    +" where Username = ?";

        ps=conn.prepareStatement(sql);
        int i=1;
        ps.setString(i++, username);

        ResultSet rs = ps.executeQuery();
        boolean exist= false;
        if(rs.next())
        exist=true;
        if(exist)
       {
        rs.close();
        ps.close();
        throw new DuplicatedObjectException("L'utente esiste già");
        }
        else
        {
            sql = "insert into Utente"
                +" values(null, ?, ?)";

            ps=conn.prepareStatement(sql);
            i=1;
            ps.setString(i++, username);
            ps.setString(i++, password);
            ps.executeUpdate();

            sql= "select id"
                +" from Utente"
                +" where username = ?";

            ps=conn.prepareStatement(sql);
            i=1;
            ps.setString(i++, username);
            rs=ps.executeQuery();
            rs.next();
            utente.setId(rs.getInt("id"));
            rs.close();
            ps.close();

            

            
        }



        }

        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return utente;



    }

    public Utente findById(int id) throws MissingObjectException
    {
        Utente utente = new Utente();
        PreparedStatement ps;

        try{
        String sql = "SELECT *"
                    +" FROM Utente"
                    +" WHERE ID = ?";

        ps=conn.prepareStatement(sql);
        int i=1;
        ps.setInt(i++, id);

        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
            utente.setId(rs.getInt("id"));
            utente.setUsername(rs.getString("username"));
            utente.setPassword(rs.getString("password"));
            rs.close();
            ps.close();
        }

        else {
            rs.close();
            ps.close();
            throw new MissingObjectException("utente non trovato");
        }

       




        }

        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return utente;
    
        
    }


    public Utente findByUsername(String username) throws MissingObjectException
    {
        Utente utente = new Utente();
        PreparedStatement ps;

        try{
        String sql = "SELECT *"
                    +" FROM Utente"
                    +" WHERE Username = ?";

        ps=conn.prepareStatement(sql);
        int i=1;
        ps.setString(i++, username);

        ResultSet rs = ps.executeQuery();
        if(rs.next())
        {
            utente.setId(rs.getInt("id"));
            utente.setUsername(rs.getString("username"));
            utente.setPassword(rs.getString("password"));
            rs.close();
            ps.close();
        }

        else {
            rs.close();
            ps.close();
            throw new MissingObjectException("utente non trovato");
        }

        




        }

        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return utente;
    
        
    }


    public void deleteUtente(Utente utente) throws MissingObjectException
    {
        PreparedStatement ps;

        try{

            String sql = "select *"
                    + " from Utente"
                    +" where id = ?";

        ps=conn.prepareStatement(sql);
        int i=1;
        ps.setInt(i++, utente.getId());

        ResultSet rs = ps.executeQuery();
        boolean exist= false;
        if(rs.next())
        exist=true;
        if(!exist)
       {rs.close();
        ps.close();
        
        throw new MissingObjectException("l'utente non esiste");}
                     else
                     {
                        sql = "DELETE"
                        +" FROM Utente"
                        +" Where id=?";

            ps=conn.prepareStatement(sql);
            i=1;
            ps.setInt(i++, utente.getId());
            ps.executeUpdate();
            rs.close();
            ps.close();

                     
        
        }
    


        }

        catch(SQLException e) {System.out.println(e.getMessage());}
    }


    
}
