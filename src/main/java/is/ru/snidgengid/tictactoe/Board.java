package is.ru.snidgengid.tictactoe;

import java.util.Arrays;
import java.util.UUID;


public class Board {
	private String board[][];
	private String uuid;
	private final int BOARD_SIZE = 3;
	private Boolean isWon;
	private Boolean isDraw;
	private String whoWon;
	private String nextPlayer;

	public Board() {
		this.board = new String[BOARD_SIZE][BOARD_SIZE];
		this.uuid = UUID.randomUUID().toString();
		this.isWon = false;
		this.isDraw = false;
		this.whoWon = null;
		this.nextPlayer = "X";
		}

	//checks if game is won or draw and switches player
	public void checkGame() {
		checkIfGameIsWonOrDraw();
		switchPlayer();
	}

	private void checkIfGameIsWonOrDraw() {
		//This loop checks for a winner in horizontal lines
		for (int i = 0; i < BOARD_SIZE; i++) {
			if ( (this.getElement(i,0) != null) && 
				this.getElement(i,0).equals(this.getElement(i,1)) &&
				this.getElement(i,1).equals(this.getElement(i,2)) ) {
				this.isWon = true;
				this.whoWon = this.getElement(i,0);
				return;
			}
		}
		//This loop checks for a winner in vertical lines
		for (int i = 0; i < BOARD_SIZE; i++) {
			if ( (this.getElement(0,i) != null) && 
				this.getElement(0,i).equals(this.getElement(1,i)) &&
				this.getElement(1,i).equals(this.getElement(2,i)) ) {
				this.isWon = true;
				this.whoWon = this.getElement(0,i);
				return;
			}
		}	
		//check for a diagonal winning line 
		if (this.getElement(0,0) != null && 
			this.getElement(0,0).equals(this.getElement(1,1)) && 
			this.getElement(1,1).equals(this.getElement(2,2)) ) {
				this.isWon = true;
				this.whoWon = this.getElement(0,0);
				return;
		}
		//check for a diagonal winning line 
		if (this.getElement(0,2) != null && 
			this.getElement(0,2).equals(this.getElement(1,1)) && 
			this.getElement(1,1).equals(this.getElement(2,0)) ) {
				this.isWon = true;
				this.whoWon = this.getElement(0,2);
				return;
		}

		//check if every cell is checked if so it is a draw
		int counter = 0;
		for (int i = 0; i < BOARD_SIZE; i++)
			for(int j = 0; j < BOARD_SIZE; j++) {
				if (board[i][j] != null)
					counter++;
			}
		if (counter == 9)
			this.isDraw = true;
	}

	private	void switchPlayer() {
		if(this.nextPlayer.equals("X"))
			this.nextPlayer = "O";
		else
			this.nextPlayer = "X";
	}

	public void setElement(int i, int j, String value) {
		if (checkIfMoveValid(i, j))
			this.board[i][j] = value;
		else
			throw new RuntimeException("Cell already taken! Please try again");
	}

	//checks if the cell is already checked if so it is not a valid move
	private boolean checkIfMoveValid(int i, int j) {
		if (this.board[i][j] != null)
			return false;
		else
			return true;
	}

	public String getNextPlayer() {
		return this.nextPlayer;
	}

	public void setWhoWon(String winner) {
		this.whoWon = winner;
	}
	public String getWhoWon() {
		return this.whoWon;
	}

	public boolean getIsDraw() {
		return this.isDraw;
	}

	public void setIsDraw(boolean isDraw) {
		this.isDraw = isDraw;
	}

	public boolean getIsWon() {
		return this.isWon;
	}

	public void setIsWon(Boolean isWon) {
		this.isWon = isWon;
	}

	public String[][] getBoard() {
		return this.board;
	}

	public String getUUID() {
		return this.uuid;
	}

	public String getElement(int i, int j) {
		return this.board[i][j];
	}
}
