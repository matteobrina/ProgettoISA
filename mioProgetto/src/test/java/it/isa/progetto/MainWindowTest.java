package it.isa.progetto;

import org.assertj.swing.core.matcher.JButtonMatcher;
import org.assertj.swing.core.matcher.JTextComponentMatcher;
import org.assertj.swing.fixture.JButtonFixture;
import org.assertj.swing.fixture.JTextComponentFixture;
import org.junit.Test;

public class MainWindowTest extends AbstractUiTest {

    private JButtonFixture login;
    private JButtonFixture indietroButtonFixture;
    private JTextComponentFixture username1;
    

    @Override
    protected void onSetUp() {
        this.login = this.frame.button(JButtonMatcher.withText("Login"));
        
       
    }

    @Test
    public void testWithDifferingComponentMatchers() {
        // use JTextComponentMatcher.any() as there is only one text input
        
        this.login.requireVisible().requireEnabled().click();
        this.indietroButtonFixture = this.frame.button(JButtonMatcher.withName("Indietro1"));
        this.username1=this.frame.textBox(JTextComponentMatcher.withName("Username1"));
        this.username1.enterText("ciao");
        this.indietroButtonFixture.requireVisible().requireEnabled().click();
        // use value assigned in MainWindow class via JTextArea.setName("Center-Area") to identify component here
        

        
       
        
    }

    @Override
    protected void onTearDown() {
        this.login = null;
        this.indietroButtonFixture=null;
        this.username1=null;
        
    }
}
