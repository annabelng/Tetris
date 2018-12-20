import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Block {

	private int r;
	private int c;
	private Color color;

	private int size;
	private int n = 0;

	private int type = (int) (Math.random() * (3 - 1 + 1) + 1);

	private boolean canMove;
	private boolean gameOver;
	private boolean moveRight;
	private boolean moveLeft;
	private boolean haveMoved;

	public Block(gameGrid game) {
		gridCell[][] grid = game.getGrid();

		// square
		if (type == 1) {
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
		// rectangle
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
		// s-block
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

	public boolean moveRight() {
		this.moveRight = true;
		return this.moveRight;
	}

	public boolean moveLeft() {
		this.moveLeft = true;
		return this.moveLeft;
	}

	public boolean move(gameGrid game) {
		// move right
		// square=================================================
		gridCell[][] grid = game.getGrid();

		if (type == 1) {

			if (this.moveRight == true) {

				if (this.c + 2 == grid[0].length) {
					this.moveRight = false;
					System.out.println("Bool:" + moveRight);

				} else {
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
				}

				// leftward movement
			} else if (this.moveLeft == true) {

				// checking left wall
				if (this.c == 0) {
					this.moveLeft = false;
					System.out.println("Bool:" + moveLeft);

					// if no collision w wall, continue to move down
				} else {
					this.color = Color.BLACK;

					grid[r][c].setC(color);
					grid[r][c + 1].setC(color);
					grid[r + 1][c].setC(color);
					grid[r + 1][c + 1].setC(color);

					// moving column left
					this.c--;

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
					System.out.println("Bool:" + canMove);

					// checking for other blocks below
				} else if ((grid[r + 2][c].getC() != Color.BLACK)
						|| (grid[r + 2][c + 1].getC() != Color.BLACK)) {
					this.canMove = false;
					System.out.println("Bool:" + canMove);

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
					grid[r + 1][c].setC(color);
					grid[r + 1][c + 1].setC(color);

					this.r++;
					System.out.println("Bool:" + canMove);

					this.color = Color.CYAN;

					grid[r][c].setC(color);
					grid[r][c + 1].setC(color);
					grid[r + 1][c].setC(color);
					grid[r + 1][c + 1].setC(color);

				}
			}
		}

		// rectangle type=======================================================

		if (type == 2) {
			if (this.moveRight == true) {

				if (this.c + 4 == grid[0].length) {
					this.moveRight = false;
					System.out.println("Bool:" + moveRight);
				} else {
					this.color = Color.BLACK;
					grid[r][c].setC(color);
					grid[r][c + 1].setC(color);
					grid[r][c + 2].setC(color);
					grid[r][c + 3].setC(color);

					c++;

					this.color = Color.red;
					grid[r][c].setC(color);
					grid[r][c + 1].setC(color);
					grid[r][c + 2].setC(color);
					grid[r][c + 3].setC(color);
					this.moveRight = false;
				}

			} else if (this.moveLeft == true) {

				// checking left wall
				if (this.c == 0) {
					this.moveLeft = false;
					System.out.println("Left" + moveLeft);

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
					System.out.println("Bool:" + canMove);

				} else if ((grid[r + 1][c].getC() != Color.BLACK)
						|| (grid[r + 1][c + 1].getC() != Color.BLACK)
						|| (grid[r + 1][c + 2].getC() != Color.BLACK)
						|| (grid[r + 1][c + 3].getC() != Color.BLACK)) {

					this.canMove = false;
					System.out.println("Bool:" + canMove);

					if (this.haveMoved == false) {
						System.exit(0);
					}

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

		if (type == 3) {
			if (this.moveRight == true) {

				if (this.c + 2 == grid[0].length) {
					this.moveRight = false;
					System.out.println("Bool:" + moveRight);

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
					System.out.println("Bool:" + moveLeft);

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
					System.out.println("Bool:" + canMove);

					// checking for other blocks below
				} else if ((grid[r + 1][c + 1].getC() != Color.BLACK)
						|| (grid[r + 2][c].getC() != Color.BLACK)
						|| (grid[r + 2][c - 1].getC() != Color.BLACK)) {
					this.canMove = false;
					System.out.println("Bool:" + canMove);

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

	public void gameOver(Graphics g) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("Helvetica", Font.BOLD, 80));
		g.drawString("GAME OVER", 150, 300);
	}

}