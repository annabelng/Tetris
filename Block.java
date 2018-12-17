import java.awt.Color;
import java.awt.Graphics;

public class Block {
	private int x, y;
	private int r;
	private int column;
	private Color c;
	private int length, width;
	private Color color;
	int vy = 10;
	private int[] type;
	private int size;
	private int n = 0;

	public Block(int n) {

//		type = new int[5];
//		size = 10;
//		for (int i = 0; i < type.length; i++) {
//			type[i] = i;
//		}
//		n = (int) (Math.random() * (4));

		// square block
		//if (type[n] == 0) {
			r = 0;
			column = 25;
			y = r * 10;
			x = column * 10;
			color = Color.CYAN;
			length = 20;
			size = 10;

	//	}
	}

	public int getR() {
		return r;
	}
	public Color getC() {
		return c;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getColumn() {
		return column;
	}

	public void move(){
		y+=vy;
	}

	public void paint(Graphics g) {
		// TODO Auto-generated method stub
	//	System.out.println(12);
		g.setColor(Color.blue);
		g.fillRect(x, y, size, size);
//		g.fillRect(x + 10, y, size, size);
//		g.fillRect(x, y + 10, size, size);
//		g.fillRect(x + 10, y + 10, size, size);
	}

	public void set(int newX, int newY, int newSize, Color newC) {
		x = newX;
		y = newY;
		size = newSize;
		c = newC;

	}
	// g.setColor(color);
	// g.fillRect(x, y, size, size);

	public void setC(Color newC) {
		// TODO Auto-generated method stub
		c = newC;
	}
}
