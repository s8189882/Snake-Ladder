package javapractice;

public class SnakenLadder {
	
	public static final int POSITION = 0;
	public static final int ROLL_DICE = 0;
	
	public static void main(String args[]) {

		int rollDice = 0;
		
		rollDice = (int)((Math.random()*6)+1);
	    System.out.println("Rolled Dice Value :" + rollDice);
	}
}
