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
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import sun.applet.Main;
public class Menu extends JFrame implements ActionListener{

    /**
     * @param args the command line arguments
     */
    Home homemenu = new Home();
    Stage1 state1 = new Stage1();;
    SFX soundx = new SFX();
        
    public Menu() throws IOException{
	this.setSize(960,720);
	this.add(homemenu);
	homemenu.BExit1.addActionListener(this);
        homemenu.BStart.addActionListener(this);
        state1.BPause.addActionListener(this);
        state1.Bresum.addActionListener(this);
        state1.requestFocusInWindow();
		state1.t.suspend();
		state1.time.suspend();
		state1.player.suspend();                               
		state1.Bice1.suspend();
                state1.timeanimate.suspend();
                state1.move.suspend();
                state1.bombpause.suspend();
                state1.boss.suspend();
                state1.inframe.suspend();
                state1.debufftime.suspend();
                
    }
    public void actionPerformed(ActionEvent e) {
            if(e.getSource()== homemenu.BStart){
		this.setLocationRelativeTo(null);
		this.remove(homemenu);
                this.setSize(960,720);
                this.add(state1);
                state1.requestFocusInWindow();
		state1.timestart = false;
		state1.sco=0;
		state1.LP =3;
		state1.BossLT = 60;
		state1.startshoot=false;
		state1.timestart=false;
                state1.t.resume();
		state1.time.resume();
		state1.player.resume();
		state1.Bice1.resume();
                state1.timeanimate.resume();
                state1.move.resume();
                state1.bombpause.resume();
                state1.boss.resume();
                state1.inframe.resume();
                state1.debufftime.resume();
            }else if(e.getSource() == homemenu.BExit1){
		System.exit(0);
            }else if(e.getSource() == state1.BPause){
                soundx.pause();
		this.setLocationRelativeTo(null);
		this.setSize(960,720);
		this.add(state1);
		state1.requestFocusInWindow();
		state1.t.suspend();
		state1.time.suspend();
		state1.player.suspend();                               
		state1.Bice1.suspend();
                state1.timeanimate.suspend();
                state1.move.suspend();
                state1.bombpause.suspend();
                state1.boss.suspend();
                state1.inframe.suspend();
                state1.debufftime.suspend();
                

			
            }else if(e.getSource() == state1.Bresum){
                soundx.resume();
		this.setLocationRelativeTo(null);
		this.setSize(960,720);
		this.add(state1);
		state1.requestFocusInWindow();
		state1.t.resume();
		state1.time.resume();
		state1.player.resume();
		state1.Bice1.resume();
                state1.timeanimate.resume();
                state1.move.resume();
                state1.bombpause.resume();
                state1.boss.resume();
                state1.inframe.resume();
                state1.debufftime.resume();

            }
            this.validate();
            this.repaint();
	}
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        JFrame jf = new Menu();
        jf.setSize(960,720);
        jf.setTitle("Animation Example");
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
    }

    
    
}
