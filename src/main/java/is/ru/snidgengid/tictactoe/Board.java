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

	public Board() {
		this.board = new String[BOARD_SIZE][BOARD_SIZE];
		this.uuid = UUID.randomUUID().toString();
		this.isWon = false;
		this.isDraw = false;
		this.whoWon = null;
		}

	public void checkGame() {
		for (int i = 0; i < BOARD_SIZE; i++) {
			if ( (this.getElement(i,0) != null) && 
				(this.getElement(i,0) == this.getElement(i,1)) &&
				(this.getElement(i,1) == this.getElement(i,2)) ) {
				this.isWon = true;
				this.whoWon = this.getElement(0,i);
			}
		}
		
	}

	public void setElement(int i, int j, String value) {
		if (checkIfMoveValid(i, j))
			this.board[i][j] = value;
		else
			throw new RuntimeException("Cell already taken! Please try again");
	}

	private boolean checkIfMoveValid(int i, int j) {
		if (this.board[i][j] != null)
			return false;
		else
			return true;
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
