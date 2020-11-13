/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stsky;
import java.awt.*;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 *
 * @author BasLF
 */
public class redice extends Hitboxs{
    BufferedImage bigImg;
    Image img;
    public int y;
    public int x;
    public int count=0;
    int r = 1;
    redice(int x,int y) throws IOException{
            this.bigImg = ImageIO.read(this.getClass().getResource("/stsky/res/redice.png"));

            this.x=x;
            this.y=y;
    }
    public void move(){
	this.y+=1;
        }
    public Image getImage(){
            return bigImg;
	}
    public int getX(){
            return x;
	}

	public int getY(){
            return y;
	}
        public redice getthis(){
            return this;
	}
}
