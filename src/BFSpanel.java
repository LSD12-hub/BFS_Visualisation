import javax.swing.Timer;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;

import java.util.ArrayList;
import java.util.Random;

public class BFSpanel extends JPanel implements ActionListener{
    
    static final int WIDTH = 500, HEIGHT = 500;
    final int DELAY = 100;

    static final int rows = 20, cols = 20;

    boolean isRunning = false;

    Timer timer;

    ArrayList<Cell> queue = new ArrayList<>(); 
    ArrayList<Cell> visited = new ArrayList<>();

    Cell [][] grid = new Cell[cols][rows];

    Random random;

    public BFSpanel(){
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.MAGENTA);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdaptor(this));

        MyMouseAdaptor m = new MyMouseAdaptor(this);
        this.addMouseListener(m);
        this.addMouseMotionListener(m);
        this.addMouseWheelListener(m);
        
        random = new Random();
        
        createGrid();
        createObstacles();
        addNeighbours();
    }

    public void stopGame(){
        isRunning = false;
        timer.stop();
    }

    public void createObstacles(){
        for(int i = 0; i < cols; i++){
            for(int j = 0; j < rows; j++){
                if(random.nextInt(10) == 1 || random.nextInt(10) == 2 || random.nextInt(10) == 3 || random.nextInt(10) == 4 || random.nextInt(10) == 5)
                    grid[i][j].isObstacles = true;
            }
        }
    }

    public void addNeighbours(){
        for(int i = 0; i < cols; i++){
            for(int j = 0; j < rows; j++){
                
                if(i > 0)
                    grid[i][j].neighbours.add(grid[i - 1][j]);
                if(j < grid.length - 1)
                    grid[i][j].neighbours.add(grid[i][j + 1]);
                if(i < grid.length - 1)
                    grid[i][j].neighbours.add(grid[i + 1][j]);
                if(j > 0)
                    grid[i][j].neighbours.add(grid[i][j - 1]);
                    
            }
        }
    }

    public void setStartingNode(int i, int j){
        visited.add(grid[i][j]);
        queue.add(grid[i][j]);
        grid[i][j].isObstacles = false;
    }

    public void createGrid(){
        for(int i = 0; i < cols; i++){
            for(int j = 0; j < rows; j++){
                grid[i][j] = new Cell(i, j);
            }
        }
    }

    public void startGame(){
        isRunning = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        for(int i = 0; i < cols; i++){
            for(int j = 0; j < rows; j++){
                grid[i][j].draw_cell(g, Color.RED);
            }
        }

        for(Cell c : visited){
            c.draw_cell(g, Color.BLUE);
        }

        for(Cell c : queue){
            c.draw_cell(g, Color.GREEN);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(queue.size() > 0){

            Cell currenyCell = queue.get(0);
            queue.remove(0);

            for(Cell c : currenyCell.neighbours){
                if(!visited.contains(c) && !c.isObstacles){
                    visited.add(c);
                    queue.add(c);
                }
            }
        }
        repaint();
    }
}
