import java.util.Scanner;

public class Hangman_Game {

	public static void main(String[] args) {

		String[] dictionary = new String[20];

		dictionary[0] = "programming";
		dictionary[1] = "world";
		dictionary[2] = "wordlist";
		dictionary[3] = "array";
		dictionary[4] = "argument";
		dictionary[5] = "parameter";
		dictionary[6] = "lecture";
		dictionary[7] = "laboratory";
		dictionary[8] = "homework";
		dictionary[9] = "windows";
		dictionary[10] = "macintosh";
		dictionary[11] = "notebook";
		dictionary[12] = "laptop";
		dictionary[13] = "input";
		dictionary[14] = "output";
		dictionary[15] = "integer";
		dictionary[16] = "boolean";
		dictionary[17] = "question";
		dictionary[18] = "apple";
		dictionary[19] = "microsoft";

		// intro
		System.out.print("Hello! Are you ready for some hangman?");
		System.out.print("\nPress y (or type \"yes\" or \"YEAH!!\") to play or any other key to quit: ");

		// main menu
		Scanner input = new Scanner(System.in);
		char reply = input.next().charAt(0);
		reply = Character.toLowerCase(reply);

		// the game
		while (reply == 'y') {

			String randomWord = dictionary[(int) Math.round(Math.random() * 19)];

			// System.out.println(randomWord); //uncomment to see the chosen word

			System.out.println("\nLET'S GO! Your word has " + randomWord.length() + " letters. Good luck!");

			runHangman(randomWord);

			System.out.print("Do you want to play again?\n(press y to confirm or any other key to quit): ");
			reply = input.next().charAt(0);
			reply = Character.toLowerCase(reply);

		}
		System.out.println("\nIt was great having you around! \nSee you next time.");
	}

	public static void runHangman(String wordToGuess) {

		char head = 'O', body = '|', legR = '\\', legL = '/';

		char[] letters = wordToGuess.toCharArray();
		int length = letters.length;

		char[] blank = new char[length];
		for (int i = 0; i < length; i++) {
			blank[i] = '_';
		}
		int wrongCount = 0;
		int count = 0; // amount of attempts
		int completion = 0; // how much of the word has been guessed
		String alreadyGuessed = ""; // list of guessed letters

		while (true) {

			if (alreadyGuessed.equals("")) {
				System.out.println();
			} else {
				System.out.print("Your guesses were: ");
				for (int x = 0; x < alreadyGuessed.length(); x++) {
					if (x == 0)
						System.out.print(alreadyGuessed.substring(x, x + 1).toUpperCase());
					else
						System.out.print(", " + alreadyGuessed.substring(x, x + 1).toUpperCase());
				}
				System.out.println("\n");
			}

			for (int i = 0; i < length; i++) {
				System.out.print(blank[i] + " ");
			}
			System.out.println("\n\n_________________");
			System.out.print("Guess a letter: ");
			Scanner input = new Scanner(System.in);

			String guessS = input.next(); // StdIn was giving me trouble, so I switched to Scanner

			while (guessS.length() != 1) {
				System.out.println();
				System.out.print("Oh! Someone's in a rush.\nPlease insert only 1 character: ");
				guessS = input.next();
			}

			char guess = guessS.charAt(0);
			guess = Character.toLowerCase(guess);
			// System.out.println("_________________");

			boolean isHit = false;
			boolean sameGuess = false;

			for (int n = 0; n < length; n++) {
				if (guess == letters[n]) {
					if (Character.toLowerCase(blank[n]) == letters[n]) { // this prevents a player from guessing the
											// same letter right multiple times and
											// still "win"
						break;
					} else {
						blank[n] = Character.toUpperCase(guess);
						completion++;
						isHit = true;
					}
				}
			}

			count++;

			if (alreadyGuessed.indexOf(guess) < 0) { // the return of indexOf() when no chars are found is -1
				alreadyGuessed += guess;
			} else {
				count--;
				sameGuess = true;
				System.out.println("\nIt looks like you already guessed this character.");
				System.out.println("Please try another one. (this won't count as a try)\n");
			}

			if (isHit)
				System.out.println("\nHooray!! You guessed right!\n");
			if (!isHit && !sameGuess) {
				System.out.println("\nOops, that's not it! Try again.\n");
				wrongCount++;
			}

			//print hung person
			if (wrongCount >= 1) {
				System.out.println("  |");
				System.out.println(" " + head + "|");
			}
			if (wrongCount >= 2)
				System.out.print(legL);
			if (wrongCount >= 3)
				System.out.print(body);
			if (wrongCount >= 4)
				System.out.println(legR);
			if (wrongCount >= 5)
				System.out.print(legL);
			if (wrongCount == 6)
				System.out.print(" " + legR);
			System.out.println("\n");
			
			//check for endgame condition
			if (wrongCount == 6)
				break;
			if (completion == length)
				break;
		}

		if (wrongCount == 6) {
			System.out.println("Oh, no! They hung you!");
			System.out.print("You got this far: ");
			
		} else {
			System.out.println();
			System.out.println("CONGRATULATIONS!! YOU BEAT THE GAME IN " + count + " TRIES!");
			System.out.print("The word is: ");

		}
		
		for (int i = 0; i < length; i++) {
			System.out.print(blank[i] + " ");
		}
		System.out.println("\n");

	}
}
