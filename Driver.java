import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
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
	rectangle[] Rectangle = new rectangle[5];
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
			square[i].setY(-100);
			square[i].move();
			/*if (square[i].getIsMoving() == false) {
				TBlock[i].move();
			}
			if (TBlock[i].getIsMoving() == false) {
				SBlock[i].move();
			}
			if (SBlock[i].getIsMoving() == false) {
				LBlock[i].move();
			}
			if (LBlock[i].getIsMoving() == false) {
				Rectangle[i].move();
			}*/
		}
	}

	public void update() {
		
		moveCycle();
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

		for (int i = 0; i < square.length; i++) {
			square[i] = new squareBlock("square.png");
			f.add(square[i].getImg());
		}
		for (int i = 0; i < Rectangle.length; i++) {
			Rectangle[i] = new rectangle("LongRectangle.png");
			f.add(Rectangle[i].getImg());
		}
		for (int i = 0; i < TBlock.length; i++) {
			TBlock[i] = new tBlock("TBlock.png");
			f.add(TBlock[i].getImg());
		}
		for (int i = 0; i < SBlock.length; i++) {
			SBlock[i] = new sBlock("SBlock.png");
			f.add(SBlock[i].getImg());
		}
		for (int i = 0; i < LBlock.length; i++) {
			LBlock[i] = new lBlock("LBlock.png");
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