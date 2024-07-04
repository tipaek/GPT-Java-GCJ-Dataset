import java.util.*;
import java.io.*;

public class Solution {
	// Try to program this with my daughter jumping over my head!! :D
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs,
								// strings, chars, etc.
		for (int test = 1; test <= t; ++test) {
			int x = in.nextInt();
			int y = in.nextInt();
			String path = in.next();
			int time = path.length();
			String res = "IMPOSSIBLE";
			for (int i = 1; i <= time; i++) {
				char c = path.charAt(i-1);
					 if (c == 'S') {y--;}
				else if (c == 'N') {y++;}
				else if (c == 'E') {x++;}
				else if (c == 'W') {x--;}
				if (Math.abs(x)+Math.abs(y) <= i) {
					res = String.valueOf(i);
					break;
				}
			}
			
			System.out.println(String.format("Case #%d: %s", test,res));
		}
		in.close();
	}

}