/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stsky;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author BasLF
 */
public class Baditem extends Hitboxs {
    BufferedImage bigImg;
    Image img;
    public int y;
    public int x;
    public int count=0;
    int r = 3;
    Baditem(int x,int y) throws IOException{
            this.bigImg = ImageIO.read(this.getClass().getResource("/stsky/res/baditem.png"));

            this.x=x;
            this.y=y;
    }
    public Image getImage(){
            return bigImg;
	}

        public void move(){
	this.y+=1;
        }
	public int getX(){
            return x;
	}

	public int getY(){
            return y;
	}

	public Baditem getthis(){
            return this;
	}
    
}
