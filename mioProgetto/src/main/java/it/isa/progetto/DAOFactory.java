package it.isa.progetto;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DAOFactory {



  private Connection connection;

  

  
  public void beginTransaction() {

    try {
      Class.forName(Configuration.DATABASE_DRIVER);
      this.connection = DriverManager.getConnection(Configuration.DATABASE_URL);
      this.connection.setAutoCommit(false);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }

  
  public void commitTransaction() {
    try {
      this.connection.commit();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  
  public void rollbackTransaction() {

    try {
      this.connection.rollback();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }

  public void closeTransaction() {
    try {
      this.connection.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  
  public UtenteDAO getUserDAO() {
    return new UtenteDAO(connection);
  }

  
  public BranoDAO getContactDAO() {
    return new BranoDAO(connection);
  }
}