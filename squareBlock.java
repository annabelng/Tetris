import java.awt.Color;
import java.awt.Graphics;

public class squareBlock {
	private int x;
	private int y;
	private int vy;
	private int width, height;
	private Color c;

	public squareBlock() {
		x = 0;
		y = 0;
		height = 50;
		width = 50;
		c = Color.blue;

	}
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(c);
		g.fillRect(x, y, width, height);
		
	}
}