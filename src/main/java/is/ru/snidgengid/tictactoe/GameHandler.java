package is.ru.snidgengid.tictactoe;

import static spark.Spark.*;
import spark.Request;
import spark.Response;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.easymock.EasyMock;  



public class GameHandler {
	public Object newGame(Request req, Response res){	
		try{
			ObjectMapper mapper = new ObjectMapper();
            Board b = new Board();            
            String jsonInString = mapper.writeValueAsString(b);
            res.status(200);
            res.type("text/json");
            return jsonInString;	
	        //return "{\"board\":[[null,null,null],[null,null,null],[null,null,null]],\"uuid\":\"636e4b86-ec96-4ab9-b044-ed7713076cf2\",\"isWon\":false,\"isDraw\":false,\"whoWon\":null,\"nextPlayer\":\"X\"}";
      	}
      	catch (Exception e) {
      		return "Error";
      	}
	}
}