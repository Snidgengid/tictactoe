var c;
var painted;
var content;
var winningCombination;
var theCanvas;
var cxt;
var squaresFilled = 0;
var turn = 0;

$("button").click(function(){
$.getJSON("/newGame", function(result){
  console.log(result);
  game = result;
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

    painted = new Array();
    content = new Array();
    var game;
    winningCombination = [[0,1,2],[3,4,5],[6,7,8],[0,3,6],[1,4,7],[2,5,8],[0,4,8],[2,4,6]];

    for(var l = 0; l <= 8; l++){

      painted[l] = false;
      content[l] = '';
    }
  }

  function canvasClicked(canvasNumber){
    console.log("clicked canvas " + canvasNumber)
  	theCanvas = "canvas"+canvasNumber;
  	c = document.getElementById(theCanvas);
  	cxt = c.getContext("2d");

    //Hér er ég að láta X birtast á kassanum þegar leikmaður X ýtir á kassa. 
  	if(painted[canvasNumber-1]== false){
  		if(turn%2==0){ //inní if setningunni segir okkur hver er að gera núna.
  			cxt.beginPath();
  			cxt.moveTo(10,10);
  			cxt.lineTo(40,40);
  			cxt.moveTo(40,10);
  			cxt.lineTo(10,40);
  			cxt.stroke();
  			cxt.closePath();
  			content[canvasNumber-1] = 'X';
  		}
  		else
  		{ // Ef leikmaður X er ekki að gera þá birtist O á kassann sem leikmaður O ýtir á.
  			cxt.beginPath();
  			cxt.arc(25,25,20,0,Math.PI*2,true);
  			cxt.stroke();
  			cxt.closePath();
  			content[canvasNumber-1] = 'O';
  		}
  turn++; //Hér skiptum við yfir svo að næsti player á að gera. 
  painted[canvasNumber-1] = true; // Hér segjum við að þessi kassi er fyltur.
  squaresFilled++; //Hér er að fyllast í kassana.
  }}


  function newgame(){
    for(var i = 1; i <= 9; i++){
     theCanvas = "canvas"+i;
      c = document.getElementById(theCanvas);
      cxt = c.getContext("2d");
      cxt.clearRect(0, 0, c.width, c.height);
      painted[i-1] = false
    }
    
}

