//import java.util.*;
import stdlib.*;

public class String_Calculator {
	public static void main(String[] words) {
		System.out.print("please input the calculation: ");

		String[] input = StdIn.readAllStrings();
		System.out.println();

		char operator = ' ';
		for (int j = 0; j < input.length; j++)
			System.out.println(input[j]);
		System.out.println();
		double num1 = Double.parseDouble(input[0]);
		double num2 = 0;

		for (int i = 1; i < input.length; i++) {
			if (i % 2 != 0) {
				operator = input[i].charAt(0);
			} else
				num2 = Double.parseDouble(input[i]);

			if (i > 1 && i % 2 == 0) {
				num1 = Calculator3.operation(num1, num2, operator);
			}
		}
		System.out.println(num1);
	}
	
	public static double calculation(double num1, double num2) {
		
	}
}
