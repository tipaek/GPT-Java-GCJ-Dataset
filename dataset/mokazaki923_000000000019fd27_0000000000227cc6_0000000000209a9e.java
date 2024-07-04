import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		int b = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
//		in.nextLine();
		while (true) {
			System.out.println(1);
			//System.out.flush();
			String result = in.nextLine();
			if (result.equals("N"))
				break;
			System.out.println("1111111111");
			//System.out.flush();
			String ok = in.nextLine();
			if (ok.equals("N"))
				break;
		}
	}

}
