package Warrior;

import java.awt.*;
import javax.swing.*;


public class Board extends JPanel{
    
    int score;
    
    Image titleScreen = Toolkit.getDefaultToolkit().getImage(".\\src\\pic\\Home.gif");
    Image Gameover = Toolkit.getDefaultToolkit().getImage(".\\src\\pic\\Over.gif");
    Image Win = Toolkit.getDefaultToolkit().getImage(".\\src\\pic\\Win.gif");
    
    Image red_ghost_right = Toolkit.getDefaultToolkit().getImage(".\\src\\pic\\ghost_red_Right.png");
    Image red_ghost_left = Toolkit.getDefaultToolkit().getImage(".\\src\\pic\\ghost_red_Left.png");
    Image[] G_red = {red_ghost_left,red_ghost_right}; // สลับรูปไปมา
    
    Image yellow_ghost_right = Toolkit.getDefaultToolkit().getImage(".\\src\\pic\\ghost_yellow_Right.png");
    Image yellow_ghost_left = Toolkit.getDefaultToolkit().getImage(".\\src\\pic\\ghost_yellow_Left.png");
    Image[] G_yellow = {yellow_ghost_left,yellow_ghost_right};
    
    Image blue_ghost_right = Toolkit.getDefaultToolkit().getImage(".\\src\\pic\\ghost_blue_Right.png");
    Image blue_ghost_left = Toolkit.getDefaultToolkit().getImage(".\\src\\pic\\ghost_blue_Left.png");
    Image[] G_blue = {blue_ghost_left,blue_ghost_right};
    
    Image pink_ghost_right = Toolkit.getDefaultToolkit().getImage(".\\src\\pic\\ghost_pink_Right.png");
    Image pink_ghost_left = Toolkit.getDefaultToolkit().getImage(".\\src\\pic\\ghost_pink_Left.png");
    Image[] G_pink = {pink_ghost_left,pink_ghost_right};
    
    //warrior
    Image Warrior = Toolkit.getDefaultToolkit().getImage(".\\src\\pic\\warrior.png");
    Image warrior_left = Toolkit.getDefaultToolkit().getImage(".\\src\\pic\\warrior1.png");
    Image warrior_right = Toolkit.getDefaultToolkit().getImage(".\\src\\pic\\warrior.png");
    Image warrior_up = Toolkit.getDefaultToolkit().getImage(".\\src\\pic\\warrior1.png");
    Image warrior_down = Toolkit.getDefaultToolkit().getImage(".\\src\\pic\\warrior1.png");
    Image[] warrior_images  = {warrior_left,warrior_right,warrior_up,warrior_down};
   
    Warrior warrior = new  Warrior(10*Component.cellSize,15*Component.cellSize);
    
    //Ghosts
    Ghost ghost1 = new Ghost(10*Component.cellSize,8*Component.cellSize);
    Ghost ghost2 = new Ghost(10*Component.cellSize,9*Component.cellSize);
    Ghost ghost3 = new Ghost(11*Component.cellSize,9*Component.cellSize);
    Ghost ghost4 = new Ghost(9*Component.cellSize,9*Component.cellSize);
            
    boolean title ;
    boolean balls[][];
    boolean states[][];
    int lives = 2;
        
    public Board() {
        title = true;
        balls = new boolean[Component.cellSize][Component.cellSize];
        states = new boolean[Component.cellSize][Component.cellSize];
        unit();
    }
    public void unit(){
        for (int i = 0; i < Component.cellSize; i++) {
            for (int j = 0; j < Component.cellSize; j++) {
                balls[i][j]=true;
                states[i][j]=true;
            }
        }
    }
    
    //กำหนดให้โชว์เลือดเป็นรูป warrior
    public void drawLives(Graphics g){
        
        g.setColor(Color.red);
            for (int i = 0; i < lives; i++) {
                g.drawImage(warrior_left,(Component.cellSize+5) * i+15, Component.max+10, Component.cellSize, Component.cellSize,null);
            }
    }
    // สร้างลูกบอลถ้าเจอตำแหน่งที่บล็อคสีฟ้าอยู่จะลบทิ้ง
    public void update(Graphics g, int x , int y, int width, int height){
        g.fillRect(x, y, width, height);
        
        for (int i = x/20; i < x/20 + width/20; i++) {
            for (int j = y/20; j < y/20 + height/20; j++) {
                balls[i][j] = false;
                states[i-1][j-1] = false;
            }
        }
    }
    //สร้างลูกบอลและกำหนดที่ที่ลูกบอลอยู่
    public void drawBalls(Graphics g){
        g.setColor(Color.gray);
        for (int i = 1; i < Component.cellSize; i++) {
            for (int j = 1; j < Component.cellSize; j++) {
                if(balls[i][j]){
                    g.fillOval(i*20+8, j*20+8, 4, 4);
                }
            }
        }
        
    }
    
    public void reset(){
        if(lives > 0){
            lives--;
            ghost1.x=10*Component.cellSize;
            ghost1.y=8*Component.cellSize;
            
            ghost2.x=10*Component.cellSize;
            ghost2.y=9*Component.cellSize;
            
            ghost3.x=11*Component.cellSize;
            ghost3.y=9*Component.cellSize;
            
            ghost4.x=9*Component.cellSize;
            ghost4.y=9*Component.cellSize;
               
            warrior.x =10*Component.cellSize;
            warrior.y = 15*Component.cellSize;
            
            Game.flag = true;
        }
        
    }
    
    //วาดรูปตารางที่ให้ตัว warrior เดิน
    public void drawBoard(Graphics g){
        
        
        
        //สร้างบล็อคสีฟ้า
        g.setColor(Color.darkGray);
       
        update(g,210,40,60,20);
        update(g,300,40,60,20);
        update(g,40,80,60,20);
        update(g,140,80,100,20);
        update(g,200,80,20,60);
        update(g,320,80,60,20);
        update(g,40,40,60,20);
        update(g,120,40,60,20);
        update(g,150,20,20,40);
        update(g,20,120,80,60);
        update(g,320,120,80,60);
        update(g,20,200,80,60);
        update(g,310,200,80,60);
        update(g,150,160,40,20);
        update(g,220,160,40,20);
        //update(g,160,180,20,20);
        update(g,160,200,100,20);
        update(g,240,180,20,20);
        update(g,120,120,60,20);
        update(g,120,80,20,100);
        update(g,280,80,20,100);
        update(g,240,120,60,20);
        update(g,280,200,20,60);
        update(g,120,200,20,60);
        update(g,160,240,100,20);
        update(g,200,260,20,40);
        update(g,110,280,60,20);
        update(g,230,280,60,20);
        update(g,40,280,60,20);
        update(g,80,280,20,60);
        update(g,320,280,60,20);
        update(g,320,280,20,60);
        update(g,360,320,40,20);
        update(g,20,320,40,20); 
        update(g,160,320,100,20);
        update(g,200,320,20,60);
        update(g,40,360,140,20);
        update(g,240,360,140,20);
        update(g,280,320,20,60);
        update(g,120,320,20,60);
        
        repaint();
        
        
    }
    
    @Override
    public void paint(Graphics g){  
        g.setColor(Color.black);
        g.fillRect(0,0,420,500);
        
        drawBoard(g);
        drawBalls(g);
        drawLives(g);
        
        Font f=new Font("Arial",Font.BOLD,20);
        g.setFont(f);
        g.drawString("Coin: "+score, Component.max/2+50,Component.max+30);
        //สร้างผีไปไว้ำตำแหน่งที่กำหนด
        g.drawImage(G_red[ghost1.index], ghost1.x,ghost1.y, null); 
        g.drawImage(G_yellow[ghost2.index], ghost2.x,ghost2.y, null);
        g.drawImage(G_pink[ghost3.index], ghost3.x,ghost3.y, null);
        g.drawImage(G_blue[ghost4.index], ghost4.x,ghost4.y, null);
        
        g.drawImage(warrior_images[warrior.index], warrior.x,warrior.y,null);
             
        if(title){
            g.drawImage(titleScreen, 0, 0, null);
        }
        if(lives ==0){
            g.drawImage(Gameover, 0, 0, null);
        }
        if(check()){
            g.drawImage(Win, 0, 0, null);
        }
    }
    public boolean check(){
        for (int i = 1; i < Component.cellSize; i++) {
            for (int j = 1; j < Component.cellSize; j++) {
                if(balls[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
    

