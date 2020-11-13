/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stsky;


import java.awt.*;
import java.awt.geom.Rectangle2D;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author BasLF
 */
public class Bcirno extends Hitboxs{
    BufferedImage bigImg;
    int i,j;
    public int width = 24;
    public int height = 32;
    final int rows = 8;
    final int cols = 8;
    public int count=0;
    public int y;
    public int x;
    public int r=5;
    BufferedImage[] sprites = new BufferedImage[rows * cols];
    public Bcirno()  throws IOException {
        this.bigImg = ImageIO.read(this.getClass().getResource("/stsky/res/test.png"));
        for(i=0;i<rows;i++){
            for(j=0;j<cols;j++){
            sprites[(i * cols) + j] = bigImg.getSubimage(
                j * width,
                i * height,
                width,
                height
            );
        }
        }
        
        
    }
    public Image getimage(int i){
        i = (i%4)+32;
        return (Image)sprites[i];
    }
    
    void standstill(){
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
    public Rectangle2D getbound(){
    	return (new Rectangle2D.Double(x,y,25,25));
    }
    
}
