package is.ru.snidgengid.tictactoe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNotEquals;
import static org.cthul.matchers.CthulMatchers.*;
import org.junit.Test;
import spark.Request;
import spark.Response;
import org.easymock.EasyMock;  



public class GameHandlerTest {
	public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("is.ru.snidgengid.tictactoeTest");
	}

	String BOARD_JSON_REGEX = ".*board.*:.*null,null,null.*,.*null,null,null.*,.*null,null,null.*,.*uuid.*:.*........-....-....-....-.............*,.*isWon.*:false,.*isDraw.*:false,.*whoWon.*:null,.*nextPlayer.*:.*X.*";	

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

}
