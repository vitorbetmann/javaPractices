import java.util.*;

public class In_Alphabetical_Order {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String word1 = sc.next();
		String dummy1 = word1.toLowerCase();
		String word2 = sc.next();
		String dummy2 = word2.toLowerCase();

		// covering exceptions
		boolean sameWords = dummy1.equals(dummy2);
		if (sameWords) {
			System.out.println("\nPotehto Potahto");
		}

		if (!sameWords && (dummy1.length() <= dummy2.length()) && dummy2.substring(0, dummy1.length()).equals(dummy1)) {
			System.out.println("\n" + word1 + " comes before " + word2 + " alphabetically");
		}
		if (!sameWords && (dummy2.length() <= dummy1.length()) && dummy1.substring(0, dummy2.length()).equals(dummy2)) {
			System.out.println("\n" + word2 + " comes before " + word1 + " alphabetically");
		}

		// checking each letter
		int reference;

		if (word1.length() <= word2.length())
			reference = word1.length();
		else
			reference = word2.length();

		for (int i = 0; i < reference && !dummy1.equals(dummy2); i++) {
			if (dummy1.charAt(i) < dummy2.charAt(i)) {
				System.out.println("\n" + word1 + " comes before " + word2 + " alphabetically");
				break;
			}
			if (dummy1.charAt(i) > dummy2.charAt(i)) {
				System.out.println("\n" + word2 + " comes before " + word1 + " alphabetically");
				break;
			}
			if (dummy1.charAt(i) == dummy2.charAt(i)) {
				continue;
			}
		}
	}
}
