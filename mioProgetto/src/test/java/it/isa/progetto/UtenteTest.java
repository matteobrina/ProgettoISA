package it.isa.progetto;

import org.junit.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;


@TestInstance(Lifecycle.PER_CLASS)
public class UtenteTest {


    @Test
    public void testSetId() throws NoSuchFieldException, IllegalAccessException {
        //given
        final int id=9;
        final Utente utente = new Utente();

        //when
        utente.setId(id);

        //then
        final Field field = utente.getClass().getDeclaredField("id");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(utente), id);

    }

    @Test
    public void testGetId() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Utente utente = new Utente();
        final int id=23;
        final Field field = utente.getClass().getDeclaredField("id");
        field.setAccessible(true);
        field.set(utente, id);

        //when
        final int result = utente.getId();

        //then
        assertEquals("field wasn't retrieved properly", result, id);
    }

    @Test
    public void testSetUsername() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Utente utente = new Utente();

        //when
        utente.setUsername("testsetusername");

        //then
        final Field field = utente.getClass().getDeclaredField("username");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(utente), "testsetusername");

    }

    @Test
    public void testGetUsername() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Utente utente = new Utente();
        final Field field = utente.getClass().getDeclaredField("username");
        field.setAccessible(true);
        field.set(utente, "testgetusername");

        //when
        final String result = utente.getUsername();

        //then
        assertEquals("field wasn't retrieved properly", result, "testgetusername");
    }

    @Test
    public void testSetPassword() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Utente utente = new Utente();

        //when
        utente.setPassword("testsetpassword");

        //then
        final Field field = utente.getClass().getDeclaredField("password");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(utente), "testsetpassword");

    }

    @Test
    public void testGetPassword() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Utente utente = new Utente();
        final Field field = utente.getClass().getDeclaredField("password");
        field.setAccessible(true);
        field.set(utente, "testgetpassword");

        //when
        final String result = utente.getPassword();

        //then
        assertEquals("field wasn't retrieved properly", result, "testgetpassword");
    }

    
}
