import java.awt.Color;
import java.awt.Graphics;

public class gameGrid {
	private int length, width;
	private gridCell[][] gGrid;
	private Color c;

	public gameGrid(int l, int w) {
		length = l;
		width = w;

		gGrid = new gridCell[length][width];

		for (int r = 0; r < gGrid.length; r++) {
			for (int c = 0; c < gGrid[0].length; c++) {
				gGrid[r][c] = new gridCell();
				gGrid[r][c].set(c * 10, r * 10, 10, Color.BLACK);
			}
		}
	}

	public int fullrow() {
		int n = 0;
		boolean full;

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
			if(full == true) {
				n++;
				for(c = 0; c<gGrid[r].length; c++) {
					gGrid[r][c].setC(Color.BLACK);
				}
			}
		}
		
		return n;
	}

	public void paint(Graphics g) {
		for (int r = 0; r < gGrid.length; r++) {
			for (int c = 0; c < gGrid[0].length; c++) {

				gGrid[r][c].paint(g);
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
