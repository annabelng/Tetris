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
	squareBlock square = new squareBlock("square.png");
	rectangle Rectangle2 = new rectangle("LongRectangle.png");
	tBlock TBlock = new tBlock("tBlock.png");
	sBlock SBlock = new sBlock("sBlock.png");
	lBlock LBlock = new lBlock("LBlock.png");

	JLabel squareBlock;

	public void paint(Graphics g) {
		super.paintComponent(g);

		// square.paint(g);
	}

	public void moveCycle(){
		square.move();
		if (square.getIsMoving() == false) {
			Rectangle2.move();
		}
		if (Rectangle2.getIsMoving() == false) {
			SBlock.move();
		}
		if (SBlock.getIsMoving() == false) {
			LBlock.move();
		}
		if (LBlock.getIsMoving() == false) {
			TBlock.move();
		}
	}
	public void update() {
		moveCycle();
		
		
		
	
		
		
		
		
		
			Rectangle character = new Rectangle(square.getX(), square.getY(), 100, 100);
			//square.move();
			Rectangle obj = new Rectangle(Rectangle2.getX(), Rectangle2.getY(), 200, 50);
			if (obj.intersects(character)) {
				Rectangle2.setVy(0);
				Rectangle2.setX(square.getX());
				Rectangle2.setY(square.getY()-40);
				
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

		f.add(square.getImg());
		f.add(Rectangle2.getImg());
		f.add(TBlock.getImg());
		f.add(SBlock.getImg());
		f.add(LBlock.getImg());

		f.setResizable(false);
		f.setLayout(null);
		f.addKeyListener(this);
		f.add(this);

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