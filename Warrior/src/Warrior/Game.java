package Warrior;

import java.awt.*;
import java.awt.event.*;
import java.util.logging.*;
import javax.swing.*;

public class Game implements KeyListener{

    Board board = new Board();
    Timer timer;
    char direction = 'L';
    static boolean flag = true;
    
    public Game() {
        
        JFrame frame = new JFrame();
        frame.setSize(440,500); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.add(board,BorderLayout.CENTER);
        frame.setTitle("Warrior");
        frame.setVisible(true);
        frame.addKeyListener(this);
        
        timer = new Timer(40,new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!board.title && board.lives > 0){
                    
                    if(flag){
                        try {
                            Thread.sleep(2000);
                            flag=false;
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                board.ghost1.move();
                if(board.ghost1.getShape().intersects(board.warrior.getShape())){
                    board.reset();
                    
                }
                board.ghost2.move();
                if(board.ghost2.getShape().intersects(board.warrior.getShape())){
                    board.reset(); 
                }
                board.ghost3.move();
                if(board.ghost3.getShape().intersects(board.warrior.getShape())){
                    board.reset();
                }
                board.ghost4.move();
                if(board.ghost4.getShape().intersects(board.warrior.getShape())){
                    board.reset();
                }
                
                board.ghost1.updateState(board.states);
                board.ghost2.updateState(board.states);
                board.ghost3.updateState(board.states);
                board.ghost4.updateState(board.states);
                
                board.warrior.move(direction);
                //บอกว่ากินจุดแล้วได้แต้ม
                if(board.balls[board.warrior.x/20][board.warrior.y/20]){
                    board.score++;
                }
                //แพ็คแมนโดนบอลแล้วจุดหาย
                board.balls[board.warrior.x/20][board.warrior.y/20]=false;
                board.warrior.updateState(board.states); // ทำให้กดได้
                }
            }
        });
        timer.start();
    }

    
    public static void main(String[] args) {
        Game g = new Game();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                direction = 'L';
                break;
            case KeyEvent.VK_D:
                direction = 'R';
                break;
            case KeyEvent.VK_S:
                direction = 'D';
                break;
            case KeyEvent.VK_W:
                direction = 'U';
                break;
            case KeyEvent.VK_LEFT:
                direction = 'L';
                break;
            case KeyEvent.VK_RIGHT:
                direction = 'R';
                break;
            case KeyEvent.VK_DOWN:
                direction = 'D';
                break;
            case KeyEvent.VK_UP:
                direction = 'U';
                break;
                case KeyEvent.VK_ENTER:
                board.title = false;
                break;
            
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
