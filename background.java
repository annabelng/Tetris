import java.awt.Color;
import java.awt.Graphics;

public class background {
	private int x, y;
	private int width, height;
	private Color c;
	
	public background() {
		int x = 0; 
		int y = 0;
		c = Color.BLACK;
		height = 1000;
		width = 600;
	}
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(c);
		g.fillRect(x, y, width, height);
		
	}
}
