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

	int screen_width = 600;
	int screen_height = 800;
	int x = 250;
	int y = 20;
	int vy = 2;
	int vx = 10;
	int gridSize = 10;
	int r = 0;
	int c = 23;
	int score = 0;
	int sum = 0;
	/* public static */
	gameGrid grid = new gameGrid(40, 30);
	Block block;
	// gameGrid game = new gameGrid(80,50);
	

	public void paint(Graphics g) {
		super.paintComponents(g);

		grid.paint(g);

		g.setColor(Color.WHITE);

		g.setFont(new Font("Helvetica", Font.BOLD, 40));
		String stringScore = Integer.toString(score);
		g.drawString(stringScore, 275, 100);

	}

	public void update() {
		int n;

		if (block.move(grid) == false) {
			block.setType((int) (Math.random() * (2 - 1 + 1) + 1));
			block = new Block(grid);
			
			n = grid.fullrow();
			score = score + n*10;
			System.out.println(n);
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
		f.setSize(screen_width, screen_height);
		f.getContentPane();
		f.setResizable(false);
		f.addKeyListener(this);
		f.add(this);

		// game.game(80, 50, grid);
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