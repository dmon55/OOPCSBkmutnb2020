/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stsky;

import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author BasLF
 */
public class RBullet extends Hitboxs{
    BufferedImage bigImg;
    int i,j;
    public int width = 10;
    public int height = 16;
    final int rows = 1;
    final int cols = 1;
    public int y;
    public int x;
    public int count=0;
    public int r=4;
    BufferedImage[] sprites = new BufferedImage[rows*cols];

    public RBullet(int x,int y) throws IOException {
        this.bigImg = ImageIO.read(this.getClass().getResource("/stsky/res/Rbullet1.png"));
        for(i=0;i<rows;i++){
            sprites[(i * cols) + j] = bigImg.getSubimage(
                j * width,
                i * height,
                width,
                height
            );
            
        }

        this.x=x;
        this.y=y;
    }
    public void move(){
	this.y-=5;
    }
    public Rectangle2D getbound(){
    	return (new Rectangle2D.Double(x,y,25,25));
    }
    

    
    void drawSpriteFrame(){
        i=1;
        for (j = 0; j < cols; j++){
            sprites[(i * cols) + j] = bigImg.getSubimage(
                j * width,
                i * height,
                width,
                height
            );
        }
    
    }

        
    
}
