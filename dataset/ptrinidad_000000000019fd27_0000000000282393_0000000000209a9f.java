import java.util.*;
import java.io.*;

public class Solution {
	// Try to program this with my daughter jumping over my head!! :D
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs,
								// strings, chars, etc.
		for (int test = 1; test <= t; ++test) {
			System.out.print("Case #" + test + ": ");
			String line = in.next();
			int currentNumber = -1;
			for (int i = 0; i < line.length(); i++) {
				int c = Integer.valueOf(line.charAt(i)-48);
				if (c != currentNumber) {
					if (currentNumber != -1) {
						for (int j = 0; j < currentNumber; j++) {
							System.out.print(")");
						}
					}
					currentNumber = c;
					for (int j = 0; j < c; j++) {
						System.out.print("(");
					}
				}
				System.out.print(c);
			}
			for (int j = 0; j < currentNumber; j++) {
				System.out.print(")");
			}
			System.out.println();
		}
			
		in.close();
	}

}
