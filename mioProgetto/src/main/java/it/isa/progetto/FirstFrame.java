package it.isa.progetto;


import javax.swing.JFrame;
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


        lp.jButton2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(container, "1");
                
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
