package is.ru.snidgengid.tictactoe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertNotEquals;
import static org.cthul.matchers.CthulMatchers.*;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import spark.Request;
import spark.Response;
import org.easymock.EasyMock;  
import static org.easymock.EasyMock.replay;

public class GameHandlerTest {

	public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("is.ru.snidgengid.tictactoeTest");
	}

	String BOARD_JSON_REGEX = ".*board.*:.*null,null,null.*,.*null,null,null.*,.*null,null,null.*,.*uuid.*:.*........-....-....-....-.............*,.*isWon.*:false,.*isDraw.*:false,.*whoWon.*:null,.*nextPlayer.*:.*X.*";	
	String BOARD_FIRST_ACTION_JSON_REGEX = ".*board.*:.*null,null,null.*,.*null,.*X.*,null.*,.*null,null,null.*,.*uuid.*:.*........-....-....-....-.............*,.*isWon.*:false,.*isDraw.*:false,.*whoWon.*:null,.*nextPlayer.*:.*O.*";	

	@Test
	public void testNewGameReturnsCorrectString() {
		GameHandler game = new GameHandler();
		Response res = EasyMock.createMock(Response.class);  
		Request req = null;
		String response = (String)game.newGame(req, res);
		assertThat(response,matchesPattern(BOARD_JSON_REGEX));
	}

	@Test
	public void testNewGameReturnsDifferentUUID() {
		GameHandler game = new GameHandler();
		Response res = EasyMock.createMock(Response.class);
		Request req = null;
		String firstResponse = (String)game.newGame(req, res);
		String secondResponse = (String)game.newGame(req, res);
		assertThat(firstResponse,matchesPattern(BOARD_JSON_REGEX));
		assertThat(secondResponse,matchesPattern(BOARD_JSON_REGEX));
		assertNotEquals(firstResponse,secondResponse);
	}

	@Test
	public void testFirstActionOnGame() {
		try {
			//Create new game
			GameHandler game = new GameHandler();
			Response res = EasyMock.createMock(Response.class);
			Request req = EasyMock.createMock(Request.class);
			String gameJSON = (String)game.newGame(req, res);
			System.out.println(gameJSON);

			//Create board object from response
			ObjectMapper mapper = new ObjectMapper();
			Board board = mapper.readValue(gameJSON,Board.class);

			//Create game action object and set action
			GameAction action = new GameAction();
			action.setXCoord(1);
			action.setYCoord(1);
			action.setUUID(board.getUUID());

			//Create json string of action for request
			String actionJSON = mapper.writeValueAsString(action);
			String actionResponse = (String)game.action(actionJSON,res);
			System.out.println(actionResponse);
			assertNotEquals(actionResponse,gameJSON);
			assertThat(actionResponse,matchesPattern(BOARD_FIRST_ACTION_JSON_REGEX));
		} catch (Exception e) {
			fail("FAIIIIL");
		}
	}

		@Test
		public void testActionOnGameWithRequest() {
			try {
				//Create new game
				GameHandler game = new GameHandler();
				Response res = EasyMock.createMock(Response.class);
				Request req = EasyMock.createMock(Request.class);
				String gameJSON = (String)game.newGame(req, res);
				System.out.println(gameJSON);

				//Create board object from response
				ObjectMapper mapper = new ObjectMapper();
				Board board = mapper.readValue(gameJSON,Board.class);

				//Create game action object and set action
				GameAction action = new GameAction();
				action.setXCoord(1);
				action.setYCoord(1);
				action.setUUID(board.getUUID());

				//Create json string of action for request
				String actionResponse = (String)game.action(req,res);
				
		} catch (Exception e) {
				assertEquals("Error making action", e.getMessage());
		}
	}
}

