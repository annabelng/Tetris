import java.awt.Color;
import java.awt.Graphics;

public class gameGrid {
	private int length, width;
	private gridCell[][] gGrid;
	private Color c;
	boolean full;

	public gameGrid(int l, int w) {
		length = l;
		width = w;

		gGrid = new gridCell[length][width];

		for (int r = 0; r < gGrid.length; r++) {
			for (int c = 0; c < gGrid[0].length; c++) {
				gGrid[r][c] = new gridCell();
				gGrid[r][c].set(c * 20, r * 20, 20, Color.BLACK);
			}
		}
	}

	public int fullrow() {
		int n = 0;
		boolean blackRow;
		
		for (int r = 0; r < gGrid.length; r++) {
			int c = 0;

			full = true;
			while (full && c < gGrid[r].length) {
				if (gGrid[r][c].getC() == Color.BLACK) {
					full = false;
				} else {
					c++;
				}
			}
			
			if (full == true) {
				n++;
				for (c = 0; c < gGrid[r].length; c++) {
					for (int r2 = r; r2 >15; r2--) {
								gGrid[r2][c].setC(gGrid[r2 - 1][c].getC());
								gGrid[r2 - 1][c].setC(Color.BLACK);
					}
				}
			}
		}

		return n;
	}

	public void fall() {
		if (full == true) {

		}
	}

	public void paint(Graphics g) {
		for (int r = 0; r < gGrid.length; r++) {
			for (int c = 0; c < gGrid[0].length; c++) {

				gGrid[r][c].paint(g);
			}
		}
	}
	
	public void paintOver(Graphics g) {
		for (int r = 0; r < gGrid.length; r++) {
			for (int c = 0; c < gGrid[0].length; c++) {

				gGrid[r][c].paintOver(g);
			}
		}
	}

	public Color getC() {
		return c;
	}

	public void setC(Color NEWC) {
		c = NEWC;
	}

	public gridCell[][] getGrid() {
		return gGrid;
	}

}