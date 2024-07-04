import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		int n, curChar;
		String str, strArr[][];
		StringBuilder out;
		in.nextLine();
		for (int i = 1; i <= t; ++i) {
			str = in.nextLine();
			n =0;
			out = new StringBuilder();
			for(int j=0; j<str.length(); j++) {
				curChar = Character.getNumericValue(str.charAt(j));
				if(curChar>n) {
					for(int m=n;m<curChar;m++) {
						out.append("(");
					}
					n = curChar;
				} else if (curChar<n) {
					for(int m=curChar;m<n;m++) {
						out.append(")");
					}
					n = curChar;
				}
				out.append(curChar);
			}
			for(int m=0;m<n;m++) {
				out.append(")");
			}
			System.out.println("Case #" + i + ": " + out.toString());
		}
	}
}