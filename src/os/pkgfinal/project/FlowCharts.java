/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os.pkgfinal.project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Kareem Elantably
 */
public class FlowCharts extends JFrame {
    public FlowCharts()
            {
            setSize(1000, 1000);
        setTitle("Choose");
              JButton b1=new JButton("First Fit");
              b1.setBounds(30, 300, 150, 100);
            
               JButton b2=new JButton("Best Fit");
              b2.setBounds(410, 300, 150, 100);
              
               JButton b3=new JButton("Worst Fit");
              b3.setBounds(800, 300, 150, 100);
               Container cp=getContentPane();
               
                 cp.setLayout(null);
                 
                 cp.add(b1);
                 cp.add(b2);
                 cp.add(b3);
                 b1.addActionListener(new Action());
                 b2.addActionListener(new Action2());
                 b3.addActionListener(new Action3());
                 
            }
   static class Action implements ActionListener
   {
   @Override
   public void actionPerformed(ActionEvent e)
   {
   firstFit obj=new firstFit();
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
   }
   
    static class Action2 implements ActionListener
   {
   @Override
   public void actionPerformed(ActionEvent e)
   {
   bestFit obj=new bestFit();
        obj.setVisible(true);
   }
   
   }
   
   static class Action3 implements ActionListener
   {
   @Override
   public void actionPerformed(ActionEvent e)
   {
   worstFit obj=new worstFit();
        obj.setVisible(true);
   }
   
   }
   
    
}
