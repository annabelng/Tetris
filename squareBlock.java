import java.awt.Color;
import java.awt.Graphics;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class squareBlock {
	private int x;
	private int y;
	private int vy, vx;
	private int w, h;
	private JLabel img;

	public squareBlock(String filename) {
		String src = new File("").getAbsolutePath() + "/src/";
		ImageIcon squareIcon = new ImageIcon(src + filename);
		// connect the file to the img
		img = new JLabel(squareIcon);
		w = 100;
		h = 100;
		x = 0;
		y = 0;
		vy = 3;
		img.setBounds(x, y, w, h);
	}

	public int getX() {
		return x; // getter for objects x field
	}

	public void setX(int newX) {
		x = newX; // update object
		// object object's image
		img.setBounds(x, y, w, h);
	}

	public int getY() {
		return y; // getter for objects x field
	}

	public void setY(int newY) {
		y = newY; // update object
		// object object's image
		img.setBounds(x, y, w, h);
	}

	public int getW() {
		return w;
	}

	public int getH() {
		return h;
	}

	public void move(){
		y += vy;
		img.setBounds(x,y,w,h);
		if(y > 870)
			y = 870;
	}
	public JLabel getImg() {
		return img; // getter for object's img
	}
}