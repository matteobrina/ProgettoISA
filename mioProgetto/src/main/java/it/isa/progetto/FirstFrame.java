package it.isa.progetto;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;



public class FirstFrame extends JFrame {

    private JPanel container = new JPanel();
    private FirstPanel fp = new FirstPanel();
    private LoginPanel lp = new LoginPanel();
    private RegisterPanel rp = new RegisterPanel();
    private CardLayout cl = new CardLayout();
    private LoginPanelController lpc = new LoginPanelController();
    private RegisterPanelController rpc = new RegisterPanelController();
    private MainPanelController mpc = new MainPanelController();
    private String username="";
    private MainPanel mp = new MainPanel(mpc.findAllBrani(), username);


    public FirstFrame() 
    {

        
    
        super("Brinafy");
        File file = new File("songs/l.mp3");
        
        
        
        
        

        
        container.setLayout(cl);

        container.add(fp, "1");
        container.add(lp, "2");
        container.add(rp, "3");
        container.add(mp, "7");
        
        cl.show(container, "1");

        fp.jButton1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(container, "2");
                
            }
            
        });

        fp.jButton2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(container, "3");
                
            }
            
        });

        lp.jButton1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Utente utente = lpc.login(lp.jTextField1.getText(), String.valueOf(lp.jTextField2.getPassword()));
                    JOptionPane.showMessageDialog(lp, "Login avvenuto con successo!");
                    username = "Benvenuto "+utente.getUsername();
                    mp= new MainPanel(mpc.findAllBrani(), username);
                
                    mp.jButton1.addActionListener(new ActionListener(){

                        @Override
                        public void actionPerformed(ActionEvent e) {
                           try{ 

                            if (mp.jButton3.isEnabled())
                            mpc.stop();
                           
                           mp = new MainPanel((mpc.findByString(mp.jTextField1.getText())), username);
                           mp.jButton1.addActionListener(this);
                           
                           
                           
                           container.add(mp, "7");
            
                           cl.show(container, "7");
            
            
                           }
            
                           catch(MissingObjectException ex){
            
                            JOptionPane.showMessageDialog( mp, "Nessun Brano!");
            
                           }
                          
                            
                                
            
                               
                                
            
                             
                             
                        }
                        
                        
                        
                    });


                    container.add(mp, "7");
                    cl.show(container, "7");
                }
                catch(MissingObjectException ex)
                {
                    JOptionPane.showMessageDialog(lp, "L'utente non esiste!");
                }

                catch(WrongPasswordException ex)
                {
                    JOptionPane.showMessageDialog(lp, "Password Errata!");
                }
                
            }
            
        });

        lp.jButton2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(container, "1");
                
            }
            
        });

        rp.jButton1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try{

                rpc.register(rp.jTextField1.getText(), String.valueOf(rp.jTextField2.getPassword()));
                JOptionPane.showMessageDialog(lp, "Registrazione avvenuta con successo!");
                cl.show(container, "1");
                }
                catch(DuplicatedObjectException ex)
                {
                    JOptionPane.showMessageDialog(lp, "L'utente esiste già!");
                }
            }
            
        });

        rp.jButton2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(container, "1");
                
            }
            
        });

        


       

        

        

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {

                
                file.delete();
                
                }
                
            });
        



        


        
       


        
        

        
        add(container);
        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    


    

    
}
