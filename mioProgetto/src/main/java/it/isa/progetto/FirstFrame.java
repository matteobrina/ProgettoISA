package it.isa.progetto;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstFrame extends JFrame {

    JPanel container = new JPanel();
    FirstPanel fp = new FirstPanel();
    LoginPanel lp = new LoginPanel();
    RegisterPanel rp = new RegisterPanel();
    MainPanel mp= new MainPanel();
    CardLayout cl = new CardLayout();
    LoginPanelController lpc = new LoginPanelController();
    RegisterPanelController rpc = new RegisterPanelController();
    public FirstFrame()
    {
        super("Brinafy");

        
        container.setLayout(cl);

        container.add(fp, "1");
        container.add(lp, "2");
        container.add(rp, "3");
        container.add(mp, "4");

        cl.show(container, "4");

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
                    cl.show(container, "4");
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

        


        
       


        
        

        
        add(container);
        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    


    

    
}
