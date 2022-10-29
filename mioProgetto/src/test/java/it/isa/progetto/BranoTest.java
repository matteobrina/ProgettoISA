package it.isa.progetto;

import org.junit.jupiter.api.TestInstance;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;


import org.junit.Test;
import org.junit.jupiter.api.TestInstance.Lifecycle;




@TestInstance(Lifecycle.PER_CLASS)
public class BranoTest {   
    
    
    @Test
    public void testSetId() throws NoSuchFieldException, IllegalAccessException {
        //given
        final int id=5;
        final Brano brano = new Brano();

        //when
        brano.setId(id);

        //then
        final Field field = brano.getClass().getDeclaredField("id");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(brano), id);

    }

    @Test
    public void testGetId() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Brano brano = new Brano();
        final int id=7;
        final Field field = brano.getClass().getDeclaredField("id");
        field.setAccessible(true);
        field.set(brano, id);

        //when
        final int result = brano.getId();

        //then
        assertEquals("field wasn't retrieved properly", result, id);
    }


    @Test
    public void testSetTitolo() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Brano brano = new Brano();

        //when
        brano.setTitolo("testsettitolo");

        //then
        final Field field = brano.getClass().getDeclaredField("titolo");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(brano), "testsettitolo");

    }

    @Test
    public void testGetTitolo() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Brano brano = new Brano();
        final Field field = brano.getClass().getDeclaredField("titolo");
        field.setAccessible(true);
        field.set(brano, "testgettitolo");

        //when
        final String result = brano.getTitolo();

        //then
        assertEquals("field wasn't retrieved properly", result, "testgettitolo");
    }

    @Test
    public void testSetAlbum() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Brano brano = new Brano();

        //when
        brano.setAlbum("testsetalbum");

        //then
        final Field field = brano.getClass().getDeclaredField("album");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(brano), "testsetalbum");

    }

    @Test
    public void testGetAlbum() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Brano brano = new Brano();
        final Field field = brano.getClass().getDeclaredField("album");
        field.setAccessible(true);
        field.set(brano, "testgetalbum");

        //when
        final String result = brano.getAlbum();

        //then
        assertEquals("field wasn't retrieved properly", result, "testgetalbum");
    }

    @Test
    public void testSetCanzone() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Brano brano = new Brano();
        final String a = "testsetcanzone";
        final byte[] b = a.getBytes();

        //when
        brano.setCanzone(b);

        //then
        final Field field = brano.getClass().getDeclaredField("canzone");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(brano), b);

    }

    @Test
    public void testGetCanzone() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Brano brano = new Brano();
        final String a = "testgetcanzone";
        final byte[] b = a.getBytes();
        final Field field = brano.getClass().getDeclaredField("canzone");
        field.setAccessible(true);
        field.set(brano, b);

        //when
        final byte[] result = brano.getCanzone();

        //then
        assertEquals("field wasn't retrieved properly", result, b);
    }

    @Test
    public void testSetArtista() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Brano brano = new Brano();

        //when
        brano.setArtista("testsetartista");

        //then
        final Field field = brano.getClass().getDeclaredField("artista");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(brano), "testsetartista");

    }

    @Test
    public void testGetArtista() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Brano brano = new Brano();
        final Field field = brano.getClass().getDeclaredField("artista");
        field.setAccessible(true);
        field.set(brano, "testgetartista");

        //when
        final String result = brano.getArtista();

        //then
        assertEquals("field wasn't retrieved properly", result, "testgetartista");
    }

    @Test
    public void testSetAscolti() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Brano brano = new Brano();
        final int a = 9;

        //when
        brano.setAscolti(a);

        //then
        final Field field = brano.getClass().getDeclaredField("ascolti");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(brano), a);

    }

    @Test
    public void testGetAscolti() throws NoSuchFieldException, IllegalAccessException {
        //given
        final Brano brano = new Brano();
        final int a = 15;
        final Field field = brano.getClass().getDeclaredField("ascolti");
        field.setAccessible(true);
        field.set(brano, a);

        //when
        final int result = brano.getAscolti();

        //then
        assertEquals("field wasn't retrieved properly", result, a);
    }

  

    

    

}
    
    
    
    
    
