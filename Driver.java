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
	int c = 5;

	gridCell[][] grid = new gridCell[80][50];
	Block blocks = new Block(0);
	public void paint(Graphics g) {
		super.paintComponents(g);
		
		blocks.paint(g);
	//	g.fillRect(blocks.getX(), 300, 50, 50);
//		for (int r = 0; r < grid.length; r++) {
//			for (int c = 0; c < grid[0].length; c++) {
//				grid[r][c].paint(g);
//				grid[blocks.getR()][blocks.getColumn()].setC(Color.BLUE);
//				grid[blocks.getR()][blocks.getColumn()].paintBlock(g);
//			}
//		}
	}

	public void update(){
		
//		int newR = blocks.getR();
//		
//			grid[newR][blocks.getColumn()].setC(Color.BLACK);
//			newR++;
//			grid[newR][blocks.getColumn()].setC(Color.BLUE);
//			
			blocks.move();
		
		/*y += vy;
		if (y > screen_height - 75) {
			vy = 0;
			vx = 0;
		}*/
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
		if (e.getKeyCode() == 39 && y < screen_height - 75 && x < screen_width - 50) {
			x += vx;

		}
		if (e.getKeyCode() == 37 && y < screen_height - 75 && x > 0) {
			x -= vx;

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}