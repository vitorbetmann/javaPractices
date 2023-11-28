import java.util.*;

public class Battleship {

	public static void main(String[] args) {

		System.out.println("    WELCOME TO BATTLESHIP\n");

		boolean cond1 = false, cond2 = false;

		Scanner inputSize = new Scanner(System.in);
		System.out.print(
				"The board is gonna be a \"WIDTH x HEIGTH\" matrix.\nHow big would you like it to be?\n\nPlease insert the HEIGHT: ");
		int sizeX = inputSize.nextInt();

		while (!cond1) {
			if (sizeX < 0) {
				System.out.println("\nWow... Someone's really funny.");
				System.out.print("\nPlease, my dear clown, pick a non-negative value: ");
				sizeX = inputSize.nextInt();

			} else
				cond1 = true;
		}

		System.out.print("\nAlright, now please insert the WIDTH: ");
		int sizeY = inputSize.nextInt();

		while (!cond2) {
			if (sizeY < 0) {
				System.out.println("\nWow... Someone's really funny.");
				System.out.print("\nPlease, my dear clown, pick a non-negative value: ");
				sizeY = inputSize.nextInt();

			} else
				cond2 = true;
		}

		if (sizeY == 0 || sizeX == 0) {
			System.out.print(
					"\nWell... There can be no ships if there's no board. \n\nTechnically you win. Congrats I guess...");

		} else {
			System.out.print(
					"\nPlease insert the amount of ships on the board.\n(The maximum amount of ships you can have for this board is "
							+ sizeX * sizeY + "):");

			int shipAmount = inputSize.nextInt();

			System.out.print("\n");

			int[][] shipPosFix = new int[sizeX + 1][sizeY + 1];
			String[][] boardCopy = new String[sizeX + 1][sizeX + 1];
			boardCopy = board(sizeX, sizeY);
			shipPosFix = shipPos(sizeX, sizeY, shipAmount); // CREATE A FIXED POSITION FOR THE SHIPS
			if (shipAmount == 0) {
				System.out.println(
						"\nLooks like we live in peaceful times. There are no ships to sink. \nYOU BEAT THE GAME!! \\nCONGRATULATIONS!!!!!");

			} else {
				do {
					Scanner input = new Scanner(System.in);
					System.out.print("\nPlease choose the X coordinate: ");
					int targetX = input.nextInt();
					System.out.print("Please choose the Y coordinate: ");
					int targetY = input.nextInt();
					System.out.print("\n");

					targetHit(shipPosFix, targetX, targetY, sizeX, sizeY);

					if (targetHit(shipPosFix, targetX, targetY, sizeX, sizeY)) {
						boardCopy[targetX][targetY] = "HIT!";
					} else
						boardCopy[targetX][targetY] = "MISS";

					for (int i = 1; i < boardCopy.length; i++) {
						for (int j = 1; j < boardCopy[i].length; j++) {
							System.out.print(" (" + boardCopy[i][j] + ") ");
						}
						System.out.println("\n");
					}

				} while (!gameOver());
				System.out.println("YOU BEAT THE GAME!! \nCONGRATULATIONS!!!!!");

			}
		}
	}

	////////////////////////////////// CREATE A NEW EMPTY BOARD
	public static String[][] board(int sizeX, int sizeY) {
		String[][] board = new String[sizeX + 1][sizeY + 1];

		for (int i = 1; i < board.length; i++) {
			for (int j = 1; j < board[i].length; j++) {
				board[i][j] = i + ", " + j;

				System.out.print(" (" + board[i][j] + ") ");
			}
			System.out.println("\n");
		}
		return board;
	}

	/////////////////////////////////// CREATE RANDOMIZED POSITIONS FOR THE SHIPS
	public static int[][] shipPos(int sizeX, int sizeY, int shipAmount) {
		int[][] shipPos = new int[sizeX + 1][sizeY + 1];

		for (int x = 0; x < shipAmount; x++) {
			int i = (int) Math.round(1 + Math.random() * (sizeX - 1));
			int j = (int) Math.round(1 + Math.random() * (sizeY - 1));

			if (shipPos[i][j] == 1) {
				x--;
			} else {
				shipPos[i][j] = 1;
				System.out.println(i + ", " + j);
			}

		}

		return shipPos;
	}

	//////////////////////////// CHECK IF IT'S A HIT
	public static boolean targetHit(int[][] shipPosFix, int targetX, int targetY, int sizeX, int sizeY) {
		int[][] boardInt = new int[sizeX + 1][sizeY + 1];

		boardInt[targetX][targetY] = 1;

		if (boardInt[targetX][targetY] == shipPosFix[targetX][targetY]) {
			return true;
		}

		return false;
	}

	///////////////////////////// TRIGGER END OF GAME
	public static boolean gameOver() {

		return false;

		/*
		 * boolean[] cond = new boolean[4];
		 * 
		 * int i = 0; if (boardS.equals("(BUM!)")) { cond[i] = true; i++; } return
		 * cond[0] && cond[1] && cond[2] && cond[3];
		 */
	}

}
