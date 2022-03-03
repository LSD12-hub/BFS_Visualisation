import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MyMouseAdaptor implements MouseListener, MouseMotionListener, MouseWheelListener{

    BFSpanel bfspanel;
    int w = BFSpanel.WIDTH / BFSpanel.cols, h = BFSpanel.HEIGHT / BFSpanel.rows;

    public MyMouseAdaptor(BFSpanel bfspanel){
        this.bfspanel = bfspanel;
    }
    
    @Override
	public void mouseClicked(MouseEvent e) {
        if(e.isControlDown()){
            int x = e.getX() / w;
            int y = e.getY() / h;
            bfspanel.setStartingNode(x, y);
        }

        if(e.isAltDown()){
            int x = e.getX() / w;
            int y = e.getY() / h;
            bfspanel.grid[x][y].isObstacles = true;
        }

        bfspanel.repaint();
    }

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mouseDragged(MouseEvent e) {
        if(e.isControlDown()){
            int x = e.getX() / w;
            int y = e.getY() / h;
            bfspanel.setStartingNode(x, y);
        }

        if(e.isAltDown()){
            int x = e.getX() / w;
            int y = e.getY() / h;
            bfspanel.grid[x][y].isObstacles = true;
        }

        bfspanel.repaint();
    }

	@Override
	public void mouseMoved(MouseEvent e) {
    }

    @Override
	public void mouseWheelMoved(MouseWheelEvent m) {}
}
