package is.ru.snidgengid.tictactoe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.cthul.matchers.CthulMatchers.*;
import org.junit.Test;
import spark.Request;
import spark.Response;
import org.easymock.EasyMock;  



public class GameHandlerTest {
	public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("is.ru.snidgengid.tictactoeTest");
	}	

	@Test
	public void testNewGameReturnsCorrectString() {
		GameHandler game = new GameHandler();
		Response res = EasyMock.createMock(Response.class);  
		Request req = null;
		String response = (String)game.newGame(req, res);
		assertThat(response,matchesPattern(".*board.*:.*null,null,null.*,.*null,null,null.*,.*null,null,null.*,.*uuid.*:.*........-....-....-....-.............*,.*isWon.*:false,.*isDraw.*:false,.*whoWon.*:null,.*nextPlayer.*:.*X.*"));
	}

}
