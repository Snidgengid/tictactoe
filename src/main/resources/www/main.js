var c;
var painted;
var content;
var winningCombination;
var theCanvas;
var cxt;
var squaresFilled = 0;
var turn = 0;
var tictactoe;

$("button").click(function(){
$.getJSON("/newGame", function(result){
  updateGame(result)
});
});



	var TicTacToe = {
		"board": [[null,null,null], [null,null,null],[null,null,null]],
		"uuid": "",
		"isWon": false,
		"isDraw": false,
		"nextPlayer": "x"
	};


  window.onload=function(){
    $.getJSON("/newGame", function(result){
      updateGame(result)
    });
    painted = new Array();
    content = new Array();
    var game;
    winningCombination = [[0,1,2],[3,4,5],[6,7,8],[0,3,6],[1,4,7],[2,5,8],[0,4,8],[2,4,6]];

    for(var l = 0; l <= 8; l++){

      painted[l] = false;
      content[l] = '';
    }
  }

  var map = {
  "1": [0,0],
  "2": [0,1],
  "3": [0,2],
  "4": [1,0],
  "5": [1,1],
  "6": [1,2],
  "7": [2,0],
  "8": [2,1],
  "9": [2,2],
};

  

  console.log(map);

  function canvasClicked(canvasNumber){
    if (tictactoe.isWon || tictactoe.isDraw)
    {
      return;
    }

    var action = {}
    action['uuid'] = tictactoe.uuid;
    action['xcoord'] = map[canvasNumber][0];
    action['ycoord'] = map[canvasNumber][1];

    console.log(action);

    $.ajax({
    url: '/action',
    type: 'PUT',
    dataType   : 'json',
    contentType: 'application/json; charset=UTF-8', // This is the money shot
    data: JSON.stringify(action),
    success: function(result) {
      if (result != "Error making action")
      {
        updateGame(result);
        if (tictactoe.isWon)
        {
          $('.whoWon').text(tictactoe.whoWon + " has won the game!");
        }
        else if (tictactoe.isDraw)
        {
          $('.whoWon').text("This is a draw");
        }
      }
    }
    });




    }


  function updateGame(board){
    tictactoe = board;
    for(var i = 1; i <= 9; i++){

     theCanvas = "canvas"+i;
      c = document.getElementById(theCanvas);
      cxt = c.getContext("2d");
      cxt.clearRect(0, 0, c.width, c.height);
      painted[i-1] = false

      if (tictactoe.board[map[i][0]][map[i][1]] != "null")
      {
        console.log(tictactoe.board[map[i][0]][map[i][1]]);
        console.log("IS SET");
        drawCanvas(i,tictactoe.board[map[i][0]][map[i][1]]);
      }
    }


   

    var iarrayLength = tictactoe.board.length;
      for (var i = 0; i < iarrayLength; i++) {
        var jarrayLength = tictactoe.board[i].length;
        for (var j = 0; j < jarrayLength; j++) {
          console.log(tictactoe.board[i][j])
        }
        //Do something
      }
    
}

 function drawCanvas(canvasNumber, player){
      console.log("clicked canvas " + canvasNumber)
    theCanvas = "canvas"+canvasNumber;
    c = document.getElementById(theCanvas);
    cxt = c.getContext("2d");

    //Hér er ég að láta X birtast á kassanum þegar leikmaður X ýtir á kassa. 
    if(painted[canvasNumber-1]== false){
      if(player == "X"){ //inní if setningunni segir okkur hver er að gera núna.
        cxt.beginPath();
        cxt.moveTo(10,10);
        cxt.lineTo(40,40);
        cxt.moveTo(40,10);
        cxt.lineTo(10,40);
        cxt.stroke();
        cxt.closePath();
        content[canvasNumber-1] = 'X';
      }
      else if (player == "O")
      { // Ef leikmaður X er ekki að gera þá birtist O á kassann sem leikmaður O ýtir á.
        cxt.beginPath();
        cxt.arc(25,25,20,0,Math.PI*2,true);
        cxt.stroke();
        cxt.closePath();
        content[canvasNumber-1] = 'O';
      }
  painted[canvasNumber-1] = true; // Hér segjum við að þessi kassi er fyltur.
  
}
}






