import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		int a = in.nextInt();
		int b = in.nextInt();
		for (int i = 1; i <= t; ++i) {

			for (int x = -15; x < 16; x++) {

				boolean exitFlag = false;
				for (int y = -15; y < 16; y++) {
					System.out.println(x + " " + y);
					String result = in.next().trim();

					if ("CENTER".equals(result)) {
						exitFlag = true;
					}
				}

				if (exitFlag == true)
					break;
			}
		}
	}
}