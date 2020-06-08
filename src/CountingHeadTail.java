import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class CountingHeadTail {
    private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String headsOrTailsGuess = "";
		String guessRight;
		int correctCount =0;
		int  numberOfFlips =0;
		int randCoin;
		int userCoin = -1;
		final int HEADS = 0;
		final int TAILS = 1;
		double percentCorrect = 0.0;
		Random rand = new Random();
		
		
		do {
			System.out.println("Guess which will have more: heads or tails?");
			headsOrTailsGuess = scanner.nextLine().toLowerCase();
			if (headsOrTailsGuess.equals("heads")) {
				userCoin = HEADS;
			} else if (headsOrTailsGuess.equals("tails")) {
				userCoin = TAILS;
			} else {
				headsOrTailsGuess = "";
			}		
		} while (headsOrTailsGuess == "");

		
		do {
			System.out.println("How many times shall we flip a coin?");
			try {
				numberOfFlips = scanner.nextInt();
			} catch (InputMismatchException exception) {
				numberOfFlips = -1;
				System.out.println("Please enter digits only, greater than 0");
			}
			scanner.nextLine();
		} while (numberOfFlips <= 0);
		
		for ( int i = 1; i<=numberOfFlips; i++) {
			randCoin = rand.nextInt(2);
			guessRight = "";
			switch(randCoin) {
				case HEADS:	
					if (userCoin == HEADS) {
						correctCount += 1;
						guessRight = "*";
					}
					System.out.println(i+ " heads" + guessRight);
					break;
				case TAILS:	
					if (userCoin == TAILS) {
						correctCount += 1;
						guessRight = "*";
					}
					System.out.println(i+ " tails" + guessRight);
					break;
				default:
					System.out.println("should never get here randCoin=" + randCoin);
			}
			
		}
		
		System.out.println("\nYour guess, "+ headsOrTailsGuess+", came up "+correctCount+
				" time" + (correctCount != 1 ? "s." : "."));
		
		percentCorrect = (double)correctCount/numberOfFlips*100.0;
		System.out.println("That's "+ Math.round(percentCorrect) +"%. ");

	}

}

