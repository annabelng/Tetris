import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Block {

	// row, column, and color
	private int r;
	private int c;
	private Color color;

	private int type = (int) (Math.random() * (3 - 1 + 1) + 1);

	// flags within the program that help with collision detection
	// and other boundaries
	private boolean canMove;
	private boolean gameOver;
	private boolean moveRight;
	private boolean moveLeft;
	private boolean haveMoved;

	// constructor w the overall game grid passed in as argument
	public Block(gameGrid game) {

		// declaring array and returning the initialized array
		// from the game grid class
		gridCell[][] grid = game.getGrid();

		// checking for square type
		// square constructor
		if (type == 1) {
			// initial values
			this.r = 5;
			this.c = 10;
			this.gameOver = false;
			this.moveRight = false;
			this.moveLeft = false;
			this.haveMoved = false;

			this.color = Color.CYAN;

			grid[r][c].setC(color);
			grid[r][c + 1].setC(color);
			grid[r + 1][c].setC(color);
			grid[r + 1][c + 1].setC(color);
		}

		// checking for rectangle
		if (type == 2) {
			this.r = 5;
			this.c = 10;
			this.gameOver = false;
			this.moveRight = false;
			this.moveLeft = false;
			this.haveMoved = false;

			this.color = Color.red;

			grid[r][c].setC(color);
			grid[r][c + 1].setC(color);
			grid[r][c + 2].setC(color);
			grid[r][c + 3].setC(color);

		}
		// checking for s-block
		if (type == 3) {
			this.r = 5;
			this.c = 10;
			this.gameOver = false;
			this.moveRight = false;
			this.moveLeft = false;
			this.haveMoved = false;

			this.color = Color.green;

			grid[r][c].setC(color);
			grid[r][c + 1].setC(color);
			grid[r + 1][c - 1].setC(color);
			grid[r + 1][c].setC(color);
		}

	}

	// getter for moveRight
	public boolean moveRight() {
		this.moveRight = true;
		return this.moveRight;
	}

	// getter for moveLeft
	public boolean moveLeft() {
		this.moveLeft = true;
		return this.moveLeft;
	}

	// move cycle for ALL blocks - long method
	public boolean move(gameGrid game) {
		// square====================================================
		// getting the grid again
		gridCell[][] grid = game.getGrid();

		// checking for square type
		if (type == 1) {

			// if right arrow key is detected
			if (this.moveRight == true) {

				// checks for right wall
				if (this.c + 2 == grid[0].length) {
					this.moveRight = false;
					// testing the moveRight function
					System.out.println("Right:" + moveRight);

					// checks for collision with block on right
				} else if (grid[r][this.c + 2].getC() != Color.BLACK || grid[r + 1][this.c + 2].getC() != Color.BLACK) {
					this.moveRight = false;

				// if no collision with right wall or block, block continues
				// to move right
				} else {
					// clearing initial block
					this.color = Color.BLACK;

					grid[r][c].setC(color);
					grid[r][c + 1].setC(color);
					grid[r + 1][c].setC(color);
					grid[r + 1][c + 1].setC(color);

					// adds one to column to move right
					this.c++;

					// resets the location and color
					this.color = Color.CYAN;

					grid[r][c].setC(color);
					grid[r][c + 1].setC(color);
					grid[r + 1][c].setC(color);
					grid[r + 1][c + 1].setC(color);
					this.moveRight = false;
				}

				// leftward movement
			} else if (this.moveLeft == true) {

				// checking left wall
				if (this.c == 0) {
					this.moveLeft = false;
					System.out.println("Left:" + moveLeft);

				}else if(grid[r][this.c-1].getC()!=Color.BLACK||grid[r+1][this.c-1].getC()!=Color.BLACK){
					this.moveLeft = false;
					
				// if no collision w wall or block, block continues to move left
				} else {
					// clearing block
					this.color = Color.BLACK;

					grid[r][c].setC(color);
					grid[r][c + 1].setC(color);
					grid[r + 1][c].setC(color);
					grid[r + 1][c + 1].setC(color);

					// subtracting one from column to move left
					this.c--;

					// resetting the block's location and color
					this.color = Color.CYAN;

					grid[r][c].setC(color);
					grid[r][c + 1].setC(color);
					grid[r + 1][c].setC(color);
					grid[r + 1][c + 1].setC(color);
					this.moveLeft = false;
				}

			} else {

				// downward movement

				// checking the bottom boundary
				if (r + 1 == grid.length - 3) {
					this.canMove = false;
					// another tester print statement
					System.out.println("canMove:" + canMove);

					// checking for other blocks
					// checks the blocks immediately below the block
				} else if ((grid[r + 2][c].getC() != Color.BLACK) || (grid[r + 2][c + 1].getC() != Color.BLACK)) {
					this.canMove = false;
					System.out.println("canMove:" + canMove);

					// once block has moved at least one row down
					// this flag is switched off
					// so if it's still false, that mean the blocks are up to the top
					if (this.haveMoved == false) {
						System.exit(0);
					}

					// block is clear to move down
				} else if (this.r + 1 < grid.length - 3) {
					this.canMove = true;
					this.haveMoved = true;

					// downward movement
					// clears block
					this.color = Color.BLACK;

					grid[r][c].setC(color);
					grid[r][c + 1].setC(color);
					grid[r + 1][c].setC(color);
					grid[r + 1][c + 1].setC(color);

					// adds one to row to move the entire block down
					this.r++;
					System.out.println("Bool:" + canMove);

					// resets block location and color
					this.color = Color.CYAN;

					grid[r][c].setC(color);
					grid[r][c + 1].setC(color);
					grid[r + 1][c].setC(color);
					grid[r + 1][c + 1].setC(color);

				}
			}
		}

		// rectangle type=======================================================

		// checking for rectangle type
		if (type == 2) {

			if (this.moveRight == true) {
				// right wall check changes depending on block
				if (this.c + 4 == grid[0].length) {
					this.moveRight = false;
					System.out.println("Right:" + moveRight);

				} else if (grid[r][this.c + 4].getC() != Color.BLACK) {
					this.moveRight = false;

					// if not hitting the wall, continue to move right
				} else {
					// resetting block
					this.color = Color.BLACK;
					grid[r][c].setC(color);
					grid[r][c + 1].setC(color);
					grid[r][c + 2].setC(color);
					grid[r][c + 3].setC(color);

					// adding one to column to move right
					c++;

					// resetting location and color
					this.color = Color.red;
					grid[r][c].setC(color);
					grid[r][c + 1].setC(color);
					grid[r][c + 2].setC(color);
					grid[r][c + 3].setC(color);
					this.moveRight = false;
				}
				// checking for leftward movement
			} else if (this.moveLeft == true) {

				// checking left wall
				if (this.c == 0) {
					this.moveLeft = false;
					System.out.println("Left" + moveLeft);

				}else if(grid[r][this.c-1].getC()!=Color.BLACK){
					this.moveLeft = false;
					
				// if not hitting wall or block continue to move left
				} else {

					this.color = Color.BLACK;
					grid[r][c].setC(color);
					grid[r][c + 1].setC(color);
					grid[r][c + 2].setC(color);
					grid[r][c + 3].setC(color);

					// moving column left
					this.c--;

					this.color = Color.red;

					grid[r][c].setC(color);
					grid[r][c + 1].setC(color);
					grid[r][c + 2].setC(color);
					grid[r][c + 3].setC(color);
					this.moveLeft = false;
				}

			} else {
				// downward movement
				// checking the bottom boundary
				if (this.r + 1 == grid.length - 2) {

					this.canMove = false;
					System.out.println("canMove:" + canMove);

					// checking if block is hitting another block
					// checking the cells directly below the block
				} else if ((grid[r + 1][c].getC() != Color.BLACK) || (grid[r + 1][c + 1].getC() != Color.BLACK)
						|| (grid[r + 1][c + 2].getC() != Color.BLACK) || (grid[r + 1][c + 3].getC() != Color.BLACK)) {

					this.canMove = false;
					System.out.println("canMove:" + canMove);

					// game over
					if (this.haveMoved == false) {
						System.exit(0);
					}

					// if everything is clear, move down
				} else if (this.r + 1 < grid.length - 2) {
					this.canMove = true;
					this.haveMoved = true;
					// downward movement
					this.color = Color.BLACK;

					grid[r][c].setC(color);
					grid[r][c + 1].setC(color);
					grid[r][c + 2].setC(color);
					grid[r][c + 3].setC(color);

					this.r++;

					System.out.println("Bool:" + canMove);

					this.color = Color.red;

					grid[r][c].setC(color);
					grid[r][c + 1].setC(color);
					grid[r][c + 2].setC(color);
					grid[r][c + 3].setC(color);

				}
			}
		}
		// s-block ==========================================================

		// same structure as previous move cycles, only thing
		// that changes is the shape of block and location of checks
		if (type == 3) {
			if (this.moveRight == true) {

				if (this.c + 2 == grid[0].length) {
					this.moveRight = false;
					System.out.println("Right:" + moveRight);

				} else if (grid[r][this.c + 2].getC() != Color.BLACK || grid[r + 1][this.c + 1].getC() != Color.BLACK) {
					this.moveRight = false;

				} else {
					this.color = Color.BLACK;

					grid[r][c].setC(color);
					grid[r][c + 1].setC(color);
					grid[r + 1][c - 1].setC(color);
					grid[r + 1][c].setC(color);

					this.c++;

					this.color = Color.green;

					grid[r][c].setC(color);
					grid[r][c + 1].setC(color);
					grid[r + 1][c - 1].setC(color);
					grid[r + 1][c].setC(color);
					this.moveRight = false;
				}

				// leftward movement
			} else if (this.moveLeft == true) {

				// checking left wall
				if (this.c - 1 == 0) {
					this.moveLeft = false;
					System.out.println("Left:" + moveLeft);

				}else if(grid[r][this.c-1].getC()!=Color.BLACK||grid[r+1][this.c-2].getC()!=Color.BLACK){
					this.moveLeft = false;
					
				// if no collision w wall, continue to move down
				} else {
					this.color = Color.BLACK;

					grid[r][c].setC(color);
					grid[r][c + 1].setC(color);
					grid[r + 1][c - 1].setC(color);
					grid[r + 1][c].setC(color);

					// moving column left
					this.c--;

					this.color = Color.green;

					grid[r][c].setC(color);
					grid[r][c + 1].setC(color);
					grid[r + 1][c - 1].setC(color);
					grid[r + 1][c].setC(color);
					this.moveLeft = false;
				}

			} else {
				// downward movement

				// checking the bottom boundary
				if (r + 1 == grid.length - 3) {
					this.canMove = false;
					System.out.println("canMove:" + canMove);

					// checking for other blocks below
				} else if ((grid[r + 1][c + 1].getC() != Color.BLACK) || (grid[r + 2][c].getC() != Color.BLACK)
						|| (grid[r + 2][c - 1].getC() != Color.BLACK)) {
					this.canMove = false;
					System.out.println("canMove:" + canMove);

					if (this.haveMoved == false) {
						System.exit(0);
					}
					// clear to move down
				} else if (this.r + 1 < grid.length - 3) {
					this.canMove = true;
					this.haveMoved = true;
					// downward movement
					this.color = Color.BLACK;

					grid[r][c].setC(color);
					grid[r][c + 1].setC(color);
					grid[r + 1][c - 1].setC(color);
					grid[r + 1][c].setC(color);

					this.r++;
					System.out.println("Bool:" + canMove);

					this.color = Color.green;

					grid[r][c].setC(color);
					grid[r][c + 1].setC(color);
					grid[r + 1][c - 1].setC(color);
					grid[r + 1][c].setC(color);

				}
			}
		}
		// returns the canMove boolean so
		// program knows when to create the new block
		return canMove;
	}

	public boolean getCanMove() {
		return canMove;
	}

	public boolean getGameOver() {

		return gameOver;
	}

	public int getR() {
		return this.r;
	}

	public int getC() {
		return this.c;
	}

	public void setType(int newType) {
		type = newType;
	}
}