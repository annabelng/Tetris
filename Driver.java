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
		g.setColor(new Color(255, 255, 255));
		g.drawRect(20, 20, 30, 40);
		
		// square.paint(g);
	}

	public void collision() {
		Rectangle square3 = new Rectangle(square.getX(), square.getY(), 100,
				100);
		Rectangle rectangle = new Rectangle(Rectangle2.getX(),
				Rectangle2.getY(), 200, 50);
		Rectangle tBlock2 = new Rectangle(TBlock.getX(), TBlock.getY(), 150,
				100);
		Rectangle sBlock2 = new Rectangle(SBlock.getX(), SBlock.getY(), 150,
				100);
		Rectangle lBLock2 = new Rectangle(LBlock.getX(), LBlock.getY(), 150,
				100);

		if (rectangle.intersects(square3)) {
			Rectangle2.setVy(0);
			Rectangle2.setX(Rectangle2.getX());
			Rectangle2.setY(Rectangle2.getY());
			Rectangle2.setIsMoving(false);
		}
		if (sBlock2.intersects(rectangle)) {
			// SBlock.setIsMoving(false);
			SBlock.setVy(0);
			SBlock.setX(SBlock.getX());
			SBlock.setY(SBlock.getY() - 20);
			SBlock.setIsMoving(false);
		}
		if (lBLock2.intersects(sBlock2)) {
			// SBlock.setIsMoving(false);
			LBlock.setVy(0);
			LBlock.setX(LBlock.getX());
			LBlock.setY(LBlock.getY() - 20);
			LBlock.setIsMoving(false);
		}
		if (tBlock2.intersects(sBlock2)) {
			// SBlock.setIsMoving(false);
			TBlock.setVy(0);
			TBlock.setX(TBlock.getX());
			TBlock.setY(TBlock.getY() - 20);
			TBlock.setIsMoving(false);
		}
	}

	public void reset() {
		
			square = new squareBlock("square.png");
			Rectangle2 = new rectangle("LongRectangle.png");
			TBlock = new tBlock("tBlock.png");
			SBlock = new sBlock("sBlock.png");
			LBlock = new lBlock("LBlock.png");
			f.add(square.getImg());
			f.add(Rectangle2.getImg());
			f.add(TBlock.getImg());
			f.add(SBlock.getImg());
			f.add(LBlock.getImg());
			square.move();
		
	}

	public void moveCycle() {
		Rectangle square3 = new Rectangle(square.getX(), square.getY() - 20,
				100, 120);
		Rectangle rectangle = new Rectangle(Rectangle2.getX(),
				Rectangle2.getY() - 20, 200, 60);
		Rectangle tBlock2 = new Rectangle(TBlock.getX(), TBlock.getY() - 20,
				150, 120);
		Rectangle sBlock2 = new Rectangle(SBlock.getX(), SBlock.getY() - 20,
				150, 120);
		Rectangle lBLock2 = new Rectangle(LBlock.getX(), LBlock.getY() - 20,
				150, 120);

		// ||rectangle.intersects(tBlock2)||rectangle.intersects(sBlock2)||rectangle.intersects(lBLock2)
		// ||sBlock2.intersects(square3)||sBlock2.intersects(tBlock2)||sBlock2.intersects(lBLock2)
		square.move();
		if (square.getIsMoving() == false) {
			Rectangle2.move();

			if (rectangle.intersects(square3)) {
				Rectangle2.setVy(0);
				Rectangle2.setX(Rectangle2.getX());
				Rectangle2.setY(Rectangle2.getY());
				Rectangle2.setIsMoving(false);
			}

		}
		if (Rectangle2.getIsMoving() == false) {
			SBlock.move();

			// SBlock.setIsMoving(false);

			if (sBlock2.intersects(rectangle)) {
				// SBlock.setIsMoving(false);
				SBlock.setVy(0);
				SBlock.setX(SBlock.getX());
				SBlock.setY(SBlock.getY());
				SBlock.setIsMoving(false);
			}
		}
		if (SBlock.getIsMoving() == false) {
			LBlock.move();

			if (lBLock2.intersects(sBlock2)) {
				// SBlock.setIsMoving(false);
				LBlock.setVy(0);
				LBlock.setX(LBlock.getX());
				LBlock.setY(LBlock.getY());
			}
			}
			if (LBlock.getIsMoving() == false) {
				TBlock.move();
				if (tBlock2.intersects(sBlock2)) {
					// SBlock.setIsMoving(false);
					TBlock.setVy(0);
					TBlock.setX(TBlock.getX());
					TBlock.setY(TBlock.getY());
				}
			}
		//reset();

	}

	public void update() {
		moveCycle();
		
		//reset();
		//moveCycle();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();
		repaint();
	}

	public static void main(String[] arg) {
		Driver d = new Driver();
		
	}

	JFrame f = new JFrame();;

	public Driver() {
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
		squareBlock square2 = new squareBlock("square.png");
		square2.setY(300);
		square2.setX(300);
		f.add(square2.getImg());
		System.out.println("spawn");
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