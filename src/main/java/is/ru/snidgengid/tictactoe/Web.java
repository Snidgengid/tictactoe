package is.ru.snidgengid.tictactoe;

import static spark.Spark.*;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import spark.Request;
import spark.Response;
import spark.Route;


public class Web {

    /**
    * Main initializer for Spark Framework that grants HTTP access to TicTacToe
    *
    * @param args String array - not used
    * @return void
    */
    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        staticFileLocation("/www"); 
        get("/newGame", (req, res) -> new GameHandler().newGame(req,res));
        put("/action", (req, res) -> new GameHandler().action(req,res));
         
        

    }

    /**
    * Checks if environmental variable PORT is set and returns it, else it returns 4567
    *
    * @param 
    * @return Integer with assigned port for Web Service
    */    
    public static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

}

