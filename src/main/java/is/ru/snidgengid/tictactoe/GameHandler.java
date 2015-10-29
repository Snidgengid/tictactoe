package is.ru.snidgengid.tictactoe;

import static spark.Spark.*;
import spark.Request;
import spark.Response;


public class GameHandler {
	public Object newGame(Request req, Response res){	
		try{	
	        return "{\"board\":[[null,null,null],[null,null,null],[null,null,null]],\"uuid\":\"636e4b86-ec96-4ab9-b044-ed7713076cf2\",\"isWon\":false,\"isDraw\":false,\"whoWon\":null,\"nextPlayer\":\"X\"}";
      	}
      	catch (Exception e) {
      		return "Error";
      	}
	}
}