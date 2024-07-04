import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		String output[] = new String[t];
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt();
			output[i-1] = findString(n, in);

		}
		for (int i = 1; i <= t; ++i) {
			System.out.println("Case #" + i + ": " + output[i-1]);
		}
	}

	private static String findString(int n, Scanner scanner) {
		String s = "";
		String inputPatternArray[]  = new String[n];
		String inputString;
		String inputPattern;
		for (int i = 1; i <= n; ++i) {
			inputPatternArray[i-1] =scanner.next();
		}
		for (int i = 1; i <= n; ++i) {
			inputPattern = inputPatternArray[i-1];
			inputString = inputPattern.replaceFirst("\\*","");
			if(s.length() >= inputPattern.length())
			{
				if(!s.endsWith(inputString))
				{
					return "*";
				}
			}
			else
			{
				if(!inputString.endsWith(s))
				{
					return "*";
				}
				s = inputString;
			}
		}
		return "A"+s;
	}
}
