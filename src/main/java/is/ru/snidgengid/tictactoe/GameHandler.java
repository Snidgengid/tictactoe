package is.ru.snidgengid.tictactoe;

import static spark.Spark.*;
import spark.Request;
import spark.Response;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
* Implementation of game handler for Spark Web Framework
*/
public class GameHandler {
	Database dbConn;

	/**
	* Constructor for GameHandler.
	*/
	public GameHandler() {
		dbConn = new Database();
	}

	/**
	* Request handler to create a new game, stores it in the database and returns a json representation of the class Board
	* @param req Request
	* @param res Response
	* @return String 
	*/
	public Object newGame(Request req, Response res) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Board b = new Board();
			String jsonInString = mapper.writeValueAsString(b);
			dbConn.setBoard(b.getUUID(), jsonInString);
			res.status(200);
			res.type("text/json");
			return jsonInString;
		} catch (Exception e) {
			return "Error creating new game";
		}
	}

	/**
	* Request handler to create a new game, stores it in the database and returns a json representation of the class Board
	* @param request Object (String or Object)
	* @param res Response
	* @return String 
	*/
	public Object action(Object request, Response res) {
		try {
			//To allow for testing an object request can enter
			//the function as an object, where it is checked, If
			//It it a Request then the body content is fetched.
			//Else its treated as a string which contains the body
			String body;
			if (request.getClass().getName().equals("spark.webserver.RequestWrapper")) {
				Request req = (Request)request;
				body = req.body();
			} else
				body = (String)request;

			ObjectMapper mapper = new ObjectMapper();
			GameAction gameAction = mapper.readValue(body, GameAction.class);

			String boardJSON = dbConn.getBoard(gameAction.getUUID());

			Board board = mapper.readValue(boardJSON, Board.class);

			board.setElement(gameAction.getXCoord(), gameAction.getYCoord(), board.getNextPlayer());
			board.checkGame();

			String jsonInString = mapper.writeValueAsString(board);
			dbConn.setBoard(board.getUUID(), jsonInString);

			return jsonInString;


		} catch (Exception e) {
			return "Error making action";
		}
	}
}