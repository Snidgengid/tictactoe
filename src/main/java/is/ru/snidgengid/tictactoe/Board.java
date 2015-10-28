package is.ru.snidgengid.tictactoe;

import java.util.Arrays;
import java.util.UUID;


public class Board {
	private String board[][];
	private String uuid;
	private final int BOARD_SIZE = 3;
	private Boolean isWon;


	public Board() {
		this.board = new String[BOARD_SIZE][BOARD_SIZE];
		this.uuid = UUID.randomUUID().toString();
		this.isWon = false;	
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

	public boolean getIsWon() {
		return this.isWon;
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
