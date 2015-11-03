#Design Report
=======

##Introduction:

This report represents the initial design of our implementation of the game TicTacToe. We will be implementing a simple tictactoe game with a web application, available through an app deployed on Heroku.
We made the decision to split the program into layers. Using java for the game logic, spark java framework for the middle layer and JavaScript for the front end layer. 
We split our team into smaller groups to deal with the programming of each layer.

##Initial design:
The project will be kept in a source control enviroment. All business logic code will be coded using TestDriven Development. 
Our initial assumption is that the game is a simple human to human game, where X always begins.

#####**The game logic:**

Contains a class that handles all the game logic. It returns the relevant information in one string when called.
#####**Middle layer:**
Handles the communication between the game logic and the front-end layer as well as saving the game and actions of each game in the database.
#####**Front-end layer:**
The interface of the game. Sends a request to the rest service after each action.

![](https://github.com/Snidgengid/tictactoe/blob/dev/images/Game_spark_script.png)

##Functional description

1. When "New Game" button is pushed at front-end layer. A GET request is sent to /newGame.
2. GET request is recieved by web service, which creates a new instance of the Board class.
3. Board instance is converted to a JSON string, saved in REDIS database.
4. JSON string is sent to front-end layer as a response to the the GET request.
5. Front-end layer a game action is performed, a PUT request is sent to /action containing a JSON string with coordinates and game UUID
6. PUT request is recieved by web service, which converts the request to a new instance of gameAction class.
7. Using the UUID from gameAction the JSON string for that game is fetched from the REDIS database.
8. The JSON string from the REDIS database is converted to an instance of board.
9. The gameAction is performed on the instance of the board and updated.
10. The updated board is converted to JSON string and saved in the database and sent as a response to the PUT request from the front-end layer
11. The front-end layer updates the board and checks variables in the JSON response if the game is won or is a draw.
12. If the game is won or is a draw the game stops and you can start a new game.
 
