/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stsky;

import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author BasLF
 */
public class Reimu extends Hitboxs{
    BufferedImage bigImg;
    int i,j;
    public int width = 32;
    public int height = 48;
    final int rows = 3;
    final int cols = 8;
    public int count=0;
    public int y;
    public int x;
    public int r=3;
    BufferedImage[] sprites = new BufferedImage[rows * cols];
    public Reimu()  throws IOException {
        this.bigImg = ImageIO.read(this.getClass().getResource("/stsky/res/reimu.png"));
        
        for(i=0;i<rows;i++){
           
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

    public Reimu updateloca(){
        return this; 
    }
    
    public Image getImage(int i) {
        i = i%7;
        return sprites[i];
    }

        
        
    
    
    Image moveleft(int i){
        i = i%7+7;
        return sprites[i];
    
    }
    Image moveright(int i){
        i = i%7+14;
        return sprites[i];
    
    }
    
    
    
    
}
