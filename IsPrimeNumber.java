

public class IsPrimeNumber {
	public static void main(String[] words) {

		int max = 50;

		for (int i = -1; i <= max; i++) {
			System.out.println(i + " " + isPrimeNum(i));
		}

	}

	public static boolean isPrimeNum(int n) {

		// negatives, zero and one are not prime
		if (n <= 1)
			return false;

		// 2 is prime
		if (n == 2)
			return true;

		// check if a number is only divisible by 1 and itself
		for (int i = 2; i < n; i++) { // every natural num is divisible by one, so start from 2
			if (n % i == 0)
				return false;
		}

		return true;

	}

}
