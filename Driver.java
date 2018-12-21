import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
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
import java.util.concurrent.TimeUnit;

// Class driver 
public class Driver extends JPanel implements ActionListener, KeyListener {

	// variables for screen
	int screen_width = 400;
	int screen_height = 800;

	int score = 0;

	// creating objects

	// main grid for the game - the 2D array is initialized in the class
	gameGrid grid = new gameGrid(40, 20);

	// block object, can be all shapes
	Block block;

	// painting the grid and blocks
	public void paint(Graphics g) {
		super.paintComponents(g);

		// painting grid - blocks are in the grid
		// gameGrid is passed into block class so blocks are directly painted in there
		grid.paint(g);

		// drawing the score
		// updating over and over by being called in actionPerformed
		g.setColor(Color.WHITE);
		g.setFont(new Font("Helvetica", Font.BOLD, 40));
		String stringScore = Integer.toString(score);
		g.drawString(stringScore, screen_width / 2, 100);

	}

	public void update() {
		// setting n for number of rows cleared
		int n;

		// if block can't move anymore
		if (block.move(grid) == false) {

			// randomize type number for random shape
			block.setType((int) (Math.random() * (3 - 1 + 1) + 1));
			// create new block object
			block = new Block(grid);

			// n is set to the number of rows cleared
			// returned from full row method in gameGrid class
			n = grid.fullrow();

			// update score according to n
			// each cleared row = 10 pts
			score = score + n * 10;
			System.out.println(n);

		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// update cycle
		update();
		repaint();
	}

	// driver class
	public static void main(String[] arg) {
		Driver d = new Driver();

	}

	public Driver() {
		// setting up JFrame
		JFrame f = new JFrame();
		f.setTitle("Tetris");
		f.setSize(screen_width, screen_height);
		f.getContentPane();
		f.setResizable(false);
		f.addKeyListener(this);
		f.add(this);

		// creating initial block
		block = new Block(grid);

		// end creating objects
		t = new Timer(60, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

	}

	Timer t;

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

		System.out.println(e.getKeyCode());
		if (e.getKeyCode() == 39) {
			block.moveRight();

		}
		if (e.getKeyCode() == 37) {
			block.moveLeft();

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}