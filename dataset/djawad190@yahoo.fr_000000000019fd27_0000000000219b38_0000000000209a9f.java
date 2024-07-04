import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int T = in.nextInt();
		int N;
		int[] digits;
		int diff, enclosingStack, currentV, previousV = 0;

		ArrayList<String> stack = new ArrayList<>();
		StringBuilder S;
		for (int i = 1; i <= T; i++) {

			String array[] = in.next("[0-9]+").split("");
			digits = Arrays.asList(array).stream().mapToInt(Integer::parseInt).toArray();
			previousV = 0;
			enclosingStack = 0;
			S = new StringBuilder(100);
			for (int digit : digits) {
				currentV = digit;
				diff = currentV - previousV;
				if (diff > 0)
					for (int j = 0; j < diff; j++)
						S.append("(");
				else
					for (int j = 0; j < Math.abs(diff); j++)
						S.append(")");

				enclosingStack += diff;
				S.append(digit);
				previousV = currentV;
			}
			for (int j = 0; j < enclosingStack; j++)
				S.append(")");

			System.out.println("Case #" + i + ": " + S.toString());
		}
	}

}
