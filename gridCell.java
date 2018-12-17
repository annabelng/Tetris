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

	public int getY() {
		return y;
	}

	public int getSize() {
		return size;
	}

	public Color getC() {
		return c;
	}

	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(c);
		g.fillRect(x, y, size, size);
	}

}
