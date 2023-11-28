import java.util.*;

public class thePerfectFizzBuzz {
	public static void main(String[] args) {
		
		int n = 100;
		
		for (int i = 1; i <= n; i++) {
			if (fizzBuzz(i).equals(""))
				System.out.println(i);
			else
				System.out.println(fizzBuzz(i));
		}
	}

	public static String fizzBuzz(int i) {
		
		String output = "";

		if (i % 3 == 0)
			output += "Fizz";
		if (i % 5 == 0)
			output += "Buzz";

		return output;
	}
}
