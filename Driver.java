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
	rectangle Rectangle = new rectangle("LongRectangle.png");
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
			TBlock.move();
		}
		if (TBlock.getIsMoving() == false) {
			SBlock.move();
		}
		if (SBlock.getIsMoving() == false) {
			LBlock.move();
		}
		if (LBlock.getIsMoving() == false) {
			Rectangle.move();
		}
	}
	public void update() {
		moveCycle();
		
		
		
		
		
		
		
		
		
		
		/*
		for (int i = 0; i < squareBlock.length; i++) {
			squareBlock[i].move();
			lBLock obj = new lBlock(squareBlock[i].getX(), squareBlock[i].getY(), 100, 100);
			if (squareBlock.intersects(lBlock || rectangle || sBlock || tBlock)) {
				squareBlock.setX(getX);
				squareBlock.setY(getY);
			*/	
				
				
					
		
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
		f.add(Rectangle.getImg());
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