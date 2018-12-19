import java.awt.Color;
import java.awt.Graphics;

public class gridCell {
	private int x, y;
	private int size;
	private Color c;


	public gridCell() {
		x = 0;
		y = 0;
		size = 0;
		c = Color.BLACK;
	}

	// set function that sets everything
	public void set(int newX, int newY, int newSize, Color newC) {
		x = newX;
		y = newY;
		size = newSize;
		c = newC;

	}

	public void setX(int NEWX) {
		x = NEWX;
	}

	public void setC(Color NEWC) {
		c = NEWC;
	}

	public int getX() {
		return x;
	}

	public Color getC() {
		return c;
	}
	
	public int getY() {
		return y;
	}

	public int getSize() {
		return size;
	}

	

	/*public void paintBlock(Graphics g) {
		g.setColor(Color.BLUE);
		for(int r = 0; r<2; r++) {
			for(int c = 23; c<25;c++) {
				r=r;
				int column=c;
				x = column*10;
				y = r*10;
				g.setColor(Color.blue);
				g.fillRect(x, y, size, size);
			}
		}
	}*/

	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(c);
		g.fillRect(x, y, size, size);
	}
}