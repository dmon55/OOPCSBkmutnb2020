/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stsky;

import java.io.InputStream;
import sun.audio.AudioPlayer;
import javax.sound.sampled.*;
import sun.audio.AudioStream;

/**
 *
 * @author BasLF
 */
public class SFX {
    public void shoot() 
            {
              try
              {
                // get the sound file as a resource out of my jar file;
                // the sound file must be in the same directory as this class file.
                // the input stream portion of this recipe comes from a javaworld.com article.
                    
                    
                    InputStream inputStream = getClass().getResourceAsStream("res/se_plst00.wav");
                    AudioStream audioStream = new AudioStream(inputStream);
                    AudioPlayer.player.start(audioStream);
                    Clip myclip = AudioSystem.getClip();
                    FloatControl audioControl = (FloatControl) myclip.getControl(FloatControl.Type.MASTER_GAIN);
                     audioControl.setValue(-20.0f); //decrease volume *note: unuseable/for Java sound API
                     myclip.start();

                
              }
              catch (Exception e)
              {
                
                
              }
            }
    
    public void hit1() 
            {
              try
              {
                // get the sound file as a resource out of my jar file;
                // the sound file must be in the same directory as this class file.
                // the input stream portion of this recipe comes from a javaworld.com article.
                    
                    
                    InputStream inputStream = getClass().getResourceAsStream("res/se_damage00.wav");
                    AudioStream audioStream = new AudioStream(inputStream);
                    AudioPlayer.player.start(audioStream);
                    Clip myclip = AudioSystem.getClip();
                    FloatControl audioControl = (FloatControl) myclip.getControl(FloatControl.Type.MASTER_GAIN);
                     audioControl.setValue(-20.0f); //decrease volume *note: unuseable/for Java sound API
                     myclip.start();

                
              }
              catch (Exception e)
              {
                
                
              }
            }
    public void hit2() 
            {
              try
              {
                // get the sound file as a resource out of my jar file;
                // the sound file must be in the same directory as this class file.
                // the input stream portion of this recipe comes from a javaworld.com article.
                    
                    
                    InputStream inputStream = getClass().getResourceAsStream("res/se_damage01.wav");
                    AudioStream audioStream = new AudioStream(inputStream);
                    AudioPlayer.player.start(audioStream);
                    Clip myclip = AudioSystem.getClip();
                    FloatControl audioControl = (FloatControl) myclip.getControl(FloatControl.Type.MASTER_GAIN);
                     audioControl.setValue(-20.0f); //decrease volume *note: unuseable/for Java sound API
                     myclip.start();

                
              }
              catch (Exception e)
              {
                
                
              }
            }
    public void changestage() 
            {
              try
              {
                // get the sound file as a resource out of my jar file;
                // the sound file must be in the same directory as this class file.
                // the input stream portion of this recipe comes from a javaworld.com article.
                    
                    
                    InputStream inputStream = getClass().getResourceAsStream("res/se_enep01.wav");
                    AudioStream audioStream = new AudioStream(inputStream);
                    AudioPlayer.player.start(audioStream);
                    Clip myclip = AudioSystem.getClip();
                    FloatControl audioControl = (FloatControl) myclip.getControl(FloatControl.Type.MASTER_GAIN);
                     audioControl.setValue(-20.0f); //decrease volume *note: unuseable/for Java sound API
                     myclip.start();

                
              }
              catch (Exception e)
              {
                
                
              }
            }
    public void pdead() 
            {
              try
              {
                // get the sound file as a resource out of my jar file;
                // the sound file must be in the same directory as this class file.
                // the input stream portion of this recipe comes from a javaworld.com article.
                    
                    
                    InputStream inputStream = getClass().getResourceAsStream("res/se_pldead00.wav");
                    AudioStream audioStream = new AudioStream(inputStream);
                    AudioPlayer.player.start(audioStream);
                    Clip myclip = AudioSystem.getClip();
                    FloatControl audioControl = (FloatControl) myclip.getControl(FloatControl.Type.MASTER_GAIN);
                     audioControl.setValue(-20.0f); //decrease volume *note: unuseable/for Java sound API
                     myclip.start();

                
              }
              catch (Exception e)
              {
                
                
              }
            }
    public void pause() 
            {
              try
              {
                // get the sound file as a resource out of my jar file;
                // the sound file must be in the same directory as this class file.
                // the input stream portion of this recipe comes from a javaworld.com article.
                    
                    
                    InputStream inputStream = getClass().getResourceAsStream("res/se_pause.wav");
                    AudioStream audioStream = new AudioStream(inputStream);
                    AudioPlayer.player.start(audioStream);
                    Clip myclip = AudioSystem.getClip();
                    FloatControl audioControl = (FloatControl) myclip.getControl(FloatControl.Type.MASTER_GAIN);
                     audioControl.setValue(-20.0f); //decrease volume *note: unuseable/for Java sound API
                     myclip.start();

                
              }
              catch (Exception e)
              {
                
                
              }
            }
    public void resume() 
            {
              try
              {
                // get the sound file as a resource out of my jar file;
                // the sound file must be in the same directory as this class file.
                // the input stream portion of this recipe comes from a javaworld.com article.
                    
                    
                    InputStream inputStream = getClass().getResourceAsStream("res/se_cancel00.wav");
                    AudioStream audioStream = new AudioStream(inputStream);
                    AudioPlayer.player.start(audioStream);
                    Clip myclip = AudioSystem.getClip();
                    FloatControl audioControl = (FloatControl) myclip.getControl(FloatControl.Type.MASTER_GAIN);
                     audioControl.setValue(-20.0f); //decrease volume *note: unuseable/for Java sound API
                     myclip.start();

                
              }
              catch (Exception e)
              {
                
                
              }
            }
    public void bombuse() 
            {
              try
              {
                // get the sound file as a resource out of my jar file;
                // the sound file must be in the same directory as this class file.
                // the input stream portion of this recipe comes from a javaworld.com article.
                    
                    
                    InputStream inputStream = getClass().getResourceAsStream("res/se_exattack.wav");
                    AudioStream audioStream = new AudioStream(inputStream);
                    AudioPlayer.player.start(audioStream);
                    Clip myclip = AudioSystem.getClip();
                    FloatControl audioControl = (FloatControl) myclip.getControl(FloatControl.Type.MASTER_GAIN);
                     audioControl.setValue(-20.0f); //decrease volume *note: unuseable/for Java sound API
                     myclip.start();
                     

                
              }
              catch (Exception e)
              {
                
                
              }
            }
    public void gaz() 
            {
              try
              {
                // get the sound file as a resource out of my jar file;
                // the sound file must be in the same directory as this class file.
                // the input stream portion of this recipe comes from a javaworld.com article.
                    
                    
                    InputStream inputStream = getClass().getResourceAsStream("res/se_graze.wav");
                    AudioStream audioStream = new AudioStream(inputStream);
                    AudioPlayer.player.start(audioStream);
                    Clip myclip = AudioSystem.getClip();
                    FloatControl audioControl = (FloatControl) myclip.getControl(FloatControl.Type.MASTER_GAIN);
                     audioControl.setValue(-20.0f); //decrease volume *note: unuseable/for Java sound API
                     myclip.start();
                     

                
              }
              catch (Exception e)
              {
                
                
              }
            }
    public void timeout() 
            {
              try
              {
                // get the sound file as a resource out of my jar file;
                // the sound file must be in the same directory as this class file.
                // the input stream portion of this recipe comes from a javaworld.com article.
                    
                    
                    InputStream inputStream = getClass().getResourceAsStream("res/se_timeout.wav");
                    AudioStream audioStream = new AudioStream(inputStream);
                    AudioPlayer.player.start(audioStream);
                    Clip myclip = AudioSystem.getClip();
                    FloatControl audioControl = (FloatControl) myclip.getControl(FloatControl.Type.MASTER_GAIN);
                     audioControl.setValue(-20.0f); //decrease volume *note: unuseable/for Java sound API
                     myclip.start();
                     

                
              }
              catch (Exception e)
              {
                
                
              }
            }
    public void timeoutf() 
            {
              try
              {
                // get the sound file as a resource out of my jar file;
                // the sound file must be in the same directory as this class file.
                // the input stream portion of this recipe comes from a javaworld.com article.
                    
                    
                    InputStream inputStream = getClass().getResourceAsStream("res/se_fault.wav");
                    AudioStream audioStream = new AudioStream(inputStream);
                    AudioPlayer.player.start(audioStream);
                    Clip myclip = AudioSystem.getClip();
                    FloatControl audioControl = (FloatControl) myclip.getControl(FloatControl.Type.MASTER_GAIN);
                     audioControl.setValue(-20.0f); //decrease volume *note: unuseable/for Java sound API
                     myclip.start();
                     

                
              }
              catch (Exception e)
              {
                
                
              }
            }
    public void getup() 
            {
              try
              {
                // get the sound file as a resource out of my jar file;
                // the sound file must be in the same directory as this class file.
                // the input stream portion of this recipe comes from a javaworld.com article.
                    
                    
                    InputStream inputStream = getClass().getResourceAsStream("res/se_extend.wav");
                    AudioStream audioStream = new AudioStream(inputStream);
                    AudioPlayer.player.start(audioStream);
                    Clip myclip = AudioSystem.getClip();
                    FloatControl audioControl = (FloatControl) myclip.getControl(FloatControl.Type.MASTER_GAIN);
                     audioControl.setValue(-20.0f); //decrease volume *note: unuseable/for Java sound API
                     myclip.start();
                     

                
              }
              catch (Exception e)
              {
                
                
              }
            }
    
}
