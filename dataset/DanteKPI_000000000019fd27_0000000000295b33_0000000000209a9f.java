
import java.util.Scanner;

public class Solution {
	private static final String C = "(";
	private static final String L = ")";

	public static String solve(char[] datum) {

		StringBuilder sb = new StringBuilder();

		int prev = 0;
		for (char i = 0; i < datum.length; i++) {
			int elem = Character.getNumericValue(datum[i]);

			if (i == 0) {
				//Insert i times ( for the first time
				//Append elem
				sb.append(new String(new char[elem]).replace("\0", C));
				sb.append(elem);
				prev = elem;
				continue;
			}
			if (elem == prev) {
				//Just append to sb
				sb.append(elem);
				continue;
			}
			if (elem < prev) {
				//Insert prev - elem ) 
				//add elem
				sb.append(new String(new char[prev - elem]).replace("\0", L));
				sb.append(elem);
				prev = elem;
				continue;
			}
			if (elem > prev) {
				// Write elem - prev ( 
				// add elem
				sb.append(new String(new char[elem - prev]).replace("\0", C));
				sb.append(elem);
				prev = elem;
			}

		}
		//Finish line with ) - equal to last element?
		sb.append(new String(new char[prev]).replace("\0", L));

		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tests = in.nextInt();

		for (int test = 1; test < tests + 1; test++) {
			System.out.println("Case #" + test + ": " + solve(in.next().toCharArray()));
		}
	}

}
