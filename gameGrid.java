import java.awt.Color;
import java.awt.Graphics;

public class gameGrid {
	//fields for the game grid
	private int length, width;
	
	//creating a 2D array of the gridCells
	private gridCell[][] gGrid;
	private Color c;
	
	//flag for full row
	boolean full;

	//user input to decide length and width of screen
	public gameGrid(int l, int w) {
		length = l;
		width = w;

		//overall grid to contain the gridCells
		gGrid = new gridCell[length][width];

		//initializing array
		for (int r = 0; r < gGrid.length; r++) {
			for (int c = 0; c < gGrid[0].length; c++) {
				//each index contains one gridCell
				gGrid[r][c] = new gridCell();
				
				//setting size of gridcell and color
				gGrid[r][c].set(c * 20, r * 20, 20, Color.BLACK);
				
				//testing the row and column number
				System.out.println("row:"+r);
				System.out.println("col"+c);
			}
		}
	}

	//checking for full row
	public int fullrow() {
		
		//number of cleared rows is set to 0
		int n = 0;
		
		//flag for blackRow
		boolean blackRow;
		
		//going through the rows
		for (int r = 0; r < gGrid.length; r++) {
			int c = 0;

			//setting full to true so condition can exit once a black cell
			//is found
			full = true;
			
			//checks for all colored cells that aren't black
			while (full && c < gGrid[r].length) {
				//goes column by column and exits out once there's black
				if (gGrid[r][c].getC() == Color.BLACK) {
					full = false;
				} else {
					c++;
				}
			}
			
			//once a row is found
			if (full == true) {
				n++;
				//get the color of the row above the cleared row and move it
				//into the current row
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

	//painting the overall game grid
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

	//getting the gridCell in order to be passed into Block
	public gridCell[][] getGrid() {
		return gGrid;
	}

}