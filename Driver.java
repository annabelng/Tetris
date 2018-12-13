import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

// Class driver 
public class Driver extends JPanel implements KeyListener, ActionListener {

	int screen_width = 500;
	int screen_height = 1000;
	squareBlock[] square = new squareBlock[5];
	rectangle[] Rectangle2 = new rectangle[5];
	tBlock[] TBlock = new tBlock[5];
	sBlock[] SBlock = new sBlock[5];
	lBlock[] LBlock = new lBlock[5];

	JLabel squareBlock;

	public void paint(Graphics g) {
		super.paintComponent(g);

		// square.paint(g);
	}

	public void moveCycle() {
		for (int i = 0; i < square.length; i++) {
			square[i].move();
			if (square[i].getIsMoving() == false) {
				TBlock[i].move();
			}
			if (TBlock[i].getIsMoving() == false) {
				SBlock[i].move();
			}
			if (SBlock[i].getIsMoving() == false) {
				LBlock[i].move();
			}
			if (LBlock[i].getIsMoving() == false) {
				Rectangle2[i].move();
			}
		}
	}

	public void update() {
		
		moveCycle();
		
		for(int i = 0; i < square.length; i++){
		Rectangle character = new Rectangle(square[i].getX(), square[i].getY(), 100, 100);
		//square.move();
		Rectangle obj = new Rectangle(Rectangle2[i].getX(), Rectangle2[i].getY(), 200, 50);
		if (obj.intersects(character)) {
			Rectangle2[i].setVy(0);
			Rectangle2[i].setX(square[i].getX());
			Rectangle2[i].setY(square[i].getY()-40);
		}
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();
		repaint();
	}

	public static void main(String[] arg) {
		Driver d = new Driver();
	}

	public Driver() {
		JFrame f = new JFrame();
		f.setTitle("TETRIS");
		f.setSize(screen_width, screen_height);
		f.getContentPane().setBackground(new Color(0, 0, 0));

		String src = new File("").getAbsolutePath() + "/src/"; // path to image
																// setup

		f.setResizable(false);
		f.setLayout(null);
		f.addKeyListener(this);
		f.add(this);

		for (int i = 0, y = -100; i < square.length; i++, y-=5000) {
			square[i] = new squareBlock("square.png");
			square[i].setY(y);
			f.add(square[i].getImg());
		}
		for (int i = 0,  y = -100; i < Rectangle2.length; i++, y -= 500) {
			Rectangle2[i] = new rectangle("LongRectangle2.png");
			Rectangle2[i].setY(y);
			f.add(Rectangle2[i].getImg());
		}
		for (int i = 0, y = -100; i < TBlock.length; i++, y -= 500) {
			TBlock[i] = new tBlock("TBlock.png");
			TBlock[i].setY(y);
			f.add(TBlock[i].getImg());
		}
		for (int i = 0, y = -100; i < SBlock.length; i++, y -= 500) {
			SBlock[i] = new sBlock("SBlock.png");
			SBlock[i].setY(y);
			f.add(SBlock[i].getImg());
		}
		for (int i = 0, y = -100; i < LBlock.length; i++, y -= 500) {
			LBlock[i] = new lBlock("LBlock.png");
			LBlock[i].setY(y);
			f.add(LBlock[i].getImg());
		}

		// end creating objects
		t = new Timer(17, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	Timer t;

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}