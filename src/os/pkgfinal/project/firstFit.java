/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os.pkgfinal.project;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Kareem Elantably
 */
public class firstFit extends JFrame {
    public firstFit()
    {
    setSize(1000, 1000);
        setTitle("First Fit");
        Container cp=getContentPane();
               
                 cp.setLayout(null);
                 
    Label st=new Label("Start");
    st.setBounds(420, 40, 40, 20);
     Label in=new Label("initialize partition array ");
    cp.add(st);
    }
    @Override
    public void paint(Graphics g)
    {
       
    g.drawRoundRect(400, 50, 100, 70, 20, 20);
    
    
    g.drawLine(450, 120, 450, 170);
    g.drawLine(450, 170, 455, 160);
    g.drawLine(450, 170, 445, 160);
    
    g.drawRect(400,170,100,70);
    
    
    }
    
    
}
