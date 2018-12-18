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
import java.util.concurrent.TimeUnit;

// Class driver 
public class Driver extends JPanel implements ActionListener, KeyListener {

	int screen_width = 500;
	int screen_height = 800;
	int x = 250;
	int y = 20;
	int vy = 2;
	int vx = 10;
	int gridSize = 10;
	int r = 0;
	int c = 23;

	/* public static */gridCell[][] grid = new gridCell[80][50];
	Block block;

	public void paint(Graphics g) {
		super.paintComponents(g);

		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[0].length; c++) {
				grid[r][c].paint(g);
				if (grid[r][c].getC() != Color.BLACK) {
					System.out.println("row:" + r);
					System.out.println("col:" + c);
				}
				// grid[blocks.getR()][blocks.getColumn()].setC(Color.CYAN);
				// blocks.paint(g);
			}
		}

	}

	public void update() {
		/*
		 * try { Thread.sleep(1000); } catch(InterruptedException ex) {
		 * Thread.currentThread().interrupt(); }
		 */

		if (block.move(grid) == false) {
			block = new Block(grid);

			if (block.getGameOver() == true) {
				System.exit(0);
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
		f.setTitle("Tetris");
		// f.setBackground(Color.BLACK);
		f.setSize(screen_width, screen_height);
		f.getContentPane();
		f.setResizable(false);
		f.addKeyListener(this);
		f.add(this);

		// initialize Grid
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[0].length; c++) {

				grid[r][c] = new gridCell();
				grid[r][c].set(c * 10, r * 10, 10, Color.BLACK);
			}
		}
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
		// TODO Auto-generated method stub
		// System.out.println(e.getKeyCode());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub

	}

}