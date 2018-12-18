import java.awt.Color;
import java.awt.Graphics;

public class Block {

	private int r;
	private int c;
	private Color color;

	int type = 2;
	private int size;
	private int n = 0;
	private boolean canMove;
	private boolean gameOver;
	private boolean moveRight;
	private boolean moveLeft;

	public Block(gridCell[][] grid) {
		// square
		if(type == 1){
		this.r = 0;
		this.c = 25;
		this.gameOver = false;
		this.moveRight = false;
		this.moveLeft = false;

		//if ((grid[r][c].getC() != Color.BLACK) || (grid[r][c + 1].getC() != Color.BLACK)
			//	|| (grid[r + 1][c].getC() != Color.BLACK) || (grid[r + 1][c + 1].getC() != Color.BLACK)) {
			//this.gameOver = true;
		//}

		this.color = Color.CYAN;

		grid[r][c].setC(color);
		grid[r][c + 1].setC(color);
		grid[r + 1][c].setC(color);
		grid[r + 1][c + 1].setC(color);
		}
		
		//rectangle
		if(type == 2){
			this.r = 5;
			this.c = 25;
			this.gameOver = false;
			this.moveRight = false;
			this.moveLeft = false;
			
			this.color = Color.red;
			
			grid[r][c].setC(color);
			grid[r][c+1].setC(color);
			grid[r][c+2].setC(color);
			grid[r][c+3].setC(color);;
			
		}
	}
	
	

	public int getR() {
		return this.r;
	}

	public int getC() {
		return this.c;
	}

	public boolean moveRight() {
		this.moveRight = true;
		return this.moveRight;
	}

	public boolean moveLeft() {
		this.moveLeft = true;
		return this.moveLeft;
	}

	public boolean move(gridCell[][] grid) {
		// move right
		if(type == 1){
		if (this.moveRight == true) {
			this.color = Color.BLACK;

			grid[r][c].setC(color);
			grid[r][c + 1].setC(color);
			grid[r + 1][c].setC(color);
			grid[r + 1][c + 1].setC(color);

			this.c++;

			this.color = Color.CYAN;

			grid[r][c].setC(color);
			grid[r][c + 1].setC(color);
			grid[r + 1][c].setC(color);
			grid[r + 1][c + 1].setC(color);
			this.moveRight = false;

		} else if (this.moveLeft == true) {
			this.color = Color.BLACK;

			grid[r][c].setC(color);
			grid[r][c + 1].setC(color);
			grid[r + 1][c].setC(color);
			grid[r + 1][c + 1].setC(color);

			this.c--;

			this.color = Color.CYAN;

			grid[r][c].setC(color);
			grid[r][c + 1].setC(color);
			grid[r + 1][c].setC(color);
			grid[r + 1][c + 1].setC(color);
			this.moveLeft = false;
		} else {
		
			// downward movement
			// checking the bottom boundary
			if (r + 1 == grid.length - 3) {
				canMove = false;
				System.out.println("Bool:" + canMove);

				// checking for other blocks below
			} else if ((grid[r + 2][c].getC() != Color.BLACK) || (grid[r + 2][c + 1].getC() != Color.BLACK)) {
				canMove = false;
				System.out.println("Bool:" + canMove);

				// clear to move down
			} else if (this.r + 1 < grid.length - 4) {
				this.canMove = true;
				// downward movement
				this.color = Color.BLACK;

				grid[r][c].setC(color);
				grid[r][c + 1].setC(color);
				grid[r + 1][c].setC(color);
				grid[r + 1][c + 1].setC(color);

				this.r++;
				System.out.println("Bool:" + canMove);

				this.color = Color.CYAN;

				grid[r][c].setC(color);
				grid[r][c + 1].setC(color);
				grid[r + 1][c].setC(color);
				grid[r + 1][c + 1].setC(color);

			} else if (this.r + 1 == grid.length - 4) {

				this.canMove = false;
				System.out.println("Bool:" + canMove);
			}
		}
			//rectangle
			//move right
			if(type ==2){
			if (this.moveRight == true) {
				this.color = Color.BLACK;
				grid[r][c].setC(color);
				grid[r][c+1].setC(color);
				grid[r][c+2].setC(color);
				grid[r][c+3].setC(color);
				
				c++;
				this.color = Color.red;
				grid[r][c].setC(color);
				grid[r][c+1].setC(color);
				grid[r][c+2].setC(color);
				grid[r][c+3].setC(color);
				this.moveLeft = false;
			}else{
				// downward movement
				// checking the bottom boundary
				if (r + 1 == grid.length - 3) {
					canMove = false;
					System.out.println("Bool:" + canMove);
				
				} else if 
				((grid[r + 2][c].getC() != Color.BLACK) || (grid[r + 2][c + 1].getC() != Color.BLACK)) {
					canMove = false;
					System.out.println("Bool:" + canMove);
					
				} else if (this.r + 1 < grid.length - 4) {
					this.canMove = true;
					// downward movement
					this.color = Color.BLACK;
					
					grid[r][c].setC(color);
					grid[r][c+1].setC(color);
					grid[r][c+2].setC(color);
					grid[r][c+3].setC(color);

					this.r++;
					
					System.out.println("Bool:" + canMove);

					this.color = Color.red;

					grid[r][c].setC(color);
					grid[r][c+1].setC(color);
					grid[r][c+2].setC(color);
					grid[r][c+3].setC(color);
					
				} else if (this.r + 1 == grid.length - 4) {

					this.canMove = false;
					System.out.println("Bool:" + canMove);				
				
				}
				}
			
			}
				
		}

		/*
		 * System.out.println("row:" + r); System.out.println("col:" + c);
		 */
		return canMove;
	}

	public boolean getCanMove() {
		// TODO Auto-generated method stub
		return canMove;
	}

	public boolean getGameOver() {
		// TODO Auto-generated method stub
		return gameOver;
	}
}

/*
 * public void set(int newX, int newY, int newSize, Color newC) { x = newX; y =
 * newY; size = newSize; c = newC;
 * 
 * } // g.setColor(color); // g.fillRect(x, y, size, size);
 * 
 * public void setC(Color newC) { // TODO Auto-generated method stub c = newC; }
 * }
 */