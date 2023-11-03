import java.util.*;

public class _Calculator {

	public static void main(String[] args) {

		double num1, num2 = 0;
		char operator = ' ';
		Scanner input = new Scanner(System.in);

		System.out.print("Hello! Welcome to the calculator.\n");

		System.out.print("\nPlease insert a number: ");
		num1 = input.nextDouble();

		System.out.println();
		System.out.println("(sqrd = \"2\", sqrt = \"s\", pow = \"p\",  n-root = \"t\", reset = \"r\", quit = \"q\")");
		System.out.print("Please insert an operation: ");
		operator = input.next().charAt(0);

		while (operator != 'q') {

			if (operator != 's' && operator != 'r' && operator != '2' && operator != '!'
					&& operator != 'i') {
				System.out.print("\nPlease insert a number: ");
				num2 = input.nextDouble();
			}

			switch (operator) {

			case '+':
				num1 = num1 + num2;
				System.out.println("\nThe result is: " + num1);
				break;
			case '-':
				num1 = num1 - num2;
				System.out.println("\nThe result is: " + num1);
				break;
			case '*':
				num1 = num1 * num2;
				System.out.println("\nThe result is: " + num1);
				break;
			case 'i':
				num1 = -num1;
				System.out.println("\nThe result is: " + num1);
				break;
			case '%':
				num1 = num1 % num2;
				System.out.println("\nThe result is: " + num1);
				break;
			case '/':
				num1 = num1 / num2;
				System.out.println("\nThe result is: " + num1);
				break;
			case '!':
				if (num1 < 0) {
					System.out.println("\nInvalid operation, please choose another one");
					System.out.println("The stored result is: " + num1);
					break;
				}
				if (num1 == 0)
					num1 = 1;
				else {
					double i;
					for (i = (num1 - 1); i > 0; i--) {
						num1 *= i;
					}
				}
				System.out.println("\nThe result is: " + num1);
				break;
			case 's':
				num1 = Math.sqrt(num1);
				System.out.println("\nThe result is: " + num1);
				break;
			case 'p':
				num1 = Math.pow(num1, num2);
				System.out.println("\nThe result is: " + num1);
				break;
			case '2':
				num1 = Math.pow(num1, 2);
				System.out.println("\nThe result is: " + num1);
				break;
			case 't':
				num1 = Math.pow(num1, 1.0 / num2);
				System.out.println("\nThe result is: " + num1);
				break;
			case 'r':
				num1 = 0;
				System.out.println("\nYou reset the calculator: " + num1);
				break;
			default:
				System.out.print("\nInvalid operation.");
			}

			if (operator == 'r') {
				System.out.print("\nPlease insert a number: ");
				num1 = input.nextDouble();
			}

			System.out.println();
			System.out.println(
					"(squared = \"2\", square root = \"s\", power = \"p\", n-root = \"t\", reset = \"r\", quit = \"q\")");
			System.out.print("Please insert an operation: ");
			operator = input.next().charAt(0);

		}
		System.out.println("\nThank you for using the calculator.");
		System.out.print("Have a great day!");
	}
}
