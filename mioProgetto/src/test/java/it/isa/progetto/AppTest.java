package it.isa.progetto;



import org.junit.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * Unit test for simple App.
 */

 @TestInstance(Lifecycle.PER_CLASS)
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    
    
    


    @Test
    public void appTest()
    {
        new App();
        String[] args = new String[1];
        App.main(args);
    }



   
}
