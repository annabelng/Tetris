import java.awt.Color;
import java.awt.Graphics;

public class gridCell {
	private int x, y;
	private int size;
	private Color c;

	public gridCell() {
		//initializing everything
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
	//painting the grid cells
	public void paint(Graphics g) {
		
		//getting the color and setting it
		g.setColor(c);
		g.fillRect(x, y, size, size);
		
	}

	//mainly setters and getters
	public void setX(int NEWX) {
		x = NEWX;
	}

	//very important function that helps to draw the blocks
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

}