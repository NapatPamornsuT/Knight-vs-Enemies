package Warrior;

import java.awt.*;
import javax.swing.*;

public class Component {
    
    protected int index = 0;
    protected boolean states[][];
    protected static int cellSize = 20; // ขนาดบอล
    protected static int max = 400;  // Height || Width = 20x20
    protected static int speed = 4;
    
    protected char direction;
    int x,y;


    public Component() {
        
        this.states = new boolean[20][20];
        
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                this.states[i][j] = false;
            }
        }
        
    }
    public void updateState(boolean[][] UpdateStates){
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                this.states[i][j] = UpdateStates[i][j];
            }
        }

    }
    
    public boolean isValid(int x,int y){
        
        if(x >= cellSize && x < max && y >= cellSize && y < max && states[x/20-1][y/20-1]){
            return true;
        }
        else{
            return false;
        }
    }
    public Rectangle getShape(){
        return new Rectangle(x, y, 20, 20);
        
    }
    
}
