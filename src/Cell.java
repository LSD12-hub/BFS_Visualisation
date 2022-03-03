import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Cell {
        
    private int pos_x, pos_y;
    
    int score = 0;

    int w = BFSpanel.WIDTH / BFSpanel.cols, h = BFSpanel.HEIGHT / BFSpanel.rows;

    ArrayList<Cell> neighbours = new ArrayList<>();

    boolean isObstacles = false;

    Cell(int pos_x, int pos_y){
        this.pos_x = pos_x;
        this.pos_y = pos_y;
    }


    public void draw_cell(Graphics g, Color c){
        if(!isObstacles){
            g.setColor(c);
            g.fillRect(pos_x * w, pos_y * h, w, h);
            g.setColor(Color.black);
            g.drawRect(pos_x * w, pos_y * h, w, h);
        }else{
            g.setColor(Color.black);
            g.fillRect(pos_x * w, pos_y * h, w, h);
        }
    }
    
}
