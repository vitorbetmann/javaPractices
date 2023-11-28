//import java.util.*;
//import stdlib.*;

public class MySecondProgram {
	public static void main(String[] words) {
		
		int[] exArray = {6,1,4,5,3,9,0,1,9,5, 1,8,6,7,0,5,5,4,3};
		
		int[] test = plusOne(exArray);
		for (int i = 0; i < test.length; i++) {
			System.out.println(test[i]);

		}
	}
	
	public static int[] plusOne(int[] digits) {

	    long sum = 0;

	    for (int i = 0; i < digits.length; i++) {
	        sum += digits[i] * Math.pow(10, digits.length - 1 - i);
	    }

	    sum += 1;

	    String numsString = Long.toString(sum);

	    int[] result = new int[numsString.length()];

	    for (int j = 0; j < result.length; j ++) {
	        result[j] = Character.getNumericValue(numsString.charAt(j));
	    }

	    return result;
	    }

}
