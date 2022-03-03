import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class MyKeyAdaptor extends KeyAdapter{

    BFSpanel bfspanel;

    

    public MyKeyAdaptor(BFSpanel bfSpanel){
        this.bfspanel = bfSpanel;
    }
    
    public void keyPressed(KeyEvent e){
        if (e.getKeyChar() == ' ') {
            if(bfspanel.isRunning){
                bfspanel.stopGame();
            }else{
                bfspanel.startGame();
            }
        }

        if (e.getKeyChar() == 'r') {
            bfspanel.visited = new ArrayList<>();
            bfspanel.queue = new ArrayList<>();
            bfspanel.createGrid();
            bfspanel.createObstacles();
            bfspanel.addNeighbours();
            
            bfspanel.repaint();
        }

        if (e.getKeyChar() == 'c'){
            bfspanel.visited = new ArrayList<>();
            bfspanel.queue = new ArrayList<>();
            for(int i = 0; i < BFSpanel.rows; i++){
                for(int j = 0; j < BFSpanel.cols; j++){
                    bfspanel.grid[i][j].isObstacles = false;
                }
            }
            bfspanel.repaint();
        }

        if (e.getKeyChar() == 'q'){
            System.exit(0);
        }

        if (e.getKeyChar() == 'h'){
            JOptionPane.showMessageDialog(null, "SPACE BAR - pause and play\n" +
                                                "C - clear the screen\n" +
                                                "R - to reset grid\n" +
                                                "Q - quit the application\n" + 
                                                "alt + right_click - draw obstacle\n" +
                                                "shift + right_click - add starting point" , "Help", 1);
        }
    }
}
