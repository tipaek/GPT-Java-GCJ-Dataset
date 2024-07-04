import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			System.out.println("Case #" + i + ": ");
			int n = in.nextInt();
			for (int j=1; j<=n-1; j++) {
				System.out.println (j+" "+j);
				if (j==2&&n>3) {
					System.out.println (3+" "+2);
				}
			}
		}
	}
}