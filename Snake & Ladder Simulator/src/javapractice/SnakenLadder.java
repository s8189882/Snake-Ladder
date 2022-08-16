package javapractice;

public class SnakenLadder {
		
	public static void main(String args[]) {

		int rollDice = 0;
		int playOption = 0;
		int POSITION = 0;
		
		rollDice = (int)((Math.random()*6)+1);
	    System.out.println("Rolled Dice Value :" + rollDice);
	    
	    playOption = (int) Math.floor(Math.random() * 10) % 3;
		
	    switch (playOption) {
			case 0 :
				System.out.println("You encountered a LADDER!");
				System.out.println("You can move " + rollDice +" places ahead.");
				POSITION += rollDice;
				break;
				
			case 1 :
				System.out.println("You encountered a SNAKE!");
				System.out.println("You will move " + rollDice +" places back.");
				POSITION -= rollDice;
				break;
				
			case 2 :
				System.out.println("You got NO PLAY");
				System.out.println("You will have to skip your turn.");
		
		}
		
	    if (POSITION < 0)
			POSITION = 0;
		
	    System.out.println("Current Position : Square " + POSITION);

	}
}
