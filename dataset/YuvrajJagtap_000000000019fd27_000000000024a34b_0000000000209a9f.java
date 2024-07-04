import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		int numberOfTestCases = Integer.parseInt(s);
		Map<Integer, String> noOfItems = new HashMap<Integer, String>();
		for (int i = 0; i < numberOfTestCases; i++) {
			s = in.nextLine();
			noOfItems.put(i, s);
		}
		for (Integer key : noOfItems.keySet()) {
			System.out.println("Case #" + (key + 1) + ": " + correctInput(noOfItems.get(key)));
		}
	}

	public static String correctInput(String input) {
		StringBuffer sb = new StringBuffer();
		int currentInt = -1;
		int previousInt = 0;
		int difference = 0;
		for (int i = 0; i < input.length() ; i++) {
			currentInt = Integer.parseInt(input.substring(i, i+1));
			if (currentInt == -1) { // Start
				for (int j = 0; j < currentInt ; j++) {
					sb.append("(");
				}
				sb.append(currentInt);
			} else  {
				difference = currentInt - previousInt;
				if (difference > 0) {
					while (difference > 0) {
						sb.append("(");
						difference = difference - 1;
					}
				} else if (difference < 0) {
					while (difference < 0) {
						sb.append(")");
						difference = difference + 1;
					}
				}
				sb.append(currentInt);
			}
			
			if (i == (input.length() -1)) {//End
				for (int j = 0; j < currentInt ; j++) {
					sb.append(")");
				}
			}
			previousInt = currentInt;
		}
		return sb.toString();
	}
}
