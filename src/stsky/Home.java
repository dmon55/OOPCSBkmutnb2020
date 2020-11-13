/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stsky;

/**
 *
 * @author BasLF
 */
import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Home extends JPanel{
    private ImageIcon feild = new ImageIcon(this.getClass().getResource("res/World-Hakurei-Shrine.png"));
    private ImageIcon img = new ImageIcon(this.getClass().getResource("res/Th12Reimu.png"));
    private ImageIcon starts = new ImageIcon(this.getClass().getResource("res/Start.png"));
    private ImageIcon exit = new ImageIcon(this.getClass().getResource("res/Exit.png"));
    public JButton BStart = new JButton(starts);
    public JButton BExit1  = new JButton(exit);
    Home(){
            setLayout(null);
            BExit1.setBounds(425, 500, 100,50);
            add(BExit1);
            add(BStart);
            BStart.setBounds(425,400,100,50);
            add(BStart);
	}
    public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(feild.getImage(),0,0,960,720,this);
            g.drawImage(img.getImage(), 10, 200, 256, 436, this);
            g.setColor(Color.BLACK);
            g.setFont(new Font("2005_iannnnnTKO",Font.CENTER_BASELINE,90));		
            g.drawString("Shoot The Sky",180,80);	
	}
    
}
