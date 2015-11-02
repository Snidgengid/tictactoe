package is.ru.snidgengid.tictactoe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;
import java.util.UUID;


public class BoardTest {
	public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("is.ru.snidgengid.tictactoeTest");
	}
	
	@Test
	public void testEmptyNewBoard() {
		String[][] emptyBoard = new String[3][3];
		Board newBoard = new Board();
		assertArrayEquals(emptyBoard, newBoard.getBoard());
	}

	@Test
	public void testEnsureUUIDset() {
		Board board = new Board();
		UUID uuidFromString = UUID.fromString(board.getUUID());
		assertEquals(uuidFromString.toString(),board.getUUID());
	}

	@Test
	public void testInputValueToBoard() {
		Board board = new Board();
		board.setElement(0,0,"X");
		assertEquals("X",board.getElement(0,0));
	}

	@Test
	public void testInputValueToBoardInTakenCell() {
		Board board = new Board();
		try {
			board.setElement(0,0,"X");
			board.setElement(0,0,"O");
		}
		catch (RuntimeException exception) {
			assertEquals("Cell already taken! Please try again", exception.getMessage());
		}
	}

	@Test
	public void testInitalStateOfGame() {
		Board board = new Board();
		assertEquals(false, board.getIsWon());
		assertEquals(false, board.getIsDraw());
	}

	@Test
	public void testCheckIsWon() {
		Board board = new Board();
		board.setElement(0,0,"X");
		board.setElement(0,1,"X");
		board.setElement(0,2,"X");
		board.checkGame();		
		assertEquals(true, board.getIsWon());
	}

	@Test
	public void testHorizontalWinnerFirstRow() {
		Board board = new Board();
		board.setElement(0,0,"X");
		board.setElement(0,1,"X");
		board.setElement(0,2,"X");
		board.checkGame();	
		assertEquals(true, board.getIsWon());
		assertEquals("X", board.getWhoWon());
	}

	@Test
	public void testHorizontalWinnerMiddle() {
		Board board = new Board();
		board.setElement(1,0,"X");
		board.setElement(1,1,"X");
		board.setElement(1,2,"X");
		board.checkGame();	
		assertEquals(true, board.getIsWon());
		assertEquals("X", board.getWhoWon());
	}

	@Test
	public void testHorizontalWinnerLastRow() {
		Board board = new Board();
		board.setElement(2,0,"X");
		board.setElement(2,1,"X");
		board.setElement(2,2,"X");
		board.checkGame();	
		assertEquals(true, board.getIsWon());
		assertEquals("X", board.getWhoWon());
	}

	@Test
	public void testHorizontalNotWinner() {
		Board board = new Board();
		board.setElement(1,0,"X");
		board.setElement(1,1,"X");
		board.setElement(1,2,"O");
		board.checkGame();	
		assertEquals(false, board.getIsWon());
		assertEquals(null, board.getWhoWon());
	}

	@Test
	public void testVerticalWinnerFirstRow() {
		Board board = new Board();
		board.setElement(0,0,"O");
		board.setElement(1,0,"O");
		board.setElement(2,0,"O");
		board.checkGame();	
		assertEquals(true, board.getIsWon());
		assertEquals("O", board.getWhoWon());
	}

	@Test
	public void testVerticalWinnerMiddleRow() {
		Board board = new Board();
		board.setElement(0,1,"O");
		board.setElement(1,1,"O");
		board.setElement(2,1,"O");
		board.checkGame();	
		assertEquals(true, board.getIsWon());
		assertEquals("O", board.getWhoWon());
	}

	@Test
	public void testVerticalWinnerLastRow() {
		Board board = new Board();
		board.setElement(0,2,"O");
		board.setElement(1,2,"O");
		board.setElement(2,2,"O");
		board.checkGame();	
		assertEquals(true, board.getIsWon());
		assertEquals("O", board.getWhoWon());
	}

	@Test
	public void testVerticalNotWinner() {
		Board board = new Board();
		board.setElement(0,1,"X");
		board.setElement(1,1,"X");
		board.setElement(2,1,"O");
		board.checkGame();	
		assertEquals(false, board.getIsWon());
		assertEquals(null, board.getWhoWon());
	}

	@Test
	public void testDiagonalWinner() {
		Board board = new Board();
		board.setElement(0,0,"X");
		board.setElement(1,1,"X");
		board.setElement(2,2,"X");
		board.checkGame();	
		assertEquals(true, board.getIsWon());
		assertEquals("X", board.getWhoWon());
	}

	@Test
	public void testOtherDiagonalWinner() {
		Board board = new Board();
		board.setElement(0,2,"O");
		board.setElement(1,1,"O");
		board.setElement(2,0,"O");
		board.checkGame();	
		assertEquals(true, board.getIsWon());
		assertEquals("O", board.getWhoWon());
	}

	@Test
	public void testCheckDraw() {
		Board board = new Board();
		board.setElement(0,0,"X");
		board.setElement(0,1,"O");
		board.setElement(0,2,"X");

		board.setElement(1,0,"X");
		board.setElement(1,1,"O");
		board.setElement(1,2,"X");

		board.setElement(2,0,"O");
		board.setElement(2,1,"X");
		board.setElement(2,2,"O");

		board.checkGame();
		assertEquals(true, board.getIsDraw());
		assertEquals(false, board.getIsWon());
	}

	@Test
	public void testCheckAnotherDraw() {
		Board board = new Board();
		board.setElement(0,0,"O");
		board.setElement(0,1,"X");
		board.setElement(0,2,"O");

		board.setElement(1,0,"X");
		board.setElement(1,1,"X");
		board.setElement(1,2,"O");

		board.setElement(2,0,"O");
		board.setElement(2,1,"O");
		board.setElement(2,2,"X");

		board.checkGame();
		assertEquals(true, board.getIsDraw());
		assertEquals(false, board.getIsWon());
		assertEquals(null, board.getWhoWon());
	}

	@Test
	public void testFirstPlayer() {
		Board board = new Board();
		assertEquals("X",board.getNextPlayer());
	}

	@Test
	public void testNextPlayer() {
		Board board = new Board();
		board.checkGame();
		assertEquals("O",board.getNextPlayer());
	}

	@Test
	public void testPlayerThirdRound() {
		Board board = new Board();
		board.checkGame();
		board.checkGame();
		assertEquals("X",board.getNextPlayer());
	}
}
