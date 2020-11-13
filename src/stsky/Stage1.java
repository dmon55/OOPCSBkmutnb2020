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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import sun.audio.*;

import java.net.URL;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;

import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
public class Stage1 extends JPanel implements ActionListener{
       SFX sound = new SFX();
        private final ImageIcon level_background1 = new ImageIcon(this.getClass().getResource("res/nikita-kozlov.png"));
	private final ImageIcon level_background2 = new ImageIcon(this.getClass().getResource("res/lose.png"));
        private final ImageIcon level_background3 = new ImageIcon(this.getClass().getResource("res/win.png"));
	private final ImageIcon pause = new ImageIcon(this.getClass().getResource("res/puse.png"));
	private final ImageIcon resum = new ImageIcon(this.getClass().getResource("res/resum.png"));
        private final ImageIcon bar = new ImageIcon(this.getClass().getResource("res/hbar.png"));
        
	Reimu p= new Reimu();
        Bcirno bo1 = new Bcirno();
        
        
        private JLabel score = new JLabel(); 
        public JButton BPause  = new JButton(pause);
	public JButton Bresum  = new JButton(resum);
        
        
	
	int timestamp ;
        //movement
        private boolean left = false;
        private boolean up = false;
        private boolean down = false;
        private boolean right = false;
        private boolean shoot = false;

        private boolean buse ;
        
        // player info
	public int LP = 3;
        public int bomb = 3;
        boolean dead = false;
        boolean focus = false;
        int graze= 0;
        public int sco = 0+(graze*500);
        boolean debuff = false;
        
        //player bullet
        public ArrayList<RBullet> bul = new ArrayList<RBullet>();
        public ArrayList<power> powerupp = new ArrayList<power>();
        public int power = 1;
        public int RDamage = 20*power;
        
        //Timer (2nd method)

        
        
        // Boss info
        public int BossHP = 10000;
        public int BossSpells = 2;
        public int BossStage = 1;
        public int BossLT = 60;
        boolean clearReQ = false;
        //boss bullet
        public ArrayList<Ices> bb1 = new ArrayList<Ices>();
        public ArrayList<redice> redb = new ArrayList<redice>();
        public ArrayList<Baditem> badthing = new ArrayList<Baditem>();
        
        
        // stage info
	boolean timestart = true;
	boolean startshoot = false;
        boolean bombtrick = false;
        boolean PlayerDeadTrick = false;
        boolean BossStageTrick = false;
        public int times ;
	
	boolean paralyze1 = false;
	int time_paralyze=5;
        boolean stageparalyzel = false;  
        
        Thread time = new Thread(new Runnable(){
            public void run(){
		while(true){
                    try{
			Thread.sleep(10);
                    }catch(Exception e){ }
                    
                    if(timestart == false){
			repaint();
                    }
		}
            }
	});
        
        Thread player = new Thread(new Runnable(){
            public void run(){
		while(true){
                	try{
                            
                            Thread.sleep(1);
			}catch(Exception e){}
                            repaint();
		}
            }
	});
        Thread boss = new Thread(new Runnable(){
            public void run(){
		while(true){
                	try{
                            int x;
                            x= (int)(Math.random()*8);
                            if(x==0){
                                bo1.x -= 50;
                                bo1.y -= 50;
                            }else if(x==1){
                                bo1.x -= 50;
                                bo1.y += 50;
                            }else if(x==2){
                                bo1.x += 50;
                                bo1.y -= 50;
                            }else if(x==3){
                                bo1.x += 50;
                                bo1.y += 50;
                            }else if(x==4){
                                bo1.x += 50;
                            }else if(x==5){
                                bo1.x -= 50;
                            }else if(x==6){
                                bo1.y += 50;
                            }else if(x==7){
                                bo1.y -= 50;
                            }
                            if(bo1.x>670||bo1.x<0||bo1.y>300||bo1.y<20){
                                bo1.x = 400;
                                bo1.y = 70;
                            }
                            Thread.sleep(1300);
			}catch(Exception e){}
                            repaint();
		}
            }
	});
        
        Thread timeanimate = new Thread(new Runnable(){
            public void run() {
		while(true){
                	if(timestart == false){
                            timestamp = (timestamp+1) ;
                            if(timestamp>=50){
                                timestamp = 0;
                            }
                            if(paralyze1){
				time_paralyze--;
                            }
			}
			try{
                            Thread.sleep(100);
			}catch(InterruptedException e)
			{
                            e.printStackTrace();
			}
		}
            }
	});

        Thread t = new Thread(new Runnable(){
            public void run() {
		while(true){
                	if(timestart == false){
                            BossLT = (BossLT-1) ;
                            if(BossLT <=10){
                                sound.timeout();
                            }
                            
                            if(paralyze1){
				time_paralyze--;
                            }
			}
			try{
                            Thread.sleep(1000);
			}catch(InterruptedException e)
			{
                            e.printStackTrace();
			}
		}
            }
	});
        Thread Bice1 = new Thread(new Runnable(){
            public void run() {
                int nm=0;
            	while(true){
                    
			try{
                            if(startshoot==false){
                                Thread.sleep(200-nm);
                            }
			}catch(InterruptedException e){
                            e.printStackTrace();
			}
			if(startshoot == false){
                            try {
                                
                                if(stageparalyzel){
				
                                }else{
                                    int range = (int) (Math.random() * 700);
                                    int range4 = (int) (Math.random() * 700);
                                    int range2 = (int) (Math.random() * 200);
                                    int range3 = (int) (Math.random() * 500);
                                    int baditemspawn = (int)(Math.random()*8);
                                    if(BossSpells<=1){
                                        nm = 30;
                                        redb.add(new redice(bo1.x-350+range,bo1.y));
                                        bb1.add(new Ices(bo1.x-350+range,bo1.y));
                                    }else{
                                        
                                    }
                                    if(BossStage<=0){
                                        bb1.add(new Ices(p.x-100+range2,bo1.y));
                                        redb.add(new redice(p.x-250+range3,bo1.y));
                                        
                                    }else{
                                        
                                    }
                                    
                                    powerupp.add(new power(bo1.x-250+range3,bo1.y));
                                    bb1.add(new Ices(bo1.x-350+range,bo1.y));
                                    if(baditemspawn<=1){
                                        badthing.add(new Baditem(bo1.x-350+range4,bo1.y));
                                    }
                                }
                                
                            } catch (IOException ex) {
                                Logger.getLogger(Stage1.class.getName()).log(Level.SEVERE, null, ex);
                            }
			}
		}
            }
	});
	Thread paralyze = new Thread(new Runnable(){
            public void run(){
		while (true){
			if(time_paralyze < 1){
                            paralyze1 = false;
                            time_paralyze = 5;
			}
			try{
                            Thread.sleep(5000);
			}catch(InterruptedException e){e.printStackTrace();}
		}
            }
	});
        Thread debufftime = new Thread(new Runnable(){
            public void run(){
		while (true){
			
			try{
                            if(stageparalyzel){
				
                                }else{
                            if(debuff==true){
                                
                                Thread.sleep(5000);
                                debuff = false;
                            }
                            
                            }
                            
                            Thread.sleep(1);
			}catch(InterruptedException e){e.printStackTrace();}
		}
            }
	});
        Thread inframe = new Thread(new Runnable(){
            public void run(){
		while (true){
			
			try{
                            if(stageparalyzel){
				
                                }else{
                            //check live?
                        if(PlayerDeadTrick == true){
                           
                            //loss life
                            
                            LP -= 1;
                            //regain bomb
                            bomb = 3;
                            //lose score
                            sco -= 500;
                            //loss power
                            if(power>=4){
                                power -= 3;
                            }else if(power <=4){
                                power = 1;
                            }
                            Thread.sleep(4000);
                            
                            PlayerDeadTrick = false;
                            
                        }else{
                            
                        }
                        
                            }
                            Thread.sleep(1);
			}catch(InterruptedException e){e.printStackTrace();}
		}
            }
	});
        Thread bombpause = new Thread(new Runnable(){
            public void run(){
		while (true){
                    
                    
			try{
                            if(stageparalyzel){
                        
                            }else{
                                if(buse){
                                    //check bomb use
                                    if(bomb>=1){
                                        bombtrick = true;
                                        for(int i = 0;i<bb1.size();i++){
                                            bb1.remove(i);
                                        }
                                        for(int i = 0;i<redb.size();i++){
                                            redb.remove(i);
                                        }

                                        bomb -= 1;
                                        BossHP -= 4000;


                                        sound.bombuse();
                                        Thread.sleep(500);
                                        sound.bombuse();
                                        Thread.sleep(500);
                                        sound.bombuse();
                                        Thread.sleep(500);
                                        sound.bombuse();
                                        Thread.sleep(500);

                                        bombtrick = false;
                                    }
                                }else{
                            
                        }
                    }
                            Thread.sleep(1);
			}catch(InterruptedException e){e.printStackTrace();}
		}
            }
	});
        Thread move = new Thread(new Runnable(){
            public void run(){
		while (true){
			try{
                            if(stageparalyzel){
				
                                }else{
                                if(!focus){
                                    if (left && up) {
                                        p.x -= 10;
                                        p.y -= 10;
                                    } else if (left && down) {
                                        p.x -= 10;
                                        p.y += 10;
                                    } else if (right && up) {
                                        p.x += 10;
                                        p.y -= 10;
                                    } else if (right && down) {
                                        p.x += 10;
                                        p.y += 10;
                                    } else if (left) {
                                        p.x -= 10;
                                    } else if (up) {
                                        p.y -= 10;
                                    } else if (right) {
                                        p.x += 10;
                                    } else if (down) {
                                        p.y += 10;
                                    } 
                                }else{
                                    if (left && up) {
                                        p.x -= 5;
                                        p.y -= 5;
                                    } else if (left && down) {
                                        p.x -= 5;
                                        p.y += 5;
                                    } else if (right && up) {
                                        p.x += 5;
                                        p.y -= 5;
                                    } else if (right && down) {
                                        p.x += 5;
                                        p.y += 5;
                                    } else if (left) {
                                        p.x -= 5;
                                    } else if (up) {
                                        p.y -= 5;
                                    } else if (right) {
                                        p.x += 5;
                                    } else if (down) {
                                        p.y += 5;
                                    } 
                                }
                                if(shoot){
                                    bul.add(new RBullet(p.x,p.y));
                                    sound.shoot();
                                    
                                    
                                }
                            }
                        
                        
                            Thread.sleep(30);
			}catch(InterruptedException e){
                            e.printStackTrace();
                        } catch (IOException ex) {
                        Logger.getLogger(Stage1.class.getName()).log(Level.SEVERE, null, ex);
                    }
		}
            }
	});
        
        
        Stage1() throws IOException{
            
                

		this.setFocusable(true);
		this.setLayout(null);
		BPause.setBounds(850,100,40,40);
		Bresum.setBounds(850, 170, 40,40);
		BPause.addActionListener(this);
		Bresum.addActionListener(this);
		this.add(BPause);
		this.add(score);
		this.add(Bresum);
                
                
		this.addKeyListener(new KeyAdapter(){
                    @Override
                    public void keyTyped(KeyEvent e) {}
                    @Override
                    public void keyReleased(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_LEFT) left = false;
                        if (e.getKeyCode() == KeyEvent.VK_RIGHT) right = false;
                        if (e.getKeyCode() == KeyEvent.VK_UP) up = false;
                        if (e.getKeyCode() == KeyEvent.VK_DOWN) down = false;
                        if (e.getKeyCode() == KeyEvent.VK_Z) shoot = false;
                        if (e.getKeyCode() == KeyEvent.VK_SHIFT) focus = false;
                        if (e.getKeyCode() == KeyEvent.VK_X) buse = false;
                    }
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyCode() == KeyEvent.VK_LEFT) left = true;
                        if (e.getKeyCode() == KeyEvent.VK_RIGHT) right = true;
                        if (e.getKeyCode() == KeyEvent.VK_UP) up = true;
                        if (e.getKeyCode() == KeyEvent.VK_DOWN) down = true;
                        if (e.getKeyCode() == KeyEvent.VK_Z) shoot = true;
                        if (e.getKeyCode() == KeyEvent.VK_SHIFT) focus = true;
                        if (e.getKeyCode() == KeyEvent.VK_X) buse = true;
                    }
                    
                    
                   
		});
                
		
		p.x = 400;
                p.y = 500;
                bo1.x = 400;
                bo1.y = 70;
		time.start();
		player.start();
		t.start();
		Bice1.start();
		paralyze.start();
                timeanimate.start();
                move.start();
                bombpause.start();
                boss.start();
                inframe.start();
                debufftime.start();
                stageparalyzel = false;
                
	}
        
        
        
        
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(level_background1.getImage(),0,0,960,720,this);
            
           
            // check boss life time
            if(BossLT <= 0){
                BossStageTrick = true;
                sound.timeoutf();
                sco -= 5000;
            }
            //Boss Stage check
            if(BossStageTrick == true){
                sound.changestage();
               for(int i = 0;i<bb1.size();i++){
                    bb1.remove(i);
                }
               BossHP = 10000;
               BossLT = 60;
               if(BossStage>=1){
                   BossStage -= 1;
               }else{
                   BossStage = 1;
                   BossSpells -= 1;
                   if(BossSpells <= 0){
                       clearReQ = true;
                   }
               }
                BossHP = 10000;
                BossLT = 60;
                BossStageTrick = false;
            }
            if(BossHP<=0){
                BossStageTrick = true;
            }
            //bomb clear
            if(bombtrick==true){
                for(int i = 0;i<bb1.size();i++){
                    bb1.remove(i);
                }
                for(int i = 0;i<redb.size();i++){
                    redb.remove(i);
                }
            }
            
            
            
            // Game on
            if(LP >= 0 || (BossStage >=0 && BossSpells >=0)){
                g.drawImage(bar.getImage(), 20, 16,(int)((double)760.0*((double)BossHP/10000.0)),16, this);
                if(stageparalyzel){
                    g.drawImage(p.getImage(timestamp), p.x-11, p.y-23,32,48, this);
                    g.drawImage(bo1.getimage(timestamp), bo1.x-12, bo1.y+16,24,32, this);
                    
                }else{
                    
                    if(left){
                        g.drawImage(p.moveleft(timestamp), p.x-11, p.y-23,32,48, this);
                    }else if(right){
                        g.drawImage(p.moveright(timestamp), p.x-11, p.y-23,32,48, this);
                    }else{
                        g.drawImage(p.getImage(timestamp), p.x-11, p.y-23,32,48, this);
                    }
                    if(focus){
                        g.setColor(Color.RED);
                        g.fillRect(p.x, p.y, 9, 9);
                    }
                    g.drawImage(bo1.getimage(timestamp), bo1.x-12, bo1.y-16,24,32, this);
                }
                // playzone
   		if(p.x<0){
                    p.x=this.getWidth()-10;
   		}
   		if(p.x>this.getWidth()){
                    p.x=20;
   		}
                if(p.y<0){
                    p.y=20;
   		}
                if(p.y>this.getHeight()){
                    p.y=this.getHeight()-10;
   		}
                //shoot 
   		for(int i=0;i<bul.size();i++){
                    RBullet ba = bul.get(i);
      		    g.drawImage(ba.sprites[0], ba.x, ba.y,10,16, null);
      		    ba.move();
      		    ba.count++;
      		    if(ba.y<0){
      		    	bul.remove(i);
      		    }
   		}
 		// ice
		for(int i=0 ; i<bb1.size();i++){
                    Ices bossb = bb1.get(i);
                    g.drawImage( bossb.getImage() ,bossb.getX(),bossb.getY(),8,16,this);
                    bossb.move();
                    bossb.count++;
      		    if(bossb.y<0){
      		    	bossb.remove(i);
      		    }
                    
		}
                // baditem
                for(int i=0 ; i<badthing.size();i++){
                    Baditem bit = badthing.get(i);
                    g.drawImage( bit.getImage() ,bit.getX(),bit.getY(),12,12,this);
                    bit.move();
                    bit.count++;
      		    if(bit.y<0){
      		    	bit.remove(i);
      		    }
                    
		}
                for(int i=0 ; i<badthing.size();i++){
                    if(circleIntersect(badthing.get(i).getthis() ,p.updateloca())){
                        sound.getup();
                        debuff = true;
                        for(int j=0 ; j<badthing.size();j++){
                            badthing.remove(j);
                        }
                        

                    }
                }
                // redice
                    for(int i=0 ; i<redb.size();i++){
                    redice redbullet = redb.get(i);
                    g.drawImage( redbullet.getImage() ,redbullet.getX(),redbullet.getY(),8,16,this);
                    redbullet.move();
                    redbullet.count++;
      		    if(redbullet.y<0){
      		    	redbullet.remove(i);
      		    }
		}
                //power up
                for(int i=0 ; i<powerupp.size();i++){
                    power ppup = powerupp.get(i);
                    g.drawImage( ppup.getImage() ,ppup.getX(),ppup.getY(),16,16,null);
                    ppup.move();
                    ppup.count++;
      		    if(ppup.y<0){
      		    	ppup.remove(i);
      		    }
		}
                
                for(int i=0 ; i<powerupp.size();i++){
                    if(circleIntersect(powerupp.get(i).getthis() ,p.updateloca())){
                        sound.getup();
                        for(int j=0 ; j<powerupp.size();j++){
                            powerupp.remove(j);
                        }
                        power +=2;

                    }
                }
                //dead check
                
                for(int i=0 ; i<bb1.size();i++){
                    //dead check
                    if(circleIntersect(bb1.get(i).getthis() ,p.updateloca())){
                        PlayerDeadTrick = true;
                        sound.pdead();
                        for(int j=0 ; j<bb1.size();j++){
                            bb1.remove(j);
                        }
                    }
                }
                for(int i=0 ; i<redb.size();i++){
                    //dead check
                    if(circleIntersect(redb.get(i).getthis() ,p.updateloca())){
                        PlayerDeadTrick = true;
                        sound.pdead();
                        for(int j=0 ; j<redb.size();j++){
                            redb.remove(j);
                        }
                        for(int j=0 ; j<bb1.size();j++){
                            bb1.remove(j);
                        }
                    }
                }
                
                // bullet hit boss
                for(int i=0 ; i<bul.size();i++){
                    if(DamageIntersect(bul.get(i).getbound() , bo1.getbound())){
                        bul.remove(i);
                        if(BossHP>=2000){
                            sound.hit1();
                        }else{
                            sound.hit2();
                        }
                        if(debuff==true){
                            BossHP += RDamage+20;
                        sco -= RDamage;
                        }else{
                            BossHP -= RDamage;
                        sco += RDamage;
                        }
                        
                        if(BossHP <= 0){
                            BossStageTrick = true;
                        }
                    } 
                }

		      
		g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,20));
		g.setColor(Color.WHITE);
		g.drawString("SCORE =  "+sco,700, 100);	   
                g.drawString("Life =  "+LP,700, 120);	
                g.drawString("Bomb =  "+bomb,700, 140);
                g.drawString("P =  "+power,700, 160);
                g.drawString("Graze =  "+graze,700, 180);
		g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,20));
		g.drawString("Spell "+BossSpells,10,80);    
		g.drawString("Time "+BossLT,10,100);
		      
            }else{
                g.drawImage(level_background1.getImage(),0,0,960,720,this);
                

		      
		
		g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,30));
		g.setColor(Color.BLACK);
		g.drawString("SCORE =  "+sco,80, 100);	     
		g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,50));
		g.drawString("Spell "+BossSpells,350,80);
		g.drawString("Time "+BossLT,335,150);
		g.setColor(Color.RED);
		g.drawString("HP  "+LP,100,200);
		      
	    }
            //kill boss
            if(BossSpells <=-1){
                paralyze1 = true;
                stageparalyzel = true;
		this.remove(BPause);
		this.remove(Bresum);
                this.setLayout(null);
                g.drawImage(level_background3.getImage(),0,0,960,720,this);
                g.setColor(Color.RED);
                g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,40));		
		g.drawString("SCORE   "+sco,380,400);	     
		g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,70));
		g.drawString("GAME OVER",290,150);
            }
            //Dead check
            if(LP<=0){
                paralyze1 = true;
                stageparalyzel = true;
                this.remove(BPause);
                this.remove(Bresum);
                this.setLayout(null);
                g.drawImage(level_background2.getImage(),0,0,960,720,this);
                // score
                

                g.setColor(Color.BLACK);
                g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,40));		
		g.drawString("SCORE   "+sco,560,350);	     
		g.setFont(new Font("Hobo Std",Font.HANGING_BASELINE,70));
		g.drawString("GAME OVER",240,150);
				    
            }
            

	}
        public boolean circleIntersect(Baditem a , Reimu b) {
            int distSq = (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
            int radSumSq = (a.r + b.r) * (a.r + b.r);
            if (distSq == radSumSq){
                return false;
            }else if (distSq > radSumSq){

                return false; 
            }else{
                return true;
            }
        }
        public boolean circleIntersect(power a , Reimu b) {
            int distSq = (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
            int radSumSq = (a.r + b.r) * (a.r + b.r);
            if (distSq == radSumSq){
                return false;
            }else if (distSq > radSumSq){

                return false; 
            }else{
                return true;
            }
        }
        public boolean circleIntersect(Ices a , Reimu b) {
            int distSq = (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
            int radSumSq = (a.r + b.r) * (a.r + b.r);
            int nearmiss = radSumSq + 60;
            if (distSq == radSumSq){
                this.graze += 1;
                sound.gaz();
                return false;
            }else if (distSq > radSumSq){

                if(distSq < nearmiss){
                    this.graze += 1;
                    sound.gaz();
                }
                return false; 
            }else{
                return true;
            }
        }
        public boolean circleIntersect(redice a , Reimu b) {
            int distSq = (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
            int radSumSq = (a.r + b.r) * (a.r + b.r);
            int nearmiss = radSumSq + 60;
            if (distSq == radSumSq){
                this.graze += 1;
                sound.gaz();
                return false;
            }else if (distSq > radSumSq){

                if(distSq < nearmiss){
                    this.graze += 1;
                    sound.gaz();
                }
                return false; 
            }else{
                return true;
            }
        }
        public boolean DamageIntersect(Rectangle2D a, Rectangle2D b){
		return (a.intersects(b));
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== BPause){
            paralyze1 = true;

        }
        if(e.getSource()== Bresum){
            paralyze1 = false;

        }
    }
    
}
