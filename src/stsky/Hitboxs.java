/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stsky;
import javax.swing.JPanel;
import java.io.*; 

/**
 *
 * @author BasLF
 */
public abstract class Hitboxs extends JPanel{
    int r;
    int x;
    int y;
    public void updateloca(int x,int y){
        this.x=x;
        this.y=y;
    }
    
    public double hitboxscale() {
        return Math.PI*r*r;
    }
    public boolean circleIntersect(Hitboxs a, Hitboxs b) {
        int distSq = (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
        int radSumSq = (a.r + b.r) * (a.r + b.r);
        if (distSq == radSumSq){
            return false;
        }else if (distSq > radSumSq) 
            return false; 
        else
            return true;
    }
}



