package javapractice;

import java.util.Scanner;

public class SnakeLadder {
    
    int diceFace = 0;
    int diceCount = 0;
    int playOption = 0;
    int position = 0;
    String name = null;
    
    public SnakeLadder(String playerName) {
    	diceFace = 0;
    	diceCount = 0;
    	playOption = 0;
    	position = 0;
    	name = playerName;
    }
    
    public void initialiseGame() {
	    System.out.println("Player "+name+"	Position : Square " + position);  	
    }
    
    public void rollDice() {
    	diceFace = (int)(Math.random()*6)+1;
    	diceCount++;
    	System.out.println("\n\nPlayer "+name+" rolled a "+diceFace);
    	this.playOptionCheck();
    }
    
    public void playOptionCheck() {
    	playOption = (int)(Math.random()*10)%3;
    	
    	switch (playOption) {
		case 0 :
			System.out.println("Player "+name+" encountered a LADDER!");
			System.out.println("Player "+name+" can move " + diceFace +" places ahead.");
			position += diceFace;
			break;
			
		case 1 :
			System.out.println("Player "+name+" encountered a SNAKE!");
			System.out.println("Player "+name+" will move " + diceFace +" places back.");
			position -= diceFace;
			break;
			
		case 2 :
			System.out.println("Player "+name+" got NO PLAY");
			System.out.println("Player "+name+" will have to skip their turn.");
    	}
    	this.displayPosition();
    }
    
    public void displayPosition() {
    	if (position < 0)
			position = 0;
	    else
	    	if (position > 100) {
	    		position -= diceFace;
	    		System.out.println("But Player "+name+" needs to score exactly " + (100-position) +" to win the game.");
	    	}
	    System.out.println("Player "+name+" Current Position : Square " + position);
	    
	    if (playOption == 0) {
	    	System.out.println("\nSince Player "+name+" encountered a LADDER, Player "+name+" can avail an EXTRA TURN.");
	    	this.rollDice();
	    }
    }
    
    public void declareWinner() {
    	System.out.println();
		System.out.println("\nPlayer "+name+" WINS THE GAME!");
    }
   
    public void showStats() {
    	System.out.println();
		System.out.println("Player "+name+"\nNumber of times dice rolled : "+diceCount);
    }
    
    public static void main(String[] args) {   
    	
    	String player1name = null;
    	String player2name = null;

		Scanner sc = new Scanner(System.in);
    	
    	System.out.println("Welcome to Snake & Ladder Simulator!");
	    System.out.println("This problem simulates a Snake and Ladder Game.");
	    System.out.println("The Player starts from 0 rolls the die to get a number between 1 to 6, finds a safe place, ladder or a snake keeps doing till the winning spot 100 is achieved.");
	    System.out.println("\nLet's begin the game...");
	    System.out.print("Enter the name of Player 1 : ");
		player1name = sc.next();
		System.out.print("Enter the name of Player 2 : ");
		player2name = sc.next();
	    System.out.println("\nInitial position is Square Zero\n");
	    
	    SnakeLadder player1 = new SnakeLadder(player1name);
	    SnakeLadder player2 = new SnakeLadder(player2name);
	    player1.initialiseGame();
	    player2.initialiseGame();
	    
	    for (int i = 0;player1.position < 100 && player2.position < 100; i++) {
	    	player1.rollDice(); 
	 	    player2.rollDice();
	    }

    	System.out.println();
	    if(player1.position == 100) 
	    	player1.declareWinner();
	    else 
	    	player2.declareWinner();
	    
	    
	    player1.showStats();
	    player2.showStats();
	    sc.close();
	}

}
