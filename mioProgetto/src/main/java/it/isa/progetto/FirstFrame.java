package it.isa.progetto;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FirstFrame extends JFrame {

    private JPanel container = new JPanel();
    private FirstPanel fp = new FirstPanel();
    private LoginPanel lp = new LoginPanel();
    private RegisterPanel rp = new RegisterPanel();
    private CardLayout cl = new CardLayout();
    private LoginPanelController lpc = new LoginPanelController();
    private RegisterPanelController rpc = new RegisterPanelController();
    private MainPanelController mpc = new MainPanelController();
    

    private AltMainPanel amp = new AltMainPanel(mpc.findAllBrani());


    public FirstFrame()
    {
        super("Brinafy");

        
        container.setLayout(cl);

        container.add(fp, "1");
        container.add(lp, "2");
        container.add(rp, "3");
        container.add(amp, "6");
        
        cl.show(container, "6");

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
                    lpc.login(lp.jTextField1.getText(), lp.jTextField2.getText());
                    cl.show(container, "6");
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

                rpc.register(rp.jTextField1.getText(), rp.jTextField2.getText());
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

        


        amp.jButton1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
               try{ 
               
               amp = new AltMainPanel(mpc.findByString(amp.jTextField1.getText()));
               amp.jButton1.addActionListener(this);
               container.add(amp, "6");

               cl.show(container, "6");


               }

               catch(MissingObjectException ex){

                JOptionPane.showMessageDialog( amp, "Nessun Brano!");

               }
              
                
                    

                   
                    

                 
                 
            }
            
            
            
        });


        



        


        
       


        
        

        
        add(container);
        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    


    

    
}
